package tasks001_005;

/**
 * Created by evdodima on 20/11/14.
 */
public class ComplexNumber {
    private double real;
    private double im;

    public ComplexNumber() {
        this.real = 0;
        this.im = 0;


    }


    public double getIm() {
        return im;
    }

    public void setIm(double im) {
        this.im = im;
    }

    public double getReal() {

        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public ComplexNumber(double real, double im) {
        this.real = real;
        this.im = im;


    }


    public ComplexNumber add(ComplexNumber cNum) {

        return new ComplexNumber(this.real + cNum.getReal(), this.im + cNum.getIm());


    }


    public void add2(ComplexNumber cNum) {

        this.real += cNum.real;
        this.im += cNum.im;


    }


    public ComplexNumber sub(ComplexNumber cNum) {

        return new ComplexNumber(this.real - cNum.getReal() , this.im - cNum.getIm());


    }


    public void sub2(ComplexNumber cNum) {

        this.real -= cNum.real;
        this.im -= cNum.im;


    }


    public ComplexNumber multNumber(double k) {


        return new ComplexNumber(this.real * k, this.im * k);


    }


    public void multNumber2(double k) {
        this.real *= k;
        this.im *= k;


    }


    public ComplexNumber mult(ComplexNumber cNum) {

        return new ComplexNumber(this.real * cNum.getReal(), this.im * cNum.getIm());
    }


    public void mult2(ComplexNumber cNum) {
        this.real *= cNum.real;
        this.im *= cNum.im;


    }

    public ComplexNumber div(ComplexNumber cNum) {

        return new ComplexNumber(this.real / cNum.real, this.im / cNum.im);
    }


    public void div2(ComplexNumber cNum) {
        this.real /= cNum.real;
        this.im /= cNum.im;


    }


    public double length() {
        return Math.sqrt(this.real * this.real + this.im * this.im);


    }


    public String toString() {

        if (this.im > 0) {
            return this.real + " " + this.im + " * i";


        } else if (this.im == 0) {

            return this.real + "";

        }


        return this.real + "-" + this.im + "* i ";


    }

    public double arg() {

        return Math.atan(this.im / this.real);
    }


    public boolean equals(ComplexNumber cNum) {
        return this.real == cNum.getReal() && this.im == cNum.getIm();
    }


}

