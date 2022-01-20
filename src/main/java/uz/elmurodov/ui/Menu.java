package uz.elmurodov.ui;

import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.security.auth.RolesItem;
import uz.elmurodov.services.project.ProjectService;
import uz.elmurodov.services.task.TaskService;
import uz.elmurodov.ui.auth.AuthUserUI;
import uz.elmurodov.ui.column.ColumnUI;
import uz.elmurodov.ui.project.ProjectUI;
import uz.elmurodov.ui.task.TaskUI;
import uz.jl.utils.Color;
import uz.jl.utils.Input;
import uz.jl.utils.Print;

import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.isNumeric;
import static uz.elmurodov.security.SecurityHolder.authUserSession;

public class Menu {
    private static final AuthUserUI authUserUI = UNIContainer.getBean(AuthUserUI.class);
    private static final TaskUI taskUI = UNIContainer.getBean(TaskUI.class);
    private static final ProjectUI projectUI = UNIContainer.getBean(ProjectUI.class);
    private static final ColumnUI columnUI = UNIContainer.getBean(ColumnUI.class);

    public static void getMainMenu() {
        if (Objects.isNull(authUserSession)) {
            Print.println(Color.GREEN, "Login -> LOGIN");
        } else {
            Print.println(Color.GREEN, "Tasks -> TASKS");
            Print.println(Color.GREEN, "Projects -> PROJECTS");
            for (RolesItem role : authUserSession.getRoles()) {
                if (role.getCode().equalsIgnoreCase("HR") || role.getCode().equalsIgnoreCase("ADMIN")) {
                    Print.println(Color.GREEN, "=====EMPLOYEE=====");
                    Print.println(Color.GREEN, "Create Employee -> EMPLOYEE_CREATE");
                    Print.println(Color.GREEN, "Block Employee -> EMPLOYEE_BLOCK");
                    Print.println(Color.GREEN, "Unblock Employee -> EMPLOYEE_UNBLOCK");
                    Print.println(Color.GREEN, "Delete Employee -> EMPLOYEE_DELETE");
                    Print.println(Color.GREEN, "Get Employee -> EMPLOYEE_GET");
                    Print.println(Color.GREEN, "List Employees -> EMPLOYEE_LIST");
                }
            }
            if (authUserSession.isSuperUser()) {
                Print.println(Color.GREEN, "=====ORGANIZATION=====");
                Print.println(Color.GREEN, "Create Organization  -> ORGANIZATION_CREATE");
                Print.println(Color.GREEN, "Block Organization  -> ORGANIZATION_BLOCK");
                Print.println(Color.GREEN, "Unblock Organization  -> ORGANIZATION_UNBLOCK");
                Print.println(Color.GREEN, "Delete Organization  -> ORGANIZATION_DELETE");
                Print.println(Color.GREEN, "Get Organization  -> ORGANIZATION_GET");
                Print.println(Color.GREEN, "List Organizations  -> ORGANIZATION_LIST");
            }
            Print.println("Logout -> LOGOUT");
        }
        Print.println(Color.GREEN, "Exit -> EXIT");
    }

    public static void getProjectMenu() {
        Print.println(Color.GREEN, "Create Project  -> PROJECT_CREATE");
        Print.println(Color.GREEN, "List Projects  -> PROJECT_LIST");
        Print.println(Color.GREEN, "Enter Project  -> PROJECT_ENTER");
        Print.println(Color.GREEN, "Back  -> BACK");
        String choice = Input.getStr("Enter your choice: ");
        switch (choice.toUpperCase()) {
            case "PROJECT_CREATE" -> {

            }
            case "PROJECT_LIST" -> {

            }
            case "PROJECT_ENTER" -> {
                enterProjectMenu();
            }
            case "BACK" -> {
                return;
            }
            default -> Print.println(Color.RED, "Wrong choice");
        }
        getProjectMenu();
    }

    public static void enterProjectMenu() {
        projectUI.list();
        Print.println(Color.GREEN, "Back  -> BACK");
        String choice = Input.getStr("Choice Project: ");
        if (isNumeric(choice)) {
            projectDetailsMenu(Long.parseLong(choice));
        } else {
            if ("BACK".equalsIgnoreCase(choice)) {
                return;
            } else {
                Print.println(Color.RED, "Wrong choice");
            }
        }
        enterTaskMenu();
    }

    private static void projectDetailsMenu(long order) {
        ProjectService projectService = UNIContainer.getBean(ProjectService.class);
        projectService.get(order - 1);
        Print.println(Color.GREEN, "Create Task  -> TASK_CREATE");
        Print.println(Color.GREEN, "Enter Task  -> TASK_ENTER");
        Print.println(Color.GREEN, "Create Column  -> COLUMN_CREATE");
        Print.println(Color.GREEN, "Update Column  -> COLUMN_UPDATE");
        Print.println(Color.GREEN, "Delete Column  -> COLUMN_DELETE");
        Print.println(Color.GREEN, "List Columns  -> COLUMN_LIST");
        if (authUserUI.isLeader()) {
            Print.println(Color.GREEN, "Update Member  -> MEMBER_UPDATE");
            Print.println(Color.GREEN, "Delete Member  -> MEMBER_DELETE");
        }
        Print.println(Color.GREEN, "List Members  -> MEMBER_LIST");
        Print.println(Color.GREEN, "Back  -> BACK");
        String choice = Input.getStr("Enter your choice: ");
        switch (choice.toUpperCase()) {
            case "TASK_CREATE" -> {
                taskUI.create();
            }
            case "TASK_ENTER" -> {
                enterTaskMenu();
            }
            case "COLUMN_CREATE" -> {
                columnUI.create();
            }
            case "COLUMN_UPDATE" -> {
                columnUI.update();
            }
            case "COLUMN_DELETE" -> {
                columnUI.delete();
            }
            case "COLUMN_LIST" -> {
                columnUI.list();
            }
            case "MEMBER_UPDATE" -> {
                columnUI.updateMember();
            }
            case "MEMBER_DELETE" -> {
                columnUI.memberDelete();
            }
            case "MEMBER_LIST" -> {
                columnUI.memberList();
            }
            case "BACK" -> {
                return;
            }
            default -> Print.println(Color.RED, "Wrong choice");
        }
        projectDetailsMenu(order);
    }

    private static void enterTaskMenu() {
        taskUI.list();
        Print.println(Color.GREEN, "Back  -> BACK");
        String choice = Input.getStr("Choice Task: ");
        if (isNumeric(choice)) {
            taskDetailsMenu(Long.parseLong(choice));
        } else {
            if ("BACK".equalsIgnoreCase(choice)) {
                return;
            } else {
                Print.println(Color.RED, "Wrong choice");
            }
        }
        enterTaskMenu();
    }

    private static void taskDetailsMenu(Long order) {
        TaskService taskService = UNIContainer.getBean(TaskService.class);
        taskService.get(order - 1);
        Print.println(Color.GREEN, "Update Task -> TASK_CREATE");
        Print.println(Color.GREEN, "Delete Task -> TASK_DELETE");
        if (authUserUI.isLeader()) {
            Print.println(Color.GREEN, "Create Member -> MEMBER_CREATE");
        }
        Print.println(Color.GREEN, "Create Comment -> COMMENT_CREATE");
        Print.println(Color.GREEN, "Back  -> BACK");
        String choice = Input.getStr("Enter your choice: ");
        if ("TASK_CREATE".equalsIgnoreCase(choice)) {
        } else if ("TASK_DELETE".equalsIgnoreCase(choice)) {
        } else if ("MEMBER_CREATE".equalsIgnoreCase(choice)) {
        } else if ("COMMENT_CREATE".equalsIgnoreCase(choice)) {
        } else if ("BACK".equalsIgnoreCase(choice)) {
            return;
        } else {
            Print.println(Color.RED, "Wrong choice");
        }
        taskDetailsMenu(order);
    }
}
