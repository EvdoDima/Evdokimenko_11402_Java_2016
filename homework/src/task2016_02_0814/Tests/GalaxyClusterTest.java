package task2016_02_0814.Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import task2016_02_0814.Cluster;
import task2016_02_0814.Galaxy;
import task2016_02_0814.GalaxyCluster;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by evdodima on 26/02/16.
 * 11-402
 */
public class GalaxyClusterTest {
    ArrayList<Galaxy> galaxies;


    @Before
    public void before(){
         galaxies = mock(ArrayList.class);
        Galaxy g= mock(Galaxy.class);
        Iterator i = mock(Iterator.class);
        when(galaxies.iterator()).thenReturn(i);
        when(i.next()).thenReturn(g);
        when(i.hasNext()).thenReturn(true,true,false);
    }

    @Test
    public void testDispart() throws Exception {
        GalaxyCluster newgal = new GalaxyCluster(galaxies);

        for (Galaxy c: newgal.dispart()){
            Assert.assertTrue(c==galaxies.get(1));
        }
    }

    @Test
    public void testRotate() throws Exception {
        GalaxyCluster newgal = new GalaxyCluster(galaxies);
        newgal.rotate(2);

        Assert.assertEquals(2,newgal.getPeriod());
    }

    @Test
    public void testMerge() throws Exception {
        GalaxyCluster newgal = new GalaxyCluster(galaxies);
        GalaxyCluster newcl = (GalaxyCluster) newgal.merge(newgal);


        Assert.assertTrue(newcl.dispart()==galaxies);



    }

    @Test
    public void testExpand() throws Exception {
        GalaxyCluster newgal = new GalaxyCluster(galaxies);
        newgal.expand(2);
        Assert.assertEquals(2,newgal.getSize());



    }

    @Test
    public void testCollapse() throws Exception {
        GalaxyCluster newgal = new GalaxyCluster(galaxies);
        newgal.collapse(2);
        Assert.assertEquals(-2,newgal.getSize());

    }

    @Test
    public void testAddNewParts() throws Exception {
        GalaxyCluster newgal = new GalaxyCluster(galaxies);
      newgal.addNewParts(galaxies);


        Assert.assertTrue(newgal.dispart()==galaxies);





    }
}