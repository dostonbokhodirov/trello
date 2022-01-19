package uz.elmurodov.repository.organization;

import com.google.gson.reflect.TypeToken;
import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.property.DatabaseProperties;
import uz.elmurodov.repository.BaseRepository;
import uz.elmurodov.security.Organization;
import uz.elmurodov.utils.BaseUtils;

import java.lang.reflect.Type;
import java.sql.Types;
import java.util.List;

/**
 * @author Doston Bokhodirov, Wed 10:08 AM. 1/19/2022
 */
public class OrganizationRepository extends BaseRepository {
    private final DatabaseProperties property = UNIContainer.getBean(DatabaseProperties.class);

    public List<Organization> organizationList(int userId) {
        Type type = new TypeToken<List<Organization>>() {
        }.getType();
        prepareArguments(userId);
        String JsonData = (String) callProcedure(property.get("organization.list"), Types.VARCHAR);
        return BaseUtils.gson.fromJson(JsonData, type);
    }
}
