package com.company;

public abstract class Store {

    //instance vars
    private String name;
    private int numEmployees;

    //constructor
    public Store(String storeName, int numEmp){
        name = storeName;
        numEmployees = numEmp;
    }

    //method toString of superclass
    public String toString(){
        String s = "";
        s = name + " has " + numEmployees + " employees.";
        return s;
    }


}
