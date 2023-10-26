package edu.ics211.h08;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ICS211LinkedListIterator<E>
 * 
 * @author Edo Biagioni
 * @author Alessandra Gudoy
 * 
 */

public class ICS211LinkedList<E> implements Iterable<E> {
    
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

    public class LinkedListIterator implements Iterator<E>{

        protected LinkedNode<E> current;
        protected LinkedNode<E> previous;

        public LinkedListIterator(){
            current = head;
            previous = null;
        }

        @Override
        public boolean hasNext(){
            return current != null;
        }

        @Override
        public E next(){
            if(hasNext()){
                LinkedNode<E> result = current;
                previous = current;
                current = current.next;
                return result.item;
            }
            throw new NoSuchElementException("no new element");
        }

        @Override
        public void remove(){                       // TODO
            if(previous == null){
                throw new IllegalStateException();
            }

            if(previous == head){
                if(head == tail){
                    head = null;
                    tail = null;
                } else{
                    head = current;
                }
            } else{
                previous.next = current.next;
            }

            size = size - 1;
            
        }
    }

    /* * * END OF LINKED LIST ITERATOR DEFINITION * * */


    /* * * ICS211LinkedList * * */

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

    /**
     * removes head of the linked list
     * @return the previous head of the list
     * @throws NoSuchElementException if list is empty
     */
    private LinkedNode<E> removeFront(){

        // if head is null, list is empty, throw error
        if(head == null){
            throw new NoSuchElementException("list is empty");
        }

        LinkedNode<E> node = head;

        // if only one element, change head and tail
        if(head == tail){
            head = null;
            tail = null;
        } else{ // chagne head to point to element after head
            head = node.next;
        }

        // return node (which was set to the head)
        return node;
    }

    /**
     * removes tail of the linked list
     * @return the previous tail of the list
     * @throws NoSuchElementException if list is empty
     */
    private LinkedNode<E> removeTail(){

        // if head is null, list is empty, throw error
        if(head == null){
            throw new NoSuchElementException("list is empty");
        }

        LinkedNode<E> node = head;
        LinkedNode<E> result = head;

        // if only one element in list, set head and tail to null
        if(head == tail){
            head = null;
            tail = null;
        } else{
            // traverse to node before tail
            while(node.next.next != null){
                node = node.next;
            }
            
            result = node.next;     // set result to be the tail (node = node before tail)
            node.next = null;       // set next of node to be null to get rid of tail
            tail = node;            // set the tail to be current node (node before the tail)
        }

        return result;
    }

    /**
     * Removes the element at the specified position in this list
     * @param index of the element to remove
     * @return the element that was removed
     * @throws IndexOutOfBoundsException if index is not within 0...size-1
     */
    public E remove(int index){
        checkInvariants();
        
        LinkedNode<E> current = head;
        LinkedNode<E> previous = null;
        LinkedNode<E> result;

        // check if index is valid
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("index out of bounds");
        }

        if(index == 0){
            result = removeFront();
        } else if(index == size - 1){
            result = removeTail();
        } else {
            // taverse to node to remove
            while(index > 0){
                previous = current;
                current = current.next;

                index = index - 1;
            }
            result = current.next;
            previous.next = current.next;
        }
        
        size = size - 1;

        checkInvariants();
        return result.item;
    }

    /**
     * returns an iterator object for the linked list
     * @return a LinkedListIterator<E> object
     */
    public LinkedListIterator iterator(){
        return new LinkedListIterator();
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

    public static <E> void p(E print){
        System.out.println("\n" + print);
    }
}
