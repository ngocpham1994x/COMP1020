package com.company;

public class PointList {
    private Node topPointerX; //pointer, no data
    private Node topPointerY;

    public PointList(){
        topPointerX = null; //empty list
        topPointerY = null;
    }

    //commented out from Bronze level
//    public void add (double x, double y){
//        Node newNode = new Node(x,y,topPointerX,topPointerY);
//        topPointerX = newNode;
//    }

    public void insert(double x, double y){
        Node prevPointerX = null;
        Node currentPointerX = topPointerX;
        Node prevPointerY = null;
        Node currentPointerY = topPointerY;


        while (currentPointerX != null && currentPointerX.getX() < x){
            prevPointerX = currentPointerX;
            currentPointerX = currentPointerX.getXLink();  //move to next node
        }
        while (currentPointerY != null && currentPointerY.getY() < y){
            prevPointerY = currentPointerY;
            currentPointerY = currentPointerY.getYLink();  //move to next node
        }
        Node newNode = new Node(x,y,currentPointerX,currentPointerY);

        if(prevPointerX == null) {   //if Linkedlist is empty and newNode should be added at very beginning
            topPointerX = newNode;
        }
        else
            prevPointerX.setXLink(newNode);


//        Node newNodeY = new Node(x,y,null,currentPointerY);

        if(prevPointerY == null) {   //if Linkedlist is empty and newNode should be added at very beginning
            topPointerY = newNode;
        }
        else
            prevPointerY.setYLink(newNode);

    }

    public void connectTheXDots(){
        Node prevPointer = null;
        Node currentPointer = topPointerX;

        while(currentPointer != null) {
            if (prevPointer != null)
                StdDraw.line(prevPointer.getX(), prevPointer.getY(), currentPointer.getX(), currentPointer.getY());
            prevPointer = currentPointer;
            currentPointer = currentPointer.getXLink();
        }
    }

    public void connectTheYDots(){
        Node prevPointer = null;
        Node currentPointer = topPointerY;

        while(currentPointer != null) {
            if (prevPointer != null)
                StdDraw.line(prevPointer.getX(), prevPointer.getY(), currentPointer.getX(), currentPointer.getY());
            prevPointer = currentPointer;
            currentPointer = currentPointer.getYLink();
        }
    }

    public String toString(){
        String s = "[";
        Node current = topPointerX;
        while (current != null){
            s += " " + current.toString() + " ";
            current = current.getXLink();
        }
        s += "]";
        return s;
    }
}
