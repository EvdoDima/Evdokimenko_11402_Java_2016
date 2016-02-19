import java.util.ArrayList;

/**
 * Created by evdodima on 13/02/16.
 * 11-402
 */
public interface System {
    ArrayList dispart();
    Cluster makeCluster(ArrayList<System> systems);
    System collapse(System anotherSystem);


    int getSize();

}
