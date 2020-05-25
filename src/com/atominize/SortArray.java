package com.atominize;

import java.util.ArrayList;
import java.util.List;

// This class is for sorting an array of integers

public class SortArray {
    public SortArray() {
        int[] sampleArray = { 49, 1, 3, 200, 2, 4, 70, 5 };
//        Arrays.sort(sampleArray);
//        System.out.println(Arrays.toString(sampleArray));
        List<Integer> inputList = arrayToArrayList(sampleArray);
        for (int i = 0; i < inputList.size(); i++) {
            int min = minOfArray(inputList.subList(i,inputList.size()));
            inputList.remove((Integer) min);
            inputList.add(i, min);
        }
        System.out.println(inputList);
        //Todo: does not work when array contains repeated integers... fix it
    }

    public int minOfArray(List<Integer> integers) {
        int min_int = integers.get(0);
        for (int item: integers) {
            min_int = Math.min(item, min_int);
        }
        return min_int;
    }

    public List<Integer> arrayToArrayList(int[] ints) {
        List<Integer> integerList = new ArrayList<>();
        for (int item: ints) {
            integerList.add(item);
        }
        return integerList;
    }
}
