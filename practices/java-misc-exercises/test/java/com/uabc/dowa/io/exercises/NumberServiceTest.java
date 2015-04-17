package com.uabc.dowa.io.exercises;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberServiceTest {
    private NumberServiceClass test = new NumberServiceClass();

    @Test
    public void testFindSingleMissingNumber(){
        List<Integer> elementList = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++){
            elementList.add(i+1);
        }
    }

    public int newRandomNum(){
        Random genRandomNum = new Random();
        return genRandomNum.nextInt(100) + 1;
    }
}
