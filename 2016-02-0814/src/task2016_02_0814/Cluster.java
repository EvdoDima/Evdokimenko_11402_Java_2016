package task2016_02_0814;

import java.util.ArrayList;

/**
 * Created by evdodima on 11/02/16.
 * 11-402
 */
public interface Cluster {
    ArrayList dispart ();
    void rotate(int period);
    Cluster merge(Cluster toMerge);
    void expand(int radius);
    void collapse(int radius);
    void addNewParts(ArrayList parts);

}
