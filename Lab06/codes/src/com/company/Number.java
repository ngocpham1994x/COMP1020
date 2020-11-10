package com.company;

public abstract class Number {
    public String toString(){
        return "";
    }

    public double magnitude(){
        return 0.0;
    }

    public Number add(Number x){
        return new Whole(0);
        //this just for something to do, actual .add() will be selected based on dynamically defined subclass
    }

    public double getReal(){
        return 0.0;  //for dummy, for able to return something. Sole purpose is for Complex subclass
    }
}
