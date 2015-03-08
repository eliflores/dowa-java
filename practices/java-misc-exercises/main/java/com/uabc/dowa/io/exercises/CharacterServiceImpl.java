package com.uabc.dowa.io.exercises;

/**
 * Created by Andres on 3/1/2015.
 */
public class CharacterServiceImpl implements CharacterService{
    @Override
    public boolean areAnagrams(String s1, String s2) {
        //s1 = s1.replaceAll("\\s","");
        //s2 = s2.replaceAll("\\s","");
        return true;
    }

    @Override
    public void reverse(char[] arr) {
        char [] tempArr = new char[arr.length];
        System.arraycopy( arr, 0, tempArr, 0, arr.length );
        int i = arr.length;
        for(char c: tempArr){
            i--;
            arr[i] = c;
        }
    }

    @Override
    public void reverseWords(char[] arr) {
        char [] tempArr = new char[arr.length];
        System.arraycopy( arr, 0, tempArr, 0, arr.length );
        int i = arr.length - 1;
        int j;
        StringBuilder word = new StringBuilder();
        for(char c: tempArr){
            if(c == ' '){
                j = i;
                arr[j] = ' ';
                for(char cWord: word.toString().toCharArray()){
                    j++;
                    arr[j] = cWord;

                }
                word.setLength(0);
            }
            else{
                word.append(c);
            }
            i--;
        }
        if(word.length() > 0){
            j = i;
            for(char cWord: word.toString().toCharArray()){
                j++;
                arr[j] = cWord;
            }
        }
    }
}
