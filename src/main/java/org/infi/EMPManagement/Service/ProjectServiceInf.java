package org.infi.EMPManagement.Service;

import org.infi.EMPManagement.Entities.Project;

import java.util.List;

public interface ProjectServiceInf {

    Project saveProject(Project project);

    List<Project> getAllProjects();

}
