package uz.elmurodov.services.task;

import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.dtos.task.TaskCreateDto;
import uz.elmurodov.dtos.task.TaskUpdateDto;
import uz.elmurodov.exception.CustomerSQLException;
import uz.elmurodov.repository.task.TaskRepository;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.security.task.Task;
import uz.elmurodov.services.BaseService;

import java.util.List;


public class TaskService extends BaseService<TaskRepository, TaskCreateDto, TaskUpdateDto, Long> {
    private static final TaskRepository taskRepository = UNIContainer.getBean(TaskRepository.class);

    public TaskService(TaskRepository repository) {
        super(repository);
    }

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
            return new ResponseEntity<>(new Data<>(task));
        } catch (CustomerSQLException e) {
            return new ResponseEntity<>(new Data<>(e.getFriendlyMessage()), e.getStatus());
        }

    }

    @Override
    public ResponseEntity<Data<?>> block(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Data<?>> unblock(Long id) {
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
        try {
            return new ResponseEntity<>(new Data<>(taskRepository.delete(id)));
        } catch (CustomerSQLException e) {
            return new ResponseEntity<>(new Data<>(e.getFriendlyMessage()), e.getStatus());
        }
    }

    @Override
    public ResponseEntity<Data<?>> list() {
        try {
            List<Task> tasks = repository.list();
            return new ResponseEntity<>(new Data<>(tasks));
        } catch (CustomerSQLException e) {
            return new ResponseEntity<>(new Data<>(e.getFriendlyMessage()), e.getStatus());
        }
    }

    public ResponseEntity<Data<?>> addComment(TaskUpdateDto dto) {
        try {
            taskRepository.addTask(dto);
            return new ResponseEntity<>(new Data<>(true));
        } catch (CustomerSQLException e) {
            return new ResponseEntity<>(new Data<>(e.getFriendlyMessage()), e.getStatus());
        }
    }
}
