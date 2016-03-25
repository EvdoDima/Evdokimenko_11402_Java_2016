package task2016_02_0814.Tests;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import task2016_02_0814.*;

/**
 * Created by evdodima on 25/03/16.
 * 11-402
 */

@Configuration
public class Task010config {
    @Bean
    public DustCloud dustCloud1(){
        return new DustCloud(10,10,"asdsad");
    }

    @Bean
    public DustCloud dustCloud2(){
        return new DustCloud(3,6,"asdsad");
    }

    @Bean
    public DustCloud dustCloud3(){
        return new DustCloud(3,6,"asdsad");
    }


    @Bean
    public EarthTypePlanet ep1(){
        return   new EarthTypePlanet(1, 1, 40);
    }



    @Bean
    public GasCloud gc1(){
        return    new GasCloud("srgsg",2,50);
    }


    @Bean
    public GasCloud gc2(){
        return     new GasCloud("srgsg",1,43);
    }

    @Bean
    public GasCloud gc3(){
        return     new GasCloud("srgsg",6,10);
    }
    @Bean
    public GasCloud gc4(){
        return    new GasCloud("srgsg",2,50);
    }



    @Bean
    public GiantPlanet gp1(){
        return   new GiantPlanet(1, 1, 40);
    }


    @Bean
    public GiantStar gs1(){
        return   new GiantStar(12,100,3,2);
    }


    @Bean
    public NeutronStar ns1(){
        return   new NeutronStar(12,100,3,2);
    }












}
