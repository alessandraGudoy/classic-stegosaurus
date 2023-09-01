package edu.ics211.h01;

import java.io.File;
import java.io.FileNotFoundException;

public class HW1 {
	
	public static void main(String[] args) throws FileNotFoundException{
		
		/* PART 1 */
		int num = (int) (Math.random()*11);
		
		double[] result = Roots.roots(num);
		
		if(result != null) {
			
			System.out.println("Finding roots between 2 and " + num);
			
			for(int i = 0; i < result.length; i++) {
				if(i == result.length - 1) {
					System.out.println(result[i]);
				} else {
					System.out.print(result[i] + ", ");
				}
			}
			
		} else {
			System.out.println("INPUT must be greater than 2");
		}
		
		
		/* PART 2 */
		System.out.println();
		
		for(int i = 0; i < args.length; i++) {
			
			File file = new File(args[i]);
			
			if(file.exists() && file.isFile()) {
				System.out.println(args[i] + " " + Reader.numChars(args[i]));
			} else {
				System.out.println(args[i] + " not found");
			}
		}
		
	}
}
