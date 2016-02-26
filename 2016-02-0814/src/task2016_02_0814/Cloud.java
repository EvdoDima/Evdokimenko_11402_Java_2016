package task2016_02_0814;

/**
 * Created by evdodima on 11/02/16.
 * 11-402
 */
public interface Cloud {
    void expand(int radius);
    void collapse(int radius);
    Planet makePlanet();
    Star makeStar();
}
