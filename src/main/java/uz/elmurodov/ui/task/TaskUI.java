package uz.elmurodov.ui.task;

import uz.elmurodov.container.UNIContainer;
import com.google.gson.annotations.SerializedName;
import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.dtos.task.TaskCreateDto;
import uz.elmurodov.dtos.task.TaskUpdateDto;
import uz.elmurodov.enums.HttpStatus;
import uz.elmurodov.repository.auth.AuthUserRepository;
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

public class TaskUI extends BaseUI<TaskService> {

    public TaskUI(TaskService service) {
        super(service);
    }

    @Override
    public void create() {
        int columnID = Input.getNum("CoplumnId: ");
        String name = Input.getStr("Enter name: ");
        String description = Input.getStr("Enter description: ");
        String deadline = Input.getStr("Enter deadline\n(2012-12-12 12:12:12)\n: ");
        int priority = Input.getNum("Enter priority: ");
        int level = Input.getNum("Enter level\n(HARD/MEDIUM/EASY)\n: ");
        TaskCreateDto dto = new TaskCreateDto(level, columnID, name, description, deadline, priority);

        ResponseEntity<Data<?>> response = service.create(dto);
        if (!response.getStatus().equals(HttpStatus.HTTP_200.getCode())) {
            Print.println(Color.RED, response.getBody().getData());
        } else {
            Print.println(Color.GREEN, "Created task");
        }
    }

    @Override
    public void block() {
    }

    @Override
    public void unblock() {
    }

    @Override
    public void delete() {
        TaskUpdateDto dto = new TaskUpdateDto();
        dto.setId(SecurityHolder.taskSession.getId());
        ResponseEntity<Data<?>> response = service.delete(dto.getId());
        if (!response.getStatus().equals(HttpStatus.HTTP_200.getCode())) {
            Print.println(Color.RED, response.getBody().getData());
        } else {
            Print.println(Color.GREEN, "Successfully deleted");
        }
    }

    @Override
    public void update() {
        int column = Input.getNum("ColumnId: ");
        String name = Input.getStr("Enter name: ");
        String description = Input.getStr("Enter description: ");
        String deadline = Input.getStr("Enter deadline\n(2012-12-12 12:12:12)\n: ");
        int priority = Input.getNum("Enter priority: ");
        int level = Input.getNum("Enter level\n(3=HARD/2=MEDIUM/1=EASY)\n: ");
        int order = Input.getNum("Enter order: ");
        String message = Input.getStr("Enter message: ");
        TaskUpdateDto dto = new TaskUpdateDto(level, column, name, description, deadline, priority, order, message);
        ResponseEntity<Data<?>> response = service.update(dto);
        if (!response.getStatus().equals(HttpStatus.HTTP_200.getCode())) {
            Print.println(Color.RED, response.getBody().getData());
        } else {
            Print.println(Color.GREEN, "Updated");
        }
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
//        Print.println(service.list());
//        ResponseEntity<Data<?>> response =  service.list();
//        List<Task> taskList = (List<Task>) response.getBody().getData();
//        for (int i = 0; i < taskList.size(); i++) {
//            Print.println(Color.BLUE, (i+1) + ". " + taskList.get(i).getName());
//        }
    }

    public void get(Long taskId) {
        ResponseEntity<Data<?>> response = service.get(taskId);
        if (!response.getStatus().equals(HttpStatus.HTTP_200.getCode())) {
            Print.println(Color.RED, response.getBody().getData());
        } else Print.println(Color.BLUE, response.getBody().getData());
    }

    public void addMember() {

    }

    public void addComment() {
        String yourComment = Input.getStr("Add a comment : ");
        TaskUpdateDto dto = new TaskUpdateDto();
        dto.setMessage(yourComment);
        ResponseEntity<Data<?>> response=service.addComment(dto);
        if (!response.getStatus().equals(HttpStatus.HTTP_200.getCode())) {
            Print.println(Color.RED, response.getBody().getData());
        } else Print.println(Color.BLUE, "Your comment Successfully added");

    }
}
