package tasks001_005;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import task2016_02_0814.EarthTypePlanet;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by evdodima on 25/02/16.
 * 11-402
 */
public class ComplexMatrix2x2Test {

    ComplexNumber nullN;
    ComplexMatrix2x2 nullM;

    @Before
    public void generateNullCompNum() {
        nullN = mock(ComplexNumber.class);
        when(nullN.getIm()).thenReturn(0.0);
        when(nullN.getReal()).thenReturn(0.0);
        when(nullN.add(nullN)).thenReturn(nullN);
        when(nullN.sub(nullN)).thenReturn(nullN);
        when(nullN.mult(nullN)).thenReturn(nullN);

        nullM = mock(ComplexMatrix2x2.class);
        when(nullM.getMatrix()).thenReturn(new ComplexNumber[][]{{nullN, nullN}, {nullN, nullN}});
    }


    @Test
    public void DefaultConstructorShouldCreateNullMatrix() {

        ComplexMatrix2x2 m = new ComplexMatrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertTrue(m.getMatrix()[i][j].equals(nullN));
            }
        }
    }

    @Test
    public void equalsShouldWorkCorrectly() {
        ComplexMatrix2x2 m = new ComplexMatrix2x2();

        Assert.assertTrue(m.equals(nullM));

    }

    @Test
    public void AddShouldWorkCorrectly() {
        ComplexMatrix2x2 m = new ComplexMatrix2x2();
        m.add(nullM);
        Assert.assertTrue(m.equals(m));
    }

    @Test
    public void multShouldWorkCorrectly() {
        ComplexMatrix2x2 m = new ComplexMatrix2x2();
        m.mult(nullM);
        Assert.assertTrue(m.equals(nullM));
    }


    @Test
    public void DetShouldWorkCorrectly() {
        ComplexNumber n1 = mock(ComplexNumber.class);
        when(n1.getIm()).thenReturn(0.0);
        when(n1.getReal()).thenReturn(1.0);
        when(n1.add(nullN)).thenReturn(n1);
        when(n1.sub(nullN)).thenReturn(n1);
        when(n1.mult(nullN)).thenReturn(nullN);
        when(n1.mult(n1)).thenReturn(n1);




        ComplexMatrix2x2 m = new ComplexMatrix2x2(n1, nullN, nullN, n1);
        Assert.assertEquals(0, m.det().getIm(), Matrix2x2TestCase.EPS);
        Assert.assertEquals(1, m.det().getReal(), Matrix2x2TestCase.EPS);
    }
}