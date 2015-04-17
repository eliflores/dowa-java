package com.uabc.dowa.io.exercises;

/**
 * Created by rabanita on 8/03/15.
 */
public class NumberServiceClass implements NumberService{

    public NumberServiceClass(){
        //Constructor
    }

    /**
     * We have a bag containing numbers 1, 2, 3, …, 100. Each number appears exactly once, so there are 100 numbers.
     * Now one number is randomly picked out of the bag. Find the missing number.
     *
     * @param arr
     * @return
     */
    @Override
    public int findSingleMissingNumber(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
        }

        return sum1to100() - sum;
    }

    @Override
    public int findToMissingNumbers(int[] arr) {

        return 0;
    }

    @Override
    public int[] findMissingNumbers(int[] arr) {
        return new int[0];
    }

    @Override
    public int findNumberInSortedArray(int[] arr, int x) {
        return 0;
    }

    public int sum1to100(){
        int sumNumbers = 0;
        int j = 100;
        for (int i = 0; i < 50; i++){
            int temp = i + 1 + j;
            sumNumbers += temp;
            j--;
        }
        return sumNumbers;
    }
}
