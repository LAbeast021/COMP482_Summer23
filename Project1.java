// Kiarash Hesampour
// Project #1

import java.io.*;
import java.util.*;

public class Project1 {
    
    PrintStream prt = System.out;

    int g[][], visit[], nodes, edges , pathCounter = 0;
    // Queue<Integer> queue = new LinkedList<>();

    private void bfs(){
        int i , j, nodex = 1;
        Queue<Integer> queue = new LinkedList<>();
        int[] parent = new int[nodes+1];
        
        parent[1] = 1;
        queue.add(nodex);
        while (!queue.isEmpty()) {
            nodex = queue.poll();
            for (i = 2; i <= nodes; i++) {
                if (g[nodex][i] != 0 && parent[i] == 0) {
                    parent[i] = nodex;
                    queue.add(i);
                }
            }
            if(parent[nodes] != 0) {
                Queue<Integer> path = new LinkedList<>();
                int previous ,  current = nodes;
                path.add(current);
                while(parent[current] != 1) {
                    previous = current;
                    current = parent[current];
                    path.add(current);
                    g[current][previous] = 0;
                    g[previous][current] = 0;

                }
                g[current][1] = 0;
                g[1][current] = 0;
                path.add(1);
                pathCounter++ ;

                Collections.reverse((List<?>) path);
                prt.println("Path # " + pathCounter + ": " + path);

                parent[nodes] = 0 ;

                bfs();

            }
        }
   }

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
		Project1 P = new Project1();
		P.process(fn); 	
		System.out.printf("\nAuthor: K. Hesampour Date: " + java.time.LocalDate.now()); 
	}	
}