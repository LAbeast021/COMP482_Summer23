// Kiarash Hesampour
// Project #1

import java.io.*;
import java.util.*;

public class Project1 {



    public static void main(String[] args) throws Exception{
		int cnt = args.length; // get no. of atguments
		String fn;
		if (cnt < 1){
		    System.out.printf("\n\tOOOPS Invalid No. of arguments!" +
			"\n\tTO Execute: java xxxxxH9 inputfilename");
			return;
		} // end if	
		
		// get input file name
		fn = args[0];

		// create an instance of xxxxxH9 class
		Project1 g = new Project1();
		
		// call process method
		g.process(fn); 
			
		//MAKE SURE TO WRITE YOUR NAME IN NEXT LINE		
		System.out.printf("\n\tAuthor: K. Hesampour Date: " + java.time.LocalDate.now()); 
	}	// end main
}