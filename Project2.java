// Kiarash Hesampour
// Project #2

import java.io.*;
import java.util.*;
public class Project2 {

    PrintStream prt = System.out;
    public static int bunker[][];
    public static int currentTotall;


    private void firstAlg (){
        
    }


    private void adder (int number){
        currentTotall = currentTotall + number;
    }

    private void process(String fn) { 
		int i, j , people;	  
		try{ 
			Scanner inf = new Scanner(new File(fn)); 
			people = inf.nextInt();
            bunker = new int [people+1][3];
            for( i = 1 ; i <= people ; i++){
                for (j = 1 ; j <= 2 ; j++){
                    bunker[i][j] = inf.nextInt();
                }
            }

			inf.close();
		}catch(Exception e){prt.printf("\nI/O Error %s", e );}
        prt.println(Arrays.deepToString(bunker));

	}  // end process method
    public static void main(String[] args) throws Exception{
		String fn;
		fn = "input.txt";
		Project2 P = new Project2();
		P.process(fn); 	
		System.out.printf("\nAuthor: K. Hesampour Date: " + java.time.LocalDate.now()); 
	}	
    
}
