package org.infi.EMPManagement.Repo;

import org.infi.EMPManagement.Entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepoInf extends JpaRepository<Project, Long> {
}
