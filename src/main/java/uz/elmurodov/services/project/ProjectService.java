package uz.elmurodov.services.project;

import uz.elmurodov.dtos.project.ProjectCreateDto;
import uz.elmurodov.dtos.project.ProjectUpdateDto;
import uz.elmurodov.exception.CustomerSQLException;
import uz.elmurodov.repository.project.ProjectRepository;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.security.auth.AuthUser;
import uz.elmurodov.security.project.Project;
import uz.elmurodov.services.BaseService;

import java.util.List;


public class ProjectService extends BaseService<ProjectRepository, ProjectCreateDto, ProjectUpdateDto, Long> {

    public ProjectService(ProjectRepository repository) {
        super(repository);
    }

    @Override
    public ResponseEntity<Data<?>> create(ProjectCreateDto dto) {
        try {
            repository.create(dto);
            return new ResponseEntity<>(new Data<>(true));
        } catch (CustomerSQLException e) {
            return new ResponseEntity<>(new Data<>(e.getFriendlyMessage()), e.getStatus());
        }
    }

    @Override
    public ResponseEntity<Data<?>> get(Long id) {
        try {
            Project project = repository.get(id);
            return new ResponseEntity<>(new Data<>(project));
        } catch (CustomerSQLException e) {
            return new ResponseEntity<>(new Data<>(e.getFriendlyMessage()), e.getStatus());
        }
    }

    @Override
    public ResponseEntity<Data<?>> block(Long id) {
        try {
            repository.block(id);
            return new ResponseEntity<>(new Data<>(true));
        } catch (CustomerSQLException e) {
            return new ResponseEntity<>(new Data<>(e.getFriendlyMessage()), e.getStatus());
        }
    }

    @Override
    public ResponseEntity<Data<?>> unblock(Long id) {
        try {
            repository.block(id);
            return new ResponseEntity<>(new Data<>(true));
        } catch (CustomerSQLException e) {
            return new ResponseEntity<>(new Data<>(e.getFriendlyMessage()), e.getStatus());
        }
    }

    @Override
    public ResponseEntity<Data<?>> update(ProjectUpdateDto dto) {
        try {
            repository.block(dto.getId());
            return new ResponseEntity<>(new Data<>(true));
        } catch (CustomerSQLException e) {
            return new ResponseEntity<>(new Data<>(e.getFriendlyMessage()), e.getStatus());
        }
    }

    @Override
    public ResponseEntity<Data<?>> delete(Long id) {
        try {
            repository.delete(id);
            return new ResponseEntity<>(new Data<>(true));
        } catch (CustomerSQLException e) {
            return new ResponseEntity<>(new Data<>(e.getFriendlyMessage()), e.getStatus());
        }
    }

    @Override
    public ResponseEntity<Data<?>> list() {
        try {
            List<Project> list = repository.list();
            return new ResponseEntity<>(new Data<>(list));
        } catch (CustomerSQLException e) {
            return new ResponseEntity<>(new Data<>(e.getFriendlyMessage()), e.getStatus());
        }
    }

    public ResponseEntity<Data<?>> getMembers(Long id) {
        try {
            List<AuthUser> authUsers = repository.getMembers(id);
            return new ResponseEntity<>(new Data<>(authUsers));
        } catch (CustomerSQLException e) {
            return new ResponseEntity<>(new Data<>(e.getFriendlyMessage()), e.getStatus());
        }
    }
}
