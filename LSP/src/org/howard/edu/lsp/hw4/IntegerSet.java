package org.howard.edu.lsp.hw4;
import java.util.*;

public class IntegerSet {
	private List<Integer> my_set;
	
	public IntegerSet(){
		my_set = new ArrayList<Integer>();
	}
	public class IntegerSetException extends Exception {
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
	
	public void clear(){
		my_set.clear();
	}
	
	public int length() {
		return my_set.size();
	}
	
	public boolean equals(IntegerSet set) {
		if(my_set.size() != set.length()) {
			return false;
		}else {
			return my_set.containsAll(set.my_set);
		}
	}
	
	public int largest() throws IntegerSetException {
		int maxValue = Integer.MIN_VALUE;
		if (my_set.isEmpty()) {
				throw new IntegerSetException("Set is Empty");
			}
			else {
				for (Integer integer : my_set) {
					if (integer > maxValue) {
						maxValue = integer;
					}
				}
			}
		return maxValue;
	}
		
	public int smallest() throws IntegerSetException {
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
		if (my_set.contains(item) == false) {
		my_set.add(item);
		}
	}
	
	public void remove(int item) {
		if (my_set.contains(item) == true) {
			my_set.remove(item);
		}
	}
	
	public void union(IntegerSet intsetb) {
		for(int i = 0; i < intsetb.my_set.size(); i++) {
			if(my_set.contains(intsetb.my_set.get(i)) == false){
				my_set.add(intsetb.my_set.get(i));
			}
		}
	}
	
	public void intersection(IntegerSet intsetb) {
		my_set.retainAll(intsetb.my_set);
	}

	public void difference(IntegerSet intsetb) {
		for(int i = 0; i < intsetb.length();i++) {
			if(my_set.contains(intsetb.my_set.get(i)) == true){
				my_set.remove(intsetb.my_set.get(i));
			}
		}
	}
	
	public boolean isEmpty() {
		if(my_set.isEmpty() == true){
			return true;
		}
		else {
			return false;
		}
	}
	
	public String ToString() {
		String setString = "";
		for(int i = 0; i < my_set.size(); i++) {
			setString += my_set.get(i).toString() + ' ';
		}
		return setString;
	}

}
