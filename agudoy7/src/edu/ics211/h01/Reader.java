package edu.ics211.h01;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Reader, reads a file.
 * @author Gudoy, Alessandra
 */

public class Reader {

	/**
	 * Indicates the number of characters in the given file
	 * @param dir representing the path to file
	 * @return number of characters inside file
	 * @throws FileNotFoundException if file cannot be found
	 */
	public static int numChars(String dir) throws FileNotFoundException{
		File file = new File(dir);
		
		if( !(file.exists() && file.isFile()) ) {
			System.out.println(dir + " not found");
			throw new FileNotFoundException();
		}
		
		return (int) file.length();
	}
	 
}
