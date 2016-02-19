import java.util.ArrayList;

/**
 * Created by evdodima on 11/02/16.
 * 11-402
 */
public interface Planet {
    System rotateAround(Star star);
    void heat(int temperature);
    void cool(int temperature);
    PlanetCluster makeCluster(ArrayList<Planet> planets);
}
