package task2016_02_0814.Tests;

import org.junit.Assert;
import org.junit.Test;
import task2016_02_0814.NeutronStar;
import task2016_02_0814.SolarSystem;
import task2016_02_0814.Star;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by evdodima on 26/02/16.
 * 11-402
 */
public class NeutronStarTest {

    @Test
    public void testShine() throws Exception {
        NeutronStar ns = new NeutronStar(12,100,3,2);
        Assert.assertEquals(1400,ns.shine());


    }

    @Test
    public void testExplode() throws Exception {
        NeutronStar ns = new NeutronStar(12,100,3,2);
        Assert.assertEquals("H",ns.explode().getGas());
    }

    @Test
    public void testRotate() throws Exception {
        NeutronStar ns = new NeutronStar(12,100,3,2);
        ns.rotate(2);
        Assert.assertEquals(2,ns.getPeriod());


    }

    @Test
    public void testChangeType() throws Exception {
        Star star= mock(Star.class);
        NeutronStar ns = new NeutronStar(12,100,3,2);
        Assert.assertEquals(star,ns.changeType(star));


    }

    @Test
    public void testMakeSystem() throws Exception {
        ArrayList parts = mock(ArrayList.class);
        NeutronStar ns = new NeutronStar(12,100,3,2);
        SolarSystem ss  = ns.makeSystem(parts);
        Assert.assertEquals(ns,ss.getStar());




    }

}