package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.*;
import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.JavaList;
import edu.smith.cs.csc212.adtr.real.JavaMap;
import edu.smith.cs.csc212.adtr.real.JavaSet;

public class JavaMapTest {
	
	// you might want this.
	void assertIntEq(int x, int y) {
		assertEquals(x, y);
	}

	@Test
	public void testEmpty() {
		MapADT<String, Integer> empty = new JavaMap<>();
		assertEquals(empty.size(), 0);
		//Assert.assert
	}
	
	@Test
	public void testPut() {
		MapADT<String, Integer> testMap = new JavaMap<>();
		
		testMap.put("a", 1);
		testMap.put("b", 2);
		testMap.put("c", 3);
		
		assertEquals(3, testMap.size());
		
		testMap.put("c", 4);
		testMap.put("d", 4);
		
		assertEquals(4, testMap.size());
	}
	
	@Test
	public void testGet() {
		MapADT<String, Integer> testMap = new JavaMap<>();
		
		testMap.put("a", 1);
		testMap.put("b", 2);
		testMap.put("c", 3);
		testMap.put("c", 4);
		testMap.put("d", 4);
		
		assertIntEq(2, testMap.get("b"));
		assertIntEq(4, testMap.get("c"));
		assertIntEq(4, testMap.get("d"));
	}
	
	@Test
	public void testSize() {
		MapADT<String, Integer> testMap = new JavaMap<>();
		
		testMap.put("a", 1);
		testMap.put("b", 2);
		testMap.put("c", 3);
		testMap.put("c", 4);
		testMap.put("d", 4);
		
		assertEquals(4, testMap.size());
	}
	
	@Test
	public void testRemove() {
		MapADT<String, Integer> testMap = new JavaMap<>();
		
		testMap.put("a", 1);
		testMap.put("b", 2);
		testMap.put("c", 3);
		testMap.put("c", 4);
		
		assertEquals(3, testMap.size());
		
		testMap.remove("b");
		
		assertEquals(2, testMap.size());
	}
	
	@Test
	public void testGetKeys_Size() {
		MapADT<String, Integer> testMap = new JavaMap<>();
		
		testMap.put("a", 1);
		testMap.put("b", 2);
		testMap.put("c", 3);
		testMap.put("c", 4);
		
		assertEquals(3, testMap.size());
		assertEquals(3, testMap.getKeys().size());
		assertTrue(testMap.getKeys() instanceof ListADT);
	}
	
	@Test
	public void testGetKeys_Empty() {
		MapADT<String, Integer> testMap = new JavaMap<>();
		
		assertEquals(0, testMap.size());
		assertEquals(0, testMap.getKeys().size());
		assertTrue(testMap.getKeys() instanceof ListADT);
	}
	
	@Test
	public void testGetKeys_SingleElement() {
		MapADT<String, Integer> testMap = new JavaMap<>();
		
		testMap.put("a", 10);
		
		assertEquals(1, testMap.size());
		assertEquals(1, testMap.getKeys().size());
		assertTrue(testMap.getKeys() instanceof ListADT);
	}
	
	@Test
	public void testGetEntries_Size() {
		MapADT<String, Integer> testMap = new JavaMap<>();
		
		testMap.put("a", 1);
		testMap.put("b", 2);
		testMap.put("c", 3);
		testMap.put("c", 4);
		
		assertEquals(3, testMap.size());
		assertEquals(3, testMap.getEntries().size());
		assertTrue(testMap.getEntries() instanceof ListADT);
	}
	
	@Test
	public void testGetEntries_Empty() {
		MapADT<String, Integer> testMap = new JavaMap<>();
		
		assertEquals(0, testMap.size());
		assertEquals(0, testMap.getEntries().size());
		assertTrue(testMap.getEntries() instanceof ListADT);
	}
	
	@Test
	public void testGetEntries_SingleElement() {
		MapADT<String, Integer> testMap = new JavaMap<>();
		
		testMap.put("a", 10);
		
		assertEquals(1, testMap.size());
		assertEquals(1, testMap.getEntries().size());
		assertTrue(testMap.getEntries() instanceof ListADT);
	}
	
	@Test
	public void testToJava_Size() {
		MapADT<String, Integer> testMap = new JavaMap<>();
		
		testMap.put("a", 1);
		testMap.put("b", 2);
		testMap.put("c", 3);
		testMap.put("c", 4);
		testMap.put("d", 4);
		testMap.put("e", 5);
		
		assertEquals(5, testMap.size());
		assertEquals(5, testMap.toJava().size());
		assertFalse(testMap.toJava() instanceof JavaMap);
	}
	
	@Test
	public void testToJava_Empty() {
		MapADT<String, Integer> testMap = new JavaMap<>();
		
		assertEquals(0, testMap.size());
		assertEquals(0, testMap.toJava().size());
		assertFalse(testMap.toJava() instanceof JavaMap);
	}
	
	@Test
	public void testToJava_SingleElement() {
		MapADT<String, Integer> testMap = new JavaMap<>();
		
		testMap.put("a", 1);
		
		assertEquals(1, testMap.size());
		assertEquals(1, testMap.toJava().size());
		assertFalse(testMap.toJava() instanceof JavaMap);
	}
}
