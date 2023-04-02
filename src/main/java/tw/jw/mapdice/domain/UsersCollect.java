package tw.jw.mapdice.domain;

import java.io.Serializable;
import lombok.Data;

@Data
public class UsersCollect implements Serializable {
    private Integer id;

    private Integer userId;

    private String placeId;
}