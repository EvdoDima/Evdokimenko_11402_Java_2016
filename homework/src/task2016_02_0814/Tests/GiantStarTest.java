package task2016_02_0814.Tests;

import org.junit.Assert;
import org.junit.Test;
import task2016_02_0814.GiantStar;
import task2016_02_0814.SolarSystem;
import task2016_02_0814.Star;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by evdodima on 26/02/16.
 * 11-402
 */
public class GiantStarTest {


    @Test
    public void testShine() throws Exception {
        GiantStar ns = new GiantStar(12,100,3,2);
        Assert.assertEquals(36, ns.shine());


    }

    @Test
    public void testExplode() throws Exception {
        GiantStar ns = (GiantStar) MainTest.ac.getBean("gs1");
        Assert.assertEquals("He,H,C",ns.explode().getConsistence());
    }

    @Test
    public void testRotate() throws Exception {
        GiantStar ns = (GiantStar) MainTest.ac.getBean("gs1");
        ns.rotate(2);
        Assert.assertEquals(2,ns.getPeriod());


    }

    @Test
    public void testChangeType() throws Exception {
        Star star= mock(Star.class);
        GiantStar ns = (GiantStar) MainTest.ac.getBean("gs1");
        Assert.assertEquals(star,ns.changeType(star));


    }

    @Test
    public void testMakeSystem() throws Exception {
        ArrayList parts = mock(ArrayList.class);
        GiantStar ns = (GiantStar) MainTest.ac.getBean("gs1");
        SolarSystem ss  = ns.makeSystem(parts);
        Assert.assertEquals(ns,ss.getStar());




    }

}