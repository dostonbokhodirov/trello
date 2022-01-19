package uz.elmurodov.dtos.organization;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import uz.elmurodov.dtos.GenericBaseDto;
import uz.elmurodov.security.organization.Point;

@Data
public class OrganizationCreateDto implements GenericBaseDto {
	private String website;

	@SerializedName("reg_number")
	private String regNumber;

	private String name;

	private String logo;

	private Point location;

	private String email;
}