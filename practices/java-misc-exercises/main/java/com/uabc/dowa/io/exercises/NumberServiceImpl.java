package com.uabc.dowa.io.exercises;

/**
 * Created by Andres on 3/1/2015.
 */
public class NumberServiceImpl implements NumberService{
    public NumberServiceImpl(){}
    @Override
    public int findSingleMissingNumber(int[] arr) {
        int elementsSum = 0;
        int arrLth = arr.length + 1;
        int sumNElements = (arrLth*(arrLth + 1))/2;
        for(int item: arr){
            elementsSum += item;
        }
        return sumNElements - elementsSum;
    }

    @Override
    public int[] findTwoMissingNumbers(int[] arr) {
        int n = arr.length + 2; //Numero de elementos del arreglo
        double S = (n*(n + 1))/2;
        double T = (n*(n+1)*(2*n+1))/6;
        double AS = 0, AT = 0;
        for(int item: arr){
            AS += item;
            AT += Math.pow(item,2);
        }
        double a = 1;
        double b = AS - S;
        double c = ((Math.pow(S-AS,2)) - (T - AT))/2;
        double number1 = (-b + Math.sqrt((Math.pow(b,2))-4*a*c))/2*a;
        double number2 = (-b - Math.sqrt((Math.pow(b,2))-4*a*c))/2*a;
        int []values = {(int)number1, (int)number2};
        return values;
    }

    @Override
    public int[] findMissingNumbers(int[] arr) {
        return new int[0];
    }

    @Override
    public int findNumberInSortedArray(int[] arr, int x) {
        int begin = 0, end = arr.length-1;

        while(end >= begin){
            int middle = begin + ((end - begin / 2));
            if(arr[middle] == x){
                return middle;
            }
            else if(arr[middle] < x){
                begin = middle + 1;
            }
            else if(arr[middle] > x){
                end = middle - 1;
            }
        }
        return -1;
    }
}
