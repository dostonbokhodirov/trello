package uz.elmurodov.ui.task;

import uz.elmurodov.enums.HttpStatus;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.security.SecurityHolder;
import uz.elmurodov.security.task.Task;
import uz.elmurodov.services.task.TaskService;
import uz.elmurodov.ui.BaseUI;
import uz.jl.utils.Color;
import uz.jl.utils.Print;

/**
 * @author Doston Bokhodirov, Thu 12:05 AM. 1/20/2022
 */
public class TaskUI extends BaseUI<TaskService> {
    @Override
    public void create() {

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
        ResponseEntity<Data<?>> response = service.get(SecurityHolder.authUserSession.getId());
        if (!response.getStatus().equals(HttpStatus.HTTP_200.getCode())) {
            Print.println(Color.RED, response.getBody().getData());

        } else Print.println(Color.BLUE, response.getBody().getData());
    }

    @Override
    public void list() {

    }
}
