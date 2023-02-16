package org.howard.edu.lsp.hw4;
import java.util.*;

public class IntegerSet { //making integerset class
	private List<Integer> my_set;
	
	public IntegerSet(){ //creating public set
		my_set = new ArrayList<Integer>();
	}
	public class IntegerSetException extends Exception { //integer exception for largest and smallest function
		public IntegerSetException(String error) {
			super(error);
		}
	}
	public List<Integer> get_set() {
		return my_set;
	}
	
	public void set_set(List<Integer> new_set){
		my_set = new_set;
	}
	
	public void clear(){ //clear array
		my_set.clear();
	}
	
	public int length() { //return length of array(set)
		return my_set.size();
	}
	
	public boolean equals(IntegerSet set) { 
		if(my_set.size() != set.length()) {//check if size are the same
			return false;
		}else {
			return my_set.containsAll(set.my_set); //check if values are the same, return true or false
		}
	}
	
	public int largest() throws IntegerSetException {
		int maxValue = Integer.MIN_VALUE; //set value to min
		if (my_set.isEmpty()) {
				throw new IntegerSetException("Set is Empty");
			}
			else {
				for (Integer integer : my_set) {
					if (integer > maxValue) { //check if integer is grater than maxValue, update if so
						maxValue = integer;
					}
				}
			}
		return maxValue;
	}
		
	public int smallest() throws IntegerSetException { //does the same thing as largest just for smallest
		int minValue = Integer.MAX_VALUE;
		if (my_set.isEmpty()) {
				throw new IntegerSetException("Set is Empty");
			}
			else {
				for (Integer integer : my_set) {
					if (integer < minValue) {
						minValue = integer;
					}
				}
			}
		return minValue;
	}
	
	public void add(int item) {
		if (my_set.contains(item) == false) { //checks is element is already in set, adds if not
		my_set.add(item);
		}
	}
	
	public void remove(int item) {
		if (my_set.contains(item) == true) { //checks if element is in set then removes if it is
			my_set.remove(item);
		}
	}
	
	public void union(IntegerSet intsetb) {
		for(int i = 0; i < intsetb.my_set.size(); i++) {
			if(my_set.contains(intsetb.my_set.get(i)) == false){ //checks if element is already in set, if not adds element
				my_set.add(intsetb.my_set.get(i));
			}
		}
	}
	
	public void intersection(IntegerSet intsetb) {
		my_set.retainAll(intsetb.my_set); //keeps only values that both sets share
	}

	public void difference(IntegerSet intsetb) {
		for(int i = 0; i < intsetb.length();i++) {
			if(my_set.contains(intsetb.my_set.get(i)) == true){//verify if element is in both sets, then removes element
				my_set.remove(intsetb.my_set.get(i));
			}
		}
	}
	
	public boolean isEmpty() {//checks if set is empty then returns true or false
		if(my_set.isEmpty() == true){
			return true;
		}
		else {
			return false;
		}
	}
	
	public String ToString() { //iterates over set and adds each element to a string that is returned. 
		String setString = "";
		for(int i = 0; i < my_set.size(); i++) {
			setString += my_set.get(i).toString() + ' ';
		}
		return setString;
	}

}
