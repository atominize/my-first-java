package com.atominize;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/* This class is for differentiating functions of polynomials,
            exponential, logarithmic and trigonometric.
         */
public class Differentiation {
    private int[] coeAndPower;
    private String function;
    private String functionType;

    public Differentiation() {
        System.out.println("Welcome, this program helps you to differentiate any function");
        System.out.print("Enter the function, f(x) = ");
        Scanner scanner = new Scanner(System.in);
        function = scanner.next();
        System.out.println();
        String[] funcComponents = function.split("\\*");
        if (funcComponents.length > 1) {
            String result = productRule(funcComponents[0], funcComponents[1]);
            displayAnswer(function, result);
        } else {
            displayAnswer(function, diffFunction(function, analyzeFunction(function)));
        }
    }

    private String productRule(String function1, String function2) {
        String funcType1 = analyzeFunction(function1);
        String funcType2 = analyzeFunction(function2);
        return multiplyFunctions(diffFunction(function1, funcType1), function2) + " + " +
                multiplyFunctions(function1, diffFunction(function2, funcType2));
    }

    private String simplifyFunction(String function) {
        String[] functions = function.split("/+");
        List<String> polyFunctions = new ArrayList<>();
        List<String> expoFunctions = new ArrayList<>();
        for (String func: functions) {
            String[] funcComps = func.split("/*");
            if (funcComps.length >= 3) {
                for (String funcComp: funcComps) {
                    if (analyzeFunction(funcComp).equals("Poly")) {
                        polyFunctions.add(funcComp);
                    } else if (analyzeFunction(funcComp).equals("Expo")) {
                        expoFunctions.add(funcComp);
                    }
                }
            }
            if (polyFunctions.size() >= 2) {
                int[] constPoly = { 1, 0 };
                for (String poly: polyFunctions) {
                    constPoly = multiplyPoly(getPolyCoeAndPower(poly), constPoly);
                }
                polyFunctions.add(getPolyFuncFromCoeAndPower(constPoly));
            }
        }
        return polyFunctions.get(polyFunctions.size() - 1) + "*" + expoFunctions.get(0);
        // Todo: fix simplification function
    }

    private int[] multiplyPoly(int[] poly1, int[] poly2) {
        return new int[] { poly1[0]*poly2[0], poly1[1]+poly2[1] };
    }

    private boolean hasOperation(String function, String operation) {
        return function.contains(operation);
    }

    private String multiplyFunctions(String function1, String function2) {
        return function1 + "*" + function2;
    }

    private String analyzeFunction(String function) {
        if (function.matches("exp(.*)")) {
            return "Expo";
        } else {
            return "Poly";
        }

    }

    private String diffFunction(String function, String functionType) {
        if (functionType.equals("Poly")) {
            if (function.length() == 1 & !function.contains("x")) {
                coeAndPower = new int[]{ 0, 0 };
                return getPolyFuncFromCoeAndPower(coeAndPower);
            }
            coeAndPower = diffPolynomial(getPolyCoeAndPower(function));
            return getPolyFuncFromCoeAndPower(coeAndPower);
        } else if (functionType.equals("Expo")) {
            String xFunction = function.substring(4).replace(")", "");
            return chainRule("exp(u)", xFunction);
        }
        return null;
    }

    private String chainRule(String uFunction, String xFunction) {
        if (analyzeFunction(uFunction).equals("Expo")) {
            String newXFunction = getPolyFuncFromCoeAndPower(diffPolynomial(getPolyCoeAndPower(xFunction)));
            if (newXFunction.equals("1")) {
                newXFunction = "";
            } else {
                newXFunction = newXFunction + "*";
            }
            return newXFunction + uFunction.replace("u", xFunction);
        }
        return "Unknown function";
    }

    private String getPolyFuncFromCoeAndPower(int[] coeAndPower) {
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

    private void displayAnswer(String function, String output) {
        System.out.println("The differentiation of " + function + " is ");
        System.out.println(output);
    }

    private int[] diffPolynomial(int[] coeAndPower) {
        return new int[]{coeAndPower[0] * coeAndPower[1], coeAndPower[1] - 1};
    }

    private int[] getPolyCoeAndPower(String function) {
        String[] coeAndPower = function.split("x");
//        System.out.println(Arrays.toString(coeAndPower));
        int[] intCoeAndPower = {1, 1};
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
}
