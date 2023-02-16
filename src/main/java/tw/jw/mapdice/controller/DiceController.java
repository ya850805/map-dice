package tw.jw.mapdice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import tw.jw.mapdice.constant.MapDiceConstant;
import tw.jw.mapdice.exception.DiceException;
import tw.jw.mapdice.model.DiceResponse;
import tw.jw.mapdice.model.PlaceResponse;

import java.util.List;
import java.util.Random;


@RequestMapping("/dice")
@RestController
public class DiceController {
    @Value("${google.api.key}")
    private String apiKey;

    private Random random = new Random();

    @GetMapping("")
    public PlaceResponse dice(
        @RequestParam("latitude") Double latitude,
        @RequestParam("longitude") Double longitude,
        @RequestParam("radius") Double radius,
        @RequestParam("type") String type
    ) {
        //TODO an user can only dice once in one day.

        String requestURL = String.format(MapDiceConstant.NEARBY_SEARCH_URL, latitude, longitude, radius, type, apiKey);
        RestTemplate restTemplate = new RestTemplate();
        DiceResponse response = restTemplate.getForEntity(requestURL, DiceResponse.class).getBody();

        if(!"OK".equals(response.getStatus())) {
            throw new DiceException(response.getStatus());
        }

        List<PlaceResponse> results = response.getResults();
        int randIdx = random.nextInt(results.size());

        return results.get(randIdx);
    }
}
