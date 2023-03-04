package tw.jw.mapdice.domain;

import java.io.Serializable;
import lombok.Data;

@Data
public class Users implements Serializable {
    private Integer id;

    private String email;

    private String name;

    private String password;
}