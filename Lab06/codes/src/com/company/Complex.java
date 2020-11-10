package com.company;

public class Complex extends Real {
    private double imaginary;

    public Complex(double r, double c) {
        super(r);   //real part coming from superclass
        imaginary = c;
    }

    public String toString() {
        String s = "";
        s += super.toString();   //get the Real part
        if (imaginary < 0)
            s += String.format("%-4.2fi", imaginary);
        else
            s += String.format("%+4.2fi", imaginary);
        return s;
    }

    public double magnitude() {
        double mag = 0;
        mag = Math.sqrt(Math.pow(super.magnitude(), 2) + Math.pow(imaginary, 2));
        return mag;
    }

    public Number add(Number x) {
        if (x instanceof Complex)
            //Add real parts, add imaginary parts
            return new Complex(this.getReal() + x.getReal(),      //.getReal() inherit from superclass
                    this.imaginary + ((Complex) x).imaginary);
        else
            //Just add the other number to the real part
            return new Complex(this.getReal() + x.getReal(),
                    this.imaginary);
    }
}
