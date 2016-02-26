package tasks001_005;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by evdodima on 25/02/16.
 * 11-402
 */
public class Matrix2x2TestCase {
    public static final double EPS = 10e-6;

    @Test
    public void defaultConstructorShouldCreateNullMatrix() {
        Matrix2x2 m = new Matrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(0, m.getMatrix()[i][j], EPS);
            }
        }
    }


    @Test
    public void ConstructorShouldCreateMatrixWithNumber() {
        Matrix2x2 m = new Matrix2x2(4);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(4, m.getMatrix()[i][j], EPS);
            }
        }
    }


    @Test
    public void ConstructorShouldCreateMatrixFromArray() {
        double[][] arr = {{2, 3}, {4, 5}};
        Matrix2x2 m = new Matrix2x2(arr);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(i * 2 + j + 2, m.getMatrix()[i][j], EPS);
            }
        }
    }

    @Test
    public void ConstructorShouldCreateMatrixFromNumbers() {
        Matrix2x2 m = new Matrix2x2(1, 2, 3, 4);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(i * 2 + j + 1, m.getMatrix()[i][j], EPS);
            }
        }
    }

    @Test
    public void AddShouldCreateCorrecrMatrix() {
        Matrix2x2 m1 = new Matrix2x2(1, 2, 3, 4);
        Matrix2x2 m2 = new Matrix2x2(2, 3, 4, 5);
        Matrix2x2 res = m1.add(m2);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(i * 4 + j * 2 + 3, res.getMatrix()[i][j], EPS);
            }
        }
    }

    @Test
    public void Add2ShouldCreateCorrecrMatrix() {
        Matrix2x2 m1 = new Matrix2x2(0, 1, 2, 3);
        Matrix2x2 m2 = new Matrix2x2(2, 3, 4, 5);
        m1.add2(m2);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(i * 4 + j * 2 + 2, m1.getMatrix()[i][j], EPS);
            }
        }
    }


    @Test
    public void SubShouldCreateCorrecrMatrix() {
        Matrix2x2 m1 = new Matrix2x2(3, 4, 5, 6);
        Matrix2x2 m2 = new Matrix2x2(2, 3, 4, 5);
        Matrix2x2 res = m1.sub(m2);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(1, res.getMatrix()[i][j], EPS);
            }
        }
    }

    @Test
    public void Sub2ShouldCreateCorrecrMatrix() {
        Matrix2x2 m1 = new Matrix2x2(0, 1, 2, 3);
        Matrix2x2 m2 = new Matrix2x2(2, 3, 4, 5);
        m1.sub2(m2);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(-2, m1.getMatrix()[i][j], EPS);
            }
        }
    }

    @Test
    public void MultShouldCreateCorrecrMatrix() {
        Matrix2x2 m1 = new Matrix2x2(3, 4, 5, 6);
        Matrix2x2 res = m1.mult(2);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals((i*2+j+3)*2, res.getMatrix()[i][j], EPS);
            }
        }
    }

    @Test
    public void Mult2ShouldCreateCorrecrMatrix() {
        Matrix2x2 m1 = new Matrix2x2(0, 1, 2, 3);
        m1.mult2(4);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals((i*2+j)*4, m1.getMatrix()[i][j], EPS);
            }
        }
    }


    @Test
    public void DetShouldReturnCorrectDeterminat() {
        Matrix2x2 m1 = new Matrix2x2(0, 1, 2, 3);
        Assert.assertEquals(-2,m1.det(),EPS);
    }


    @Test
    public void TransShouldTransporateMatrixCorrectly() {
        Matrix2x2 m1 = new Matrix2x2(0, 1, 2, 3);
        m1.transport();
        Assert.assertEquals(2,m1.getMatrix()[0][0],EPS);
        Assert.assertEquals(0,m1.getMatrix()[0][1],EPS);
        Assert.assertEquals(3,m1.getMatrix()[1][0],EPS);
        Assert.assertEquals(1,m1.getMatrix()[1][1],EPS);
    }


    @Test
    public void InverseMatrixShouldBeCountCorrectly() {
        Matrix2x2 m1 = new Matrix2x2(1, 0, 0, 1);
        Matrix2x2 res = m1.inverseMatrix();
        Assert.assertEquals(0,res.getMatrix()[0][0],EPS);
        Assert.assertEquals(-1,res.getMatrix()[0][1],EPS);
        Assert.assertEquals(-1,res.getMatrix()[1][0],EPS);
        Assert.assertEquals(0,res.getMatrix()[1][1],EPS);


    }

    @Test
    public void InverseMatrixShouldReturnNullMAtrixWhenDetIsNull() {
        Matrix2x2 m1 = new Matrix2x2(0, 0, 0, 1);
        Matrix2x2 res = m1.inverseMatrix();
        Assert.assertEquals(0,res.getMatrix()[0][0],EPS);
        Assert.assertEquals(0,res.getMatrix()[0][1],EPS);
        Assert.assertEquals(0,res.getMatrix()[1][0],EPS);
        Assert.assertEquals(0,res.getMatrix()[1][1],EPS);


    }


    @Test
    public void DiagonalMatrixShouldBeCountCorrectly() {
        Matrix2x2 m1 = new Matrix2x2(1, 0, 0, 1);
        Matrix2x2 res = m1.equivalenDiagonal();
        Assert.assertEquals(1,res.getMatrix()[0][0],EPS);
        Assert.assertEquals(0,res.getMatrix()[0][1],EPS);
        Assert.assertEquals(0,res.getMatrix()[1][0],EPS);
        Assert.assertEquals(1,res.getMatrix()[1][1],EPS);
    }









}
