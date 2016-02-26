package task2016_02_0814;

import java.util.ArrayList;

/**
 * Created by evdodima on 11/02/16.
 * 11-402
 */
public interface Star {
    int shine();
    Cloud explode();
    void rotate(int period);
    Star changeType(Star newType);
    System makeSystem(ArrayList parts);
}
