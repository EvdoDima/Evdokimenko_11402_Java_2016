package tasks001_005;

import java.util.Arrays;

/**
 * Created by evdodima on 25/02/16.
 * 11-402
 */
public class ComplexMatrix2x2 {


    public ComplexNumber[][] getMatrix() {
        return matrix;
    }

    public ComplexNumber[][] matrix = new ComplexNumber[2][2];

    public ComplexMatrix2x2() {
        this(new ComplexNumber());

    }


    public ComplexMatrix2x2(ComplexNumber element) {
        this(element, element, element, element);
    }



    public ComplexMatrix2x2(ComplexNumber element, ComplexNumber element1, ComplexNumber element2, ComplexNumber element3) {
        this.matrix[0][0] = element;
        this.matrix[0][1] = element1;
        this.matrix[1][0] = element2;
        this.matrix[1][1] = element3;
    }


    public ComplexMatrix2x2 add(ComplexMatrix2x2 matrix) {
        return new ComplexMatrix2x2(
                this.matrix[0][0].add(matrix.getMatrix()[0][0]),
                this.matrix[0][1].add(matrix.getMatrix()[0][1]),
                this.matrix[1][0].add(matrix.getMatrix()[1][0]),
                this.matrix[1][1].add(matrix.getMatrix()[1][1]));
    }


    public ComplexMatrix2x2 mult(ComplexMatrix2x2 matrix) {
        ComplexMatrix2x2 newRationalMatrix = new ComplexMatrix2x2();
        ComplexNumber s;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                s = new ComplexNumber();
                for (int k = 0; k < 2; k++) {
                    s.add(this.matrix[i][k].mult(matrix.getMatrix()[k][j]));

                }


                newRationalMatrix.matrix[i][j] = s;
            }

        }

        return newRationalMatrix;
    }

    public ComplexNumber det() {
        return this.matrix[0][0].mult(this.matrix[1][1]).sub(this.matrix[0][1].mult(this.matrix[1][0]));


    }

    public boolean equals(ComplexMatrix2x2 o) {
        if (o==null)return false;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
              if ( !matrix[i][j].equals(o.getMatrix()[i][j])) return false;
            }
        }
        return true;
    }

}
