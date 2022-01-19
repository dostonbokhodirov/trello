package uz.elmurodov.container;

import uz.elmurodov.property.ApplicationProperties;
import uz.elmurodov.property.DatabaseProperties;
import uz.elmurodov.repository.BaseRepository;
import uz.elmurodov.repository.auth.AuthUserRepository;
import uz.elmurodov.repository.auth.AuthUserRepositoryImpl;
import uz.elmurodov.repository.organization.OrganizationRepository;
import uz.elmurodov.services.BaseService;
import uz.elmurodov.services.auth.AuthUserService;
import uz.elmurodov.services.organization.OrganizationService;
import uz.elmurodov.ui.AuthUserUI;
import uz.elmurodov.ui.organization.OrganizationUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

public class UNIContainer {
    private static final ApplicationProperties APPLICATION_PROPERTIES;
    private static final DatabaseProperties DATABASE_PROPERTIES;
    private static Connection CONNECTION;
    private final static AuthUserRepositoryImpl AUTH_USER_REPOSITORY;
    private final static AuthUserService AUTH_USER_SERVICE;
    private static final AuthUserUI AUTH_USER_UI;
    private static final OrganizationUI ORGANIZATION_UI;
    private static final OrganizationService ORGANIZATION_SERVICE;
    private static final OrganizationRepository ORGANIZATION_REPOSITORY;

    static {
        APPLICATION_PROPERTIES = new ApplicationProperties();
        DATABASE_PROPERTIES = new DatabaseProperties();
        try {
            CONNECTION = DriverManager.getConnection(
                    APPLICATION_PROPERTIES.get("db.jdbc"),
                    APPLICATION_PROPERTIES.get("db.username"),
                    APPLICATION_PROPERTIES.get("db.password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        AUTH_USER_REPOSITORY = new AuthUserRepositoryImpl();
        AUTH_USER_SERVICE = new AuthUserService(AUTH_USER_REPOSITORY);
        AUTH_USER_UI = new AuthUserUI();
        ORGANIZATION_UI = new OrganizationUI();
        ORGANIZATION_SERVICE = new OrganizationService();
        ORGANIZATION_REPOSITORY = new OrganizationRepository();
    }

    public static <T> T getBean(Class<T> bean) {
        return getBean(bean.getSimpleName().toUpperCase(Locale.ROOT));
    }

    public static <T> T getBean(String bean) {
        bean = bean.toUpperCase(Locale.ROOT);
        return switch (bean) {
            case "APPLICATIONPROPERTIES" -> (T) APPLICATION_PROPERTIES;
            case "DATABASEPROPERTIES" -> (T) DATABASE_PROPERTIES;
            case "CONNECTION" -> (T) CONNECTION;
            case "AUTHUSERSERVICE" -> (T) AUTH_USER_SERVICE;
            case "AUTHUSERREPOSITORY" -> (T) AUTH_USER_REPOSITORY;
            case "AUTHUSERUI" -> (T) AUTH_USER_UI;
            case "ORGANIZATIONUI" -> (T) ORGANIZATION_UI;
            case "ORGANIZATIONSERVICE" -> (T) ORGANIZATION_SERVICE;
            case "ORGANIZATIONREPOSITORY" -> (T) ORGANIZATION_REPOSITORY;
            default -> throw new RuntimeException("Bean Not Found");
        };
    }


}
