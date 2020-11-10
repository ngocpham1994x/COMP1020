package com.company;

public class Whole extends Number{
    private int wholeNum;

    public Whole(int w){
        wholeNum = w;
    }

    public String toString(){
        return "" + String.format("%4d", wholeNum);
    }

    public double magnitude(){
        return Math.abs(wholeNum);
    }

    public double getReal(){
        return wholeNum;
    }

    public Number add(Number x){
        if (x instanceof Whole)
            return new Whole((this.wholeNum + ((Whole)x).wholeNum));
        else
            return x.add(this); //pass the x to other class' method
    }

}
