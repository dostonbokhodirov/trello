package uz.elmurodov.dtos.column;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import uz.elmurodov.dtos.GenericDto;

@Data
public class ColumnUpdateDto extends GenericDto {
    @SerializedName("column_id")
    private int columnId;

    private String emoji;

    private String name;

    private int order;
}