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

import java.io.Serializable;
import java.lang.reflect.Type;
import java.sql.Types;
import java.util.List;

/**
 * @author Doston Bokhodirov, Wed 8:38 PM. 1/19/2022
 */
public class TaskRepository extends BaseRepository<TaskCreateDto, TaskUpdateDto, Task, Long, Boolean> {
    private final DatabaseProperties property = UNIContainer.getBean(DatabaseProperties.class);

    @Override
    public Long create(TaskCreateDto dto) {
        return null;
    }

    @Override
    public Boolean block(TaskUpdateDto dto) {
        return null;
    }

    @Override
    public Boolean unblock(TaskUpdateDto dto) {
        return null;
    }

    @Override
    public Boolean update(TaskUpdateDto dto) {
        return null;
    }

    @Override
    public Boolean delete(TaskUpdateDto dto) {
        return null;
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
}
