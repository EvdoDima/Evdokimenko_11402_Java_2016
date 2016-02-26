package task2016_02_0814.Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import task2016_02_0814.*;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;

/**
 * Created by evdodima on 26/02/16.
 * 11-402
 */
public class QuasarTest {

    ArrayList<task2016_02_0814.System> systems;


    @Before
    public void before(){
        systems = mock(ArrayList.class);
    }



    @Test
    public void testExpand() throws Exception {
        Quasar q = new Quasar("H",12,23,123,systems);
        q.expand(23);
        Assert.assertEquals(146,q.getSize());

    }

    @Test
    public void testCollapse() throws Exception {
        Quasar q = new Quasar("H",12,23,123,systems);
        q.collapse(23);
        Assert.assertEquals(100,q.getSize());

    }

    @Test
    public void testMakePlanet() throws Exception {
        Quasar q = new Quasar("H",12,23,123,systems);
        Planet p = q.makePlanet();
        Assert.assertNotNull(p);



    }

    @Test
    public void testMakeStar() throws Exception {
        Quasar q = new Quasar("H",12,23,123,systems);
        Star p = q.makeStar();
        Assert.assertNotNull(p);

    }

    @Test
    public void testRotate() throws Exception {
        Quasar q = new Quasar("H",12,23,123,systems);
        q.rotate(21);
        Assert.assertEquals(21,q.getPeriod());


    }

    @Test
    public void testMerge() throws Exception {
        Galaxy g = mock(Galaxy.class);
        Quasar q = new Quasar("H",12,23,123,systems);
        Assert.assertNotNull(q.merge(g));


    }

    @Test
    public void testDispart() throws Exception {
        Quasar q = new Quasar("H",12,23,123,systems);
        Assert.assertNotNull(q.dispart());


    }

    @Test
    public void testCollapse1() throws Exception {
        Galaxy g = mock(Galaxy.class);
        Quasar q = new Quasar("H",12,23,123,systems);
        Assert.assertNotNull(q.collapse(g));



    }

    @Test
    public void testMakeClusterWith() throws Exception {
        ArrayList<Galaxy> galaxies = mock (ArrayList.class);
        Quasar q = new Quasar("H",12,23,123,systems);
        Assert.assertNotNull(q.makeClusterWith(galaxies));

    }
}