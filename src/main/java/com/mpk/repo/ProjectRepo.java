package com.mpk.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mpk.model.Project;

public interface ProjectRepo extends JpaRepository<Project, Long>{

}
