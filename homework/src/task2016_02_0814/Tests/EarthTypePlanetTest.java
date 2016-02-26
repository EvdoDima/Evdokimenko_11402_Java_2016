package task2016_02_0814.Tests;

import org.junit.Assert;
import org.junit.Test;
import task2016_02_0814.*;

import java.util.ArrayList;
import java.util.Iterator;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by evdodima on 26/02/16.
 * 11-402
 */
public class EarthTypePlanetTest {

    @Test
    public void testRotateAround() throws Exception {
        EarthTypePlanet p = new EarthTypePlanet(1, 1, 40);
        GiantStar s = mock(GiantStar.class);
        SolarSystem sols = p.rotateAround(s);
        Assert.assertTrue(sols.getStar() == s);
    }

    @Test
    public void testHeat() throws Exception {
        EarthTypePlanet p = new EarthTypePlanet(1, 1, 40);
        p.heat(12);
        Assert.assertEquals(52,p.getTemperature());
    }

    @Test
    public void testCool() throws Exception {
        EarthTypePlanet p = new EarthTypePlanet(1, 1, 40);
        p.cool(12);
        Assert.assertEquals(28,p.getTemperature());


    }

    @Test
    public void testMakeCluster() throws Exception {
        EarthTypePlanet p = new EarthTypePlanet(1, 1, 40);
        ArrayList<Planet> planets = mock(ArrayList.class);
        Iterator i = mock(Iterator.class);
        when(planets.iterator()).thenReturn(i);
        when(i.next()).thenReturn(p,p,p,p,p,p);

        PlanetCluster plcl = p.makeCluster(planets);
        ArrayList<Planet> res = plcl.dispart();

        for (Planet c :res) {
            Assert.assertTrue(c==p);
        }

    }
}