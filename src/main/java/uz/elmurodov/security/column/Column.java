package uz.elmurodov.security.column;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import uz.elmurodov.security.Auditable;

import java.time.LocalDate;

/**
 * @author Doston Bokhodirov, Wed 8:36 PM. 1/19/2022
 */

@Data
public class Column implements Auditable {
    @SerializedName("is_deleted")
    private Boolean isDeleted;

    private String emoji;

    @SerializedName("updated_at")
    private LocalDate updatedAt;

    @SerializedName("project_id")
    private Integer projectId;

    private String name;

    @SerializedName("updated_by")
    private Integer updatedBy;

    @SerializedName("created_at")
    private String createdAt;

    private Integer id;

    @SerializedName("created_by")
    private Integer createdBy;

    @SerializedName("order")
    private Integer order;
}
