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

    @Override
    public ArrayList dispart() {
        return planets;
    }

    @Override
    public void rotate(int period) {
        this.period=period;

    }

    @Override
    public Cluster merge(Cluster toMerge) {
        return new PlanetCluster();
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
