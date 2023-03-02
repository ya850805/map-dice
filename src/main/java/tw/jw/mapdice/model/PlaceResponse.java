package tw.jw.mapdice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PlaceResponse {
    @JsonProperty("place_id")
    private String placeId;

    private String name;

    private Double rating;

    @JsonProperty("user_ratings_total")
    private Integer userRatingsTotal;

    private String vicinity;

    private String url;

    private String website;

    @JsonProperty("formatted_address")
    private String formattedAddress;

    private List<PlaceDetailReviewResponse> reviews;

    @JsonProperty("formatted_phone_number")
    private String formattedPhoneNumber;
}
