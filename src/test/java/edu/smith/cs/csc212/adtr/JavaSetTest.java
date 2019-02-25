package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.JavaSet;

public class JavaSetTest {
	
	@Test
	public void testEmpty() {
		SetADT<String> empty = new JavaSet<>();
		assertEquals(empty.size(), 0);
	}
	
	@Test
	public void testSize() {
		SetADT<String> testSet = new JavaSet<>();
		
		testSet.insert("a");
		testSet.insert("b");
		testSet.insert("c");
		testSet.insert("c");
		
		assertEquals(3, testSet.size());
	}
	
	@Test
	public void testInsert() {
		SetADT<String> testSet = new JavaSet<>();
		SetADT<String> testSet2 = new JavaSet<>();
		
		testSet.insert("a");
		
		assertEquals(1, testSet.size());
		
		testSet.insert("b");
		testSet.insert("c");
		
		assertEquals(3, testSet.size());
		
		assertEquals(0, testSet2.size());
	}
	
	@Test
	public void testContains() {
		SetADT<String> testSet = new JavaSet<>();
		
		testSet.insert("x");
		testSet.insert("y");
		testSet.insert("z");
		
		assertEquals(true, testSet.contains("y"));
		assertEquals(false, testSet.contains("a"));
	}
	
	@Test
	public void testRemove() {
		SetADT<String> testSet = new JavaSet<>();
		
		testSet.insert("a");
		testSet.insert("b");
		testSet.insert("c");
		
		assertEquals(3, testSet.size());
		
		testSet.remove("b");
		
		assertEquals(2, testSet.size());
	}
	
	@Test
	public void testToList_Size() {
		SetADT<String> testSet = new JavaSet<>();
		
		testSet.insert("a");
		testSet.insert("b");
		testSet.insert("c");
		
		assertEquals(3, testSet.size());
		
		ListADT<String> testList = testSet.toList();
		
		assertEquals(3, testSet.size());
		assertTrue(testList instanceof ListADT);
	}
	
	@Test
	public void testToList_Empty() {
		SetADT<String> testSet = new JavaSet<>();
		
		assertEquals(0, testSet.size());
		
		ListADT<String> testList = testSet.toList();
		
		assertTrue(testList.isEmpty());
		assertTrue(testList instanceof ListADT);
	}
	
	@Test
	public void testToList_SingleElement() {
		SetADT<String> testSet = new JavaSet<>();
		
		testSet.insert("a");
		
		ListADT<String> testList = testSet.toList();
		
		assertFalse(testList.isEmpty());
		assertEquals(1, testList.size());
		assertTrue(testList instanceof ListADT);
	}
	
	@Test
	public void testToJava_Size() {
		SetADT<String> testSet = new JavaSet<>();
		
		testSet.insert("a");
		testSet.insert("b");
		testSet.insert("c");
		
		assertEquals(3, testSet.size());
		
		assertEquals(3, testSet.toJava().size());
		assertTrue(testSet instanceof JavaSet);
		assertFalse(testSet.toJava() instanceof JavaSet);
	}
	
	@Test
	public void testToJava_Empty() {
		SetADT<String> testSet = new JavaSet<>();
		
		assertEquals(0, testSet.size());
		assertEquals(0, testSet.toJava().size());
		assertTrue(testSet instanceof JavaSet);
		assertFalse(testSet.toJava() instanceof JavaSet);
	}
	
	@Test
	public void testToJava_SingleElement() {
		SetADT<String> testSet = new JavaSet<>();
		
		testSet.insert("a");
		
		assertEquals(1, testSet.size());
		assertEquals(1, testSet.toJava().size());
		assertTrue(testSet instanceof JavaSet);
		assertFalse(testSet.toJava() instanceof JavaSet);
	}
	
}
