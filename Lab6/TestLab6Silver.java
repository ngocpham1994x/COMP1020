/**
 * Test Program
 * Lab 6 Silver
 * COMP 1020
 */
public class TestLab6Silver {
  
  public static void main(String[] args) { 
    System.out.print("Number n1 is Real (should print \"123.46\"): ");
    Number n1 = new Real(123.4567);
    System.out.println(n1);

    System.out.print("Number n2 is Complex (should print \"3.20+6.70i\"): ");
    Number n2 = new Complex(3.2,6.7);
    System.out.println(n2);

    System.out.print("Number n3 is Complex (should print \"3.20-6.70i\"): ");
    Number n3 = new Complex(3.2,-6.7);
    System.out.println(n3);

    System.out.print("Number n4 is Whole (should print \"13579\"): ");
    Number n4 = new Whole(13579);
    System.out.println(n4);

    System.out.printf("Magnitude of n1 (should be 123.45670 ): %8.5f%n",n1.magnitude());
    System.out.printf("Magnitude of n2 (should be 7.42496 ): %8.5f%n",n2.magnitude());
    System.out.printf("Magnitude of n3 (should be 7.42496 ): %8.5f%n",n3.magnitude());
    System.out.printf("Magnitude of n4 (should be 13579.0 ): %7.1f%n",n4.magnitude());
    
  }
  
}
