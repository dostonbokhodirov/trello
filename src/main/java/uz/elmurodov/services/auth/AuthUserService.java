package uz.elmurodov.services.auth;

import uz.elmurodov.dtos.auth.AuthUserCreateDto;
import uz.elmurodov.dtos.auth.AuthUserUpdateDto;
import uz.elmurodov.exception.CustomerSQLException;
import uz.elmurodov.repository.auth.AuthUserRepository;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.security.SecurityHolder;
import uz.elmurodov.services.BaseService;

import static uz.elmurodov.security.SecurityHolder.*;

public class AuthUserService extends BaseService<AuthUserRepository,
        AuthUserCreateDto,
        AuthUserUpdateDto,
        Long> {

    public AuthUserService(AuthUserRepository repository) {
        super(repository);
    }

    public ResponseEntity<Data<?>> login(String username, String password) {
        try {
            SecurityHolder.setSessionUser(repository.login(username, password));
            permissions = authUserSession.getPermissions();
//            projectSession.setId(3L); // TODO: 1/20/22 olib tashlash kerak, shunchaki test uchun
            return new ResponseEntity<>(new Data<>(true));
        } catch (CustomerSQLException e) {
            return new ResponseEntity<>(new Data<>(e.getFriendlyMessage()), e.getStatus());
        }
    }

    @Override
    public ResponseEntity<Data<?>> create(AuthUserCreateDto dto) {
        try {
            return new ResponseEntity<>(new Data<>(repository.create(dto)));
        } catch (CustomerSQLException e) {
            return new ResponseEntity<>(new Data<>(e.getFriendlyMessage()),e.getStatus());
        }
    }

    @Override
    public ResponseEntity<Data<?>> get(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Data<?>> block(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Data<?>> unblock(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Data<?>> update(AuthUserUpdateDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<Data<?>> delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Data<?>> list() {
        return null;
    }

    public ResponseEntity<Data<?>> isLeader(Long userId, Long projectId) {
        try {
            return new ResponseEntity<>(new Data<>(repository.isLeader(userId, projectId)));
        } catch (CustomerSQLException e) {
            return new ResponseEntity<>(new Data<>(e.getFriendlyMessage()), e.getStatus());
        }
    }
}
