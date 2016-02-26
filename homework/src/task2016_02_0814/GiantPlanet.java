package task2016_02_0814;

import java.util.ArrayList;

/**
 * Created by evdodima on 11/02/16.
 * 11-402
 */
public class GiantPlanet implements Planet {

    int radius;
    int mass;
    int temperature;

    public GiantPlanet(int mass, int radius, int temperature) {
        this.mass = mass;
        this.radius = radius;
        this.temperature = temperature;
    }

    @Override
    public System rotateAround(Star star) {

        ArrayList<Planet> planets = new ArrayList<Planet>();
        planets.add(this);

        return new SolarSystem(planets,mass*radius,star);
    }

    @Override
    public void heat(int temperature) {
        this.temperature+=temperature;

    }

    @Override
    public void cool(int temperature) {

        this.temperature-=temperature;
    }

    @Override
    public PlanetCluster makeCluster(ArrayList<Planet> planets) {
        return new PlanetCluster();
    }
}
