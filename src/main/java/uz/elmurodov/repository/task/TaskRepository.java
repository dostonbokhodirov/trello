package uz.elmurodov.repository.task;

import com.google.gson.reflect.TypeToken;
import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.dtos.task.TaskCreateDto;
import uz.elmurodov.dtos.task.TaskUpdateDto;
import uz.elmurodov.property.DatabaseProperties;
import uz.elmurodov.repository.BaseRepository;
import uz.elmurodov.security.SecurityHolder;
import uz.elmurodov.security.task.Task;
import uz.elmurodov.utils.BaseUtils;

import java.lang.reflect.Type;
import java.sql.Types;
import java.util.List;


public class TaskRepository extends BaseRepository<TaskCreateDto,
        TaskUpdateDto,
        Task,
        Long> {
    private final DatabaseProperties property = UNIContainer.getBean(DatabaseProperties.class);

    @Override
    public Long create(TaskCreateDto dto) {
        String json = BaseUtils.gson.toJson(dto);
        prepareArguments(json, SecurityHolder.authUserSession.getId());
        return (long) callProcedure(property.get("task.create"), Types.BIGINT);
    }

    @Override
    public boolean block(Long id) {
        return true;
    }

    @Override
    public boolean unblock(Long id) {
        return true;
    }

    @Override
    public boolean update(TaskUpdateDto dto) {
        String json = BaseUtils.gson.toJson(dto);
        prepareArguments(json, SecurityHolder.authUserSession.getId());
        return (boolean) callProcedure("task.update", Types.BOOLEAN);
    }

    @Override
    public boolean delete(Long id) {
        prepareArguments(SecurityHolder.authUserSession.getId(), id);
        return (boolean) callProcedure(property.get("task.delete"), Types.BOOLEAN);
    }

    @Override
    public Task get(Long id) {
        prepareArguments(id);
        String jsonData = (String) callProcedure(property.get("task.get"), Types.VARCHAR);
        return BaseUtils.gson.fromJson(jsonData, Task.class);
    }

    @Override
    public List<Task> list() {
        Type taskList = new TypeToken<List<Task>>() {
        }.getType();
        prepareArguments(SecurityHolder.authUserSession.getId());
        String dataJson = (String) callProcedure(property.get("task.list.user"), Types.VARCHAR);
        return BaseUtils.gson.fromJson(dataJson, taskList);
    }

    public void addTask(TaskUpdateDto dto) {
        prepareArguments(BaseUtils.gson.toJson(dto), SecurityHolder.authUserSession.getId());
        callProcedure("add.comment", Types.BIGINT);
    }
}
