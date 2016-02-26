package tasks001_005;

/**
 * Created by evdodima on 25/02/16.
 * 11-402
 */
 import java.util.Arrays;

 import static java.lang.Math.abs;
public class Matrix2x2 {
    private double[][] matrix;

    public Matrix2x2(double v) {
        this();
        for (int i = 0; i <2 ; i++) {
            for (int j = 0; j < 2; j++) {
                matrix[i][j]=v;
            }

        }
    }

    public Matrix2x2(double[][] arr) {
        matrix=arr;
    }

    public Matrix2x2(double v, double v1, double v2, double v3) {
        matrix =new double[][] {{v,v1},{v2,v3}};
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public Matrix2x2() {
        matrix = new double[2][2];
    }

    public Matrix2x2 add(Matrix2x2 m2) {
        double [][] arr = m2.getMatrix();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j]+=matrix[i][j];
            }
        }
        return new Matrix2x2(arr);
    }

    public void add2(Matrix2x2 m2) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrix[i][j]+=m2.getMatrix()[i][j];
            }
        }
    }

    public Matrix2x2 sub(Matrix2x2 m2) {

        double [][] arr = matrix;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j]-=m2.getMatrix()[i][j];
            }
        }
        return new Matrix2x2(arr);

    }
    public void sub2(Matrix2x2 m2) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrix[i][j]-=m2.getMatrix()[i][j];
            }
        }
    }

    public Matrix2x2 mult(double n) {
        double[][] arr= matrix;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j]*=n;
            }
        }
        return new Matrix2x2(arr);
    }

    public void mult2(double n) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrix[i][j]*=n;
            }
        }
    }

    public double det() {
        return this.matrix[0][0] * this.matrix[1][1] - this.matrix[0][1] * this.matrix[1][0];

    }

    public void transport() {
        double c = matrix[1][1];
        matrix[1][1]=matrix[0][1];
        matrix[0][1]=matrix[0][0];
        matrix[0][0]=matrix[1][0];
        matrix[1][0]= c;
    }

    public Matrix2x2 inverseMatrix() {
        if (this.det() != 0) {
            Matrix2x2 copy = this;
            copy.transport();
            copy.mult2(1/copy.det());

            return copy;
        }

        System.out.println("Det = 0 ");
        return new Matrix2x2(0);
    }


    public Matrix2x2 equivalenDiagonal() {

        this.matrix[1][0]-=this.matrix[1][0]*this.matrix[0][0];
        this.matrix[0][1]-=this.matrix[0][1]*this.matrix[1][1];


        return this;

    }


}
