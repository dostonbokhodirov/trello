package uz.elmurodov.services.organization;

import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.dtos.organization.OrganizationCreateDto;
import uz.elmurodov.dtos.organization.OrganizationUpdateDto;
import uz.elmurodov.exception.CustomerSQLException;
import uz.elmurodov.repository.organization.OrganizationRepository;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.security.organization.Organization;
import uz.elmurodov.security.SecurityHolder;
import uz.elmurodov.services.BaseService;

import java.util.List;

/**
 * @author Doston Bokhodirov, Wed 10:04 AM. 1/19/2022
 */
public class OrganizationService extends BaseService<OrganizationRepository,
        OrganizationCreateDto,
        OrganizationUpdateDto,
        Long> {

    public OrganizationService(OrganizationRepository repository) {
        super(repository);
    }

    @Override
    public ResponseEntity<Data<?>> create(OrganizationCreateDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<Data<?>> get(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Data<?>> block(OrganizationUpdateDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<Data<?>> unblock(OrganizationUpdateDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<Data<?>> update(OrganizationUpdateDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<Data<?>> delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Data<?>> list() {
        try {
            OrganizationRepository organizationRepository = UNIContainer.getBean(OrganizationRepository.class);
            List<Organization> organizations = organizationRepository.list();
            return new ResponseEntity<>(new Data<>(organizations, (long) organizations.size()));
        } catch (CustomerSQLException e) {
            return new ResponseEntity<>(new Data<>(e.getFriendlyMessage()), e.getStatus());
        }
    }
}
