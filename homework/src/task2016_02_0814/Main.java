package task2016_02_0814;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.*;
import java.lang.System;
import java.util.ArrayList;

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




//      ApplicationContext ac = new ClassPathXmlApplicationContext("/spring-config.xml");



        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext();
        ac.register(Task007config.class);
        ac.refresh();


        EarthTypePlanet earth = (EarthTypePlanet) ac.getBean("earth");
        Planet jupiter = (Planet) ac.getBean("jupiter");
        Planet mars = (Planet) ac.getBean("mars");
        Star sun = (Star) ac.getBean("sun");

        ArrayList<Planet> planets = new ArrayList<>();
        planets.add(mars);
        planets.add(jupiter);
        planets.add(earth);

        SolarSystem ss = new SolarSystem(planets, 20, sun);
        System.out.println(sun.shine());

        for (Planet p : planets) {
            p.rotateAround(sun);
            p.heat(20);
        }


        NeutronStar ns1 = (NeutronStar) ac.getBean("ns1");
        sun = sun.changeType(ns1);
        Cloud cloud = sun.explode();

        cloud.expand(30);
        Planet newPlanet = cloud.makePlanet();
        planets.add(newPlanet);


        ArrayList<task2016_02_0814.System> systems = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            systems.add(ss);
        }

        Galaxy galaxy = new SpiralGalaxy(3, 4, 6, systems);

        ArrayList<Galaxy> galaxies = new ArrayList<>();

        for (int i = 0; i < 11; i++) {
            galaxies.add(galaxy);
        }

        Cluster gc = galaxy.makeClusterWith(galaxies);

        gc.expand(35);
        gc.addNewParts(planets);
        gc.addNewParts(systems);

        gc.rotate(2340);

        SupernovaRemnant sr = (SupernovaRemnant) ac.getBean("supernovaR");
        sr.rotate(32);
        sr.shine();
        sr.collapse(34);
        sr.explode();
    }
}
