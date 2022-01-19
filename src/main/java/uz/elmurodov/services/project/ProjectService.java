package uz.elmurodov.services.project;

import uz.elmurodov.dtos.project.ProjectCreateDto;
import uz.elmurodov.dtos.project.ProjectUpdateDto;
import uz.elmurodov.repository.project.ProjectRepository;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.services.BaseService;

/**
 * @author Doston Bokhodirov, Wed 8:45 PM. 1/19/2022
 */
public class ProjectService extends BaseService<ProjectRepository, ProjectCreateDto, ProjectUpdateDto, Long> {
    @Override
    public ResponseEntity<Data<?>> create(ProjectCreateDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<Data<?>> get(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Data<?>> block(ProjectUpdateDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<Data<?>> unblock(ProjectUpdateDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<Data<?>> update(ProjectUpdateDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<Data<?>> delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Data<?>> list(Long id) {
        return null;
    }
}
