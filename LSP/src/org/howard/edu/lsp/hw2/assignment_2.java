package org.howard.edu.lsp.hw2;

import java.io.FileNotFoundException;
import java.util.*;

public class assignment_2 {

	public static void main(String[] args) {
		FileReader filename = new FileReader(); //FileReader to read file
		HashMap<String, Integer> hashmap = new HashMap<String, Integer>(); //creating and defining structure of hashmap
		try {
			String filepath = filename.readToString("main/resources/word.txt"); //obtaning file path to read
			System.out.println(filepath);
			String[] seperated = filepath.replaceAll("[^a-zA-z ]",  "").toLowerCase().split(" ");// seperating file
			for (int x = 0; x < seperated.length; x++) { //iterating over seperated
				if (seperated[x].length() > 3) { // checking is word is 3 char or more
					if (hashmap.get(seperated[x]) == null) {
						hashmap.put(seperated[x],1); //setting number of occurrences to 1
								}
					else {
						hashmap.put(seperated[x],  hashmap.get(seperated[x]) + 1); //increasing occurences
					}
				}
			}
			for (String i : hashmap.keySet()) {
				System.out.println(i + " " + hashmap.get(i)); //printing each hashmay key
			}
		}
		catch (FileNotFoundException e) { //error catching
			System.out.println("File not found in directory");
		}
		}
	}