package edu.ics211.h11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Constructor, add, size, height, remove, occurrences, removeOne
 * 
 * @author Benjamin Strauss, Edo Biagioni, Alessandra Gudoy
 */

public class BinaryStringTree {

	protected BinaryStringNode root = null;
	protected int size;

	public static void main(String[] args) throws FileNotFoundException{
		BinaryStringTree tree = new BinaryStringTree("/Users/agudoy/Desktop/UH_FALL2023/ICS 211/classic-stegosaurus/agudoy7/src/edu/ics211/h11/file.txt");
		BinaryStringTree constitution = new BinaryStringTree("/Users/agudoy/Desktop/UH_FALL2023/ICS 211/classic-stegosaurus/agudoy7/src/edu/ics211/h11/constitution.txt");
		System.out.println(tree.size());
		System.out.println(tree.occurrences("peter"));

		tree.removeOne("peter");
		System.out.println(tree.size());
		System.out.println(tree.occurrences("peter"));

		tree.removeOne("the");
		System.out.println(tree.size());
		System.out.println(tree.occurrences("the"));
		System.out.println(constitution.size());

		System.out.println(tree.keys().toString());

	}
	
	public BinaryStringTree() {
		size = 0;
	}
	
	/**
	 * Construct a new BinaryStringTree using the words in the given file
	 * @param fileName
	 * @throws FileNotFoundException
	 */
	public BinaryStringTree(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		Scanner scanner = new Scanner(file);

		while(scanner.hasNext()){
			String tmp = scanner.next();
			String str = "";

			for(int i=0; i<tmp.length(); i++){
				if(Character.isLetter(tmp.charAt(i))){
					str = str + tmp.substring(i, i+1);
				}
			}

			if(!str.equals("")){
				add(str);
			}
		}
		scanner.close();

	}
	
	/**
	 * 
	 * @param key
	 * @return the number of occurrences of the given String, or
         *         0 if the String is not found
	 */
	public long occurrences(String key) {
		BinaryStringNode node = searchFor(root, key);
		if(node == null){
			return 0;
		}
		return node.getOccurrences();
	}

	protected BinaryStringNode searchFor(BinaryStringNode node, String key){
		if(node == null || node.getKey().equals(key)){
			return node;
		}
		if(node.compareTo(key) < 0){
			return searchFor(node.right, key);
		}
		return searchFor(node.left, key);
			
	}

	public java.util.Set<String> keys() {
		java.util.Set<String> result = new java.util.HashSet<>();
		goThrough(root, result);
		return result;
	}

	protected void goThrough(BinaryStringNode node, java.util.Set<String> set){
		if(node != null){
			set.add(node.getKey());
			goThrough(node.left, set);
			goThrough(node.right, set);
		}
	}
	
	/**
	 * If the key is in the tree, increment its number of occurences by 1.
	 * 		Else add the key to the tree with occurence 1.
	 * @param key to be added to the trees
	 */
	public void add(String key) {
		root = add(root, key);
	}

	protected BinaryStringNode add(BinaryStringNode node, String key){
		if(node == null){
			size = size + 1;
			return new BinaryStringNode(key);
		}
		if(node.compareTo(key) == 0){
			node.incrementOccurrences();
			return node;
		} else{
			if(node.compareTo(key) < 0){
				node.right = add(node.right, key);
			} else{
				node.left = add(node.left, key);
			}
		}
		return node;
	}
	
	/**
	 * Removes one occurrence of the given key from the tree, usually
     * by decrementing the value associated with the key.
	 * However, if the key has a value of 1, deletes the node
	 * If the key is not in the tree, does nothing.
	 * @param key
	 */
	public void removeOne(String key) {
		BinaryStringNode node = searchFor(root, key);

		if(node.getOccurrences() == 1){
			remove(key);
		} else{
			node.decrementOccurrences();
		}
	}
	
	/**
	 * Removes the given String from the tree by deleting the node
	 * @param key
	 */
	public void remove(String key) {
		root = remove(root, key);
		size = size - 1;
	}

	public BinaryStringNode remove(BinaryStringNode node, String key){
		if(root == null){
			return root;
		}

		if(node.compareTo(key) == 0){
			if(node.left == null){
				return node.right;
			} else if(node.right == null){
				return node.left;
			} else{
				String replacement = getRightMost(node.left);

				BinaryStringNode newNode = new BinaryStringNode(replacement,
											remove(node.left, replacement), node.right);
				
				return newNode;
			}
		} else{
			if(node.compareTo(key) > 0){
				node.left = remove(node.left, key);
			} else{
				node.right = remove(node.right, key);
			}
		}

		return node;
	}

	protected String getRightMost(BinaryStringNode node){
		BinaryStringNode right = node.right;
		if(right == null){
			return node.getKey();
		} else{
			return getRightMost(right);
		}
	}
	
	/**
	 * 
	 * @return number of nodes in the tree == the number of unique Strings
	 */
	public int size() {
		return size;
	}

	/**
	 * 
	 * @return the height of the tree.  An empty tree has height 0,
         *         a tree with one node has height 1
	 */
	public int height() {
		if(root == null){
			return 0;
		}
		return getHeight(root);
	}

	public int getHeight(BinaryStringNode node){
		if(node == null){
			return 0;
		}
		int leftHeight = getHeight(node.left);
		int rightHeight = getHeight(node.right);

		return Math.max(leftHeight, rightHeight) + 1;
	}

	public String toString(){
		return toString(root);
	}

	public String toString(BinaryStringNode node){
		if(node == null){
			return "__";
		} else{
			return node.getKey() + "( " + toString(node.left) + ", " +
					toString(node.right) + " )"; 
		}
	}

}