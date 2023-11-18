package edu.ics211.h11;

/**
 * BinaryStringNode
 * 
 * @author Alessandra Gudoy
 */
public class BinaryStringNode implements Comparable<BinaryStringNode> {

    String key;
    long occurrences;
    BinaryStringNode left;
    BinaryStringNode right;
	
    public BinaryStringNode(){ }
	
    public BinaryStringNode(String value){
        key = value;
        occurrences = 1;
        left = null;
		right = null;
	}
	
	public BinaryStringNode(String value, BinaryStringNode l, BinaryStringNode r){
		key = value;
		occurrences = 1;
		left = l;
		right = r;
	}
	
	public String getKey(){
		return key;
	}
	
	public BinaryStringNode getLeft(){
		return left;
	}
	
	public BinaryStringNode getRight(){
		return right;
	}

	public void incrementOccurrences(){
		occurrences = occurrences + 1;
	}
	
	public String toString(){
		return new String("VALUE: " + key);
	}
	
	public int compareTo(BinaryStringNode o) {
		return key.compareTo(o.key);
	}
	
	
}	