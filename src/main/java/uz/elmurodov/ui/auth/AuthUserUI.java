package uz.elmurodov.ui.auth;

import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.enums.HttpStatus;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.security.SecurityHolder;
import uz.elmurodov.services.auth.AuthUserService;
import uz.elmurodov.ui.BaseUI;
import uz.jl.utils.Color;
import uz.jl.utils.Input;
import uz.jl.utils.Print;

/**
 * @author Doston Bokhodirov, Mon 2:43 PM. 1/17/2022
 */
public class AuthUserUI extends BaseUI {

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
        AuthUserService authUserService = UNIContainer.getBean(AuthUserService.class);
        ResponseEntity<Data<?>> response = authUserService.get((long) SecurityHolder.authUserSession.getId());
        if (!response.getStatus().equals(HttpStatus.HTTP_200.getCode())) {
            Print.println(Color.RED, response.getBody().getData());
        } else Print.println(Color.BLUE, response.getBody().getData());
    }

    @Override
    public void list() {

    }

    public void login() {
        String username = Input.getStr("Enter username: ");
        String password = Input.getStr("Enter password: ");
        AuthUserService authUserService = UNIContainer.getBean(AuthUserService.class);
        ResponseEntity<Data<?>> response = authUserService.login(username, password);
        if (!response.getStatus().equals(HttpStatus.HTTP_200.getCode())) {
            Print.println(Color.RED, response.getBody().getData());
        } else {
            Print.println(Color.BLUE, "Successfully logged in");
//            System.out.println(BaseUtils.gson.toJson(SecurityHolder.session));
        }
    }

    public void logout() {
        SecurityHolder.setSessionUser(null);
        SecurityHolder.permissions = null;
        Print.println(Color.GREEN, "Successfully logged out");
    }
}
