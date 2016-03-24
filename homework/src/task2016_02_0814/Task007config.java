package task2016_02_0814;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by evdodima on 24/03/16.
 * 11-402
 */
@Configuration
@ComponentScan(value = {"task2016_02_0814"})
public class Task007config {

    @Bean
    public  EarthTypePlanet earth(){
        return new EarthTypePlanet(1,1,30);
    }

    @Bean
    public  EarthTypePlanet jupiter(){
        return new EarthTypePlanet(80,40,-20);
    }

    @Bean
    public  EarthTypePlanet mars(){
        return new EarthTypePlanet(2,1,24);
    }

    @Bean
    public  GiantStar sun(){
        return new GiantStar(5,1,5000,1);
    }

    @Bean
    public  NeutronStar ns1(){
        return new NeutronStar(40,5,1000,1);
    }

    @Bean
    public  DustCloud dustCloud(){
        return new DustCloud(123,200,"C,F,P");
    }
}
