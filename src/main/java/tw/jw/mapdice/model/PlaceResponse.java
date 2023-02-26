package tw.jw.mapdice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PlaceResponse {
    @JsonProperty("place_id")
    private String placeId;

    private String name;

    private Double rating;

    @JsonProperty("user_ratings_total")
    private Integer userRatingsTotal;

    private String vicinity;
}
