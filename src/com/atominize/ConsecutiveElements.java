package com.atominize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// This class finds the consecutive integers in an array

public class ConsecutiveElements {
    public ConsecutiveElements() {
        int[] sampleArray = { 49, 1, 3, 200, 2, 4, 70, 5 };
//        System.out.println(Arrays.toString(sampleArray));

//        List<Integer> inputList = new ArrayList<Integer>(Arrays.stream(sampleArray).boxed().collect(Collectors.toList()));
        List<Integer> inputList = new ArrayList<>();
        List<Integer> conArray = new ArrayList<>();
        for (int item: sampleArray) {
            inputList.add(item);
        }
        for (int i = 0; i < inputList.size(); i++) {
            for (int item: inputList.subList(i+1, inputList.size())) {
                if (inputList.get(i) == item + 1 || inputList.get(i) == item - 1) {
                    conArray.add(inputList.get(i));
                    conArray.add(item);
                }
            }
        }
        List<Integer> integerList = removeDuplicates(conArray);
        System.out.println(integerList.size());
        // TODO: check the list to see if it is conservative numbers
    }

    public List<Integer> removeDuplicates(List<Integer> arrayList) {
        List<Integer> newArrayList = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            for (int item: arrayList.subList(i+1, arrayList.size())) {
                if (arrayList.get(i) == item) {
                    newArrayList.add(item);

                }
            }
        }
        for (int item: newArrayList) {
            arrayList.remove((Integer) item);
        }
        return arrayList;
    }
}
