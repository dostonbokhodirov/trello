package uz.elmurodov.services.task;

import com.google.gson.reflect.TypeToken;
import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.dtos.task.TaskCreateDto;
import uz.elmurodov.dtos.task.TaskUpdateDto;
import uz.elmurodov.exception.CustomerSQLException;
import uz.elmurodov.property.DatabaseProperties;
import uz.elmurodov.repository.task.TaskRepository;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.security.SecurityHolder;
import uz.elmurodov.security.task.Task;
import uz.elmurodov.services.BaseService;
import uz.elmurodov.utils.BaseUtils;
import uz.jl.utils.BaseUtil;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author Doston Bokhodirov, Wed 9:01 PM. 1/19/2022
 */
public class TaskService extends BaseService<TaskRepository, TaskCreateDto, TaskUpdateDto, Long> {
    private static final TaskRepository taskRepository = UNIContainer.getBean(TaskRepository.class);

    @Override
    public ResponseEntity<Data<?>> create(TaskCreateDto dto) {
        try {
            return new ResponseEntity<>(new Data<>(taskRepository.create(dto)));
        } catch (CustomerSQLException e) {
            return new ResponseEntity<>(new Data<>(e.getFriendlyMessage()), e.getStatus());
        }
    }

    @Override
    public ResponseEntity<Data<?>> get(Long id) {
        try {
            Task task = repository.get(id);
            SecurityHolder.taskSession = task;
            return new ResponseEntity<>(new Data<>(task));
        } catch (CustomerSQLException e) {
            return new ResponseEntity<>(new Data<>(e.getFriendlyMessage()), e.getStatus());
        }

    }

    @Override
    public ResponseEntity<Data<?>> block(TaskUpdateDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<Data<?>> unblock(TaskUpdateDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<Data<?>> update(TaskUpdateDto dto) {
        try {
            return new ResponseEntity<>(new Data<>(taskRepository.update(dto)));
        } catch (CustomerSQLException e) {
            return new ResponseEntity<>(new Data<>(e.getFriendlyMessage()), e.getStatus());
        }
    }

    @Override
    public ResponseEntity<Data<?>> delete(Long id) {
        TaskUpdateDto dto = new TaskUpdateDto();
        dto.setId(id);
        try {
            return new ResponseEntity<>(new Data<>(taskRepository.delete(dto)));
        } catch (CustomerSQLException e) {
            return new ResponseEntity<>(new Data<>(e.getFriendlyMessage()), e.getStatus());
        }
    }

    @Override
    public ResponseEntity<Data<?>> list() {
        List<Task> tasks = taskRepository.list();
        return new ResponseEntity<>(new Data<>(tasks, (long) tasks.size()));
    }
}
