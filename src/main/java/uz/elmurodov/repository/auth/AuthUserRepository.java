package uz.elmurodov.repository.auth;

import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.dtos.auth.AuthUserCreateDto;
import uz.elmurodov.dtos.auth.AuthUserUpdateDto;
import uz.elmurodov.property.DatabaseProperties;
import uz.elmurodov.repository.BaseRepository;
import uz.elmurodov.security.SecurityHolder;
import uz.elmurodov.security.auth.AuthUser;
import uz.elmurodov.utils.BaseUtils;

import java.sql.Types;
import java.util.List;

public class AuthUserRepository extends BaseRepository<AuthUserCreateDto,
        AuthUserUpdateDto,
        AuthUser,
        Long> {
    private final DatabaseProperties property = UNIContainer.getBean(DatabaseProperties.class);

    public AuthUser login(String userName, String password) {
        prepareArguments(userName,password);
        String jsonDATA = (String) callProcedure(property.get("auth.login"), Types.VARCHAR);
        return BaseUtils.gson.fromJson(jsonDATA, AuthUser.class);
    }

    @Override
    public Long create(AuthUserCreateDto dto) {
        String json = BaseUtils.gson.toJson(dto);
        prepareArguments(json, SecurityHolder.authUserSession.getId());
        return (long) callProcedure(property.get("user.create"),Types.BIGINT);
    }

    @Override
    public boolean block(Long id) {
        return true;
    }

    @Override
    public boolean unblock(Long id) {
        return true;
    }

    @Override
    public boolean update(AuthUserUpdateDto dto) {
        return true;
    }

    @Override
    public boolean delete(Long id) {
        return true;
    }

    @Override
    public AuthUser get(Long id) {
        return null;
    }

    @Override
    public List<AuthUser> list() {
        return null;
    }

    public Boolean isLeader(Long userId, Long projectId) {
        prepareArguments(userId, projectId);
        return (Boolean) callProcedure(property.get("auth.isLead"), Types.BOOLEAN);
    }
}
