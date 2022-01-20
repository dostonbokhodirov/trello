package uz.elmurodov.ui.organization;

import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.dtos.organization.OrganizationUpdateDto;
import uz.elmurodov.enums.HttpStatus;
import uz.elmurodov.repository.organization.OrganizationRepository;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.security.SecurityHolder;
import uz.elmurodov.services.organization.OrganizationService;
import uz.elmurodov.ui.BaseUI;
import uz.elmurodov.utils.BaseUtils;
import uz.jl.utils.Color;
import uz.jl.utils.Input;
import uz.jl.utils.Print;

/**
 * @author Doston Bokhodirov, Wed 10:01 AM. 1/19/2022
 */
public class OrganizationUI extends BaseUI<OrganizationService> {
    private static final OrganizationService organizationService = UNIContainer.getBean(OrganizationService.class);

    @Override
    public void create() {

    }

    @Override
    public void block() {

    }

    @Override
    public void unblock() {

    }

    @Override
    public void delete() {
        OrganizationUpdateDto dto = new OrganizationUpdateDto();
        dto.setId(SecurityHolder.organizationSession.getId());
        ResponseEntity<Data<?>> response = organizationService.delete(dto.getId());
        if (!response.getStatus().equals(HttpStatus.HTTP_200.getCode())) {
            Print.println(Color.RED, response.getBody().getData());
        } else {
            Print.println(Color.GREEN, "Successfully deleted");
        }
    }

    @Override
    public void update() {
        OrganizationUpdateDto dto = new OrganizationUpdateDto();
        int organizationId = Input.getNum("Organization Id : ");
        String email = Input.getStr("Email : ");
        String website = Input.getStr("Website : ");
        String logo = Input.getStr("Logo : ");
        String location = Input.getStr("Location : ");
        dto.setEmail(email);
        dto.setLocation(location);
        dto.setWebsite(website);
        dto.setLogo(logo);
        dto.setId((long) organizationId);
        ResponseEntity<Data<?>> response = organizationService.update(dto);
        if (!response.getStatus().equals(HttpStatus.HTTP_200.getCode())) {
            Print.println(Color.RED, response.getBody().getData());
        } else {
            Print.println(Color.GREEN, "Successfully blocked project");
        }
    }

    @Override
    public void get() {
        ResponseEntity<Data<?>> response = service.get(SecurityHolder.organizationSession.getId());
        if (!response.getStatus().equals(HttpStatus.HTTP_200.getCode())) {
            Print.println(Color.RED, response.getBody().getData());

        } else Print.println(Color.BLUE, response.getBody().getData());
    }

    @Override
    public void list() {
        ResponseEntity<Data<?>> response = service.list();
        if (!response.getStatus().equals(HttpStatus.HTTP_200.getCode())) {
            Print.println(response.getBody());
        } else {
            Print.println(BaseUtils.gson.toJson(response.getBody()));
        }
    }
}
