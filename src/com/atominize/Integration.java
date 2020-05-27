package com.atominize;

import java.util.Scanner;

public class Integration {
    private String function;
    private String solution = "";
    private UtilMethods utilMethods = new UtilMethods();

    public Integration() {
        System.out.println("Welcome, this program helps you to integrate any function");
        System.out.print("Enter the function, f(x) = ");
        Scanner scanner = new Scanner(System.in);
        function = scanner.next();
        System.out.println();

        String[] funcSplitAtAddition = function.split("\\+");
        for (String func: funcSplitAtAddition) {
            solution = utilMethods.addToSolution(integrateFunc(func), solution);
        }

        displayAnswer(function, solution);
    }

    private String integrateFunc(String function) {
        int[] coeAndPower = utilMethods.getPolyCoeAndPower(function);
        return utilMethods.getPolyFuncFromCoeAndPower(integratePoly(coeAndPower));
    }

    private int[] integratePoly(int[] coeAndPower) {
        return new int[]{ coeAndPower[0] / (coeAndPower[1] + 1), coeAndPower[1] + 1};
    }

    private String getIntegrand(String func) {
        UtilMethods utilMethods = new UtilMethods();
        utilMethods.analyzeFunction(func);
        return null;
    }

    private void displayAnswer(String function, String output) {
        System.out.println("The integration of " + function + " is ");
        System.out.println(output);
    }
}
