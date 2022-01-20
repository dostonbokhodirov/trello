package uz.elmurodov.repository.project;

import com.google.gson.reflect.TypeToken;
import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.dtos.project.ProjectCreateDto;
import uz.elmurodov.dtos.project.ProjectUpdateDto;
import uz.elmurodov.property.DatabaseProperties;
import uz.elmurodov.repository.BaseRepository;

import uz.elmurodov.security.SecurityHolder;
import uz.elmurodov.security.project.Project;
import uz.elmurodov.utils.BaseUtils;

import java.lang.reflect.Type;
import java.sql.Types;
import java.util.List;

/**
 * @author Nodirbek Jureav, Wed 8:31 PM. 1/19/2022
 */
public class ProjectRepository extends BaseRepository<ProjectCreateDto, ProjectUpdateDto, Project, Long, Boolean> {
    @Override
    public Long create(ProjectCreateDto dto) {
        prepareArguments(BaseUtils.gson.toJson(dto), SecurityHolder.authUserSession.getId());
        return (Long) callProcedure(UNIContainer.getBean(DatabaseProperties.class).get("create.project"), Types.VARCHAR);
    }

    @Override
    public Boolean block(ProjectUpdateDto dto) {
        prepareArguments(SecurityHolder.authUserSession.getId(), BaseUtils.gson.toJson(dto));
        return (Boolean) callProcedure(UNIContainer.getBean(DatabaseProperties.class).get("block.project"), Types.VARCHAR);
    }

    @Override
    public Boolean unblock(ProjectUpdateDto dto) {
        prepareArguments(SecurityHolder.authUserSession.getId(), BaseUtils.gson.toJson(dto));
        return (Boolean) callProcedure(UNIContainer.getBean(DatabaseProperties.class).get("unblock.project"), Types.VARCHAR);
    }

    @Override
    public Boolean update(ProjectUpdateDto dto) {
        prepareArguments(SecurityHolder.authUserSession.getId(), BaseUtils.gson.toJson(dto));
        return (Boolean) callProcedure(UNIContainer.getBean(DatabaseProperties.class).get("unblock.project"), Types.VARCHAR);
    }

    @Override
    public Boolean delete(ProjectUpdateDto dto) {
        prepareArguments(SecurityHolder.authUserSession.getId(), dto.getId());
        return (Boolean) callProcedure(UNIContainer.getBean(DatabaseProperties.class).get("delete.project"), Types.VARCHAR);
    }

    @Override
    public Project get(Long id) {
        return null;
    }

    @Override
    public List<Project> list() {
        prepareArguments(SecurityHolder.authUserSession.getId());
        String data = (String) callProcedure(UNIContainer.getBean(DatabaseProperties.class).get("list.project"), Types.VARCHAR);
        Type type = new TypeToken<List<Project>>() {
        }.getType();
        return BaseUtils.gson.fromJson(data, type);
    }
}
