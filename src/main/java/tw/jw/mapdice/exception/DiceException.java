package tw.jw.mapdice.exception;

import lombok.Data;

@Data
public class DiceException extends RuntimeException {
    private Integer code;
    private String message;

    public DiceException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
