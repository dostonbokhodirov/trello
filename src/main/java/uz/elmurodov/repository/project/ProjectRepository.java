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

public class ProjectRepository extends BaseRepository<ProjectCreateDto,
        ProjectUpdateDto,
        Project,
        Long> {
    @Override
    public Long create(ProjectCreateDto dto) {
        prepareArguments(BaseUtils.gson.toJson(dto), SecurityHolder.authUserSession.getId());
        return (Long) callProcedure(UNIContainer.getBean(DatabaseProperties.class).get("create.project"), Types.VARCHAR);
    }

    @Override
    public boolean block(Long id) {
        prepareArguments(SecurityHolder.authUserSession.getId(), id);
        return (boolean) callProcedure(UNIContainer.getBean(DatabaseProperties.class).get("block.project"), Types.VARCHAR);
    }

    @Override
    public boolean unblock(Long id) {
        prepareArguments(SecurityHolder.authUserSession.getId(), id);
        return (boolean) callProcedure(UNIContainer.getBean(DatabaseProperties.class).get("unblock.project"), Types.VARCHAR);
    }

    @Override
    public boolean update(ProjectUpdateDto dto) {
        prepareArguments(SecurityHolder.authUserSession.getId(), BaseUtils.gson.toJson(dto));
        return (boolean) callProcedure(UNIContainer.getBean(DatabaseProperties.class).get("unblock.project"), Types.VARCHAR);
    }

    @Override
    public boolean delete(Long id) {
        prepareArguments(SecurityHolder.authUserSession.getId(), id);
        return (boolean) callProcedure(UNIContainer.getBean(DatabaseProperties.class).get("delete.project"), Types.VARCHAR);
    }

    @Override
    public Project get(Long id) {
        prepareArguments(id, SecurityHolder.authUserSession.getId());
        String dataJson = (String) callProcedure(UNIContainer.getBean(DatabaseProperties.class).get("project.get"), Types.VARCHAR);
        return BaseUtils.gson.fromJson(dataJson, new TypeToken<Project>() {
        }.getType());
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
