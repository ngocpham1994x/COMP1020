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
  }//drawFractal
  
}
