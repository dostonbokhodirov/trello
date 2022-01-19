package uz.elmurodov.repository.task;

import uz.elmurodov.dtos.task.TaskCreateDto;
import uz.elmurodov.dtos.task.TaskUpdateDto;
import uz.elmurodov.repository.BaseRepository;
import uz.elmurodov.security.task.Task;

import java.util.List;

/**
 * @author Doston Bokhodirov, Wed 8:38 PM. 1/19/2022
 */
public class TaskRepository extends BaseRepository<TaskCreateDto, TaskUpdateDto, Task, Long, Boolean> {
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
        return null;
    }

    @Override
    public List<Task> list(Long id) {
        return null;
    }
}
