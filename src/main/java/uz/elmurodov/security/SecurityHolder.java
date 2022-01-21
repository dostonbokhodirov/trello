package uz.elmurodov.security;

import lombok.Setter;
import uz.elmurodov.security.auth.Session;
import uz.elmurodov.security.auth.PermissionsItem;

import java.util.List;
import java.util.Objects;

@Setter
public class SecurityHolder {
    public static Session authUserSession;

    public static void setSessionUser(Session authUser) {
        authUserSession = authUser;
    }
}
