// Kiarash Hesampour
// Project #3

import java.io.*;
import java.util.*;
public class Project3 {
    PrintStream prt = System.out;
    public static int numOfWords ;

    private void process(String fn) { 
		int i, j , people;	  
		try{ 
			Scanner inf = new Scanner(new File(fn)); 
			
		}catch(Exception e){prt.printf("\nI/O Error %s", e );}

	}  // end process method
    public static void main(String[] args) throws Exception{
		String fn;
		fn = "input.txt";
		Project3 P = new Project3();
		P.process(fn); 	
		System.out.printf("\nAuthor: K. Hesampour Date: " + java.time.LocalDate.now()); 
	}	
}
