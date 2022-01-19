package uz.elmurodov.services.task;

import uz.elmurodov.dtos.task.TaskCreateDto;
import uz.elmurodov.dtos.task.TaskUpdateDto;
import uz.elmurodov.repository.task.TaskRepository;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.services.BaseService;

/**
 * @author Doston Bokhodirov, Wed 9:01 PM. 1/19/2022
 */
public class TaskService extends BaseService<TaskRepository, TaskCreateDto, TaskUpdateDto, Long> {
    @Override
    public ResponseEntity<Data<?>> create(TaskCreateDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<Data<?>> get(Long id) {
        return null;
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
