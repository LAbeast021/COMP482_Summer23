// Kiarash Hesampour
// Project #1

import java.io.*;
import java.util.*;

public class Project1 {
    
    PrintStream prt = System.out;

    int g[][], visit[], nodes, edges, max = 9999;




    private void bfs(){

        int[] visited = new int[nodes+1];
        int i, nodex = nodes;
        Queue<Integer> queue = new LinkedList<>();

        visited[nodex] = 1;
        queue.add(nodex);
        while (!queue.isEmpty()) {
            nodex = queue.poll();
            prt.printf(" %d  ", nodex);
            for (i = 1; i <= nodex; i++) {
                if (g[nodex][i] != max && visited[i] == 0) {
                    visited[i] = 1;
                    queue.add(i);
                }
            }
            // prt.printf("hellooo  d% " , nodex);
        }
   } // end DFS from nodex




    private void process(String fn) { 
		int i, j, k, wt, n, nodex;	  
		try{ 
			Scanner inf = new Scanner(new File(fn)); 
			nodes = inf.nextInt();

			//Allocate space for graph[][] and visit[]
			g = new int[nodes+1][nodes+1];
			visit = new int[nodes+1];

			// initialize g[][] matrix
			for (i = 1; i <= nodes; i++){
				for (j = 1; j <= nodes; j++){
					g[i][j]= inf.nextInt();
                }
            }
				
			inf.close();
		}catch(Exception e){prt.printf("\nI/O Error %s", e );}

        prt.printf("injaye %d --- %d  alooo" , g[3][4] , g[4][3]);
        bfs();
	}  // end process method



    public static void main(String[] args) throws Exception{
		// int cnt = args.length;
		String fn;
		// if (cnt < 1){
		//     System.out.printf("\n\tOOOPS Invalid No. of arguments!" +
		// 	"\n\tTO Execute: java xxxxxH9 inputfilename");
		// 	return;
		// }
		
		// fn = args[0];
		fn = "input.txt";

		Project1 P = new Project1();
		
		P.process(fn); 
				
		System.out.printf("\n\tAuthor: K. Hesampour Date: " + java.time.LocalDate.now()); 
	}	
}

// // read graph data			
			// for (k = 1; k <= edges; k++){
			// 	i  = inf.nextInt();			
			// 	j  = inf.nextInt();			
			// 	wt = inf.nextInt();
			// 	g[i][j] = g[j][i] = wt;
			// }// end for
			
			//read no. of searches
			// n = inf.nextInt();
			// for (k = 1; k <= n; k++){
			// 	//Read starting node
			// 	nodex = inf.nextInt();
				
				// //DFS Graph Traversal from nodex
				// for (j = 1; j <= nodes; j++) 
				// 	visit[j] = 0;
				// prt.printf("\n\tDFS from (%d):", nodex);
				// dfs(nodex);//non recursive

				//BFS Graph Traversal from nodex
			// 	prt.printf("\n\tBFS from (%d):", nodex);
			// 	bfs(nodex);
			// }// end for