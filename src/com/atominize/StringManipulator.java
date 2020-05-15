package com.atominize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// This class get you the length of unique characters in a string

public class StringManipulator {
    public StringManipulator() {
        System.out.println("Enter word...");
        Scanner scanner = new Scanner(System.in);
        String sampleInput = scanner.next();
        List<String> inputArray = new ArrayList<>(Arrays.asList(sampleInput.split("")));

        int similarLength = 0;
        for (int i = 0; i < inputArray.size(); i++) {
            for (String item: inputArray.subList(i+1, inputArray.size())) {
//                System.out.println(inputArray.subList(i+1, inputArray.size()));
                if (inputArray.get(i).equals(item)) {
                    similarLength++;
                    break;
                }
            }
        }
        System.out.println("Input length is " + (inputArray.size() - similarLength));
    }
}
