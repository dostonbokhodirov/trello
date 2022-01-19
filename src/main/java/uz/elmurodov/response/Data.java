package uz.elmurodov.response;

import lombok.Getter;
import uz.elmurodov.dtos.GenericDto;
import uz.elmurodov.security.Auditable;

/**
 * @param <B> Body
 */
@Getter
public class Data<B>{
    private final B data;
    private final Long total;

    public Data(B data) {
        this(data, 0L);
    }

    public Data(B data, Long total) {
        this.data = data;
        this.total = total;
    }
}
