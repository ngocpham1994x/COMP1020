package com.company;

/**
 * A recursive method that draws a fractal image, and
 * a main program to test it for levels 1 to 8.
 */
public class TemplateLab10Silver {
  
  
  public static void main(String[] args) { 
    System.out.println("Click the mouse to draw the next level.");
    StdDraw.show(0);
    for(int i=1; i<=8; i++){
      StdDraw.clear();
      drawFractal(0.0,1.0,0.0,1.0,i);
      StdDraw.show(0);
      //Wait for the mouse button to go down
      while(!StdDraw.mousePressed())
        StdDraw.show(25); //Wait a bit
      //And then back up again.
      while(StdDraw.mousePressed())
        StdDraw.show(25); //Wait a bit
    }
  }
  
  public static void drawFractal(double xMin, double xMax,
                            double yMin, double yMax,
                            int nLevels){
    //******Complete the method******
    if(nLevels == 0)
      return;
    else{
      double xCentre = (xMin+xMax)/2;
      double yCentre = (yMin+yMax)/2;
      double xCentreBottomLeft = (xMin+xCentre)/2;
      double yCentreBottomLeft = (yMin+yCentre)/2;
      StdDraw.line(xCentre,yCentre,xCentreBottomLeft,yCentreBottomLeft);
      double xCentreBottomRight = (xMax+xCentre)/2;
      double yCentreBottomRight = (yMin+yCentre)/2;
      StdDraw.line(xCentre,yCentre,xCentreBottomRight,yCentreBottomRight);
      double xCentreTopLeft = (xMin+xCentre)/2;
      double yCentreTopLeft = (yMax+yCentre)/2;
      StdDraw.line(xCentre,yCentre,xCentreTopLeft,yCentreTopLeft);
      double xCentreTopRight = (xMax+xCentre)/2;
      double yCentreTopRight = (yMax+yCentre)/2;
      StdDraw.line(xCentre,yCentre,xCentreTopRight,yCentreTopRight);

      //expand bottom left
      drawFractal(xMin,xCentre,yMin, yCentre,nLevels-1);
      //expand bottom right
      drawFractal(xCentre,xMax,yCentre,yMin,nLevels-1);
      //expand top left
      drawFractal(xMin,xCentre,yCentre,yMax,nLevels-1);
      //expand top right
      drawFractal(xCentre,xMax, yCentre, yMax, nLevels-1);
    }
  }//drawFractal
  
}
