package com.atominize;

import java.util.Scanner;

public class CollarPointsChris {
    CollarPointsChris() {
        int[][] A;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows and columns (separate with space. example(6 3)) : ");
        int row = sc.nextInt();
        int column = sc.nextInt();
        A = new int[row][column];

        for (int i = 0; i<row; i++) {
            System.out.println("Enter row " + (i + 1) );
            for (int j = 0; j<column; j++) {
                A[i][j] = sc.nextInt();
            }
        }
        System.out.println("Collar Points");

        for (int i = 0; i < row; i++) {
            int start = A[i][0];
            int posRow = i;
            int posCol = 0;
            for (int j = 0; j < column; j++) {
                if (start < A[i][j]) {
                    start = A[i][j];
                    posRow = i;
                    posCol = j;

                }
            }
//            System.out.println("Max is " + start);
            int collarPoint = Integer.MAX_VALUE;
            for (int k = 0; k < row; k++) {
                if (start > A[k][posCol]) {
                    collarPoint = Integer.MAX_VALUE;
                    break;
                }
                collarPoint = start;
            }
            if (collarPoint < Integer.MAX_VALUE)
                System.out.println("Collar point is " + collarPoint + ", fount at row "
                        + posRow + " colunm " + posCol);
        }
    }
}