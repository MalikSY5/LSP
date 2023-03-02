package org.howard.edu.lsp.hw4;

import org.howard.edu.lsp.hw4.IntegerSet.IntegerSetException;

public class Driver {

	public static void main(String[] args) throws IntegerSetException {
		IntegerSet set1 = new IntegerSet();
		System.out.println("Value of Set1 is: " + set1.toString());
		System.out.println("Set1 is Empty: " + set1.isEmpty());
		set1.add(2);
		System.out.println("Set1 is Empty: " + set1.isEmpty());
		System.out.println("Value of Set1 is: " + set1.toString());
		System.out.println("Length of the set is: " + set1.length());
		set1.add(32);
		System.out.println("Value of Set1 is: " + set1.toString());
		System.out.println("Length of the set is: " + set1.length());
		set1.add(4);
		System.out.println("Value of Set1 is: " + set1.toString());
		set1.remove(2);
		System.out.println("Value of Set1 is: " + set1.toString());
		System.out.println("Length of the set is: " + set1.length());
		System.out.println("The largest value in set1 is: " + set1.largest());
		set1.add(99);
		System.out.println("The largest value in set1 is: " + set1.largest());
		System.out.println("The smallest value in set1 is: " + set1.smallest());
		set1.add(-2);
		System.out.println("The smallest value in set1 is: " + set1.smallest());
		System.out.println("Value of Set1 is: " + set1.toString());
		set1.remove(-2);
		System.out.println("Value of Set1 is: " + set1.toString());
		System.out.println("The smallest value in set1 is: " + set1.smallest());
		System.out.println("Length of the set is: " + set1.length());
		IntegerSet set2 = new IntegerSet();
		set2.add(32);
		set2.add(4);
		set2.add(99);
		System.out.println("Value of Set1 is: " + set1.toString());
		System.out.println("Value of Set2 is: " + set2.toString());
		System.out.println("Set1 and Set2 are equal: " + set1.equals(set2));
		set2.add(87);
		System.out.println("Value of Set1 is: " + set1.toString());
		System.out.println("Value of Set2 is: " + set2.toString());
		System.out.println("Set1 and Set2 are equal: " + set1.equals(set2));
		System.out.println("Value of Set1 is: " + set1.toString());
		System.out.println("Value of Set2 is: " + set2.toString());
		System.out.println("Set1 before union: " + set1.toString());
		set1.union(set2);
		System.out.println("Set1 after union: " + set1.toString());
		System.out.println("Value of Set1 is: " + set1.toString());
		System.out.println("Value of Set2 is: " + set2.toString());
		set1.add(0);
		set1.add(46);
		set1.add(21);
		set1.add(74);
		System.out.println("Value of Set1 is: " + set1.toString());
		System.out.println("Value of Set2 is: " + set2.toString());
		System.out.println("Set1 before intersection: " + set1.toString());
		System.out.println("Value of Set2 is: " + set2.toString());
		set1.intersection(set2);
		System.out.println("Set1 after intersection: " + set2.toString());
		System.out.println("Value of Set1 is: " + set1.toString());
		System.out.println("Value of Set2 is: " + set2.toString());
		System.out.println("Set1 before difference: " + set1.toString());
		set1.difference(set2);
		System.out.println("Set1 after difference: " + set1.toString());
		System.out.println("Set1 is Empty: " + set1.isEmpty());
		System.out.println("Value of Set2 is: " + set2.toString());
		set2.clear();
		System.out.println("Value of Set2 is: " + set2.toString());
		System.out.println("Set2 is Empty: " + set2.isEmpty());
		System.out.println("Value of Set1 is: " + set1.toString());
		System.out.println("Value of Set2 is: " + set2.toString());
		System.out.println("Length of set1 is: " + set1.length());
		System.out.println("Length of set2 is: " + set2.length());
		System.out.println("Set1 and Set2 are equal: " + set1.equals(set2));
		System.out.println("The largest value in set1 is: " + set1.largest());
	}
}