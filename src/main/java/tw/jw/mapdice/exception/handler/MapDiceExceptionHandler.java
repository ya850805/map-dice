package tw.jw.mapdice.exception.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tw.jw.mapdice.exception.DiceException;
import tw.jw.mapdice.model.Response;

@RestControllerAdvice
public class MapDiceExceptionHandler {
    @ExceptionHandler({DiceException.class})
    public Response<String> handleDiceException(DiceException exception) {
        return Response.build(exception.getCode(), exception.getMessage());
    }

    @ExceptionHandler({Exception.class})
    public Response<String> handleGlobalException(Exception exception) {
        return Response.fail(exception.getMessage());
    }
}
