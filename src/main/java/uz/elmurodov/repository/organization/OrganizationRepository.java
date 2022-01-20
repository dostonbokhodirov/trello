package uz.elmurodov.repository.organization;

import com.google.gson.reflect.TypeToken;
import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.dtos.organization.OrganizationCreateDto;
import uz.elmurodov.dtos.organization.OrganizationUpdateDto;
import uz.elmurodov.property.DatabaseProperties;
import uz.elmurodov.repository.BaseRepository;
import uz.elmurodov.security.SecurityHolder;
<<<<<<< HEAD
<<<<<<< HEAD
import uz.elmurodov.security.task.Task;
=======
import uz.elmurodov.security.organization.Organization;
>>>>>>> origin/developer
=======
import uz.elmurodov.security.organization.Organization;
>>>>>>> origin/developer
import uz.elmurodov.utils.BaseUtils;

import java.lang.reflect.Type;
import java.sql.Types;
import java.util.List;

/**
 * @author Doston Bokhodirov, Wed 10:08 AM. 1/19/2022
 */
public class OrganizationRepository extends BaseRepository<OrganizationCreateDto, OrganizationUpdateDto, Organization, Long, Boolean> {
    private final DatabaseProperties property = UNIContainer.getBean(DatabaseProperties.class);

    @Override
    public Long create(OrganizationCreateDto dto) {
        return null;
    }

    @Override
    public Boolean block(OrganizationUpdateDto dto) {
        return null;
    }

    @Override
    public Boolean unblock(OrganizationUpdateDto dto) {
        return null;
    }

    @Override
    public Boolean update(OrganizationUpdateDto dto) {
        String json = BaseUtils.gson.toJson(dto);
        prepareArguments(json, SecurityHolder.organizationSession.getId());
        return (Boolean) callProcedure("organization.update", Types.BOOLEAN);
    }

    @Override
    public Boolean delete(OrganizationUpdateDto dto) {
        prepareArguments(SecurityHolder.organizationSession.getId(), dto.getId());
        return (Boolean) callProcedure(property.
                get("organization.delete"), Types.BOOLEAN);
    }

    @Override
    public Organization get(Long id) {
        prepareArguments(id);
        String jsonData = (String) callProcedure(property.get("organization.get"), Types.VARCHAR);
        return BaseUtils.gson.fromJson(jsonData, Organization.class);
    }

    @Override
    public List<Organization> list() {
        prepareArguments(SecurityHolder.authUserSession.getId());
        String JsonData = (String) callProcedure(property.get("organization.list"), Types.VARCHAR);
        return BaseUtils.gson.fromJson(JsonData, new TypeToken<List<Organization>>() {
        }.getType());
    }
}
