// Kiarash Hesampour
// Project #1

import java.io.*;
import java.util.*;

public class Project1 {
    PrintStream prt = System.out;

    int g[][], visit[], nodes, edges, max = 9999;



    public static void main(String[] args) throws Exception{
		int cnt = args.length;
		String fn;
		if (cnt < 1){
		    System.out.printf("\n\tOOOPS Invalid No. of arguments!" +
			"\n\tTO Execute: java xxxxxH9 inputfilename");
			return;
		}
		
		fn = args[0];

		Project1 g = new Project1();
		
		g.process(fn); 
				
		System.out.printf("\n\tAuthor: K. Hesampour Date: " + java.time.LocalDate.now()); 
	}	
}