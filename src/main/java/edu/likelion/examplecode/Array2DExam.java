package edu.likelion.examplecode;

public class Array2DExam {


    //2차 array를 출력
    public static void printArray(String meg, double[][] A ) {

        System.out.println(meg);
        for(int i=0; i<A.length; i++) {
            for(int j=0; j<A[0].length; j++) {
                System.out.print(A[i][j]+ " ");
            }
            System.out.println();
        }

    }


    //2차 array 곱 void형
    public static void matrixMul(double[][] A, double[][] B, double[][] C) {

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                C[i][j] = 0;
                for (int k = 0; k < B.length; k++) {
                    C[i][j] += (A[i][k] * B[k][j]);
                }
            }
        }
    }

    //2차 array 곱 return형
    public static double[][] matrixMul(double[][] A, double[][] B) {

        double[][] C = new double[A.length][B[0].length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                C[i][j] = 0;
                for (int k = 0; k < B.length; k++) {
                    C[i][j] += (A[i][k] * B[k][j]);
                }
            }
        }
        printArray("C", C);
        return C;
    }


    public static void main(String[] args) {

        double[][] A = {{3, 2}, {1, 2}, {4, 2}};
        double[][] B = {{1, 2, 3}, {4, 5, 6}};
        double[][] C = new double[A.length][B[0].length];

        printArray("A", A);
        printArray("B", B);
        matrixMul(A, B);

    }

}