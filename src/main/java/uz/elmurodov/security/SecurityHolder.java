package uz.elmurodov.security;

import lombok.Setter;
import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.security.auth.AuthUser;
import uz.elmurodov.security.auth.PermissionsItem;
import uz.elmurodov.security.column.Column;
import uz.elmurodov.security.organization.Organization;
import uz.elmurodov.security.project.Project;
import uz.elmurodov.security.task.Task;

import java.util.List;
import java.util.Objects;

@Setter
public class SecurityHolder {
    public static AuthUser authUserSession;

    public static boolean hasPermission(String permission) {
        if (Objects.isNull(authUserSession))
            throw new RuntimeException("NOT_AUTHORIZED");
        for (PermissionsItem sessionPermission : authUserSession.getPermissions()) {
            if (sessionPermission.getCode().equals(permission)) return true;
        }
        return false;
    }

    public static void setSessionUser(AuthUser authUser) {
        SecurityHolder.authUserSession = authUser;
    }


}
