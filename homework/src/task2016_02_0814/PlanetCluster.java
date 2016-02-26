package task2016_02_0814;

import java.util.ArrayList;

/**
 * Created by evdodima on 13/02/16.
 * 11-402
 */
public class PlanetCluster implements Cluster {


    int numberofPlanets;
    int mass;
    ArrayList<Planet> planets;
    int period;
    int size;

    public int getMass() {
        return mass;
    }

    public int getNumberofPlanets() {
        return numberofPlanets;
    }

    public int getPeriod() {
        return period;
    }

    public ArrayList<Planet> getPlanets() {
        return planets;
    }

    public int getSize() {
        return size;
    }

    public PlanetCluster(ArrayList<Planet> planets) {
        this.planets = planets;
    }

    @Override
    public ArrayList<Planet> dispart() {
        return planets;
    }

    @Override
    public void rotate(int period) {
        this.period=period;

    }

    @Override
    public Cluster merge(Cluster toMerge) {
        return new PlanetCluster(planets);
    }

    @Override
    public void expand(int radius) {
        this.size+=radius;

    }

    @Override
    public void collapse(int radius) {
        this.size-=radius;


    }

    @Override
    public void addNewParts(ArrayList parts) {
        planets.addAll(parts);

    }
}
