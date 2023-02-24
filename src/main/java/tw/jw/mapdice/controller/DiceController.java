package tw.jw.mapdice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import tw.jw.mapdice.constant.MapDiceConstant;
import tw.jw.mapdice.constant.PlaceTypeEnum;
import tw.jw.mapdice.domain.Users;
import tw.jw.mapdice.exception.MapDiceException;
import tw.jw.mapdice.model.DiceResponse;
import tw.jw.mapdice.model.PlaceResponse;
import tw.jw.mapdice.model.Response;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


@RequestMapping("/dice")
@RestController
public class DiceController {
    @Value("${google.api.key}")
    private String apiKey;

    @Autowired
    private StringRedisTemplate redisTemplate;

    private Random random = new Random();

    @GetMapping("")
    public Response<PlaceResponse> dice(
        @RequestParam("latitude") Double latitude,
        @RequestParam("longitude") Double longitude,
        @RequestParam(value = "radius", required = false, defaultValue = "1000") Double radius,
        @RequestParam("type") String type
    ) {
        List<String> allTypes = Arrays.stream(PlaceTypeEnum.values()).map(PlaceTypeEnum::getValue).collect(Collectors.toList());
        if(!allTypes.contains(type)) {
            throw new MapDiceException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "type is illegal");
        }

        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ZSetOperations<String, String> zSet = redisTemplate.opsForZSet();
        Double score = zSet.score(type, username);
        if(score == null) {
            zSet.add(type, username, 1);
        } else {
            if(score == 3) {
                throw new MapDiceException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "an user can only dice three times in one day");
            } else {
                zSet.incrementScore(type, username, 1);
            }
        }

        String requestURL = String.format(MapDiceConstant.NEARBY_SEARCH_URL, latitude, longitude, radius, type, apiKey);
        RestTemplate restTemplate = new RestTemplate();
        DiceResponse response = restTemplate.getForEntity(requestURL, DiceResponse.class).getBody();

        if(!"OK".equals(response.getStatus())) {
            throw new MapDiceException(HttpStatus.INTERNAL_SERVER_ERROR.value(), response.getStatus());
        }

        List<PlaceResponse> results = response.getResults();
        int randIdx = random.nextInt(results.size());

        return Response.ok(results.get(randIdx));
    }
}
