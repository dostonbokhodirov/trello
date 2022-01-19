package uz.elmurodov.ui.organization;

import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.enums.HttpStatus;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.security.SecurityHolder;
import uz.elmurodov.services.organization.OrganizationService;
import uz.elmurodov.ui.BaseUI;
import uz.elmurodov.utils.BaseUtils;
import uz.jl.utils.Print;

/**
 * @author Doston Bokhodirov, Wed 10:01 AM. 1/19/2022
 */
public class OrganizationUI extends BaseUI {

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

    }

    @Override
    public void update() {

    }

    @Override
    public void get() {

    }

    @Override
    public void list() {
        OrganizationService organizationService = UNIContainer.getBean(OrganizationService.class);
        ResponseEntity<Data<?>> response = organizationService.list();
        if (!response.getStatus().equals(HttpStatus.HTTP_200.getCode())) {
            Print.println(response.getBody());
        } else {
            Print.println(BaseUtils.gson.toJson(response.getBody()));
        }
    }
}
