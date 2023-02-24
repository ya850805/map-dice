package tw.jw.mapdice.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UsersCreateRequest {
    @NotBlank(message = "username cannot be blank")
    private String name;
    @NotBlank(message = "password cannot be blank")
    private String password;
}
