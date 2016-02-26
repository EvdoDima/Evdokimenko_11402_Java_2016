package task2016_02_0814.Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import task2016_02_0814.*;
import task2016_02_0814.System;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by evdodima on 26/02/16.
 * 11-402
 */
public class SolarSystemTest {

    ArrayList<Planet> planets;
    GiantStar star;


    @Before
    public void before() {
        planets = mock(ArrayList.class);
        star = mock(GiantStar.class);


    }


    @Test
    public void testDispart() throws Exception {
        SolarSystem ss = new SolarSystem(planets, 12, star);
        Assert.assertNotNull(ss.dispart());

    }

    @Test
    public void testMakeCluster() throws Exception {
        ArrayList<task2016_02_0814.System> systems = mock(ArrayList.class);
        SolarSystem ss = new SolarSystem(planets, 12, star);
        Assert.assertNotNull(ss.makeCluster(systems));

    }

    @Test
    public void testCollapse() throws Exception {
        SolarSystem ss = new SolarSystem(planets, 12, star);
        Assert.assertNotNull(ss.collapse(ss));


    }

    @Test
    public void testGetSize() throws Exception {
        SolarSystem ss = new SolarSystem(planets, 12, star);
        Assert.assertEquals(12,ss.getSize());


    }
}