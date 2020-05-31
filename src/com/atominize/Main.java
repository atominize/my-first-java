package com.atominize;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        StringManipulator stringManipulator = new StringManipulator();
//        ConsecutiveElements consecutiveElements = new ConsecutiveElements();
//        SortArray sortArray = new SortArray();
//        QuadraticSolver quadraticSolver = new QuadraticSolver();
//        Differentiation differentiation = new Differentiation();
//        differentiation.startAndDisInCon();
//        Integration integration = new Integration();
//        ArkTeX arkTeX = new ArkTeX("2x^2+4x+exp(x)", "4x + 4 + exp(x)");
        Fraction fraction = new Fraction(4,4);
        Fraction fraction1 = new Fraction(4,44);
        fraction.display();
        fraction1.display();
        Fraction.add(fraction, fraction1).display();
//        System.out.println(Fraction.getFactors(0));
    }
}
