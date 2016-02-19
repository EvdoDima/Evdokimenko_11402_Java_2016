import java.util.ArrayList;

/**
 * Created by evdodima on 11/02/16.
 * 11-402
 */
public interface Galaxy {
    void rotate(int period);
    Galaxy merge(Galaxy toMerge);
    ArrayList<System> dispart();
    GalaxyCluster collapse(Galaxy toCollapse);
    Cluster makeClusterWith(ArrayList<Galaxy> galaxies);
    int getMass();
}
