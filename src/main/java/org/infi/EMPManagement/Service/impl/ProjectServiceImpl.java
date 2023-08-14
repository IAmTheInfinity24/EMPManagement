package org.infi.EMPManagement.Service.impl;

import org.infi.EMPManagement.Entities.Project;
import org.infi.EMPManagement.Repo.ProjectRepoInf;
import org.infi.EMPManagement.Service.ProjectServiceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectServiceInf {

    @Autowired
    private ProjectRepoInf projectRepoInf;

    @Override
    public Project saveProject(Project project) {
        return projectRepoInf.save(project);
    }

    @Override
    public List<Project> getAllProjects() {
        return this.projectRepoInf.findAll();
    }
}
