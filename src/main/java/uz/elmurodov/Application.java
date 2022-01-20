package uz.elmurodov;

import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.ui.Menu;
import uz.elmurodov.ui.auth.AuthUserUI;
import uz.elmurodov.ui.column.ColumnUI;
import uz.elmurodov.ui.organization.OrganizationUI;
import uz.elmurodov.ui.project.ProjectUI;
import uz.elmurodov.ui.task.TaskUI;
import uz.jl.utils.Color;
import uz.jl.utils.Input;
import uz.jl.utils.Print;

public class Application {
    private static final AuthUserUI authUserUI = UNIContainer.getBean(AuthUserUI.class);
    private static final OrganizationUI organizationUI = UNIContainer.getBean(OrganizationUI.class);
    private static final ProjectUI projectUI = UNIContainer.getBean(ProjectUI.class);
    private static final ColumnUI columnUI = UNIContainer.getBean(ColumnUI.class);
    private static final TaskUI taskUI = UNIContainer.getBean(TaskUI.class);

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        Menu.getMainMenu();
        String choice = Input.getStr("Enter your choice: ");
        switch (choice.toUpperCase()) {
            case "LOGIN" -> authUserUI.login();
            case "TASKS" -> taskUI.list();
            case "PROJECTS" -> Menu.getProjectMenu();
            case "EMPLOYEE_ADD" -> {

            }
            case "EMPLOYEE_BLOCK" -> {

            }
            case "EMPLOYEE_UNBLOCK" -> {

            }
            case "EMPLOYEE_DELETE" -> {

            }
            case "EMPLOYEE_GET" -> {

            }
            case "EMPLOYEE_LIST" -> {

            }
            case "ORGANIZATION_ADD" -> organizationUI.create();
            case "ORGANIZATION_BLOCK" -> organizationUI.block();
            case "ORGANIZATION_UNBLOCK" -> organizationUI.unblock();
            case "ORGANIZATION_DELETE" -> organizationUI.delete();
            case "ORGANIZATION_GET" -> organizationUI.get();
            case "ORGANIZATION_LIST" -> organizationUI.list();
            case "LOGOUT" -> {
                authUserUI.logout();
            }

            case "EXIT" -> {
                Print.println(Color.GREEN, "Bye");
                return;
            }

            case "JWA_COLUMN_LIST" -> {
                columnUI.list();
            }


            case "HHH" ->{


                taskUI.create();
            }

            default -> {
                Print.println(Color.RED, "Wrong choice");
            }
        }
        run();
    }


}
