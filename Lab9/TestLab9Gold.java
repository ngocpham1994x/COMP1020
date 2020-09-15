
public class TestLab9Gold {
  
  public static void main(String[] args) { 
    final int NUM_POINTS = 50;
    //Create a PointList linked list.
    PointList points = new PointList();
    //Add random (x,y) points to it.
    for(int i=0; i<NUM_POINTS; i++)
      points.insert(Math.random(),Math.random());
    //Draw it as a set of lines
    points.connectTheXDots();
    StdDraw.setPenColor(StdDraw.RED);
    points.connectTheYDots();
    
  }
  
}//TestLab9Gold
