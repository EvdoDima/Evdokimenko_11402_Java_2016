package task2016_02_0814;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by evdodima on 13/02/16.
 * 11-402
 */
@Component("supernovaR")
public class SupernovaRemnant implements Star,Cloud {
    @Autowired
            @Qualifier("ns1")
    Star star;
    @Autowired
            @Qualifier("dustCloud")
    Cloud cloud;


    public SupernovaRemnant() {
    }

    public SupernovaRemnant(Cloud cloud, Star star) {
        this.cloud = cloud;
        this.star = star;
    }

    public Cloud getCloud() {
        return cloud;
    }

    public Star getStar() {
        return star;
    }

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
    public int shine() {

        return star.shine();
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
