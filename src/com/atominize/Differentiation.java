package com.atominize;


import java.util.Arrays;
import java.util.Scanner;

/* This class is for differentiating functions of polynomials,
            exponential, logarithmic and trigonometric.
         */
public class Differentiation {
    private int[] coeAndPower;
    private String function;

    public Differentiation() {
        System.out.println("Welcome, this program helps you to differentiate any function");
        System.out.print("Enter the function, f(x) = ");
        Scanner scanner = new Scanner(System.in);
        function = scanner.next();
        System.out.println();
        if (function.length() == 1 & !function.contains("x")) {
           coeAndPower = new int[]{ 0, 0 };
           displayPolyAnswer(coeAndPower);
           return;
        }
        coeAndPower = diffPolynomial(getPolyCoeAndPower(function));
        displayPolyAnswer(coeAndPower);
    }

    private void displayPolyAnswer(int[] coeAndPower) {
        String[] output = { Integer.toString(coeAndPower[0]), "x", "^", Integer.toString(coeAndPower[1]) };
        if (coeAndPower[1] == 0) {
            output[1] = "";
            output[2] = "";
            output[3] = "";
         }
        if (coeAndPower[0] == 1 & coeAndPower[1] != 0) output[0] = "";
        System.out.println("The differentiation of " + function + " is ");
        System.out.println(output[0] + output[1] + output[2] + output[3]);
    }

    private int[] diffPolynomial(int[] coeAndPower) {
        return new int[]{coeAndPower[0] * coeAndPower[1], coeAndPower[1] - 1};
    }

    private int[] getPolyCoeAndPower(String function) {
        String[] coEfAndPower = function.split("x");
        int[] intCoeAndPower = {1, 1};
        if (coEfAndPower.length == 1) {
            intCoeAndPower[0] = Integer.parseInt(coEfAndPower[0]);
        } else if (coEfAndPower.length == 2) {
            intCoeAndPower[0] = Integer.parseInt(coEfAndPower[0]);
            intCoeAndPower[1] = Integer.parseInt(coEfAndPower[1].substring(1));
        }
//        System.out.println(Arrays.toString(intCoeAndPower));
        return intCoeAndPower;
    }
}
