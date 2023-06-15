// Kiarash Hesampour
// Project #2
public class Project2 {


    private void process(String fn) { 
		int i, j;	  
		try{ 
			Scanner inf = new Scanner(new File(fn)); 
			nodes = inf.nextInt();
			g = new int[nodes+1][nodes+1];
			for (i = 1; i <= nodes; i++){
				for (j = 1; j <= nodes; j++){
					g[i][j]= inf.nextInt();
                }
            }	
			inf.close();
		}catch(Exception e){prt.printf("\nI/O Error %s", e );}
        bfs();
        if(pathCounter == 0) {
            prt.printf("There were no paths found " );
        }
        else {
            prt.printf("There were %2d Paths" , pathCounter);
        }
	}  // end process method
    public static void main(String[] args) throws Exception{
		String fn;
		fn = "input.txt";
		Project2 P = new Project2();
		P.process(fn); 	
		System.out.printf("\nAuthor: K. Hesampour Date: " + java.time.LocalDate.now()); 
	}	
    
}
