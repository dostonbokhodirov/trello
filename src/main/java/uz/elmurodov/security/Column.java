package uz.elmurodov.security;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Column {

    @SerializedName("is_deleted")
    private Boolean isDeleted;

    @SerializedName("emoji")
    private String emoji;

    @SerializedName("updated_at")
    private LocalDate updatedAt;

    @SerializedName("project_id")
    private Integer projectId;

    @SerializedName("name")
    private String name;

    @SerializedName("updated_by")
    private Integer updatedBy;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("id")
    private Integer id;

    @SerializedName("created_by")
    private Integer createdBy;

    @SerializedName("order")
    private Integer order;

    public Boolean isIsDeleted() {
        return isDeleted;
    }

    public String getEmoji() {
        return emoji;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public String getName() {
        return name;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public Integer getOrder() {
        return order;
    }

}