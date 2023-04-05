package tw.jw.mapdice.domain;

import java.io.Serializable;
import lombok.Data;

@Data
public class Place implements Serializable {
    private String id;

    private String name;

    private String url;

    private String website;

    private String address;
}