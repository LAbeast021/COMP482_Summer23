// Kiarash Hesampour
// Project #2

import java.io.*;
import java.util.*;
public class Project2 {

    PrintStream prt = System.out;
    public static int bunker[][];
    public static int currentTotall = 0;


    private void adder (int number){
        // prt.printf("\t\n -> %2d ", number);
        currentTotall = currentTotall + number;
    }

    private void firstAlg (int p){
        int i ;
        for( i = 1 ; i <= p ; i++){
                if (bunker[i][1] < bunker[i][2]){
                    bunker[i][0] = bunker[i][2] - bunker[i][1];
                    adder(bunker[i][1]);
                }
                else{
                    bunker[i][0] = bunker[i][1] - bunker[i][2];
                    adder(bunker[i][2]);
                }
        }
    }
    private void secondAlg (int p){
        int i , counter1 = 0 , counter2 = 0 ;
        currentTotall = 0;
        Arrays.sort(bunker, Comparator.comparingInt(o -> o[0]));

        for( i = p ; i >= 1 ; i--){
            if (counter1 != (p / 2) && counter2 != (p / 2)){
                if (bunker[i][1] < bunker[i][2]){
                    counter1 ++ ;
                    adder(bunker[i][1]);
                }
                else{
                    counter2 ++ ;
                    adder(bunker[i][2]);
                }
            }
            else if (counter1 == (p/2)) {
                adder(bunker[i][2]);
            }
            else if (counter2 == (p / 2)) {
                adder(bunker[i][1]);  
            }
        }
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

            
            firstAlg(people);
            prt.printf("%d \n", currentTotall);
            
            secondAlg(people);
            // prt.println(Arrays.deepToString(bunker));

            prt.printf("%d ", currentTotall);
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
