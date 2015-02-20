package com.uabc.dowa.io;
import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class FileCharacterCounter {
    public static int countNumberOfOccurrencesInFile(char character) {
        int ocurrences = 0;
        String currentLine;
        try(
            InputStream in = FileCharacterCounter.class.getResourceAsStream("chewie.txt");
            InputStreamReader inputR = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(inputR)  )
        {
            while ((currentLine = br.readLine()) != null) {
                ocurrences += currentLine.length() - currentLine.replace(String.valueOf(character), "").length();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return ocurrences;
    }

    public static LinkedList<String> getLinesInReverseOrder() {
        LinkedList<String> reverseText = new LinkedList();
        String currentLine;
        try(
            InputStream in = FileCharacterCounter.class.getResourceAsStream("chewie.txt");
            InputStreamReader inputR = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(inputR)  )
        {
            LinkedList<String> temp = new LinkedList();
            while ((currentLine = br.readLine()) != null) {
                temp.push(currentLine);
            }
            for(int i = temp.size() - 1; i >= 0;i--){
                reverseText.push(temp.get(i));
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return reverseText;
    }
}
