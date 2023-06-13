import java.io.*;
import java.util.*;

public class Main { 

    public static int bfs(int inputSize, int[] pathLength, int[] path, int[][] adjMat) {
        int parentIdx = inputSize - 1;
        int flagSweep = 0;
        int flagFound = 0;
        pathLength[0] = -1;
        int[] level1Neighbors = new int[inputSize];
        int[] level2Neighbors = new int[inputSize];
        int[] parent = new int[inputSize];
        int[] seen = new int[inputSize];
        int rootFlag = 1;

        for (int counter0 = 0; counter0 < inputSize; counter0++) {
            if (flagFound == 0) {
                pathLength[0]++;
                if (rootFlag == 1) {
                    rootFlag = 0;
                    seen[0] = 1;
                    if (inputSize == 1) {
                        path[0] = 0;
                        break;
                    }
                    for (int counter1 = 0; counter1 < inputSize; counter1++) {
                        if (adjMat[0][counter1] == 1) {
                            level1Neighbors[counter1] = 1;
                            parent[counter1] = 0;
                        }
                    }
                } else {
                    flagSweep = 0;
                    for (int counter1 = 0; counter1 < inputSize; counter1++) {
                        if (level1Neighbors[counter1] == 1 && seen[counter1] == 0) {
                            flagSweep = 1;
                            seen[counter1] = 1;
                            if (counter1 == inputSize - 1) {
                                parentIdx = counter1;
                                for (int counter2 = pathLength[0] + 1; counter2 > 0; counter2--) {
                                    path[parentIdx] = counter2;
                                    parentIdx = parent[parentIdx];
                                }
                                flagFound = 1;
                                break;
                            } else {
                                for (int counter2 = 0; counter2 < inputSize; counter2++) {
                                    if (adjMat[counter1][counter2] == 1 && seen[counter2] == 0) {
                                        level2Neighbors[counter2] = 1;
                                        parent[counter2] = counter1;
                                    }
                                }
                            }
                        }
                    }
                    if (flagSweep == 1) {
                        // pathLength[0] += 1;
                    }
                    System.arraycopy(level2Neighbors, 0, level1Neighbors, 0, inputSize);
                }
            }
        }
        return flagFound;
    }

    public static void deletePath(int inputSize, int pathLength, int[] path, int[][] adjMat) {
        int previousIndex = 0;
        if (pathLength == 1) {
            adjMat[0][inputSize - 1] = 0;
            adjMat[inputSize - 1][0] = 0;
        }
        for (int counter0 = 0; counter0 < pathLength + 1; counter0++) {
            for (int counter1 = 0; counter1 < inputSize; counter1++) {
                if (path[counter1] == counter0) {
                    adjMat[previousIndex][counter1] = 0;
                    adjMat[counter1][previousIndex] = 0;
                    previousIndex = counter1;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int SIZE;
        try{ 
			Scanner inf = new Scanner(new File("input.txt")); 
			SIZE = inf.nextInt(); 
            int[][] adjacencyMatrix = new int[SIZE][SIZE];
            int[] path = new int[SIZE];
            int[] pathLength = {0};
            
            for (int counter1 = 1; counter1 < SIZE; counter1++) {
                path[counter1] = -1;
            }
            path[0] = 0;
            int pathCounter = 0;
            for (int i = 0; i < SIZE; i++){
                for (int j = 0; j < SIZE; j++){
                    adjacencyMatrix[i][j]= inf.nextInt();
                }
            }
            
			inf.close();
            
                    while (bfs(SIZE, pathLength, path, adjacencyMatrix) != 0) {
                        pathCounter++;
                        System.out.print("Path #" + pathCounter + " : ");
                        for (int counter1 = 0; counter1 < SIZE; counter1++) {
                            if (path[counter1] != -1) {
                                System.out.print(counter1 + 1 + "    ");
                            }
                        }
                        System.out.println();
                        deletePath(SIZE, pathLength[0], path, adjacencyMatrix);
                        for (int counter1 = 1; counter1 < SIZE; counter1++) {
                            path[counter1] = -1;
                        }
                    }
                    System.out.printf("There are # %d paths " , pathCounter);
		}catch(Exception e){System.out.printf("\nI/O Error %s", e );}
    }
}




