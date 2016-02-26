package task2016_02_0814;

/**
 * Created by evdodima on 11/02/16.
 * 11-402
 */
public class DustCloud implements Cloud{
    int mass;
    String consistence;
    int radius;

    public DustCloud(int radius, int mass, String consistence) {
        this.radius = radius;
        this.mass = mass;
        this.consistence = consistence;
    }

    @Override
    public void expand(int radius) {
        this.radius+=radius;

    }

    @Override
    public void collapse(int radius) {
        this.radius-=radius;


    }

    @Override
    public Planet makePlanet() {
        return new EarthTypePlanet(radius/mass,radius/10,mass/radius*10);
    }

    @Override
    public Star makeStar() {
        return new GiantStar(0,mass,radius/mass, 3000);
    }
}
