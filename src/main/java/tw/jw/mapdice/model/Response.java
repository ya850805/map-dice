package tw.jw.mapdice.model;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class Response<T> {
    private T data;
    private Integer code;

    public Response(T data, Integer code) {
        this.data = data;
        this.code = code;
    }

    public static <T> Response<T> build(T data, int status) {
        return new Response<T>(data, status);
    }

    public static <T> Response<T> ok(T data) {
        return new Response<T>(data, HttpStatus.OK.value());
    }

    public static <T> Response<T> fail(T data) {
        return new Response<T>(data, HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
