package com.uabc.dowa.io;

import java.util.List;
import org.junit.Test;

import static org.junit.Assert.*;

public class FileUtilsTest {
    @Test
    public void testCountNumberOfCharacterInFile() throws Exception {
        assertEquals(0, FileUtils.countNumberOfOccurrencesInFile('x'));
        assertEquals(0, FileUtils.countNumberOfOccurrencesInFile('z'));
        assertEquals(0, FileUtils.countNumberOfOccurrencesInFile('I'));

        assertEquals(0, FileUtils.countNumberOfOccurrencesInFile('2'));

        assertEquals(1, FileUtils.countNumberOfOccurrencesInFile('A'));
        assertEquals(8, FileUtils.countNumberOfOccurrencesInFile(','));
        assertEquals(9, FileUtils.countNumberOfOccurrencesInFile('u'));
        assertEquals(51, FileUtils.countNumberOfOccurrencesInFile('a'));
        assertEquals(36, FileUtils.countNumberOfOccurrencesInFile('o'));

        assertEquals(52, FileUtils.countNumberOfOccurrencesInFile('e'));
        assertEquals(31, FileUtils.countNumberOfOccurrencesInFile('i'));
    }

    @Test
    public void testGetLinesInReverseOrder() throws Exception {
        List<String> linesInReverseOrder = FileUtils.getLinesInReverseOrder();
        assertNotNull(linesInReverseOrder);
        assertEquals(9, linesInReverseOrder.size());
        assertEquals("of Kashyyyk during the Clone Wars and during the Galactic Civil War.", linesInReverseOrder.get(0));
        assertEquals("Chewbacca (or \"Chewie\", as he was known by his friends)", linesInReverseOrder.get(8));
    }
}
