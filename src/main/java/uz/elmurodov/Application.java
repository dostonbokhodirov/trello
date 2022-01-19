package uz.elmurodov;

import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.security.SecurityHolder;
import uz.elmurodov.security.task.Task;
import uz.elmurodov.ui.auth.AuthUserUI;
import uz.elmurodov.ui.Menu;
import uz.elmurodov.ui.organization.OrganizationUI;
import uz.jl.utils.Color;
import uz.jl.utils.Input;
import uz.jl.utils.Print;

public class Application {
    private static final AuthUserUI authUserUI = UNIContainer.getBean(AuthUserUI.class);
    private static final OrganizationUI organizationUI = UNIContainer.getBean(OrganizationUI.class);
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        Menu.getMainMenu();
        String choice = Input.getStr("Your choice: ");
        switch (choice.toUpperCase()) {
            case "LOGIN" -> {
//                AuthUserUI authUserUI = UNIContainer.getBean(AuthUserUI.class);
                authUserUI.login();
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

            }
            case "BlOCK_PROJECT" -> {

            }
            case "UNBLOCK_PROJECT" -> {

            }
            case "UPDATE_PROJECT" -> {

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
//                AuthUserUI authUserUI = UNIContainer.getBean(AuthUserUI.class);
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
