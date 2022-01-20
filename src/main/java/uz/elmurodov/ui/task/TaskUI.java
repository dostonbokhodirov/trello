package uz.elmurodov.ui.task;

import uz.elmurodov.container.UNIContainer;
import com.google.gson.annotations.SerializedName;
import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.dtos.task.TaskCreateDto;
import uz.elmurodov.enums.HttpStatus;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.security.SecurityHolder;
import uz.elmurodov.security.task.Task;
import uz.elmurodov.services.task.TaskService;
import uz.elmurodov.ui.BaseUI;
import uz.jl.utils.Color;
import uz.jl.utils.Input;
import uz.jl.utils.Print;

import java.util.List;

/**
 * @author Doston Bokhodirov, Thu 12:05 AM. 1/20/2022
 */
public class TaskUI extends BaseUI<TaskService> {
    TaskService taskUI = UNIContainer.getBean(TaskService.class);

    private static final TaskService taskService = UNIContainer.getBean(TaskService.class);

    @Override
    public void create() {
        String column = Input.getStr("Column: ");
        String name = Input.getStr("Enter name: ");
        String description = Input.getStr("Enter description: ");
        String deadline = Input.getStr("Enter deadline\n(2012-12-12 12:12:12)\n: ");
        String priority = Input.getStr("Enter priority: ");
        String level = Input.getStr("Enter level\n(HARD/MEDIUM/EASY)\n: ");
//        TaskCreateDto dto = new TaskCreateDto(level, column, name, description, deadline, priority);
//        taskService.create(dto);
    }

    @Override
    public void block() {

    }

    @Override
    public void unblock() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void update() {
    }

    @Override
    public void get() {
        ResponseEntity<Data<?>> response = service.get(SecurityHolder.taskSession.getId());
        if (!response.getStatus().equals(HttpStatus.HTTP_200.getCode())) {
            Print.println(Color.RED, response.getBody().getData());
        } else Print.println(Color.BLUE, response.getBody().getData());
    }

    @Override
    public void list() {
        ResponseEntity<Data<?>> response = service.list();
        if (!response.getStatus().equals(HttpStatus.HTTP_200.getCode())) {
            Print.println(Color.RED, response.getBody().getData());
        } else {
            List<Task> tasks = (List<Task>) response.getBody().getData();
            int i = 1;
            for (Task task : tasks) {
                Print.println(Color.BLUE, i++ + ". " + task.getName());
            }
        }
//        Print.println(taskService.list());
    }

    public void addMember() {
    }

    public void addCommet() {
    }
}
