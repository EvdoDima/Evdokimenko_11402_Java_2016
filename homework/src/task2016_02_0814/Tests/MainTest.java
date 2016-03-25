package task2016_02_0814.Tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import task2016_02_0814.EarthTypePlanet;

/**
 * Created by evdodima on 25/03/16.
 * 11-402
 */
public class MainTest {
    public static AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
    static {
        ac.register(Task010config.class);
        ac.refresh();
    }
    public static void main(String[] args) {

        Result result = JUnitCore.runClasses(DustCloudTest.class, EarthTypePlanet.class,
                GalaxyClusterTest.class, GasCloudTest.class, GiantPlanetTest.class,
                GiantStarTest.class,NeutronStarTest.class,PlanetClusterTest.class,
                QuasarTest.class,SolarSystemTest.class,
                SpiralGalaxyTest.class,SupernovaRemnantTest.class);
        for (Failure f:result.getFailures()){
            java.lang.System.out.println(f);
        }

    }
}
