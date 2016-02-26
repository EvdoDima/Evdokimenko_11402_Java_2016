package task2016_02_0814;

import java.util.ArrayList;

/**
 * Created by evdodima on 11/02/16.
 * 11-402
 */
public class GiantStar implements Star {
    int mass;
    int temperature;
    int age;
    int period;

    public GiantStar(int age, int mass, int temperature,int period) {
        this.age = age;
        this.mass = mass;
        this.temperature = temperature;
        this.period = period;
    }

    public int getAge() {
        return age;
    }

    public int getMass() {
        return mass;
    }

    public int getPeriod() {
        return period;
    }

    public int getTemperature() {
        return temperature;
    }

    @Override
    public int shine() {
        return  age*temperature;
    }

    @Override
    public DustCloud explode() {
        return new DustCloud(age*10,mass,"He,H,C");
    }

    @Override
    public void rotate(int period) {
        this.period=period;

    }

    @Override
    public Star changeType(Star newType) {
        return newType;
    }

    @Override
    public SolarSystem makeSystem(ArrayList parts) {

        return new SolarSystem(parts,parts.size()*23,this);
    }
}
