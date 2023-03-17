package org.howard.edu.lsp.midterm.problem51;

import java.util.ArrayList;
import java.util.List;

public class IntegerRange implements Range{
	private int lower;
   	private int upper;

   	 IntegerRange(int lower, int upper) { 	// Constructor
        		this.lower = lower;
        		this.upper = upper;
   	 }
   	 
   	public int getLower() { //Getter for lower bound
   		return this.lower;
   	}
   	
   	public int getUpper() { //Getter for upper bound
   		return this.upper;
   	}
   	
	public boolean contains(int value) {
		if(value >= getLower() && value <= getUpper()){
			return true;
		}
		else {
			return false;
		}
	}
		
	public boolean overlaps(Range other) throws EmptyRangeException {
		if (other == null){
			throw new EmptyRangeException("Range object is Empty");
		}
		int lower = getLower();
		int upper = getUpper();
		int lower2 = other.getLower();
		int upper2 = other.getUpper();
		if(lower <= lower2 && upper <= upper2 || upper >= upper2) {
			if(lower2 < upper) {
				return true;
			}
			else {
				return false;
			}
		}
		else if(lower >= lower2 && upper <= upper2 || upper >= upper2) {
			if(lower < upper2) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}

	public int size()  {
		return getUpper() - getLower();
	}

	}
