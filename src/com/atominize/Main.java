package com.atominize;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        StringManipulator stringManipulator = new StringManipulator();
//        ConsecutiveElements consecutiveElements = new ConsecutiveElements();
//        SortArray sortArray = new SortArray();
//        QuadraticSolver quadraticSolver = new QuadraticSolver();
//        Differentiation differentiation = new Differentiation();
//        differentiation.startAndShowWork();
//        Integration integration = new Integration();
//        ArkTeX arkTeX = new ArkTeX("2x^2+4x+exp(x)", "4x+4+exp(x)");
        Fraction fraction = new Fraction(4,5);
        Fraction fraction1 = new Fraction(0,2);
        fraction.display();
        fraction1.display();
//        Fraction.add(fraction, fraction1).display();
//        Fraction.subtract(fraction1, Fraction.add(fraction, fraction1)).display();
        Fraction.multiply(fraction, fraction1).display();
        Fraction.divide(fraction, fraction1).display();
//        Fraction.reciprocal(fraction1).display();
//        System.out.println(MathUtils.getLCM(2, 8));
//        System.out.println(MathUtils.factorial(0));
//        System.out.println(MathUtils.expand("x+1", 3));
//        System.out.println(Fraction.getFactors(0));
//        System.out.println(MathUtils.getGCD(77,121));
//        System.out.println(MathUtils.factorial(-1));
//        CollarPoints collarPoints = new CollarPoints();
//        CollarPointsChris collarPointsChris = new CollarPointsChris();

    }
}
