package com.mpk.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mpk.model.Project;
import com.mpk.model.User;
import com.mpk.repo.ProjectRepo;
import com.mpk.repo.UserRepo;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    
    private ProjectRepo repo;

    @Autowired
    private UserRepo userRepo;

    @PreAuthorize("hasRole('ADMIN')") 
    @PostMapping
    public Project createProject(@RequestBody
    		Map<String, String> data) {

        Project p = new Project();

        p.setName(data.get("name"));

        User user = userRepo.findById(
            Long.parseLong(data.get("userId"))
        ).orElseThrow();

        p.setCreatedBy(user);

        return repo.save(p);
    }
}
