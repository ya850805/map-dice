package tw.jw.mapdice.model;

import lombok.Data;


@Data
public class PlaceDetailResponse {
    private PlaceResponse result;
    private String status;
}
