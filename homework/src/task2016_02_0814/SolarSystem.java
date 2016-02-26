package task2016_02_0814;

import java.util.ArrayList;

/**
 * Created by evdodima on 13/02/16.
 * 11-402
 */
public class SolarSystem implements System {
    Star star;
    ArrayList<Planet> planets;
    int size;

    public ArrayList<Planet> getPlanets() {
        return planets;
    }

    public Star getStar() {
        return star;
    }

    public SolarSystem(ArrayList<Planet> planets, int size, Star star) {
        this.planets = planets;
        this.size = size;
        this.star = star;
    }

    @Override
    public ArrayList dispart() {
        return planets;
    }

    @Override
    public Cluster makeCluster(ArrayList<System> systems) {
        return new PlanetCluster(planets);
    }



    @Override
    public System collapse(System anotherSystem) {
        return new SolarSystem(planets,anotherSystem.getSize()+size,star);
    }

    @Override
    public int getSize() {
        return size;
    }
}
