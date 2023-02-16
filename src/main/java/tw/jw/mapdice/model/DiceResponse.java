package tw.jw.mapdice.model;

import lombok.Data;

import java.util.List;

@Data
public class DiceResponse {
    private List<PlaceResponse> results;
    private String status;
}
