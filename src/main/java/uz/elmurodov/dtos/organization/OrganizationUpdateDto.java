package uz.elmurodov.dtos.organization;

import lombok.Data;
import uz.elmurodov.dtos.GenericDto;
import uz.elmurodov.security.organization.Point;

@Data
public class OrganizationUpdateDto extends GenericDto {
	private String website;
	private String name;
	private String logo;
	private Point location;
	private String email;
}