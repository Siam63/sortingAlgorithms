package com.company;

import java.io.OptionalDataException;
import java.util.Random;

public class Main {
    // This entire program is a one-stop place for all major sorting algorithms.

    public static void main(String[] args) {
//        int[] inputArray = {5, 12, 3, 1, 6, 14, 22, 15, 16, 35};
        int[] array = new int[10];

        System.out.println("MERGE SORT:");
        populateArray(array, "merge");
        System.out.println("");
        // -------
        System.out.println("BUBBLE SORT:");
        populateArray(array, "bubble");
        System.out.println("");
        // -------
        System.out.println("INSERTION SORT:");
        populateArray(array, "insertion");
        System.out.println("");
    }

    public static void populateArray(int[] arr, String sortingMethod){
        Random rand = new Random();

        for(int i = 0; i < arr.length; i++){
            arr[i] = rand.nextInt((100 - 1) + 1) + 1;
        }

        if(sortingMethod.equals("merge")){
            mergeSort(arr);
            printArray(arr);
        }else if(sortingMethod.equals("quick")){
            quickSort(arr);
            printArray(arr);
        }else if(sortingMethod.equals("bubble")){
            bubbleSort(arr);
            printArray(arr);
        }else if(sortingMethod.equals("insertion")){
            insertionSort(arr);
            printArray(arr);
        }
    }

    public static void printArray(int[] inputArray){
        for(int i : inputArray){
            System.out.print(i + " ");
        }
    }

    public static void mergeSort(int[] inputArray){
        int inputLength = inputArray.length;

        if(inputLength < 2){
            return;
        }

        int midPoint = inputLength / 2;
        int[] leftHalf = new int[midPoint];
        int[] rightHalf = new int[inputLength - midPoint]; // takes into consideration odd array length

        for(int i = 0; i < midPoint; i++){
            leftHalf[i] = inputArray[i];
        }

        for(int i = midPoint; i < inputLength; i++){
            rightHalf[i - midPoint] = inputArray[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(inputArray, leftHalf, rightHalf);
    }

    private static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf){
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int leftArrayPointer = 0, rightArrayPointer = 0, targetIdx = 0;

        while(leftArrayPointer < leftSize && rightArrayPointer < rightSize){
            if(leftHalf[leftArrayPointer] <= rightHalf[rightArrayPointer]){
                inputArray[targetIdx] = leftHalf[leftArrayPointer++];
            }else{
                inputArray[targetIdx] = rightHalf[rightArrayPointer++];
            }

            targetIdx++;
        }

        while(leftArrayPointer < leftSize){
            inputArray[targetIdx] = leftHalf[leftArrayPointer++];
            targetIdx++;
        }

        while(rightArrayPointer < rightSize){
            inputArray[targetIdx] = rightHalf[rightArrayPointer++];
            targetIdx++;
        }
    }

    public static void quickSort(int[] arr){
        return;
    }

    public static void bubbleSort(int[] inputArray){
        boolean swappedBoolean = true;

        while(swappedBoolean){
            swappedBoolean = false;

            for(int i = 0; i < inputArray.length - 1; i++){
                if(inputArray[i] > inputArray[i+1]){
                    swappedBoolean = true;
                    int temp = inputArray[i];
                    inputArray[i] = inputArray[i+1];
                    inputArray[i+1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr){
        return;
    }

    public static void heapSort(int[] arr){
        return;
    }

    public static void insertionSort(int[] inputArray){
        for(int i = 1; i < inputArray.length; i++){
            int currValue = inputArray[i];
            int j = i - 1;

            while(j >= 0 && inputArray[j] > currValue){
                inputArray[j + 1] = inputArray[j--];
            }

            inputArray[j + 1] = currValue;
        }
    }
}
