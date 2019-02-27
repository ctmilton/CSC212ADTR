package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import edu.smith.cs.csc212.adtr.errors.BadIndexError;
import edu.smith.cs.csc212.adtr.errors.EmptyListError;
import edu.smith.cs.csc212.adtr.real.JavaList;


public class JavaListTest {
	
	/**
	 * Make a new empty list.
	 * @return an empty list to be tested.
	 */
	private <T> ListADT<T> makeEmptyList() {
		return new JavaList<>();
	}
	
	/**
	 * Helper method to make a full list.
	 * @return [a, b, c, d] - a small, predictable list for many tests.
	 */
	private ListADT<String> makeFullList() {
		ListADT<String> data = makeEmptyList();
		data.addBack("a");
		data.addBack("b");
		data.addBack("c");
		data.addBack("d");
		return data;
	}
		
	@Test
	public void testEmpty() {
		ListADT<String> data = makeEmptyList();
		Assert.assertEquals(0, data.size());
		Assert.assertEquals(true, data.isEmpty());
	}
	
	@Test(expected=EmptyListError.class)
	public void testRemoveFrontCrash() {
		ListADT<String> data = makeEmptyList();
		data.removeFront();
	}
	
	@Test(expected=EmptyListError.class)
	public void testRemoveBackCrash() {
		ListADT<String> data = makeEmptyList();
		data.removeBack();
	}
	
	@Test(expected=EmptyListError.class)
	public void testRemoveIndexCrash() {
		ListADT<String> data = makeEmptyList();
		data.removeIndex(3);
	}

	@Test
	public void testAddToFront() {
		ListADT<String> data = makeEmptyList();
		Assert.assertEquals(true, data.isEmpty());
		data.addFront("1");
		Assert.assertEquals(1, data.size());
		Assert.assertEquals("1", data.getIndex(0));
		Assert.assertEquals(false, data.isEmpty());
		data.addFront("0");
		Assert.assertEquals(2, data.size());
		Assert.assertEquals("0", data.getIndex(0));
		Assert.assertEquals("1", data.getIndex(1));
		Assert.assertEquals(false, data.isEmpty());
		data.addFront("-1");
		Assert.assertEquals(3, data.size());
		Assert.assertEquals("-1", data.getIndex(0));
		Assert.assertEquals("0", data.getIndex(1));
		Assert.assertEquals("1", data.getIndex(2));
		Assert.assertEquals(false, data.isEmpty());
		data.addFront("-2");
		Assert.assertEquals("-1", data.getIndex(1));
		Assert.assertEquals("-2", data.getIndex(0));
		Assert.assertEquals("0", data.getIndex(2));
		Assert.assertEquals("1", data.getIndex(3));
		Assert.assertEquals(false, data.isEmpty());
	}
	
	@Test
	public void testAddToBack() {
		ListADT<String> data = makeEmptyList();
		data.addBack("1");
		Assert.assertEquals(1, data.size());
		Assert.assertEquals("1", data.getIndex(0));
		data.addBack("0");
		Assert.assertEquals(2, data.size());
		Assert.assertEquals("0", data.getIndex(1));
		Assert.assertEquals("1", data.getIndex(0));
		data.addBack("-1");
		Assert.assertEquals(3, data.size());
		Assert.assertEquals("-1", data.getIndex(2));
		Assert.assertEquals("0", data.getIndex(1));
		Assert.assertEquals("1", data.getIndex(0));
		data.addBack("-2");
		Assert.assertEquals("-2", data.getIndex(3));
		Assert.assertEquals("-1", data.getIndex(2));
		Assert.assertEquals("0", data.getIndex(1));
		Assert.assertEquals("1", data.getIndex(0));
	}
	
	// A new test for removeBack().
	@Test
	public void testRemoveBack_Size() {
		ListADT<String> data = makeFullList();
		
		assertFalse(data.isEmpty());
		assertEquals(4, data.size());
		
		data.removeBack();
		
		assertFalse(data.isEmpty());
		assertEquals(3, data.size());
	}
	
	// A new test for removeBack().
	@Test
	public void testRemoveBack_RemovingElements() {
		ListADT<String> data = makeFullList();
		
		assertFalse(data.isEmpty());
		assertEquals("d", data.getBack());
		
		data.removeBack();
		
		assertFalse(data.isEmpty());
		assertEquals("c", data.getBack());
		
		data.removeBack();
		
		assertFalse(data.isEmpty());
		assertEquals("b", data.getBack());
		
		data.removeBack();
		
		assertFalse(data.isEmpty());
		assertEquals("a", data.getBack());
		
		data.removeBack();
		
		assertTrue(data.isEmpty());
	}
	
	// A new test for removeBack().
	@Test(expected=EmptyListError.class)
	public void testRemoveBack_EmptyList() {
		ListADT<String> data = makeEmptyList();
		
		data.removeBack();
	}
	
	// A new test for removeIndex().
	@Test
	public void testRemoveIndex_Size() {
		ListADT<String> data = makeFullList();
		
		assertFalse(data.isEmpty());
		assertEquals(4, data.size());
		
		data.removeIndex(1);
		
		assertFalse(data.isEmpty());
		assertEquals(3, data.size());
	}
	
	// A new test for removeIndex().
	@Test
	public void testRemoveIndex_RemovingElements() {
		ListADT<String> data = makeFullList();
		
		assertFalse(data.isEmpty());
		assertEquals("a", data.getIndex(0));
		
		data.removeIndex(0);
		
		assertFalse(data.isEmpty());
		assertEquals("b", data.getIndex(0));
		assertEquals("c", data.getIndex(1));
		
		data.removeIndex(1);
		
		assertFalse(data.isEmpty());
		assertEquals("d", data.getIndex(1));
		assertEquals("d", data.getBack());
		
		data.removeIndex(1);
	
		assertFalse(data.isEmpty());
		assertEquals("b", data.getBack());
		
		data.removeIndex(0);
		
		assertTrue(data.isEmpty());
	}
	
	// A new test for removeIndex().
	@Test(expected=EmptyListError.class)
	public void testRemoveIndex_EmptyList() {
		ListADT<String> data = makeEmptyList();
		
		data.removeIndex(0);
	}
	
	// A new test for removeFront().
	@Test
	public void testRemoveFront_Size() {
		ListADT<String> data = makeFullList();
		
		assertFalse(data.isEmpty());
		assertEquals(4, data.size());
		
		data.removeFront();
		
		assertFalse(data.isEmpty());
		assertEquals(3, data.size());
	}
	
	// A new test for removeFront().
	@Test
	public void testRemoveFront_RemovingElements() {
		ListADT<String> data = makeFullList();
		
		assertFalse(data.isEmpty());
		assertEquals("a", data.getFront());
		
		data.removeFront();
		
		assertFalse(data.isEmpty());
		assertEquals("b", data.getFront());
		
		data.removeFront();
		
		assertFalse(data.isEmpty());
		assertEquals("c", data.getFront());
		
		data.removeFront();
		
		assertFalse(data.isEmpty());
		assertEquals("d", data.getFront());
		
		data.removeFront();
		
		assertTrue(data.isEmpty());
	}
	
	// A new test for removeFront().
	@Test(expected=EmptyListError.class)
	public void testRemoveFront_EmptyList() {
		ListADT<String> data = makeEmptyList();
		
		data.removeFront();
	}
	
	// A new test for addIndex().
	@Test
	public void testAddIndex_Size() {
		ListADT<String> data = makeFullList();
		
		assertEquals(4, data.size());
		
		data.addIndex(2, "x");
		
		assertFalse(data.isEmpty());
		assertEquals(5, data.size());
		
		data.addIndex(3, "y");
		
		assertFalse(data.isEmpty());
		assertEquals(6, data.size());
	}
	
	// A new test for addIndex().
	@Test
	public void testAddIndex_SingleElement() {
		ListADT<String> data = makeFullList();
		
		assertEquals("a", data.getIndex(0));
		assertEquals("b", data.getIndex(1));
		assertEquals("c", data.getIndex(2));
		assertEquals("d", data.getIndex(3));
		
		data.addIndex(2, "z");
		
		assertFalse(data.isEmpty());
		assertEquals("a", data.getIndex(0));
		assertEquals("b", data.getIndex(1));
		assertEquals("z", data.getIndex(2));
		assertEquals("c", data.getIndex(3));
		assertEquals("d", data.getIndex(4));
	}
	
	// A new test for addIndex().
	@Test
	public void testAddIndex_MultipleElements() {
		ListADT<String> data = makeFullList();
		
		assertEquals("a", data.getIndex(0));
		assertEquals("b", data.getIndex(1));
		assertEquals("c", data.getIndex(2));
		assertEquals("d", data.getIndex(3));
		
		data.addIndex(0, "x");
		
		assertFalse(data.isEmpty());
		assertEquals(5, data.size());
		
		data.addIndex(3, "y");
		
		assertFalse(data.isEmpty());
		assertEquals(6, data.size());
			
		data.addIndex(6, "z");
		
		assertFalse(data.isEmpty());
		assertEquals(7, data.size());
		assertEquals("x", data.getIndex(0));
		assertEquals("a", data.getIndex(1));
		assertEquals("b", data.getIndex(2));
		assertEquals("y", data.getIndex(3));
		assertEquals("c", data.getIndex(4));
		assertEquals("d", data.getIndex(5));
		assertEquals("z", data.getIndex(6));
	}
	
	// A new test for addIndex().
		@Test(expected=BadIndexError.class)
		public void addIndex_BadIndex() {
			ListADT<String> data = makeEmptyList();
			
			data.addIndex(9, "hi");
		}
	
	@Test
	public void testGetFront() {
		ListADT<String> data = makeFullList();
		assertEquals("a", data.getFront());
	}
	
	@Test
	public void testGetBack() {
		ListADT<String> data = makeFullList();
		assertEquals("d", data.getBack());
	}
	
	@Test(expected=EmptyListError.class)
	public void testGetFrontCrash() {
		ListADT<String> data = makeEmptyList();
		data.getFront();
	}
	
	@Test(expected=EmptyListError.class)
	public void testGetBackCrash() {
		ListADT<String> data = makeEmptyList();
		data.getBack();
	}
	
	@Test(expected=BadIndexError.class)
	public void testGetIndexLow() {
		ListADT<String> data = makeFullList();
		data.getIndex(-2);
	}
	
	@Test(expected=BadIndexError.class)
	public void testGetIndexHigh() {
		ListADT<String> data = makeFullList();
		data.getIndex(data.size());
	}
	
	@Test(expected=BadIndexError.class)
	public void testGetIndexHighEasy() {
		ListADT<String> data = makeFullList();
		data.getIndex(data.size()*2);
	}
	
	@Test(expected=BadIndexError.class)
	public void testAddIndexHighEasy() {
		ListADT<String> data = makeFullList();
		data.addIndex(data.size()*2, "the");
	}
	
	@Test(expected=BadIndexError.class)
	public void testAddIndexHigh() {
		ListADT<String> data = makeFullList();
		data.addIndex(data.size()+1, "the");
	}
	
	@Test(expected=BadIndexError.class)
	public void testAddIndexLow() {
		ListADT<String> data = makeFullList();
		data.addIndex(-1, "the");
	}
	
	// A new test for setIndex().
	@Test
	public void testSetIndex_SameSize() {
		ListADT<String> data = makeFullList();
		
		assertEquals(4, data.size());
		
		data.setIndex(3, "e");
		
		assertFalse(data.isEmpty());
		assertEquals(4, data.size());
	}
	
	// A new test for setIndex().
	@Test
	public void testSetIndex_SingleElement() {
		ListADT<String> data = makeFullList();
		
		assertEquals("d", data.getIndex(3));
		
		data.setIndex(3, "e");
		
		assertFalse(data.isEmpty());
		assertEquals("a", data.getIndex(0));
		assertEquals("b", data.getIndex(1));
		assertEquals("c", data.getIndex(2));
		assertEquals("e", data.getIndex(3));
	}
	
	// A new test for setIndex().
	@Test
	public void testSetIndex_MultipleElements() {
		ListADT<String> data = makeFullList();
		
		data.setIndex(0, "x");
		data.setIndex(2, "y");
		data.setIndex(3, "z");
		
		assertFalse(data.isEmpty());
		assertEquals("x", data.getIndex(0));
		assertEquals("b", data.getIndex(1));
		assertEquals("y", data.getIndex(2));
		assertEquals("z", data.getIndex(3));
	}
	
	// A new test for setIndex().
	@Test(expected=BadIndexError.class)
	public void testSetIndex_BadIndex() {
		ListADT<String> data = makeFullList();
		
		data.setIndex(6, "hi");
	}
	
	@Test
	public void testToJava() {
		assertEquals(makeFullList().toJava(), Arrays.asList("a", "b", "c", "d"));
	}
}
