package task2016_02_0814.Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import task2016_02_0814.*;
import task2016_02_0814.System;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by evdodima on 26/02/16.
 * 11-402
 */
public class SupernovaRemnantTest {

    GiantStar star;
    GasCloud cloud;

    @Before
    public void before() {
        star = mock(GiantStar.class);
        cloud = mock(GasCloud.class);
        DustCloud d = mock(DustCloud.class);

        when(star.explode()).thenReturn(d);
        when(star.changeType(star)).thenReturn(star);
        when(star.shine()).thenReturn(123);
        when(star.getPeriod()).thenReturn(12);

        GiantPlanet p = mock(GiantPlanet.class);
        when(cloud.getSize()).thenReturn(23);
        when(cloud.makePlanet()).thenReturn(p);
        NeutronStar star = mock(NeutronStar.class);
        when(cloud.makeStar()).thenReturn(star);


    }

    @Test
    public void testExpand() throws Exception {
        SupernovaRemnant sr= new SupernovaRemnant(cloud,star);
        sr.expand(23);
        Assert.assertEquals(23,((GasCloud)sr.getCloud()).getSize());

    }

    @Test
    public void testCollapse() throws Exception {
        SupernovaRemnant sr= new SupernovaRemnant(cloud,star);
        sr.collapse(3);
        Assert.assertEquals(23,((GasCloud)sr.getCloud()).getSize());


    }

    @Test
    public void testMakePlanet() throws Exception {
        SupernovaRemnant sr= new SupernovaRemnant(cloud,star);
        Assert.assertNotNull(sr.makePlanet());

    }

    @Test
    public void testMakeStar() throws Exception {
        SupernovaRemnant sr= new SupernovaRemnant(cloud,star);
        Assert.assertNotNull(sr.makeStar());

    }

    @Test
    public void testShine() throws Exception {
        SupernovaRemnant sr= new SupernovaRemnant(cloud,star);
        Assert.assertEquals(123, sr.shine());


    }

    @Test
    public void testExplode() throws Exception {
        SupernovaRemnant sr= new SupernovaRemnant(cloud,star);
        Assert.assertNotNull(sr.explode());


    }

    @Test
    public void testRotate() throws Exception {
        SupernovaRemnant sr= new SupernovaRemnant(cloud,star);
        sr.rotate(12);
        Assert.assertEquals(12,((GiantStar)sr.getStar()).getPeriod());

    }

    @Test
    public void testChangeType() throws Exception {
        SupernovaRemnant sr= new SupernovaRemnant(cloud,star);
        Assert.assertEquals(star, sr.changeType(star));

    }

    @Test
    public void testMakeSystem() throws Exception {
        SupernovaRemnant sr= new SupernovaRemnant(cloud,star);

        ArrayList<System> s = mock(ArrayList.class);
        Assert.assertNotNull(sr.makeSystem(s));


    }

}