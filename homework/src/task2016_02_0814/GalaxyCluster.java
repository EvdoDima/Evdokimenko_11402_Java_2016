package task2016_02_0814;

import java.util.ArrayList;

/**
 * Created by evdodima on 13/02/16.
 * 11-402
 */
public class GalaxyCluster implements Cluster {
    int numberofGalaxies;
    int mass;
    ArrayList<Galaxy> galaxies;
    int period;
    int size;

    public ArrayList<Galaxy> getGalaxies() {
        return galaxies;
    }

    public int getMass() {
        return mass;
    }

    public int getNumberofGalaxies() {
        return numberofGalaxies;
    }

    public int getPeriod() {
        return period;
    }

    public int getSize() {
        return size;
    }

    public GalaxyCluster(ArrayList<Galaxy> galaxies) {
        this.galaxies = galaxies;
        this.numberofGalaxies = galaxies.size();
        for (Galaxy g : galaxies) {
            mass += g.getMass();
        }
    }

    @Override
    public ArrayList<Galaxy> dispart() {
        return galaxies;
    }

    @Override
    public void rotate(int period) {
        this.period = period;
    }

    @Override
    public Cluster merge(Cluster toMerge) {
        ArrayList newCluster = toMerge.dispart();
        newCluster.addAll(galaxies);
        return new GalaxyCluster(newCluster);
    }

    @Override
    public void expand(int radius) {
        size+=radius;

    }

    @Override
    public void collapse(int radius) {
        size-=radius;

    }

    @Override
    public void addNewParts(ArrayList parts) {
        galaxies.addAll(parts);
    }
}
