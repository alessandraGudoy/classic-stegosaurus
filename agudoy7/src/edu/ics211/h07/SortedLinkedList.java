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
        return this.size;
    }

    //@Override
    public E get(int index) {
        return null;
    }

    /** 
	  * Adds element at the head of the list
	  * @param value to be added
	  */
    private void addAtFront(E value){
        head = new LinkedNode<E>(value, head);
        if(tail == null){
            tail = head;
        }
    }

    /** 
	  * Adds element at the tail of the list.  Assumes (and checks) that tail is not null
	  * @param value to be added
	  * @throws RuntimeException if tail is null
	  */
    private void addAtEnd(E value){
        if(tail == null){
            throw new RuntimeException("Tail is null");
        }
        LinkedNode<E> newElement = new LinkedNode<E>(value);
        tail.next = newElement;
        tail = newElement;
    }

    //@Override
    public boolean add(E value) {
        LinkedNode<E> newElement = new LinkedNode<E>(value);
        LinkedNode<E> current = head;
        System.out.println();
        System.out.println("ADDING VALUE: " + newElement.item);

        if(current == null || current.item.compareTo(newElement.item) > 0){
            addAtFront(value);
        } else {
            while(current.next != null && current.item.compareTo(newElement.item) < 0){
                current = current.next;
            }

            if(current.item.compareTo(newElement.item) == 0){
                return false;
            }

            newElement.next = current.next;
            current.next = newElement;
        }

        if(head == tail){
                tail = newElement;
        } else {
            current = head;
            while(current.next != null){
                current = current.next;
            }
            tail = current;
        }


         size = size + 1;
         return true;
        
    }

    //@Override
    public boolean remove(E value) {
        return true;
    }

    //@Override
    public int indexOf(E value) {
        LinkedNode<E> current = head;
        int index = 0;

        while(current != null){
            if(current.item == value){
                return index;
            }
            current = current.next;
            index = index + 1;
        }

        return -1;
    }

    //@Override
    public String toString() {
        LinkedNode<E> current = head;
        String result = "";

        while(current != null){
            result = result + current.item + " ";
            current = current.next;
        }

        return result.trim();
    }


    /* * * * * */

    public static void main(String[] args){
        SortedLinkedList<String> list = new SortedLinkedList<String>();

        System.out.println("CURRENT: " + list.toString());
        System.out.println(list.add("one"));

        System.out.println("CURRENT: " + list.toString());
        System.out.println(list.add("two"));

        System.out.println("CURRENT: " + list.toString());
        System.out.println(list.add("three"));

        System.out.println("CURRENT: " + list.toString());
        System.out.println(list.add("two"));

        System.out.println("CURRENT: " + list.toString());

        System.out.println("two: " + list.indexOf("four"));
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
