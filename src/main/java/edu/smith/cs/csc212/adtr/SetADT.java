package edu.smith.cs.csc212.adtr;

import java.util.HashSet;
import java.util.Set;

/**
 * This is our abstract interface to a Set. Items inside are unordered but
 * unique.
 * 
 * @author jfoley
 *
 * @param <ItemType> - the type of the items stored in this Set.
 */
public interface SetADT<ItemType> {
	/**
	 * How many items are inside.
	 * 
	 * @return the number of unique items added to the set.
	 */
	public int size();

	/**
	 * Add an element to this set if new/unique.
	 * 
	 * @param value - the value to add.
	 */
	public void insert(ItemType value);

	/**
	 * Check whether a certain value has been seen in this Set.
	 * 
	 * @param value - the value to look for.
	 * @return true if already inside this set.
	 */
	public boolean contains(ItemType value);

	/**
	 * Remove a value from this Set. No error is reported if your remove something
	 * you don't have.
	 * 
	 * @param value - the value to remove.
	 */
	public void remove(ItemType value);

	/**
	 * Convert this SetADT to a list, for equality comparisons and looping.
	 * 
	 * @return a ListADT object.
	 */
	public ListADT<ItemType> toList();
	
	/**
	 * Convert this to a Java data structure; probably useful for unit-test errors.
	 * @return - a Java List object.
	 */
	default public Set<ItemType> toJava() {
		HashSet<ItemType> output = new HashSet<>();
		for (ItemType x : this.toList()) {
			output.add(x);
		}
		return output;
	}
}
