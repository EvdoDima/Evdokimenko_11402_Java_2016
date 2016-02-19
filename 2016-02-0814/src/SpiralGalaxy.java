import java.util.ArrayList;

/**
 * Created by evdodima on 11/02/16.
 * 11-402
 */
public class SpiralGalaxy implements Galaxy {
    int mass;
    int size;
    ArrayList<System> systems;
    int period;

    public SpiralGalaxy(int mass, int period, int size, ArrayList<System> systems) {
        this.mass = mass;
        this.period = period;
        this.size = size;
        this.systems = systems;
    }

    @Override
    public void rotate(int period) {
        this.period=period;
    }

    @Override
    public Galaxy merge(Galaxy toMerge) {
        systems.addAll(toMerge.dispart());
        return new SpiralGalaxy(mass+toMerge.getMass(),period*2,size+toMerge.getMass()/2,systems);
    }

    @Override
    public ArrayList<System> dispart() {
        return systems;
    }

    @Override
    public GalaxyCluster collapse(Galaxy toCollapse) {
        ArrayList<Galaxy> clust = new ArrayList<Galaxy>();
        clust.add(this);
        clust.add(toCollapse);
        return new GalaxyCluster(clust);
    }

    @Override
    public Cluster makeClusterWith(ArrayList<Galaxy> galaxies) {
        galaxies.add(this);
        return new GalaxyCluster(galaxies);
    }

    @Override
    public int getMass() {
        return mass;
    }
}
