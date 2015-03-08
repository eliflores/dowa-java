package com.uabc.dowa.io.exercises;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class CharacterServiceTest {

    @Test
    public void testAreAnagrams() {
        CharacterServiceImpl chService = new CharacterServiceImpl();
        assertEquals(true, chService.areAnagrams("animal", "lamina"));
    }

    @Test
    public void testReverse() {
        CharacterServiceImpl chService = new CharacterServiceImpl();
        String s = "hola";
        String s2 = "aloh";
        char [] charArr = s.toCharArray();
        chService.reverse(charArr);
        assertArrayEquals(s2.toCharArray(), charArr);
    }

    @Test
    public void testReverseWords() {
        CharacterServiceImpl chService = new CharacterServiceImpl();
        String s = "hola como estas";
        String s2 = "estas como hola";
        char [] charArr = s.toCharArray();
        chService.reverseWords(charArr);
        assertArrayEquals(s2.toCharArray(), charArr);
    }
}
