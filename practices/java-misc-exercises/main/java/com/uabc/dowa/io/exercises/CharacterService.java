package com.uabc.dowa.io.exercises;

public interface CharacterService {
    /**
     * Determines if two strings are anagrams.  Whitespace is ignored, but all other characters
     * (including punctuation) count.
     *
     * @param s1 first string to compare
     * @param s2 second string to compare
     * @return true if s1 and s2 are anagrams, false otherwise
     */
    boolean areAnagrams(String s1, String s2);

    /**
     * Reverses a char array in place.
     *
     * @param arr - array to be reversed
     */
    public void reverse(char arr[]);


    /**
     * Reverses a words in a char array in place.
     *
     * @param arr - array which words are to be reversed
     */
    public void reverseWords(char arr[]);
}
