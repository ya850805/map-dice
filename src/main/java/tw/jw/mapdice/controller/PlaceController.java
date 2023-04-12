package tw.jw.mapdice.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import tw.jw.mapdice.constant.MapDiceConstant;
import tw.jw.mapdice.domain.Place;
import tw.jw.mapdice.exception.MapDiceException;
import tw.jw.mapdice.model.PlaceDetailResponse;
import tw.jw.mapdice.model.PlaceResponse;
import tw.jw.mapdice.model.Response;
import tw.jw.mapdice.service.PlaceService;


@RestController
@RequestMapping("/place")
public class PlaceController {
    @Value("${google.api.key}")
    private String apiKey;

    @Autowired
    private PlaceService placeService;

    @GetMapping("/{id}")
    public Response<PlaceResponse> detail(@PathVariable("id") String id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format(MapDiceConstant.PLACE_DETAIL_URL, id, apiKey);
        PlaceDetailResponse response = restTemplate.getForEntity(url, PlaceDetailResponse.class).getBody();

        if(!"OK".equals(response.getStatus())) {
            throw new MapDiceException(HttpStatus.INTERNAL_SERVER_ERROR.value(), response.getStatus());
        }

        //insert place to database when accept query place detail request
        PlaceResponse placeResponse = response.getResult();
        Place place = new Place();
        BeanUtils.copyProperties(placeResponse, place);
        placeService.insert(place);

        return Response.ok(placeResponse);
    }
}
