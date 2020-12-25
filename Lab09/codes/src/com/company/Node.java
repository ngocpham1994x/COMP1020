package com.company;

public class Node {
    private double x,y;
    private Node pointerX, pointerY;

    public Node(double a, double b, Node thePointerX, Node thePointerY){
        x = a;
        y = b;
        pointerX = thePointerX;
        pointerY = thePointerY;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public Node getXLink(){
        return this.pointerX;
    }
    public Node setXLink(Node newPointerX){
        return this.pointerX = newPointerX;
    }

    public Node getYLink(){
        return this.pointerY;
    }

    public Node setYLink(Node newPointerY){
        return this.pointerY = newPointerY;
    }

    public String toString(){
        return "(" + String.format("%5.3f",x) + "," + String.format("%5.3f",y) + ")";
    }
}
