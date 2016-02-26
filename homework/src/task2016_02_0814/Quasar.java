package task2016_02_0814;

import java.util.ArrayList;

/**
 * Created by evdodima on 13/02/16.
 * 11-402
 */
public class Quasar implements Galaxy,Cloud {
    int size;
    int mass;
    String gas;
    ArrayList<System> systems;
    int period;

    public String getGas() {
        return gas;
    }

    public int getPeriod() {
        return period;
    }

    public int getSize() {
        return size;
    }

    public ArrayList<System> getSystems() {
        return systems;
    }

    public Quasar(String gas, int mass, int period, int size, ArrayList<System> systems) {
        this.gas = gas;
        this.mass = mass;
        this.period = period;
        this.size = size;
        this.systems = systems;
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
    public Planet makePlanet() {
        return new GiantPlanet((mass/(systems.size()-4))/10,size/(systems.size()+2),mass/(size+3));
    }

    @Override
    public Star makeStar() {
        return new NeutronStar(0,mass/(systems.size()-4),size/(mass-21),mass/(size+54));
    }

    @Override
    public void rotate(int period) {
        this.period=period;

    }

    @Override
    public Galaxy merge(Galaxy toMerge) {
        return new SpiralGalaxy(mass+toMerge.getMass(),size/mass,size+toMerge.getMass()/mass,systems);
    }

    @Override
    public ArrayList<System> dispart() {
        return systems;
    }

    @Override
    public GalaxyCluster collapse(Galaxy toCollapse) {
        return new GalaxyCluster(new ArrayList<Galaxy>());
    }

    @Override
    public Cluster makeClusterWith(ArrayList<Galaxy> galaxies) {
        return new GalaxyCluster(new ArrayList<Galaxy>());
    }

    @Override
    public int getMass() {
        return mass;
    }
}
