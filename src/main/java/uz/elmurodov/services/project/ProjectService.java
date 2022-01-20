package uz.elmurodov.services.project;

import uz.elmurodov.dtos.project.ProjectCreateDto;
import uz.elmurodov.dtos.project.ProjectUpdateDto;
import uz.elmurodov.exception.CustomerSQLException;
import uz.elmurodov.repository.project.ProjectRepository;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
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
        return null;
    }

    @Override
    public ResponseEntity<Data<?>> block(ProjectUpdateDto dto) {
        try{
            repository.block(dto);
            return new ResponseEntity<>(new Data<>(true));
        }catch (CustomerSQLException e){
            return new ResponseEntity<>(new Data<>(e.getFriendlyMessage()),e.getStatus());
        }
    }

    @Override
    public ResponseEntity<Data<?>> unblock(ProjectUpdateDto dto){
        try{
            repository.block(dto);
            return new ResponseEntity<>(new Data<>(true));
        }catch (CustomerSQLException e){
            return new ResponseEntity<>(new Data<>(e.getFriendlyMessage()),e.getStatus());
        }
    }

    @Override
    public ResponseEntity<Data<?>> update(ProjectUpdateDto dto) {
        try{
            repository.block(dto);
            return new ResponseEntity<>(new Data<>(true));
        }catch (CustomerSQLException e){
            return new ResponseEntity<>(new Data<>(e.getFriendlyMessage()),e.getStatus());
        }
    }

    @Override
    public ResponseEntity<Data<?>> delete(Long id) {
        try{
            ProjectUpdateDto dto=new ProjectUpdateDto();
            dto.setId(id);
            repository.delete(dto);
            return new ResponseEntity<>(new Data<>(true));
        }catch (CustomerSQLException e){
            return new ResponseEntity<>(new Data<>(e.getFriendlyMessage()),e.getStatus());
        }
    }

    @Override
    public ResponseEntity<Data<?>> list() {
        try{
             List<Project> list= repository.list();
             return new ResponseEntity<>(new Data<>(list));
        }catch (CustomerSQLException e){
            return new ResponseEntity<>(new Data<>(e.getFriendlyMessage()),e.getStatus());
        }
    }
}
