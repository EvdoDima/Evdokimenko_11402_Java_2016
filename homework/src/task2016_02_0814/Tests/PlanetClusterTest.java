package task2016_02_0814.Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import task2016_02_0814.Planet;
import task2016_02_0814.PlanetCluster;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by evdodima on 26/02/16.
 * 11-402
 */
public class PlanetClusterTest {

    ArrayList<Planet> planets;
    Planet g;


    @Before
    public void before(){
        planets = mock(ArrayList.class);
        g= mock(Planet.class);
        Iterator i = mock(Iterator.class);
        when(planets.iterator()).thenReturn(i);
        when(i.next()).thenReturn(g);
        when(i.hasNext()).thenReturn(true,true,false);
    }

    @Test
    public void testDispart() throws Exception {
        PlanetCluster newp = new PlanetCluster(planets);

        for (Planet c: newp.dispart()){
            Assert.assertTrue(c == g);
        }
    }

    @Test
    public void testRotate() throws Exception {
        PlanetCluster newp = new PlanetCluster(planets);
        newp.rotate(2);

        Assert.assertEquals(2,newp.getPeriod());
    }

    @Test
    public void testMerge() throws Exception {
        PlanetCluster newp = new PlanetCluster(planets);
        PlanetCluster newcl = (PlanetCluster) newp.merge(newp);


        Assert.assertTrue(newcl.dispart()==planets);



    }

    @Test
    public void testExpand() throws Exception {
        PlanetCluster newp = new PlanetCluster(planets);
        newp.expand(2);
        Assert.assertEquals(2,newp.getSize());



    }

    @Test
    public void testCollapse() throws Exception {
        PlanetCluster newp = new PlanetCluster(planets);
        newp.collapse(2);
        Assert.assertEquals(-2,newp.getSize());

    }

    @Test
    public void testAddNewParts() throws Exception {
        PlanetCluster newp = new PlanetCluster(planets);
        newp.addNewParts(planets);


        Assert.assertTrue(newp.dispart()==planets);





    }
}