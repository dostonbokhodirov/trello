package uz.elmurodov.repository.user;

import uz.elmurodov.criterias.GenericCriteria;
import uz.elmurodov.dtos.GenericDto;
import uz.elmurodov.dtos.auth.UserCreateDto;
import uz.elmurodov.dtos.auth.UserUpdateDto;
import uz.elmurodov.dtos.user.BlockDto;
import uz.elmurodov.exception.ApiRuntimeException;
import uz.elmurodov.exception.CustomerSQLException;
import uz.elmurodov.repository.AbstractRepository;
import uz.elmurodov.repository.GenericCrudRepository;
import uz.elmurodov.repository.GenericRepository;
import uz.elmurodov.security.SecurityHolder;
import uz.elmurodov.utils.BaseUtils;

import javax.print.attribute.standard.MediaSize;
import java.io.Serializable;
import java.sql.Types;
import java.util.List;

public class UserRepository extends AbstractRepository implements
        GenericCrudRepository<GenericDto, UserCreateDto, UserUpdateDto, Long>,
        GenericRepository<GenericDto, GenericCriteria> {

    @Override
    public Long create(UserCreateDto dto) {
        String json = BaseUtils.gson.toJson(dto);
        prepareArguments(json, SecurityHolder.authUserSession.getId());
        return (long) callProcedure(property.get("user.create"), Types.BIGINT);
    }

    @Override
    public GenericDto get(Long id) {
        return null;
    }

    @Override
    public Boolean update(UserUpdateDto dto) {
        return false;
    }

    @Override
    public void delete(Long id) {
        try {
            prepareArguments(id, SecurityHolder.authUserSession.getId());
            callProcedure(property.get("user.delete"), Types.BOOLEAN);
        } catch (CustomerSQLException e) {
            throw new ApiRuntimeException(e.getFriendlyMessage(), e.getStatus());
        }
    }

    @Override
    public List<GenericDto> list(GenericCriteria criteria) {
        return null;
    }

    public void block(BlockDto dto) {
        prepareArguments(gson.toJson(dto), SecurityHolder.authUserSession.getId());
        callProcedure(property.get("user.block"), Types.BOOLEAN);
    }
}
