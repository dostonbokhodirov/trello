package uz.elmurodov.services.organization;

import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.exception.CustomerSQLException;
import uz.elmurodov.repository.organization.OrganizationRepository;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.security.Organization;

import java.util.List;

/**
 * @author Doston Bokhodirov, Wed 10:04 AM. 1/19/2022
 */
public class OrganizationService {
    public ResponseEntity<Data<?>> organizationList(int userId) {
        try {
            OrganizationRepository organizationRepository = UNIContainer.getBean(OrganizationRepository.class);
            List<Organization> organizations = organizationRepository.organizationList(userId);
            return new ResponseEntity<>(new Data<>(organizations, (long) organizations.size()));
        } catch (CustomerSQLException e) {
            return new ResponseEntity<>(new Data<>(e.getFriendlyMessage()), e.getStatus());
        }
    }
}
