package com.uabc.dowa.io.exercises;

public interface NumberService {
    /**
     * We have a bag containing numbers 1, 2, 3, …, 100. Each number appears exactly once, so there are 100 numbers.
     * Now one number is randomly picked out of the bag. Find the missing number.
     *
     * @param arr
     * @return
     */
    public int findSingleMissingNumber(int arr[]);

    /**
     * We have a bag containing numbers 1, 2, 3, …, 100. Each number appears exactly once, so there are 100 numbers.
     * Now two numbers are randomly picked out of the bag. Find the two missing numbers.
     *
     * @param arr
     * @return
     */
    public int findToMissingNumbers(int arr[]);

    /**
     * We have a bag containing numbers 1, 2, 3, …, 100. Each number appears exactly once, so there are 100 numbers.
     * Now N numbers are randomly picked out of the bag. Find the missing numbers.
     *
     * @param arr
     * @return
     */
    public int[] findMissingNumbers(int arr[]);

    /**
     * Given a sorted array of integers, how can you find the location of a particular integer x?
     */
    public int findNumberInSortedArray(int arr[], int x);
}
