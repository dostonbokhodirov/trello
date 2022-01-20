package uz.elmurodov.ui;

import uz.elmurodov.security.auth.PermissionsItem;
import uz.elmurodov.security.SecurityHolder;
import uz.jl.utils.Color;
import uz.jl.utils.Print;

import java.util.Objects;

import static uz.elmurodov.security.SecurityHolder.permissions;

public class Menu {


    public static void getMainMenu() {
        if (Objects.isNull(SecurityHolder.authUserSession)) {
            Print.println(Color.BLUE, "Login -> LOGIN");
        } else {
            try{
                for (PermissionsItem permission : permissions) {
                    Print.println(Color.BLUE, permission.getName() + " -> " + permission.getCode());
                }
            }catch (NullPointerException e){
                Print.println(Color.RED,"Permission not found");
            }
            Print.println("Logout -> LOGOUT");
        }
        Print.println(Color.BLUE, "Exit -> EXIT");
    }
}
