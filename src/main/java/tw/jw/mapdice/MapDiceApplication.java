package tw.jw.mapdice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MapDiceApplication {
    //TODO clear user dice count in redis every day.
    public static void main(String[] args) {
        SpringApplication.run(MapDiceApplication.class, args);
    }

}
