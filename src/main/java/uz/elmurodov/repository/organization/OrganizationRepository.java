package uz.elmurodov.repository.organization;

import com.google.gson.reflect.TypeToken;
import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.dtos.organization.OrganizationCreateDto;
import uz.elmurodov.dtos.organization.OrganizationUpdateDto;
import uz.elmurodov.property.DatabaseProperties;
import uz.elmurodov.repository.BaseRepository;
import uz.elmurodov.security.SecurityHolder;
import uz.elmurodov.security.organization.Organization;
import uz.elmurodov.security.task.Task;
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
        prepareArguments(SecurityHolder.organizationSession.getId(), BaseUtils.gson.toJson(dto));
        return (Boolean) callProcedure(UNIContainer.
                getBean(DatabaseProperties.class).get("update.organization"), Types.VARCHAR);
    }

    @Override
    public Boolean delete(OrganizationUpdateDto dto) {
        prepareArguments(SecurityHolder.organizationSession.getId(), dto.getId());
        return (Boolean) callProcedure(UNIContainer.
                getBean(DatabaseProperties.class).get("delete.organization"), Types.VARCHAR);
    }

    @Override
    public Organization get(Long id) {
        prepareArguments(id);
        String jsonData = (String) callProcedure(property.get("get.organization"), Types.VARCHAR);
        return BaseUtils.gson.fromJson(jsonData, Organization.class);    }

    @Override
    public List<Organization> list() {
        prepareArguments(SecurityHolder.authUserSession.getId());
        String JsonData = (String) callProcedure(property.get("organization.list"), Types.VARCHAR);
        return BaseUtils.gson.fromJson(JsonData, new TypeToken<List<Organization>>() {
        }.getType());
    }
}
