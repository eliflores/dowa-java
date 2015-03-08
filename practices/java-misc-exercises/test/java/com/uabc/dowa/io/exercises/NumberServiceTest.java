package com.uabc.dowa.io.exercises;

import org.junit.Test;

import java.util.Random;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class NumberServiceTest {
    @Test
    public void testFindSingleMissingNumber(){
        NumberServiceImpl classTest = new NumberServiceImpl();
        int [] test = new int[100];
        for(int i = 1; i <= 100; i++){
            test[i-1] = i;
        }
        int index = this.randInt();
        assertEquals(index, classTest.findSingleMissingNumber(removeElement(test, index)));
    }

    @Test
    public void testFindTwoMissingNumbers(){
        NumberServiceImpl classTest = new NumberServiceImpl();
        int [] test = new int[100];
        for(int i = 1; i <= 100; i++){
            test[i-1] = i;
        }
        test = removeElement(test, 45);
        test = removeElement(test,39);
        int [] values = {45, 39};
        assertArrayEquals(values, classTest.findTwoMissingNumbers(test));
    }

    @Test
    public void testFindMissingNumbers(){

    }

    @Test
    public void testFindNumberInSortedArray(){

    }

    public int randInt() {
        int min = 1;
        int max = 100;
        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public int[] removeElement(int[] arr, int del){
        int i , j ;
        for (i = j = 0; j < arr.length; ++j) {
            if (j != del - 1) {
                arr[i++] = arr[j];
            }
        }
        return Arrays.copyOf(arr, i);
    }
}
