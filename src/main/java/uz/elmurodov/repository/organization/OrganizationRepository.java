package uz.elmurodov.repository.organization;

import com.google.gson.reflect.TypeToken;
import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.dtos.organization.OrganizationCreateDto;
import uz.elmurodov.dtos.organization.OrganizationUpdateDto;
import uz.elmurodov.property.DatabaseProperties;
import uz.elmurodov.repository.BaseRepository;
import uz.elmurodov.security.SecurityHolder;
import uz.elmurodov.security.organization.Organization;
import uz.elmurodov.utils.BaseUtils;

import java.sql.Types;
import java.util.List;


public class OrganizationRepository extends BaseRepository<OrganizationCreateDto,
        OrganizationUpdateDto,
        Organization,
        Long> {
    private final DatabaseProperties property = UNIContainer.getBean(DatabaseProperties.class);

    @Override
    public Long create(OrganizationCreateDto dto) {
        return null;
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
    public boolean update(OrganizationUpdateDto dto) {
        prepareArguments(SecurityHolder.organizationSession.getId(), BaseUtils.gson.toJson(dto));
        return (boolean) callProcedure(UNIContainer.
                getBean(DatabaseProperties.class).get("update.organization"), Types.VARCHAR);
    }

    @Override
    public boolean delete(Long id) {
        prepareArguments(SecurityHolder.organizationSession.getId(), dto.getId());
        return (boolean) callProcedure(UNIContainer.
                getBean(DatabaseProperties.class).get("delete.organization"), Types.VARCHAR);
    }

    @Override
    public Organization get(Long id) {
        prepareArguments(id);
        String jsonData = (String) callProcedure(property.get("get.organization"), Types.VARCHAR);
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
