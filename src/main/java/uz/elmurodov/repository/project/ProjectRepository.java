package uz.elmurodov.repository.project;

import uz.elmurodov.dtos.project.ProjectCreateDto;
import uz.elmurodov.dtos.project.ProjectUpdateDto;
import uz.elmurodov.repository.BaseRepository;
import uz.elmurodov.security.project.Project;

import java.util.List;

/**
 * @author Doston Bokhodirov, Wed 8:31 PM. 1/19/2022
 */
public class ProjectRepository extends BaseRepository<ProjectCreateDto, ProjectUpdateDto, Project, Long, Boolean> {
    @Override
    public Long create(ProjectCreateDto dto) {
        return null;
    }

    @Override
    public Boolean block(ProjectUpdateDto dto) {
        return null;
    }

    @Override
    public Boolean unblock(ProjectUpdateDto dto) {
        return null;
    }

    @Override
    public Boolean update(ProjectUpdateDto dto) {
        return null;
    }

    @Override
    public Boolean delete(ProjectUpdateDto dto) {
        return null;
    }

    @Override
    public Project get(Long id) {
        return null;
    }

    @Override
    public List<Project> list(Long id) {
        return null;
    }
}
