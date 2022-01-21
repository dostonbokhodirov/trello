package uz.elmurodov.exception;

import lombok.Getter;
import uz.elmurodov.enums.HttpStatus;

@Getter
public class ApiRuntimeException extends RuntimeException {
    private Integer status;

    public ApiRuntimeException(String message, HttpStatus status) {
        super(message);
        this.status = status.getCode();
    }
}
