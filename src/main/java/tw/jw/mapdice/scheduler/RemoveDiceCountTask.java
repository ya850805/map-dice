package tw.jw.mapdice.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tw.jw.mapdice.constant.PlaceTypeEnum;

@Slf4j
@Component
public class RemoveDiceCountTask {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Scheduled(cron = "0 0 0 * * *")
    public void removeDiceCount() {
        log.info("Remove redis dice count by PlaceTypeEnum");
        for (PlaceTypeEnum placeTypeEnum : PlaceTypeEnum.values()) {
            redisTemplate.delete(placeTypeEnum.getValue());
        }
    }
}
