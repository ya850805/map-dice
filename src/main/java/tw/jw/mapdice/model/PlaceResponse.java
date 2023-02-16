package tw.jw.mapdice.model;

import lombok.Data;

@Data
public class PlaceResponse {
    private String name;
    private Double rating;
    private Integer userRatingsTotal;
    private String vicinity;
}
