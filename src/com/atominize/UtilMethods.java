package com.atominize;

public class UtilMethods {

    public UtilMethods() {}

    public String addToSolution(String partialSol, String solution) {
        if (partialSol.equals("0"))
            partialSol = "";
        if (solution.equals("")) {
            solution = partialSol;
        } else {
            solution += " + " + partialSol;
        }
        return solution;
    }

    public String getPolyFuncFromCoeAndPower(int[] coeAndPower) {
        String[] output = { Integer.toString(coeAndPower[0]), "x", "^", Integer.toString(coeAndPower[1]) };
        if (coeAndPower[1] == 0) {
            output[1] = "";
            output[2] = "";
            output[3] = "";
        } else if (coeAndPower[1] == 1) {
            output[2] = "";
            output[3] = "";
        }
        if (coeAndPower[0] == 1 & coeAndPower[1] != 0) output[0] = "";
        return output[0] + output[1] + output[2] + output[3];
    }

    public int[] getPolyCoeAndPower(String function) {
        String[] coeAndPower = function.split("x");
//        System.out.println(function);
//        System.out.println(Arrays.toString(coeAndPower));
        int[] intCoeAndPower = {1, 0};
        if (coeAndPower.length == 1) {
            intCoeAndPower[0] = Integer.parseInt(coeAndPower[0]);
        } else if (coeAndPower.length == 2) {
            try {
                intCoeAndPower[1] = Integer.parseInt(coeAndPower[1].substring(1));
                intCoeAndPower[0] = Integer.parseInt(coeAndPower[0]);
            } catch (NumberFormatException ignored) {

            }
        }
//        System.out.println(Arrays.toString(intCoeAndPower));
        return intCoeAndPower;
    }

    public String analyzeFunction(String function) {
        if (function.matches("exp(.*)")) {
            return "Expo";
        } else {
            return "Poly";
        }
    }
}
