package task2016_02_0814;

import java.util.ArrayList;

/**
 * Created by evdodima on 11/02/16.
 * 11-402
 */
public class NeutronStar implements Star{
    int mass;
    int temperature;
    int age;
    int period;


    public NeutronStar(int age, int mass, int period, int temperature) {
        this.age = age;
        this.mass = mass;
        this.period = period;
        this.temperature = temperature;
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
        int pow = age*mass+temperature*100;
        return pow;

    }

    @Override
    public GasCloud explode() {
        return new GasCloud("H",mass,mass*temperature);
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
        return new SolarSystem(parts,mass*temperature,this);
    }
}
