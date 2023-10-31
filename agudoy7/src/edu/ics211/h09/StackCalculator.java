package edu.ics211.h09;

public class StackCalculator {
    
    public static void main(String[] args){

    }

    private LinkedNode head;

    public static class LinkedNode{
        private long item;
        private LinkedNode next;

        public LinkedNode(){
            item = 0;
            next = null;
        }

        public LinkedNode(long value){
            item = value;
            next = null;
        }

        public LinkedNode(long value, LinkedNode reference){
            item = value;
            next = reference;
        }
    }
}
