// coded by Michelle Auyoung

// function to find number of ways a number can be a sum of (integer) squares
// Example: 25 = 0*0 + 5*5
//		or: 25 = 3*3 + 4*4
//		=> answer is 2

import java.io.*;
import java.util.*;

public class double_squares {
	public static void main(String args[]) {
		try{
			// read input file
			FileInputStream fstream = new FileInputStream(args[0]);
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			  
			while ((strLine = br.readLine()) != null)   {
			  
				// current number to check
				int x = 0;
				  
				// temp container to hold square root of x
				int sqrtx = 0;
				  
				// counter
				int count = 0;
				  
				// temp container to hold target operand of sum
				int target = 0;
				  
				// temp container to hold first operand
				int prev = 0;
			  
				x = Integer.parseInt(strLine);
				  
				// one operand of sum cannot be greater than sqrt of x
				sqrtx = (int)Math.sqrt(x);
				  
				for (int i = 0; i <= sqrtx; i++) {
					// zero is always a sum of squares of itself
					if (x == 0)
						count += 1;
					  
					target = x - i*i;
					  
//					System.out.print("target: ");
//					System.out.println(target);
					  
					// check if target operand is a square
					double temp = Math.sqrt((double)target) % 1;
					if (temp == 0) {
						prev = i*i;
						// check if target already counted (1+4 is the same as 4+1)
						// only count when target is the smaller one to avoid repeat
						if (target < prev) {
//							System.out.println("counted");
							count += 1;
						}
					}
				}
				System.out.println(count);
			}
		  
			//Close the input stream
			in.close();
		}
		
		catch (Exception e){//Catch exception if any
		  System.err.println("Error: " + e.getMessage());
		}
	}
}
