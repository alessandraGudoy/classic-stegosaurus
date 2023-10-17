package edu.ics211.h07;

/**
 * SortedLinkedList, A sorted list implemented using a singly-linked list
 * 
 * @author Edo Biagioni
 * @author Benjamin Strauss
 * @author Alessandra Gudoy
 * 
 *         [Best Case] [Avg Case] [Worst Case] Add: O(1) O(n) O(n) Remove: O(1)
 *         O(n) O(n)
 * 
 *         Best case for adding is constant time, O(1) for when we are adding to
 *         the front of the list, where head points to the new node and the new
 *         node points to the previous head. Worst case and average case is
 *         linear time, O(n), is when we are adding to the end of the list and
 *         have to go through the entire list.
 * 
 *         Best case for removing is constant time, O(1), for when we are
 *         removing the head, where head now points to the node that the
 *         previous head pointed to. Worst case and average is linear time,
 *         O(n), when we need to go through the list to remove a node in the
 *         middle or the end.
 */

public class SortedLinkedList<E extends Comparable<E>> implements SortedLinkedListInterface<E> {

	protected LinkedNode<E> head;
	protected LinkedNode<E> tail;
	protected int size;

	// Default constructor, initializes an empty linked list
	public SortedLinkedList() {
		head = null;
		tail = null;
		size = 0;
		checkInvariants();
	}

	/**
	 * Returns the size of the list (number of unique elements)
	 * 
	 * @return int representing the size of the list (number of elements)
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Gets the element at given index
	 * 
	 * @param index, index/location of element to get
	 * @return E, the value of the element at given index
	 * @throws RuntimeException if index out of bounds, index must be between 0
	 *                          inclusive and the size of the array exclusive (0 <=
	 *                          index < size)
	 */
	public E get(int index) {
		if (index >= size || index < 0) {
			throw new RuntimeException("invalid index");
		}

		LinkedNode<E> node = head;

		for (int i = 1; i <= index; i++) {
			node = node.next;
		}

		return node.item;
	}

	/**
	 * Adds element at the head of the list
	 * 
	 * @param value to be added
	 */
	private void addAtFront(E value) {
		head = new LinkedNode<E>(value, head);
		if (tail == null) {
			tail = head;
		}
	}

	/**
	 * Adds element at the tail of the list. Assumes (and checks) that tail is not
	 * null
	 * 
	 * @param value to be added
	 * @throws RuntimeException if tail is null
	 */
	private void addAtEnd(E value) {
		if (tail == null) {
			throw new RuntimeException("Tail is null");
		}
		LinkedNode<E> newElement = new LinkedNode<E>(value);
		tail.next = newElement;
		tail = newElement;
	}

	/**
	 * Adds element to the list if it does not already exist, list being sorted is
	 * questionable
	 * 
	 * @param value, value of node to be added to list
	 * @return true if value is added to the list, false if value already exists in
	 *         list
	 */
	public boolean add(E value) {
		LinkedNode<E> newElement = new LinkedNode<E>(value);
		LinkedNode<E> current = head;

		if (current == null || current.item.compareTo(newElement.item) > 0) {
			addAtFront(value);
		} else {
			while (current.next != null && current.item.compareTo(newElement.item) < 0) {
				current = current.next;
			}

			if (current.item.compareTo(newElement.item) == 0) {
				return false;
			}

			newElement.next = current.next;
			current.next = newElement;
		}

		if (head == tail) {
			tail = newElement;
		} else {
			current = head;
			while (current.next != null) {
				current = current.next;
			}
			tail = current;
		}

		size = size + 1;
		return true;

	}

	/**
	 * Removes the node with the given value from the list
	 * 
	 * @param value, value to be removed from list
	 * @return true if value is removed, false if value does not exist in list
	 */
	public boolean remove(E value) {
		LinkedNode<E> current = head;
		LinkedNode<E> previous = null;

		if (head.item == value) {
			head = current.next;
			size = size - 1;
			return true;
		}

		while (current.item != null) {
			if (current.item == value) {
				if (current == tail) {
					tail = previous;
				}

				previous.next = previous.next.next;
				size = size - 1;
				return true;
			} else {
				if (current.next == null) {
					return false;
				}
				previous = current;
				current = current.next;
			}
		}

		return false;
	}

	/**
	 * Returns the index of the given value
	 * 
	 * @param value to find the index of
	 * @return index of the given value, where index of the head starts at 0, an int
	 *         between 0 inclusive and the list's size exclusive, 0 <= index < size
	 */
	public int indexOf(E value) {
		LinkedNode<E> current = head;
		int index = 0;

		while (current != null) {
			if (current.item == value) {
				return index;
			}
			current = current.next;
			index = index + 1;
		}

		return -1;
	}

	/**
	 * A string representation of the list where the values of the nodes are
	 * separated by a space
	 * 
	 * @return a string representation of the values stored in the list
	 */
	public String toString() {
		LinkedNode<E> current = head;
		String result = "";

		while (current != null) {
			result = result + current.item + " ";
			current = current.next;
		}

		return result.trim();
	}

	/* * * * * */

	public static void main(String[] args) {
		SortedLinkedList<String> list = new SortedLinkedList<String>();

		list.add("dd");
		list.add("ff");
		list.add("cc");
		list.add("bb");
		list.add("ee");
		list.add("aa");

		System.out.println(list.toString());
		System.out.println("ee".compareTo("ff"));

		System.out.println("CURRENT: " + list.toString());
		System.out.println("Head: " + list.head.item);
		System.out.println("Tail: " + list.tail.item);
		System.out.println("Size: " + list.size);

		System.out.println("indexOf(): " + list.indexOf("three"));
		System.out.println("get(): " + list.get(2));
		System.out.println("remove(): " + list.remove("a"));

		System.out.println("CURRENT: " + list.toString());
		System.out.println("Head: " + list.head.item);
		System.out.println("Tail: " + list.tail.item);
		System.out.println("Size: " + list.size);

	}

	/* * * * * */

	/* * * LINKED NODE DEFINITION * * */

	/**
	 * A node in a singly-linked list
	 * 
	 * @author Edo Biagioni
	 * @lecture ICS 211 Jan 27 or later
	 * @date January 26, 2010
	 */
	private static class LinkedNode<T> {
		private T item;
		private LinkedNode<T> next;

		// Default constructor
		private LinkedNode() {
			item = null;
			next = null;
		}

		/**
		 * Constructor to set node with no successor
		 * 
		 * @param value, the value to be stored by this node
		 */
		private LinkedNode(T value) {
			item = value;
			next = null;
		}

		/**
		 * Constructor to set node with specified successor (may be null)
		 * 
		 * @param value,     the value to be stored by this node
		 * @param reference, the next field for this node
		 */
		private LinkedNode(T value, LinkedNode<T> reference) {
			item = value;
			next = reference;
		}

	}

	/* * * END OF LINKED NODE DEFINITION * * */

	/* * * GIVEN CODE * * */

	/**
	 * Checks assertion
	 * 
	 * @throws java.lang.AssertionError if the assertion is not true
	 */
	public void verify(boolean mustBeTrue) {
		if (!mustBeTrue) {
			throw new java.lang.AssertionError("assertion error");
		}
	}

	/**
	 * checks class invariants
	 * 
	 * @throws java.lang.AssertionError if the invariant is violated
	 */
	public void checkInvariants() {
		// uncomment the next line to skip the checks:
		// return;
		// either head and tail are both null, or neither is null.
		// size is zero if and only if they are null, and otherwise is positive
		verify((head == null) == (tail == null));
		verify((size == 0) == (head == null));
		verify(size >= 0);
		// if the list only has one element, head should be the same as tail
		// (and also if the list has no elements), otherwise they should differ
		verify((head == tail) == (size <= 1));
		// a non-null tail variable should always have a null "next" field
		verify((tail == null) || (tail.next == null));
		// check to make sure size is the same as the length of the list.
		// this code takes O(n), so comment it out if performance is important
		int measuredSize = 0;
		LinkedNode<E> node = head;
		// if visitedLast is null, the list is empty, and tail should also be null
		LinkedNode<E> visitedLast = null;
		while (node != null) {
			visitedLast = node;
			node = node.next;
			measuredSize++;
		}
		verify(measuredSize == size);
		// also make sure "last" really is the last node in the linked list
		verify(visitedLast == tail);
	}

}
