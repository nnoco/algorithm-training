package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
341. Flatten Nested List Iterator - https://leetcode.com/problems/flatten-nested-list-iterator/

Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Given the list [[1,1],2,[1,1]],

By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].

Example 2:
Given the list [1,[4,[6]]],

By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].

 * @author nnoco
 *
 */
public class FlattenNestedListIterator implements Iterator<Integer> {
	private List<Integer> flattenList;
	private Iterator<Integer> iterator;
	
	public FlattenNestedListIterator(List<NestedInteger> nestedList) {
		this.flattenList = new ArrayList<Integer>();
		
		flate(nestedList);
		
		iterator = flattenList.iterator();
	}
	
	private void flate(List<NestedInteger> nestedList) {
		for(NestedInteger nestedInteger : nestedList) {
			if(nestedInteger.isInteger()) {
				flattenList.add(nestedInteger.getInteger());
			} else {
				flate(nestedInteger.getList());
			}
		}
	}

	@Override
    public Integer next() {
		return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }
}

interface NestedInteger {
	// @return true if this NestedInteger holds a single integer, rather than a
	// nested list.
	public boolean isInteger();

	// @return the single integer that this NestedInteger holds, if it holds a
	// single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger();

	// @return the nested list that this NestedInteger holds, if it holds a
	// nested list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}