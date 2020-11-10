package com.company;

public class CharMatrixTest {

        public static void main(String[] args) {
            CharMatrix matrix = new CharMatrix(6,6,'o');
            System.out.println(matrix);
            System.out.println(matrix.toStringRotated());
//        matrix.fillTopHalf('x');
//        matrix.fillDiagonal('x');
//        matrix.fillAboveDiagonal('x');
//        matrix.fillBelowDiagonal('x');
//        matrix.fillOtherRow('x');
//        matrix.fillOtherColumn('x');
            System.out.println(matrix);
        }

    }


}
