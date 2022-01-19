package uz.elmurodov.ui.organization;

import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.enums.HttpStatus;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.services.organization.OrganizationService;
import uz.elmurodov.utils.BaseUtils;
import uz.jl.utils.Print;

/**
 * @author Doston Bokhodirov, Wed 10:01 AM. 1/19/2022
 */
public class OrganizationUI {
    public void organizationList(int userId) {
        OrganizationService organizationService = UNIContainer.getBean(OrganizationService.class);
        ResponseEntity<Data<?>> response = organizationService.organizationList(userId);
        if (!response.getStatus().equals(HttpStatus.HTTP_200.getCode())) {
            Print.println(response.getBody());
        } else {
            Print.println(BaseUtils.gson.toJson(response.getBody().getData()));
        }
    }
}
