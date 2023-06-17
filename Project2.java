// Kiarash Hesampour
// Project #2

import java.io.*;
import java.util.*;
public class Project2 {

    PrintStream prt = System.out;
    public static int bunker[][];
    public static int currentTotall = 0;


    private void adder (int number){
        currentTotall = currentTotall + number;
    }

    private void firstAlg (int p){
        int i ;
        for( i = 1 ; i <= p ; i++){
                if (bunker[i][1] < bunker[i][2]){
                    adder(bunker[i][1]);
                }
                else{
                    adder(bunker[i][2]);
                }
        }
    }
    private void secondAlg (int p){
        int i ;
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
            prt.println(Arrays.deepToString(bunker));
            firstAlg(people);
            prt.printf("The result after running first algorithm is %d ", currentTotall);
            secondAlg(people);
		}catch(Exception e){prt.printf("\nI/O Error %s", e );}

	}  // end process method
    public static void main(String[] args) throws Exception{
		String fn;
		fn = "input.txt";
		Project2 P = new Project2();
		P.process(fn); 	
		System.out.printf("\nAuthor: K. Hesampour Date: " + java.time.LocalDate.now()); 
	}	
    
}
