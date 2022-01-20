package uz.elmurodov;

import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.security.SecurityHolder;
import uz.elmurodov.security.task.Task;
import uz.elmurodov.ui.auth.AuthUserUI;
import uz.elmurodov.ui.Menu;
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
            case "LOGIN" -> {
                authUserUI.login();
            }
            case "TASKS" -> {

            }
            case "PROJECTS" -> {
                Menu.getProjectMenu();
            }
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
            case "ORGANIZATION_ADD" -> {

            }
            case "ORGANIZATION_BLOCK" -> {

            }
            case "ORGANIZATION_UNBLOCK" -> {

            }
            case "ORGANIZATION_DELETE" -> {

            }
            case "ORGANIZATION_GET" -> {

            }
            case "ORGANIZATION_LIST" -> {

            }
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


            default -> {
                Print.println(Color.RED, "Wrong choice");
            }
        }
        run();
    }


}
