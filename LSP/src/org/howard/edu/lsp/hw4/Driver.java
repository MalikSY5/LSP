package org.howard.edu.lsp.hw4;

import org.howard.edu.lsp.hw4.IntegerSet.IntegerSetException;

public class Driver {

	public static void main(String[] args) throws IntegerSetException {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(50);
		set1.add(-20);
		set1.add(42);
		System.out.println("Value of Set1 is: " + set1.ToString());
		System.out.println("Length of the set is: " + set1.length());
		set1.remove(2);
		System.out.println("Value of Set1 is: " + set1.ToString());
		System.out.println("Length of the set is: " + set1.length());
		IntegerSet set2 = new IntegerSet();
		set2.add(1);
		set2.add(2);
		set2.add(50);
		set2.add(-20);
		set2.add(42);
		System.out.println("Set1 and Set2 are equal: " + set1.equals(set2));
		System.out.println("Value of Set1 is: " + set1.ToString());
		System.out.println("Value of Set2 is: " + set2.ToString());
		System.out.println("The largest value in set1 is: " + set1.largest());
		set1.remove(2);
		System.out.println("The largest value in set1 is: " + set1.largest());
		System.out.println("The largest value in set1 is: " + set1.smallest());
		set1.remove(2);
		System.out.println("The largest value in set1 is: " + set1.smallest());
		System.out.println("Set1 before union: " + set1.ToString());
		set1.union(set2);
		System.out.println("Set1 after union: " + set1.ToString());
		set2.add(67);
		set2.add(86);
		set2.add(33);
		set2.add(33);
		set2.remove(1500);
		System.out.println("Set2 before intersection: " + set2.ToString());
		set2.intersection(set1);
		System.out.println("Set2 after intersection: " + set2.ToString());
		set1.add(8);
		System.out.println("Set1 before difference: " + set1.ToString());
		set1.difference(set2);
		System.out.println("Set1 after difference: " + set1.ToString());
		System.out.println("Set1 is Empty: " + set1.isEmpty());
		set1.clear();
		System.out.println("Set1 is Empty: " + set1.isEmpty());
	}

}
