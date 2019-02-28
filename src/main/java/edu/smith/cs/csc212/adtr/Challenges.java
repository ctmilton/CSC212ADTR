package edu.smith.cs.csc212.adtr;

import org.junit.Test;
import static org.junit.Assert.*;

import edu.smith.cs.csc212.adtr.real.JavaList;
import edu.smith.cs.csc212.adtr.real.JavaMap;
import edu.smith.cs.csc212.adtr.real.JavaSet;

public class Challenges {

	// The union of two sets is the set of elements that either contains.
	public static SetADT<Integer> union(SetADT<Integer> left, SetADT<Integer> right) {
		SetADT<Integer> output = new JavaSet<>();
		ListADT<Integer> leftSide = left.toList();
		ListADT<Integer> rightSide = right.toList();
		
		for (int i : leftSide) {
			output.insert(i);
		}
		
		for (int j : rightSide) {
			if (!output.contains(j)) {
				output.insert(j);
			}
		}
		
		return output;
	}
	
	// The intersection of two sets is the set of elements that both contain.
	public static SetADT<Integer> intersection(SetADT<Integer> left, SetADT<Integer> right) {
		SetADT<Integer> output = new JavaSet<>();
		ListADT<Integer> leftSide = left.toList();
		ListADT<Integer> rightSide = right.toList();
		
		for(int i : leftSide) {
			for (int j : rightSide) {
				if (i == j) {
					output.insert(i);
				}
			}
		}
		
		return output;
	}
	
	// Count the words in the input list and put them in the map.
	public static MapADT<String, Integer> wordCount(ListADT<String> words) {
		MapADT<String, Integer> output = new JavaMap<>();
		ListADT<String> wordsList = words;
		SetADT<String> loopedSet = new JavaSet<>();
		ListADT<String> modifiedList = new JavaList<>();
		
		for (String s : wordsList) {
			if (!loopedSet.contains(s)) {
				loopedSet.insert(s);
			}
		}
		
		modifiedList = loopedSet.toList();
		
		for (int i=0; i<modifiedList.size(); i++) {
			int count = 0;
			
			for (int j=0; j<wordsList.size(); j++) {
				if (modifiedList.getIndex(i) == wordsList.getIndex(j)) {
					count += 1;
				}
			}
			
			output.put(modifiedList.getIndex(i), count);
		}
		
		return output;
	}
	
	
	
	//The following code is for testing these methods.
	
	
	/**
	 * Make a new empty set.
	 * @return an empty set to be tested.
	 */
	private <T> SetADT<T> makeEmptySet() {
		return new JavaSet<>();
	}
	
	/**
	 * Helper method to make a full set.
	 * @return [1, 2, 3, 4] - a small, predictable set for tests.
	 */
	private SetADT<Integer> makeFullSet() {
		SetADT<Integer> data = makeEmptySet();
		data.insert(1);
		data.insert(2);
		data.insert(3);
		data.insert(4);
		return data;
	}
	
	/**
	 * Helper method to make another full set.
	 * @return [2, 5, 4, 6, 7, 1] - a small, predictable set for tests.
	 */
	private SetADT<Integer> makeFullSet2() {
		SetADT<Integer> data = makeEmptySet();
		data.insert(2);
		data.insert(5);
		data.insert(4);
		data.insert(6);
		data.insert(7);
		data.insert(1);
		return data;
	}
	
	/**
	 * Helper method to make a full list.
	 * @return [a, b, c, b, d, c, b] - a small, predictable list for tests.
	 */
	private ListADT<String> makeFullList() {
		ListADT<String> data = new JavaList<>();
		data.addBack("a");
		data.addBack("b");
		data.addBack("c");
		data.addBack("b");
		data.addBack("d");
		data.addBack("c");
		data.addBack("b");
		return data;
	}
	
	@Test
	public void testUnion() {
		SetADT<Integer> data1 = makeFullSet();
		SetADT<Integer> data2 = makeFullSet2();
		
		SetADT<Integer> result = union(data1, data2);
		
		assertEquals(7, result.size());
		assertTrue(result.contains(1));
		assertTrue(result.contains(2));
		assertTrue(result.contains(3));
		assertTrue(result.contains(4));
		assertTrue(result.contains(5));
		assertTrue(result.contains(6));
		assertTrue(result.contains(7));
	}

	@Test
	public void testIntersection() {
		SetADT<Integer> data1 = makeFullSet();
		SetADT<Integer> data2 = makeFullSet2();
		
		SetADT<Integer> result = intersection(data1, data2);
		
		assertEquals(3, result.size());
		assertTrue(result.contains(1));
		assertTrue(result.contains(2));
		assertFalse(result.contains(3));
		assertTrue(result.contains(4));
		assertFalse(result.contains(5));
		assertFalse(result.contains(6));
		assertFalse(result.contains(7));
	}
	
	@Test
	public void testWordCount() {
		ListADT<String> data = makeFullList();
		ListADT<String> keys = new JavaList<>();
		ListADT<Pair<String, Integer>> values = new JavaList<>();
		MapADT<String, Integer> result = wordCount(data);
		
		keys = result.getKeys();
		values = result.getEntries();
		
		assertEquals(4, result.size());
		assertFalse(keys.isEmpty());
		assertEquals(4, keys.size());
		assertFalse(values.isEmpty());
		assertEquals(4, values.size());
	}
}
