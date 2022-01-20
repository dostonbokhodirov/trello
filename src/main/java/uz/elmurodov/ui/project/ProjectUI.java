package uz.elmurodov.ui.project;

import uz.elmurodov.services.project.ProjectService;
import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.dtos.project.ProjectCreateDto;
import uz.elmurodov.dtos.project.ProjectUpdateDto;
import uz.elmurodov.enums.HttpStatus;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.security.SecurityHolder;
import uz.elmurodov.security.project.Project;
import uz.elmurodov.services.project.ProjectService;
import uz.elmurodov.ui.BaseUI;
import uz.jl.utils.Color;
import uz.jl.utils.Input;
import uz.jl.utils.Print;

import java.util.List;

/**
 * @author Doston Bokhodirov, Thu 12:04 AM. 1/20/2022
 */
public class ProjectUI extends BaseUI<ProjectService> {
    @Override
    public void create() {
        String name = Input.getStr("Name : ");
        String tz = Input.getStr("Tz : ");
        String description = Input.getStr("Desctiption : ");
        ProjectService projectService = UNIContainer.getBean(ProjectService.class);
        ProjectCreateDto dto = new ProjectCreateDto();
        dto.setName(name);
        dto.setDescription(description);
        dto.setTz(tz);
        dto.setBackground("grey");
        dto.setOrganizationId(SecurityHolder.authUserSession.getOrganization().getId());
        ResponseEntity<Data<?>> response = projectService.create(dto);
        if (!response.getStatus().equals(HttpStatus.HTTP_200.getCode())) {
            Print.println(Color.RED, response.getBody().getData());
        } else {
            Print.println(Color.GREEN, "Successfully created project");
        }
    }

    @Override
    public void block() {
        ProjectService projectService = UNIContainer.getBean(ProjectService.class);
        ProjectUpdateDto dto = new ProjectUpdateDto();
        dto.setId(SecurityHolder.projectSession.getId());
        ResponseEntity<Data<?>> response = projectService.block(dto);
        if (!response.getStatus().equals(HttpStatus.HTTP_200.getCode())) {
            Print.println(Color.RED, response.getBody().getData());
        } else {
            Print.println(Color.GREEN, "Successfully blocked project");
        }
    }

    @Override
    public void unblock() {
        ProjectService projectService = UNIContainer.getBean(ProjectService.class);
        ProjectUpdateDto dto = new ProjectUpdateDto();
        dto.setId(SecurityHolder.projectSession.getId());
        ResponseEntity<Data<?>> response = projectService.block(dto);
        if (!response.getStatus().equals(HttpStatus.HTTP_200.getCode())) {
            Print.println(Color.RED, response.getBody().getData());
        } else {
            Print.println(Color.GREEN, "Successfully unblocked project");
        }
    }

    @Override
    public void delete() {
        ProjectService projectService = UNIContainer.getBean(ProjectService.class);
        ResponseEntity<Data<?>> response = projectService.delete(SecurityHolder.projectSession.getId());
        if (!response.getStatus().equals(HttpStatus.HTTP_200.getCode())) {
            Print.println(Color.RED, response.getBody().getData());
        } else {
            Print.println(Color.GREEN, "Successfully unblocked project");
        }
    }

    @Override
    public void update() {
        ProjectService projectService = UNIContainer.getBean(ProjectService.class);
        ProjectUpdateDto dto = new ProjectUpdateDto();
        String name = Input.getStr("Name : ");
        String tz = Input.getStr("Tz : ");
        String description = Input.getStr("Desctiption : ");
        String background = Input.getStr("Background : ");
        int organizationId = Input.getNum("Organization Id : ");
        dto.setName(name);
        dto.setDescription(description);
        dto.setBackground(background);
        dto.setOrganizationId(organizationId);
        dto.setTz(tz);
        ResponseEntity<Data<?>> response = projectService.update(dto);
        if (!response.getStatus().equals(HttpStatus.HTTP_200.getCode())) {
            Print.println(Color.RED, response.getBody().getData());
        } else {
            Print.println(Color.GREEN, "Successfully blocked project");
        }
    }

    @Override
    public void get() {
        ProjectService projectService = UNIContainer.getBean(ProjectService.class);
        ResponseEntity<Data<?>> response = projectService.get(SecurityHolder.projectSession.getId());
        if (!response.getStatus().equals(HttpStatus.HTTP_200.getCode())) {
            Print.println(Color.RED, response.getBody().getData());
        } else {
            Print.println(Color.GREEN, "Successfully blocked project");
        }
    }

    @Override
    public void list() {
        ProjectService projectService = UNIContainer.getBean(ProjectService.class);
        ResponseEntity<Data<?>> response = projectService.list();
        List<Project> list = (List<Project>) response.getBody().getData();
        if (!response.getStatus().equals(HttpStatus.HTTP_200.getCode())) {
            Print.println(Color.RED, response.getBody().getData());
        } else {
            int i = 1;
            for (Project project : list) {
                Print.println(Color.GREEN, i++ + ". " + project.getName());
            }
        }
    }

    public void get(Long projectId) {
        ProjectService projectService = UNIContainer.getBean(ProjectService.class);
        ResponseEntity<Data<?>> response = projectService.get(projectId);
        if (!response.getStatus().equals(HttpStatus.HTTP_200.getCode())) {
            Print.println(Color.RED, response.getBody().getData());
        } else {
            Print.println(Color.GREEN, "Successfully blocked project");
        }
    }
}
