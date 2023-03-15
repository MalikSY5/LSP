package org.howard.edu.lsp.hw5;
import java.util.*;

public class IntegerSet { //making IntegerSet class
	private List<Integer> my_set;
	
	public IntegerSet(){ //creating public set
		my_set = new ArrayList<Integer>();
	}
	public class IntegerSetException extends Exception { //integer exception for largest and smallest function
		public IntegerSetException(String error) {
			super(error);
		}
		/**
	       * Used to return set to user
	       *
	       * @param set     IntegerSet instance
	       * @return        given set
	       */
	}
	public List<Integer> get_set() {
		return my_set;
	}
	/**
     * creates new set
     *
     * @param set     list of integers for set
     * @return        nothing, makes new set with given list
     */
	public void set_set(List<Integer> new_set){
		my_set = new_set;
	}
	
	/**
     * Clear the set of all elements
     *
     * @param NULL
     * @return        NULL
     */
	
	public void clear(){ //clear array
		my_set.clear();
	}
	
	/**
     * Get's the length of current set
     *
     * @param NULL
     * @return        length of current set
     */
	
	public int length() { //return length of array(set)
		return my_set.size();
	}
	/**
     * Determine if two IntegerSets are equal
     *
     * @param set     IntegerSet instance to compare with
     * @return        true if equal, otherwise false
     */
	
	public boolean equals(IntegerSet set) { 
		if(my_set.size() != set.length()) {//check if size are the same
			return false;
		}else {
			return my_set.containsAll(set.my_set); //check if values are the same, return true or false
		}
	}
	
	/**
     * Determine greatest integer in set
     *
     * @param NULL
     * @return        greatest integer in set, else returns Exception -> set is empty 
     */
	
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
	
	/**
     * Determine smallest integer in set
     *
     * @param NULL
     * @return        smallest integer in set, else returns Exception -> set is empty 
     */
	
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
	
	/**
     * Adds integer into set
     *
     * @param integer
     * @return  NUll, adds element into set if it is not already there, else does nothing 
     */
	
	public void add(int item) {
		if (my_set.contains(item) == false) { //checks is element is already in set, adds if not
		my_set.add(item);
		}
	}
	
	/**
     * removes integer into set
     *
     * @param integer
     * @return  NUll, removes element from set by index, else does nothing 
     */
	
	public void remove(int item) {
		if (my_set.contains(item) == true) { //checks if element is in set then removes if it is
			my_set.remove(my_set.indexOf(item));
		}
	}
	
	/**
     * Performs Set Union on two sets
     *
     * @param IntegerSet set
     * @return  NUll, adds elements if they are not already in set one, else does nothing 
     */
	
	public void union(IntegerSet intsetb) {
		for(int i = 0; i < intsetb.my_set.size(); i++) {
			if(my_set.contains(intsetb.my_set.get(i)) == false){ //checks if element is already in set, if not adds element
				my_set.add(intsetb.my_set.get(i));
			}
		}
	}
	
	/**
     * Performs Set Intersection on two sets
     *
     * @param IntegerSet set
     * @return  NUll, keeps elements if they are in both sets, else does nothing 
     */
	
	public void intersection(IntegerSet intsetb) {
		my_set.retainAll(intsetb.my_set); //keeps only values that both sets share
	}
	
	/**
     * Performs Set Difference on two sets
     *
     * @param IntegerSet set
     * @return  NUll, removes elements if elements are in both sets,else does nothing
     */
	
	public void difference(IntegerSet intsetb) {
		for(int i = 0; i < intsetb.length();i++) {
			if(my_set.contains(intsetb.my_set.get(i)) == true){//verify if element is in both sets, then removes element
				my_set.remove(intsetb.my_set.get(i));
			}
		}
	}
	
	/**
     * Determines is set is empty or not
     *
     * @param NULL
     * @return  true if set is empty or false if set has elements 
     */
	
	public boolean isEmpty() {//checks if set is empty then returns true or false
		if(my_set.isEmpty() == true){
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
     * Converts IntegerSet elements to string 
     *
     * @param NULL
     * @return  string variable with elements from set 
     */
	
	public String toString() { //iterates over set and adds each element to a string that is returned. 
		String setString = "";
		for(int i = 0; i < my_set.size(); i++) {
			setString += my_set.get(i).toString() + ' ';
		}
		return setString;
	}

}
