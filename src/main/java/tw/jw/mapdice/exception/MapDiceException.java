package tw.jw.mapdice.exception;

import lombok.Data;

@Data
public class MapDiceException extends RuntimeException {
    private Integer code;
    private String message;

    public MapDiceException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
