package task2016_02_0814.Tests;

import org.junit.Assert;
import org.junit.Test;
import task2016_02_0814.*;

import static org.junit.Assert.*;

/**
 * Created by evdodima on 26/02/16.
 * 11-402
 */
public class GasCloudTest {

    private static final double EPS = 10e-6;

    @Test
    public void testExpand() throws Exception {
        GasCloud gasCloud = new GasCloud("srgsg",2,50);
        gasCloud.expand(5);
        Assert.assertEquals(55, gasCloud.getSize(), EPS);


    }

    @Test
    public void testCollapse() throws Exception {
        GasCloud gasCloud = new GasCloud("srgsg",1,43);
        gasCloud.collapse(1);
        Assert.assertEquals(42,gasCloud.getSize(),EPS);

    }

    @Test
    public void testMakePlanet() throws Exception {
        GasCloud gasCloud = new GasCloud("srgsg",6,10);
        GiantPlanet p =  gasCloud.makePlanet();
        Assert.assertEquals(1,p.getRadius(),EPS);
        Assert.assertEquals(1,p.getMass(),EPS);
        Assert.assertEquals(0,p.getTemperature(),EPS);
    }

    @Test
    public void testMakeStar() throws Exception {
        GasCloud gasCloud = new GasCloud("srgsg",2,50);
        NeutronStar s =  gasCloud.makeStar();
        Assert.assertEquals(0,s.getAge(),EPS);
        Assert.assertEquals(2,s.getMass(),EPS);
        Assert.assertEquals(6000,s.getTemperature(),EPS);

    }

}