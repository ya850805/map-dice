package tw.jw.mapdice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PlaceDetailReviewResponse {
    @JsonProperty("author_name")
    private String authorName;

    private Integer rating;

    @JsonProperty("relative_time_description")
    private String relativeTimeDescription;

    private String text;
}
