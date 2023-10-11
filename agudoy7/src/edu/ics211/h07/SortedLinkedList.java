package edu.ics211.h07;

/**
 * SortedLinkedList, A sorted list implemented using a singly-linked list
 * @author Edo Biagioni
 * @author Benjamin Strauss
 * @author Alessandra Gudoy
 */

public class SortedLinkedList<E extends Comparable<E> > implements SortedLinkedListInterface<E>{

    protected LinkedNode<E> head;
    protected LinkedNode<E> tail;
    protected int size;

    // Default constructor, initializes an empty linked list
    public SortedLinkedList(){
        head = null;
        tail = null;
        size = 0;
        checkInvariants();
    }

    //@Override
    public int size() {
        return 0;
    }

    //@Override
    public E get(int index) {
        return null;
    }

    //@Override
    public boolean add(E value) {
        return true;
    }

    //@Override
    public boolean remove(E value) {
        return true;
    }

    //@Override
    public int indexOf(E value) {
        return 0;
    }

    //@Override
    public String toString() {
        String result = "";

        return result;
    }


    /* * * * * */

    public static void main(String[] args){
        SortedLinkedList<String> list = new SortedLinkedList<String>();


        System.out.println(list.toString());
    }

    /* * * * * */
    

    /* * * LINKED NODE DEFINITION * * */

    /**
     * A node in a singly-linked list
     * @author Edo Biagioni
     * @lecture ICS 211 Jan 27 or later
     * @date January 26, 2010
     */
    private static class LinkedNode<T>{
        private T item;
        private LinkedNode<T> next;

        // Default constructor
        private LinkedNode(){
            item = null;
            next = null;
        }

        /**
         * Constructor to set node with no successor
         * @param value, the value to be stored by this node
         */
        private LinkedNode(T value){
            item = value;
            next = null;
        }

        /**
         * Constructor to set node with specified successor (may be null)
         * @param value, the value to be stored by this node
         * @param reference, the next field for this node
         */
        private LinkedNode(T value, LinkedNode<T> reference){
            item = value;
            next = reference;
        }

    }

    /* * * END OF LINKED NODE DEFINITION * * */
    

    /* * * GIVEN CODE * * */

    /** 
	 * Checks assertion
	 * @throws java.lang.AssertionError if the assertion is not true
	 */
	public void verify(boolean mustBeTrue) {
		if (! mustBeTrue) {
			throw new java.lang.AssertionError("assertion error");
		}
	}

    /** 
	 * checks class invariants
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
