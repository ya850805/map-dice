package tw.jw.mapdice.model;

import lombok.Data;

@Data
public class UsersCreateRequest {
    private String name;
    private String password;
}
