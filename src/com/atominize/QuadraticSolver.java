package com.atominize;

    /* This class is for solving quadratic equations
    It takes the coefficients of the quadratic and
    Displays the roots of the equation.
     */

import java.util.Scanner;

public class QuadraticSolver {
    private double A, B, C, first_root, second_root;
    private int typeOfEqn;

    public QuadraticSolver() {
        System.out.println("Welcome to the quadratic solver");
        System.out.println("This solves quadratics of the form Ax^2 + Bx + C = 0");
        getEqnCoefficients();
        solveQuadraticEqn(A, B, C);
        System.out.println("The first root is " + first_root);
        if (typeOfEqn != 0) {
            System.out.println("The second root is " + second_root);
        }
        System.out.println();
        if (continueSolver()) {
            new QuadraticSolver();
        }
    }

    private void getEqnCoefficients() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the value of A, A = ");
        A = scanner.nextDouble();
        System.out.print("Please enter the value of B, B = ");
        B = scanner.nextDouble();
        System.out.print("Please enter the value of C, C = ");
        C = scanner.nextDouble();
        System.out.println("Is this the equation you want to solve?");
        System.out.println(A + "x^2 + " + B + "x + " + C + " = 0, Y(Yes)/N(No)");
        System.out.println("Enter Y or N");
        String response = scanner.next();
        if (response.toLowerCase().equals("n")) {
            System.out.println("Sorry, please re-enter the equation again");
            getEqnCoefficients();
        } else {
            System.out.println("Thank you, we will proceed to solve it for you");
        }
    }

    private void solveQuadraticEqn(double A, double B, double C) {
        System.out.println("About to solve equation");
        double det = calDiscriminant(A, B, C);
        if (det == 0) {
            System.out.println("The equation has a repeated root");
            first_root = -B / 2*A;
            typeOfEqn = 0;
        } else if (det > 0) {
            System.out.println("The equation has real and distinct roots");
            first_root = (-B + Math.sqrt(det)) / 2*A;
            second_root = (-B - Math.sqrt(det)) / 2*A;
            typeOfEqn = 1;
        } else {
            System.out.println("The equation has a pair of complex conjugate root");
            // Todo: write the codes for complex roots
            typeOfEqn = 2;
        }
    }

    private double calDiscriminant(double A, double B, double C) {
        return B*B - 4*A*C;
    }

    private boolean continueSolver() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to continue? Yes(Y) / No(N) ");
        System.out.print("Enter Y or N ");
        String response = scanner.next();
        return response.toLowerCase().equals("y");
    }
}
