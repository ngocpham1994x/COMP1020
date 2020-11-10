package com.company;

public class Real extends Number {

    private double real;

    public Real(double num){
        real = num;
    }

    public String toString(){
        return "" + String.format("%4.2f", real);
    }

    public double magnitude(){
        return Math.abs(real);
    }

    public double getReal(){
        return real;
    }

    public Number add(Number x){
        if(x instanceof Complex)
            return  x.add(this);  //Complex class will do the addition
        else
            return new Real(real + x.getReal());  //Real class does the addition
    }

}
