package tw.jw.mapdice.model;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class Response<T> {
    private Integer code;
    private T data;

    public Response(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public static <T> Response<T> build(int status, T data) {
        return new Response<T>(status, data);
    }

    public static <T> Response<T> ok(T data) {
        return new Response<T>(HttpStatus.OK.value(), data);
    }

    public static <T> Response<T> fail(T data) {
        return new Response<T>(HttpStatus.INTERNAL_SERVER_ERROR.value(), data);
    }
}
