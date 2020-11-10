package com.company;

public class List extends Data{
    private double[] arr;

    public List(double[] a){
        arr = a;
    }

    public double valueOf() {
        double sum = 0;
        for (int i=0; i < arr.length; i++)
            sum += arr[i];
        return sum;
    }

    public int length(){
        return arr.length;
    }
}
