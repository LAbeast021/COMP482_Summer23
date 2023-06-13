// Kiarash Hesampour
// Project #1

import java.io.*;
import java.util.*;

public class Project1 {
    
    PrintStream prt = System.out;

    int g[][], visit[], nodes, edges;
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
                prt.println("The Queue contents:" + path);

                parent[nodes] = 0 ;

                bfs();

            }
            // else {
            //     queue.poll();
            // }
        }
        // prt.printf("[ ");
        // for (i = 1 ; i <= nodes ; i++) {
        //     prt.printf(" %3d ,  ", parent[i]);
        // }
   } // end DFS from nodex
// ____________________________________________________________________________________________________\\
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