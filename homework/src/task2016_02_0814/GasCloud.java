package task2016_02_0814;

/**
 * Created by evdodima on 11/02/16.
 * 11-402
 */
public class GasCloud implements Cloud {
    int size;
    int mass;
    String gas;

    public String getGas() {
        return gas;
    }

    public int getMass() {
        return mass;
    }

    public int getSize() {
        return size;
    }

    public GasCloud(String gas, int mass, int size) {
        this.gas = gas;
        this.mass = mass;
        this.size = size;
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
    public GiantPlanet makePlanet() {
        return new GiantPlanet(size/mass,size/10,mass/size*10);
    }

    @Override
    public NeutronStar makeStar() {
        return new NeutronStar(0,mass,size/mass, 6000);
    }
}
