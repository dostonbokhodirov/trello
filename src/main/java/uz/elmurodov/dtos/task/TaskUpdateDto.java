package uz.elmurodov.dtos.task;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import uz.elmurodov.dtos.GenericDto;

@Data
public class TaskUpdateDto extends GenericDto {
	private int level;

	@SerializedName("project_column_id")
	private int projectColumnId;

	private String name;

	private String description;

	private String deadline;

	private int priority;

	private int order;
}