package tw.jw.mapdice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MapDiceApplication {
    //TODO Add place domain object, insert place detail when user dice.(in order to find out all places that user collect)
    public static void main(String[] args) {
        SpringApplication.run(MapDiceApplication.class, args);
    }

}
