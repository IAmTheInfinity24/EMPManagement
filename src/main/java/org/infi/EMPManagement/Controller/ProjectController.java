package org.infi.EMPManagement.Controller;

import org.infi.EMPManagement.Entities.Project;
import org.infi.EMPManagement.Service.ProjectServiceInf;
import org.infi.EMPManagement.dto.ProjectDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/apis/projects")
public class ProjectController {

    @Autowired
    private ProjectServiceInf projectServiceInf;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/")
    ResponseEntity<ProjectDto> saveProject(@RequestBody ProjectDto projectDto){
        Project project = modelMapper.map(projectDto, Project.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(this.projectServiceInf.saveProject(project), ProjectDto.class));
    }

    @GetMapping("/")
    ResponseEntity<List<ProjectDto>> getProjects(){
        List<Project> allProjects = this.projectServiceInf.getAllProjects();
        List<ProjectDto> dtos = allProjects.stream().map(project -> modelMapper.map(project, ProjectDto.class)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }
}
