package task2016_02_0814;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import task2016_02_0814.Tests.*;

import java.lang.*;

/**
 * Created by evdodima on 16/02/16.
 * 11-402
 */
public class Main {


    public static void main(String[] args) {
        //testing
//        Result result = JUnitCore.runClasses(DustCloudTest.class,EarthTypePlanet.class,
//                GalaxyClusterTest.class, GasCloudTest.class, GiantPlanetTest.class,
//                GiantStarTest.class,NeutronStarTest.class,PlanetClusterTest.class,
//                QuasarTest.class,SolarSystemTest.class,
//                SpiralGalaxyTest.class,SupernovaRemnantTest.class);
//        for (Failure f:result.getFailures()){
//            java.lang.System.out.println(f);
//        }

        //main
        ApplicationContext ac = new ClassPathXmlApplicationContext("/spring-config.xml");
        Planet p = (Planet) ac.getBean("earth");
        java.lang.System.out.println(p==null);
    }
}
