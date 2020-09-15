/**
 * Test Program
 * Lab 6 Gold
 * COMP 1020
 */
public class TestLab6Gold {
  
  public static void main(String[] args) { 
    System.out.print("Number n1 is Real (should print \"-1.23\"): ");
    Number n1 = new Real(-1.23);
    System.out.println(n1);
    System.out.println("n1 is "+n1.getClass());
    
    System.out.print("Number n2 is Complex (should print \"3.20+6.70i\"): ");
    Number n2 = new Complex(3.2,6.7);
    System.out.println(n2);
    System.out.println("n2 is "+n2.getClass());

    System.out.print("Number n3 is Complex (should print \"3.20-6.70i\"): ");
    Number n3 = new Complex(3.2,-6.7);
    System.out.println(n3);
    System.out.println("n3 is "+n3.getClass());

    System.out.print("Number n4 is Whole (should print \"-35\"): ");
    Number n4 = new Whole(-35);
    System.out.println(n4);
    System.out.println("n4 is "+n4.getClass());

    System.out.println();
    System.out.println("Testing addition:");
    Number answer;
    
    answer = n1.add(n1);
    System.out.println("n1.add(n1) should be -2.46 (Real): "+answer+" "+answer.getClass());
    answer = n1.add(n2);
    System.out.println("n1.add(n2) should be 1.97+6.70i (Complex): "+answer+" "+answer.getClass());
    answer = n1.add(n4);
    System.out.println("n1.add(n4) should be -36.23 (Real): "+answer+" "+answer.getClass());
    answer = n2.add(n1);
    System.out.println("n2.add(n1) should be 1.97+6.70i (Complex): "+answer+" "+answer.getClass());
    answer = n2.add(n2);
    System.out.println("n2.add(n2) should be 6.40+13.40i (Complex): "+answer+" "+answer.getClass());
    answer = n2.add(n4);
    System.out.println("n2.add(n4) should be -31.80+6.70i (Complex): "+answer+" "+answer.getClass());
    answer = n4.add(n1);
    System.out.println("n4.add(n1) should be -36.23 (Real): "+answer+" "+answer.getClass());
    answer = n4.add(n2);
    System.out.println("n4.add(n2) should be -31.80+6.70i (Complex): "+answer+" "+answer.getClass());
    answer = n4.add(n4);
    System.out.println("n4.add(n4) should be -70 (Whole): "+answer+" "+answer.getClass());
    
  }
  
}
