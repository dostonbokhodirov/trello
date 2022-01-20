package uz.elmurodov;

import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.security.SecurityHolder;
import uz.elmurodov.security.task.Task;
import uz.elmurodov.ui.auth.AuthUserUI;
import uz.elmurodov.ui.Menu;
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
    private static final TaskUI taskUI = UNIContainer.getBean(TaskUI.class);
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        Menu.getMainMenu();
        String choice = Input.getStr("Your choice: ");
        switch (choice.toUpperCase()) {
            case "LOGIN" -> {
                authUserUI.login();
            }
            case "TASKS" -> {

            }
            case "PROJECTS" -> {
                projectUI.list();
            }
            case "CREATE_ORGANIZATION" -> {

            }
            case "BlOCK_ORGANIZATION" -> {

            }
            case "UNBLOCK_ORGANIZATION" -> {

            }
            case "UPDATE_ORGANIZATION" -> {

            }
            case "DELETE_ORGANIZATION" -> {

            }
            case "GET_ORGANIZATION" -> {

            }
            case "ORGANIZATIONS_LIST" -> {

            }
            case "CREATE_PROJECT" -> {
                projectUI.create();
            }
            case "BlOCK_PROJECT" -> {
                projectUI.block();
            }
            case "UNBLOCK_PROJECT" -> {
                projectUI.unblock();
            }
            case "UPDATE_PROJECT" -> {
                projectUI.update();
            }
            case "DELETE_PROJECT" -> {

            }
            case "GET_PROJECT" -> {

            }
            case "PROJECTS_LIST" -> {

            }

            case "ORGANIZATION_LIST" -> {
                organizationUI.list();
            }

            case "AUTH_USER_INFO" -> {
                authUserUI.get();
            }

            case "LOGOUT" -> {
                authUserUI.logout();
            }

            case "EXIT" -> {
                Print.println(Color.GREEN, "Bye");
                return;
            }
            default -> {
                Print.println(Color.RED, "Wrong choice");
            }
        }
        run();
    }


}
