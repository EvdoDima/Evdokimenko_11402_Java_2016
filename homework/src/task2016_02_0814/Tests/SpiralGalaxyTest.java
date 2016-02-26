package task2016_02_0814.Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import task2016_02_0814.*;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockingDetails;
import static org.mockito.Mockito.when;

/**
 * Created by evdodima on 26/02/16.
 * 11-402
 */
public class SpiralGalaxyTest {
    ArrayList<task2016_02_0814.System> systems ;
    @Before
    public void before(){
      systems  = mock(ArrayList.class);
    }

    @Test
    public void testRotate() throws Exception {
        SpiralGalaxy sg = new SpiralGalaxy(12,234,454,systems);
        sg.rotate(12);
        Assert.assertEquals(12,sg.getPeriod());

    }

    @Test
    public void testMerge() throws Exception {
        SpiralGalaxy sg = new SpiralGalaxy(12,234,454,systems);
        Assert.assertNotNull(sg.merge(sg));
    }

    @Test
    public void testDispart() throws Exception {
        SpiralGalaxy sg = new SpiralGalaxy(12,234,454,systems);
Assert.assertNotNull(sg.dispart());


    }

    @Test
    public void testCollapse() throws Exception {
        SpiralGalaxy sg = new SpiralGalaxy(12,234,454,systems);
        Assert.assertNotNull(sg.collapse(sg));


    }

    @Test
    public void testMakeClusterWith() throws Exception {
        SpiralGalaxy sg = new SpiralGalaxy(12,234,454,systems);
        ArrayList<Galaxy> galaxies = mock(ArrayList.class);
        Iterator<Galaxy> i= mock(Iterator.class);
        when(galaxies.iterator()).thenReturn(i);
        when(i.hasNext()).thenReturn(true,false);
        when(i.next()).thenReturn(sg);
     Assert.assertNotNull(sg.makeClusterWith(galaxies));


    }

    @Test
    public void testGetMass() throws Exception {
        SpiralGalaxy sg = new SpiralGalaxy(12,234,454,systems);
        Assert.assertEquals(12,sg.getMass());


    }
}