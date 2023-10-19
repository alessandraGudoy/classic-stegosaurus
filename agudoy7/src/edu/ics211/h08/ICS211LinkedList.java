package edu.ics211.h08;

import java.util.Iterator;

/**
 * ICS211LinkedListIterator<E>
 * 
 * @author Edo Biagioni
 * @author Alessandra Gudoy
 * 
 */

public class ICS211LinkedList<E> implements Iterable<E> {

    public static void main(String[] args){
        ICS211LinkedList<String> list = new ICS211LinkedList<String>();

        list.add("abc");
        list.add("def");
        list.add("ghi");
        list.add("jkl");
        list.add("mno");

        for(String str : list){
            System.out.println(str);
        }
    }
    
    /* * * LINKED NODE DEFINITION * * */
    
    /** 
	 * A node in a singly-linked list
	 * @author         Edo Biagioni
	 * @lecture        ICS 211 Jan 27 or later
	 * @date           January 26, 2010
	 */

    protected static class LinkedNode<T>{
        protected T item;
        protected LinkedNode<T> next;

        // default constructor
        protected LinkedNode(){
            item = null;
            next = null;
        }

        /**
         * constructor to build a node with no successor
         * @param value to be stored by this node
         */
        protected LinkedNode(T value){
            item = value;
            next = null;
        }

        /**
         * constructor to build node with specified successor
         * @param value to be stored by this node
         * @param reference, the next field for this node
         */
        protected LinkedNode(T value, LinkedNode<T> reference){
            item = value;
            next = reference;
        }
    }

    /* * * END LINKED NODE DEFINITION * * */


    /* * * LINKED LIST ITERATOR DEFINITION * * */

    protected class LinkedListIterator<N> implements Iterator<N>{

        protected LinkedNode<N> previous;

        public LinkedListIterator(){
            previous = null;
        }

        @Override
        public boolean hasNext(){
            return previous.next != null;
        }

        @Override
        public N next(){
            LinkedNode<N> result = previous;
            previous = previous.next;
            return result.item;
        }

        @Override
        public void remove(){
            //TODO
        }
    }

    /* * * END OF LINKED LIST ITERATOR DEFINITION * * */


    /* * * ICS211LinkedListIterator * * */

    // If linked list is empty, both head and tail are null.
    protected LinkedNode<E> head;       // start of the linked list
    protected LinkedNode<E> tail;       // end of the linked list, next=null
    protected int size;

    public ICS211LinkedList(){
        head = null;
        tail = null;
        size = 0;
        // one fo the constructor's jobs is to make sure that the invariants hold.
        checkInvariants();
    }

    /* * * CODE * * */
    // private helper methods simplify implementation of public add() method
    // helper methods NEVER modify size, public method tracks the size
    // ** invariants probably do not hold at the end of helper methods

    /**
     * adds at the head of the list
     * @param value to be added
     */
    private void addAtFront(E value){
        head = new LinkedNode<E>(value, head);
        if(tail == null){
            tail = head;
        }
    }

    /**
     * adds at the tail of the list. Assumes and checks that tail is not null
     * @param value to be added
     * @throws RuntimeException
     */
    private void addAtEnd(E value){
        if(tail == null){
            throw new RuntimeException("invalid call to addAtEnd, tail is null");
        }
        LinkedNode<E> newNode = new LinkedNode<E>(value);
        tail.next = newNode;
        tail = newNode;
    }

    /**
     * adds a value to the list after the given node
     * @param reference, the node after which the new value is added
     * @param value to be added
     */
    private void addAfter(LinkedNode<E> reference, E value){
        LinkedNode<E> newNode = new LinkedNode<E>(value, reference.next);
        reference.next = newNode;
        if(reference == tail){      // if added at end, update tail value
            tail = newNode;
        }
    }

    /**
     * adds a value to the end of the list
     * @param value to be added
     * @return true (always succeeds)
     */
    public boolean add(E value){
        checkInvariants();      // useful for debugging
        if(head != null){
            addAtEnd(value);
        } else{
            addAtFront(value);
        }

        size = size + 1;
        checkInvariants();      // invariants valid at start, are they still valid?
                                // did this method break the invariants?

        return true;
    }

    /**
     * adds a value to the list in the given position
     * @param index, the position at which to add: 0 to add at the start
     * @param value to be added
     * @throws IndexOutOfBoundsException if index is less than 0
     *          of greater than the number of elements in the linked list
     */
    public void add(int index, E value){
        checkInvariants();
        if((index < 0) || (index > size)){
            String badIndex = new String(
                "index " + index + " must be betweeen 0 and " + size);
            throw new IndexOutOfBoundsException(badIndex);
        }
        if(index == 0){
            addAtFront(value);
        } else{
            addAfter(nodeAtPosition(index - 1), value);
        }

        size = size + 1;
        checkInvariants();
    }

    //TODO
    public E remove(int index){
        return null;
    }

    //TODO
    public LinkedListIterator<E> iterator(){
        return null;
    }

    /**
     * returns teh node at the requested position, may take time O(n)
     * @param index, the position of the requested node, 0 for the head node
     * @return requested node
     * @throws NullPointerException if index is larger than the linked list
     */
    private LinkedNode<E> nodeAtPosition(int index){
        verify(index >= 0);
        LinkedNode<E> result = head;

        while(index > 0){
            result = result.next;
            index = index - 1;
        }

        verify(result != null);
        return result;
    }

    /**
     * concatenates the element of the linked list, separated by " ==> "
     * @return the string represenation of the list
     */
    public String toString(){
        checkInvariants();
        LinkedNode<E> node = head;
        StringBuffer result = new StringBuffer();
        while(node != null){
            result.append(node.item.toString());
            node = node.next;
            if(node != null){
                result.append(" ==> ");
            }
        }
        checkInvariants();
        return result.toString();
    }



    /**
     * checks assertation
     * @throws java.lang.AssertionError if assertation is not true
     */
    private void verify(boolean mustBeTrue){
        if(!mustBeTrue){
            throw new java.lang.AssertionError("assertation error");
        }
    }

    /**
     * checks class invariants
     * @throws java.lang.AssertionError if invariant is violated
     */
    private void checkInvariants(){
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
