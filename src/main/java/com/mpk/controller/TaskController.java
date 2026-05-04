package com.mpk.controller;

import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mpk.model.Project;
import com.mpk.model.Role;
import com.mpk.model.Status;
import com.mpk.model.Task;
import com.mpk.model.User;
import com.mpk.repo.ProjectRepo;
import com.mpk.repo.TaskRepo;
import com.mpk.repo.UserRepo;

//@RestController
//@RequestMapping("/tasks")
//public class TaskController {
//
//    @Autowired
//    private TaskRepo repo;
//
//    @Autowired
//    private UserRepo userRepo;
//
//    @Autowired
//    private ProjectRepo projectRepo;
//    
//@PreAuthorize("hasRole('ADMIN')")
//    @PostMapping
//    public Task createTask(@RequestBody Map<String, String> data) {
//
//        Task t = new Task();
//
//        t.setTitle(data.get("title"));
//        t.setDescription(data.get("description"));
//        t.setStatus(Status.valueOf(data.get("status")));
//
//        User user = userRepo.findById(
//            Long.parseLong(data.get("userId"))
//        ).orElseThrow();
//
//        Project project = projectRepo.findById(
//            Long.parseLong(data.get("projectId"))
//        ).orElseThrow();
//
//        t.setAssignedTo(user);
//        t.setProject(project);
//
//        return repo.save(t);
//    }
//}

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepo repo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ProjectRepo projectRepo;

    // 🔥 ADMIN can create task
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public Task createTask(@RequestBody Map<String, String> data) {

        Task t = new Task();

        t.setTitle(data.get("title"));
        t.setDescription(data.get("description"));
        t.setStatus(Status.valueOf(data.get("status")));

        User user = userRepo.findById(
            Long.parseLong(data.get("userId"))
        ).orElseThrow();

        Project project = projectRepo.findById(
            Long.parseLong(data.get("projectId"))
        ).orElseThrow();

        t.setAssignedTo(user);
        t.setProject(project);

        return repo.save(t);
    }

    // 🔥 ADMIN sees all, MEMBER sees only their tasks
    @GetMapping
    public List<Task> getTasks(Authentication auth) {

        String email = auth.name();
        User user = userRepo.findByEmail(email).orElseThrow();

        if (user.getRole() == Role.ADMIN) {
            return repo.findAll();
        } else {
            return repo.findByAssignedTo(user);
        }
    }

    // 🔥 MEMBER can update status
    @PreAuthorize("hasAnyRole('ADMIN','MEMBER')")
    @PutMapping("/{id}")
    public Task updateStatus(@PathVariable Long id,
                             @RequestBody Map<String, String> data) {

        Task t = repo.findById(id).orElseThrow();

        t.setStatus(Status.valueOf(data.get("status")));

        return repo.save(t);
    }
}