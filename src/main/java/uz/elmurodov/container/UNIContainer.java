package uz.elmurodov.container;

import uz.elmurodov.property.ApplicationProperties;
import uz.elmurodov.property.DatabaseProperties;
import uz.elmurodov.repository.auth.AuthUserRepository;
import uz.elmurodov.repository.column.ColumnRepository;
import uz.elmurodov.repository.organization.OrganizationRepository;
import uz.elmurodov.repository.project.ProjectRepository;
import uz.elmurodov.repository.task.TaskRepository;
import uz.elmurodov.services.auth.AuthUserService;
import uz.elmurodov.services.column.ColumnService;
import uz.elmurodov.services.organization.OrganizationService;
import uz.elmurodov.services.project.ProjectService;
import uz.elmurodov.services.task.TaskService;
import uz.elmurodov.ui.auth.AuthUserUI;
import uz.elmurodov.ui.column.ColumnUI;
import uz.elmurodov.ui.organization.OrganizationUI;
import uz.elmurodov.ui.project.ProjectUI;
import uz.elmurodov.ui.task.TaskUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

public class UNIContainer {
    private static final ApplicationProperties APPLICATION_PROPERTIES;
    private static final DatabaseProperties DATABASE_PROPERTIES;
    private static Connection CONNECTION;

    private static final OrganizationRepository ORGANIZATION_REPOSITORY;
    private static final ProjectRepository PROJECT_REPOSITORY;
    private static final ColumnRepository COLUMN_REPOSITORY;
    private static final TaskRepository TASK_REPOSITORY;
    private final static AuthUserRepository AUTH_USER_REPOSITORY;

    private static final OrganizationService ORGANIZATION_SERVICE;
    private static final ProjectService PROJECT_SERVICE;
    private static final ColumnService COLUMN_SERVICE;
    private static final TaskService TASK_SERVICE;
    private final static AuthUserService AUTH_USER_SERVICE;

    private static final OrganizationUI ORGANIZATION_UI;
    private static final ProjectUI PROJECT_UI;
    private static final ColumnUI COLUMN_UI;
    private static final TaskUI TASK_UI;
    private static final AuthUserUI AUTH_USER_UI;


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
        ORGANIZATION_REPOSITORY = new OrganizationRepository();
        PROJECT_REPOSITORY = new ProjectRepository();
        COLUMN_REPOSITORY = new ColumnRepository();
        TASK_REPOSITORY = new TaskRepository();
        AUTH_USER_REPOSITORY = new AuthUserRepository();

        ORGANIZATION_SERVICE = new OrganizationService();
        PROJECT_SERVICE = new ProjectService();
        COLUMN_SERVICE = new ColumnService();
        TASK_SERVICE = new TaskService();
        AUTH_USER_SERVICE = new AuthUserService(AUTH_USER_REPOSITORY);

        ORGANIZATION_UI = new OrganizationUI();
        PROJECT_UI = new ProjectUI();
        COLUMN_UI = new ColumnUI();
        TASK_UI = new TaskUI();
        AUTH_USER_UI = new AuthUserUI();
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

            case "ORGANIZATIONSERVICE" -> (T) ORGANIZATION_SERVICE;
            case "PROJECTSERVICE" -> (T) PROJECT_SERVICE;
            case "COLUMNSERVICE" -> (T) COLUMN_SERVICE;
            case "TASKSERVICE" -> (T) TASK_SERVICE;
            case "AUTHUSERSERVICE" -> (T) AUTH_USER_SERVICE;

            case "ORGANIZATIONREPOSITORY" -> (T) ORGANIZATION_REPOSITORY;
            case "PROJECTREPOSITORY" -> (T) PROJECT_REPOSITORY;
            case "COLUMNREPOSITORY" -> (T) COLUMN_REPOSITORY;
            case "TASLREPOSITORY" -> (T) TASK_REPOSITORY;
            case "AUTHUSERREPOSITORY" -> (T) AUTH_USER_REPOSITORY;

            case "ORGANIZATIONUI" -> (T) ORGANIZATION_UI;
            case "PROJECTUI" -> (T) PROJECT_UI;
            case "COLUMNUI" -> (T) COLUMN_UI;
            case "TASKUI" -> (T) TASK_UI;
            case "AUTHUSERUI" -> (T) AUTH_USER_UI;

            default -> throw new RuntimeException("Bean Not Found");
        };
    }


}
