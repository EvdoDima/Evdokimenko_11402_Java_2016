package task2016_02_0814.Tests;

import org.junit.Assert;
import org.junit.Test;
import task2016_02_0814.DustCloud;
import task2016_02_0814.EarthTypePlanet;
import task2016_02_0814.GiantStar;
import task2016_02_0814.Planet;

import static org.junit.Assert.*;

/**
 * Created by evdodima on 26/02/16.
 * 11-402
 */
public class DustCloudTest {
 public static final double EPS=10e-6;


    @Test
    public void testExpand() throws Exception {
        DustCloud dustCloud = (DustCloud) MainTest.ac.getBean("dustcloud1");
        dustCloud.expand(5);
        Assert.assertEquals(15,dustCloud.getRadius(),EPS);


    }

    @Test
    public void testCollapse() throws Exception {
        DustCloud dustCloud = (DustCloud) MainTest.ac.getBean("dustcloud2");
        dustCloud.collapse(1);
        Assert.assertEquals(2,dustCloud.getRadius(),EPS);

    }

    @Test
    public void testMakePlanet() throws Exception {
        DustCloud dustCloud = (DustCloud) MainTest.ac.getBean("dustcloud2");
        EarthTypePlanet p =  dustCloud.makePlanet();
        Assert.assertEquals(0,p.getRadius(),EPS);
        Assert.assertEquals(0,p.getMass(),EPS);
        Assert.assertEquals(20,p.getTemperature(),EPS);
    }

    @Test
    public void testMakeStar() throws Exception {
        DustCloud dustCloud = (DustCloud) MainTest.ac.getBean("dustcloud3");
        GiantStar s =  dustCloud.makeStar();
        Assert.assertEquals(0,s.getAge(),EPS);
        Assert.assertEquals(2,s.getMass(),EPS);
        Assert.assertEquals(2,s.getTemperature(),EPS);

    }
}