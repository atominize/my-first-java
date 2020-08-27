package com.atominize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollarPoints {
    public CollarPoints() {
        int[][] matrix = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] =  1;
            }
        }
//        for (int i = 1; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                matrix[i][j] = matrix[i][j] + 2;
//            }
//        }
//
//        for (int i = 2; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                matrix[i][j] = matrix[i][j] + 2;
//            }
//        }
        System.out.println(Arrays.deepToString(matrix));

        int k = 0;
        for (int i = 0; i < 3; i++) {
            List<Integer> row = new ArrayList();
            List<Integer> column = new ArrayList();
            for (int j = 0; j < 3; j++) {
                row.add(matrix[i][j]);
                column.add(matrix[j][i]);
            }
            System.out.println(row);
            System.out.println(column);
            int collarPoint = maxInArray(row);
            if (collarPoint == minInArray(column)) {
                System.out.println("Collar point is " + collarPoint);
            }
        }
    }

    private int minInArray(List<Integer> arrayList) {
        int min_int = arrayList.get(0);
        for (int item: arrayList) {
            min_int = Math.min(item, min_int);
        }
        return min_int;
    }

    private int maxInArray(List<Integer> arrayList) {
        int max_int = arrayList.get(0);
        for (int item: arrayList) {
            max_int = Math.max(item, max_int);
        }
        return max_int;
    }
}
