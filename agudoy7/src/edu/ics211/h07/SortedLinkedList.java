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

    @Override
    public int size() {
        return 0;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public boolean add(E value) {
        return true;
    }

    @Override
    public boolean remove(E value) {
        return true;
    }

    @Override
    public int indexOf(E value) {
        return 0;
    }

    @Override
    public String toString() {
        String result = "";

        return result;
    }
    

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
    
    
}
