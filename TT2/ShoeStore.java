package com.company;

public class ShoeStore extends Store{

    //instance vars
    private int shoeBoxes;

    //constructor
    public ShoeStore(String storeName, int numEmp, int boxes) {
        super(storeName, numEmp);
        shoeBoxes = boxes;
    }

    //toString method of subclass
    public String toString(){
        String s = "";
        s = super.toString() + "\n" + "This shoe store has " + shoeBoxes + " shoe boxes.";
        return s;
    }
}
