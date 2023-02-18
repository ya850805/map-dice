package tw.jw.mapdice.exception.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tw.jw.mapdice.exception.MapDiceException;
import tw.jw.mapdice.model.Response;

@RestControllerAdvice
public class MapDiceExceptionHandler {
    @ExceptionHandler({MapDiceException.class})
    public Response<String> handleDiceException(MapDiceException exception) {
        return Response.build(exception.getCode(), exception.getMessage());
    }

    @ExceptionHandler({Exception.class})
    public Response<String> handleGlobalException(Exception exception) {
        return Response.fail(exception.getMessage());
    }
}
