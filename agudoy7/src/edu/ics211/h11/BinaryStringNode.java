package edu.ics211.h11;

/**
 * BinaryStringNode
 * 
 * @author Alessandra Gudoy
 */
public class BinaryStringNode implements Comparable<BinaryStringNode> {

    private String key;
    private long occurrences;
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

    public int getOccurrences(){
        return (int) occurrences;
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

    public void decrementOccurrences(){
        occurrences = occurrences - 1;
    }
	
	public String toString(){
		return new String("VALUE: " + key);
	}
	
	public int compareTo(BinaryStringNode o) {
		return compareTo(o.key);
	}

    public int compareTo(String str){
        int minLength = Math.min(key.length(), str.length());
        for (int i = 0; i < minLength; i++) {
            if (key.charAt(i) != str.charAt(i)) {
                return key.charAt(i) - str.charAt(i);
            }
        }
        return key.length() - str.length();
    }
	
	
}	