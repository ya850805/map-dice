package tw.jw.mapdice.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UsersCollectCreateRequest {
    @NotBlank(message = "place id cannot be blank.")
    private String placeId;
}
