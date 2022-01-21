package uz.elmurodov.services;

import uz.elmurodov.criterias.GenericCriteria;
import uz.elmurodov.dtos.GenericBaseDto;
import uz.elmurodov.dtos.GenericDto;
import uz.elmurodov.repository.AbstractRepository;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.security.SecurityHolder;
import uz.elmurodov.security.auth.PermissionsItem;
import uz.elmurodov.security.auth.RolesItem;
import uz.elmurodov.security.auth.Session;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;


/**
 * @param <R> -> Repository
 *            CR -> Create Dto
 *            D-> Dto
 *            K->Key
 */
public abstract class AbstractService<R extends AbstractRepository> {

    protected final R repository;

    public AbstractService(R repository) {
        this.repository = repository;
    }

    protected boolean hasRole(String role) {
        Session session = SecurityHolder.authUserSession;
        if (Objects.isNull(session)) return false;
        List<RolesItem> roles = session.getRoles();
        if (Objects.isNull(roles)) return false;
        return roles.stream().anyMatch(r -> r.getCode().equalsIgnoreCase(role));
    }

    protected boolean hasPermission(String permission) {
        Session session = SecurityHolder.authUserSession;
        if (Objects.isNull(session)) return false;
        List<PermissionsItem> permissions = session.getPermissions();
        if (Objects.isNull(permissions)) return false;
        return permissions.stream().anyMatch(p -> p.getCode().equalsIgnoreCase(permission));
    }

}
