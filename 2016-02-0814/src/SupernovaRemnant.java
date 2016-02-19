import java.util.ArrayList;

/**
 * Created by evdodima on 13/02/16.
 * 11-402
 */
public class SupernovaRemnant implements Star,Cloud {
    Star star;
    Cloud cloud;



    @Override
    public void expand(int radius) {
        cloud.expand(radius);
    }

    @Override
    public void collapse(int radius) {
        cloud.collapse(radius);

    }

    @Override
    public Planet makePlanet() {
        return cloud.makePlanet();
    }

    @Override
    public Star makeStar() {
        return cloud.makeStar();
    }

    @Override
    public void shine() {
        star.shine();

    }

    @Override
    public Cloud explode() {
        cloud.expand(100);
        return cloud;
    }

    @Override
    public void rotate(int period) {
        star.rotate(period);

    }

    @Override
    public Star changeType(Star newType) {
        star=newType;
        return newType;
    }

    @Override
    public System makeSystem(ArrayList parts) {
        return new SolarSystem(parts,parts.size()*10,star);
    }
}