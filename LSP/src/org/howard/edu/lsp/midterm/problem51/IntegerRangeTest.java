package org.howard.edu.lsp.midterm.problem51;

import org.howard.edu.lsp.midterm.problem51.IntegerRange;
import org.howard.edu.lsp.midterm.problem51.Range.EmptyRangeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
	
public class IntegerRangeTest extends junit.framework.TestCase{ 
		IntegerRange range1;
		@BeforeEach
		protected void setUp() {
			range1 = new IntegerRange(10, 50);
			
		}
		
	@Test
	@DisplayName("Test case for if value is within range")
	public void testContains() {
		setUp();
		Assertions.assertTrue(range1.contains(15));
		Assertions.assertFalse(range1.contains(51));
		Assertions.assertTrue(range1.contains(50));
	}


	@Test
	@DisplayName("Test case for if range object overlaps eachother")
	public void testOverlaps() throws EmptyRangeException {
		setUp();
		IntegerRange range2 = new IntegerRange(20, 30);
		Assertions.assertTrue(range1.overlaps(range2));
		IntegerRange range3 = new IntegerRange(0, 30);
		Assertions.assertTrue(range1.overlaps(range3));
		IntegerRange range4 = new IntegerRange(15, 60);
		Assertions.assertTrue(range1.overlaps(range4));
		IntegerRange range5 = new IntegerRange(0, 60);
		Assertions.assertTrue(range1.overlaps(range5));
		IntegerRange range6 = new IntegerRange(50, 60);
		Assertions.assertFalse(range1.overlaps(range6));
		
	}

	@Test
	@DisplayName("Test case for getting size of range")
	public void testSize() {
		setUp();
		Assertions.assertEquals(40,  range1.size());
	}
}
