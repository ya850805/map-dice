package tw.jw.mapdice.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UpdatePasswordRequest {
    @NotBlank(message = "uuid cannot be blank")
    private String uuid;
    @NotBlank(message = "password cannot be blank")
    private String password;
}
