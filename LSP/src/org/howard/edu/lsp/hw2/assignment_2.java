package org.howard.edu.lsp.hw2;

import java.util.*;
import java.io.FileNotFoundException;


public class assignment_2 {
    public static void main(String[] args) {
        //instantiating the File Reader class and Hash Map
        FileReader fileReader = new FileReader();
        HashMap<String, Integer> myHashMap = new HashMap<String, Integer>();
        
        try {
            //converting file content into a string
            String fileToString = fileReader.readToString("main/resources/word.txt");
            
            //solves for punctuation and splits by spaces
            String[] splitWords = fileToString.replaceAll("[^a-zA-z ]", "").toLowerCase().split(" ");
            
            //loops through and updates the dictionary based on conditionals
            for(int i=0; i < splitWords.length; i++) {
                if(splitWords[i].length()>3) {
                    if(myHashMap.get(splitWords[i])== null) {
                        myHashMap.put(splitWords[i], 1);
                    } else {
                        myHashMap.put(splitWords[i], myHashMap.get(splitWords[i]) + 1);
                    }
                }
            }
            
            //prints the keys and values in the hash map
            for (String i:myHashMap.keySet()) {
                System.out.println(i + " " + myHashMap.get(i));
            }
        } catch (FileNotFoundException e){
            System.out.println(e);
        };
    }
}