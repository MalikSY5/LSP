package org.howard.edu.lsp.midterm.problem51;

public interface Range {
	public class EmptyRangeException extends Exception { //exception for if range object is empty
		public EmptyRangeException(String error) {
			super(error);
		}
	}
	public int getLower();
	public int getUpper();
	public boolean contains( int value );  
	public boolean overlaps( Range other ) throws EmptyRangeException;
    // returns true if the receiver contains at least 
    // one value in common with other, and false otherwise 
    //  EmptyRangeException is thrown when a null Range object is passed to the method
	public int size(); 

}
