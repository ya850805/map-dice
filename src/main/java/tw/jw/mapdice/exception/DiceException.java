package tw.jw.mapdice.exception;

import lombok.Data;

@Data
public class DiceException extends RuntimeException {
    private Integer Code;
    private String message;

    public DiceException(String message) {
        this.message = message;
    }
}
