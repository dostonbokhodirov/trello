package uz.elmurodov.dtos.user;

import lombok.Data;
import uz.elmurodov.dtos.GenericDto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class BlockDto extends GenericDto {
    private String blockedFor;
    private String blockedTill;

    public BlockDto(Long id, String blockedFor, LocalDateTime blockedTill) {
        super(id);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.blockedFor = blockedFor;
        this.blockedTill = blockedTill.format(formatter);
    }
}
