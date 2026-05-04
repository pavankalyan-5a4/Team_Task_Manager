package com.mpk.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mpk.model.Task;
import com.mpk.model.User;

public interface TaskRepo extends JpaRepository<Task, Long>{
	List<Task> findByAssignedTo(User user); 

}
