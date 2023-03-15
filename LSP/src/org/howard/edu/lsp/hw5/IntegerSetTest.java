package org.howard.edu.lsp.hw5;

import org.howard.edu.lsp.hw4.IntegerSet;
import org.howard.edu.lsp.hw4.IntegerSet.IntegerSetException;
import org.junit.jupiter.api.*;
import java.util.*;


public class IntegerSetTest extends junit.framework.TestCase{ 
	IntegerSet set1;
	@BeforeEach
	protected void setUp() {
		set1 = new IntegerSet();
	}
	
	@Test
	@DisplayName("Test case adding element into set and doing nothing is element is in set")
	public void testAdd() {
		setUp();
		Assertions.assertEquals(0, set1.length(), "Length should be zero");
		set1.add(4);
		Assertions.assertEquals(1, set1.length(), "Length should be one");
		set1.add(1);
		set1.add(2);
		set1.add(3);
		Assertions.assertEquals(4, set1.length(), "Length should be four");
		set1.add(1);
		Assertions.assertEquals(4, set1.length(), "Length should remain the same because 1 is already in set");
	}
	
	@Test
	@DisplayName("Tests for removing elements from set or doing nothing if element is not in set")
	public void testRemove() {
		setUp();
		set1.add(0);
		Assertions.assertEquals(1, set1.length(), "Length should be one");
		set1.remove(0);
		Assertions.assertEquals(0, set1.length(), "Length should be zero");
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);
		Assertions.assertEquals(4, set1.length(), "Length should be four");
		set1.remove(1);
		Assertions.assertEquals(3, set1.length(), "Length should be three");
		set1.remove(2);
		Assertions.assertEquals(2, set1.length(), "Length should be two");
		set1.remove(0);
		Assertions.assertEquals(2, set1.length(), "Length should remain same since element not in set");
		set1.remove(3);
		set1.remove(4);
		Assertions.assertEquals(0, set1.length(), "Length should be zero");
		set1.remove(0);
		Assertions.assertEquals(0, set1.length(), "Length should remain same because there are no elements to remove");
	}
	
	@Test
	@DisplayName("Returns length of set")
	public void testLength() {
		setUp();
		Assertions.assertEquals(0, set1.length(), "Length should be zero for empty set");
		set1.add(1);
		Assertions.assertEquals(1, set1.length(), "Length should be one");
		set1.add(2);
		set1.add(3);
		set1.add(4);
		Assertions.assertEquals(4, set1.length(), "Length should be four");
		set1.remove(1);
		Assertions.assertEquals(3, set1.length(), "Length should be three");
		set1.remove(2);
		set1.remove(3);
		Assertions.assertEquals(1, set1.length(), "Length should be one");
	}
	
	@Test
	@DisplayName("Test for clearing set")
	public void testClear() {
		setUp();
		Assertions.assertEquals(0, set1.length(), "Length should be zero for empty set");
		set1.add(0);
		set1.add(2);
		set1.add(1);
		set1.add(4);
		set1.add(5);
		Assertions.assertEquals(5, set1.length(), "Length should be five");
		set1.clear();
		Assertions.assertEquals(0, set1.length(), "Length should be zero after clearing");
	}
	
	@Test
	@DisplayName("Test if two sets are equal to eachother")
	public void testEquals(){
		setUp();
		IntegerSet set2 = new IntegerSet();
		Assertions.assertTrue(true == set1.equals(set2), "should be true because both are empty sets");
		set1.add(1);
		set2.add(4);
		Assertions.assertTrue(false == set1.equals(set2), "Should not be equal because elements are not the same");
		set1.add(4);
		set2.add(1);
		Assertions.assertTrue(true == set1.equals(set2), "Equal because contain the same elements");
		set2.remove(1);
		Assertions.assertTrue(false == set1.equals(set2), "Sets no longer equal after removal");
		
		
	}
	
	@Test
	@DisplayName("Test for finding largest element")
	public void testLargest() throws IntegerSetException {
		setUp();
		set1.add(76);
		set1.add(89);
		set1.add(120);
		set1.add(0);
		set1.add(21);
		set1.add(-1);
		Assertions.assertEquals(120,set1.largest(), "Largest element should be 120");
		set1.remove(120);
		Assertions.assertEquals(89,set1.largest(), "New largest element should be 89");
		set1.add(500);
		Assertions.assertEquals(500,set1.largest(), "New largest element should be 500");
		
	}
	
	@Test
	@DisplayName("Test for IntegerSetException")
	public void testIntegerSetExceptionLargest() {
		setUp();
		Throwable exception = Assertions.assertThrows(IntegerSetException.class, () -> set1.largest());
		assertEquals("Set is Empty", exception.getMessage());
		
	}
	
	@Test
	@DisplayName("Test for finding smallest element")
	public void testSmallest() throws IntegerSetException {
		setUp();
		set1.add(20);
		set1.add(10);
		set1.add(0);
		set1.add(-10);
		set1.add(-11);
		Assertions.assertEquals(-11,set1.smallest(), "Smallest element should be -11");
		set1.remove(-11);
		Assertions.assertEquals(-10,set1.smallest(), "Smallest element should be -10");
		set1.remove(-10);
		set1.add(-100);
		Assertions.assertEquals(-100,set1.smallest(), "Smallest element should be -100");
		
	}
	
	@Test
	@DisplayName("Test for IntegerSetException")
	public void testIntegerSetExceptionSmallest() {
		setUp();
		Throwable exception2 = Assertions.assertThrows(IntegerSetException.class, () -> set1.smallest());
		assertEquals("Set is Empty", exception2.getMessage());
	}
	
	@Test
	@DisplayName("Test for set Union")
	public void testUnion() {
		setUp();
		IntegerSet set2 = new IntegerSet();
		set1.add(2);
		set1.add(7);
		set1.add(5);
		set2.add(9);
		set2.add(3);
		Assertions.assertEquals(3,set1.length(), "Length should be 3 before set union");
		set1.union(set2);
		Assertions.assertEquals(5,set1.length(), "Length after set union should be 5");
		Assertions.assertEquals(2,set2.length(), "Length before set union should be 2 for set2");
		set2.union(set1);
		Assertions.assertEquals(5,set1.length(), "Length after set union should be 5");
	}
	
	@Test 
	@DisplayName("Test for set intersection")
	public void testIntersection() {
		setUp();
		IntegerSet set2 = new IntegerSet();
		set1.add(2);
		set1.add(7);
		set1.add(5);
		set2.add(9);
		set2.add(3);
		set2.add(2);
		Assertions.assertEquals(3,set1.length(), "Length should be 3 before set intersection");
		set1.intersection(set2);
		Assertions.assertEquals(1,set1.length(), "Length should be 1 after set intersection");
		set1.add(3);
		Assertions.assertEquals(3,set2.length(), "Length should be 3 before set intersection for set 2");
		set2.intersection(set1);
		Assertions.assertEquals(2,set2.length(), "Length should be 2 after set intersection for set 2");
		
	}
	
	@Test 
	@DisplayName("Test for set difference")
	public void testDifference() {
		setUp();
		IntegerSet set2 = new IntegerSet();
		set1.add(9);
		set1.add(8);
		set1.add(7);
		set2.add(9);
		set2.add(8);
		set2.add(1);
		Assertions.assertEquals(3,set1.length(), "Length should be 3 before set difference");
		set1.difference(set2);
		Assertions.assertEquals(1,set1.length(), "Length should be 1 after set difference");
		set2.add(7);
		Assertions.assertEquals(1,set1.length(), "Length should be 1 before set difference");
		set1.difference(set2);
		Assertions.assertEquals(0,set1.length(), "Length should be 0 after set difference");
	}
	
	@Test
	@DisplayName("Test is set is empty or not")
	public void testisEmpty() {
		setUp();
		set1.add(9);
		set1.add(8);
		set1.add(7);
		Assertions.assertTrue(false == set1.isEmpty(), "Should be false because set is not empty");
		set1.clear();
		Assertions.assertTrue(true == set1.isEmpty(), "Should be ture because set is empty");
		set1.add(0);
		Assertions.assertTrue(false == set1.isEmpty(), "Should be false because set is not empty");

	}
	
	@Test
	@DisplayName("Test for converting set into string")
	public void testtoString() {
		setUp();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);
		set1.add(5);
		Assertions.assertEquals(set1.toString(), "1 2 3 4 5 ", "Strings should be the same. ");
	}
}
