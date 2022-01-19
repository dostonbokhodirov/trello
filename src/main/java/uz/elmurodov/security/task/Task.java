package uz.elmurodov.security.task;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import uz.elmurodov.security.Auditable;

import java.time.LocalDate;

/**
 * @author Doston Bokhodirov, Wed 8:39 PM. 1/19/2022
 */
@Data
public class Task implements Auditable {
    private Long id;

    private int level;

    private int projectColumnId;

    private String description;

    @SerializedName("created_at")
    private LocalDate createdAt;

    @SerializedName("created_by")
    private Integer createdBy;

    private int priority;

    private boolean isDeleted;

    @SerializedName("updated_at")
    private LocalDate updatedAt;

    private String name;

    @SerializedName("updated_by")
    private Integer updatedBy;

    private String deadline;

    private int order;
}
