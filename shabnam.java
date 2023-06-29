import java.io.*;
import java.util.*;
public class shabnam {
public static void main(String[] args) {
String inputFile ="input.txt";
int n ;
int[][] costs;
shabnam s = new shabnam();


try{ 
Scanner inf = new Scanner(new File(inputFile));

n = inf.nextInt();
costs = new int [n+1][3];
for(int i = 1 ; i <= n ; i++){
for (int j = 1 ; j <= 2 ; j++){
costs [i][j] = inf.nextInt();
}
}
inf.close();
int totalCostWithoutRestrictions = calculateTotalCost(costs,n);
System.out.println("Minimum total cost without restrictions: " + totalCostWithoutRestrictions);
int totalCostWithRestrictions = calculateTotalCostWithRestrictions(costs , n);
System.out.println("Minimum total cost with restrictions: " + totalCostWithRestrictions);
} catch(Exception e){System.out.printf("\nI/O Error %s", e );


}
}
private static int calculateTotalCost(int[][] costs,int p) {
int totalCost = 0;
for( int i = 1 ; i <= p ; i++){
if(costs[i][1]<costs[i][2])
{
totalCost += costs[i][1];
}
else
{
totalCost += costs[i][2];

}
}
return totalCost;

}
private static int calculateTotalCostWithRestrictions (int costs[][] , int n){
    int totalCost = 0, bunker1 = 0 , bunker2 = 0;
    for( int i = 1 ; i <= n ; i++){
        costs[i][0] = Math.abs(costs[i][1] - costs[i][2]);
    }
    Arrays.sort(costs, Comparator.comparingInt(o -> o[0]));
    for(int i = n ; i >= 1 ; i--){
        if (bunker1 != (n / 2) && bunker2 != (n / 2)){
            if (costs[i][1] < costs[i][2]){
                bunker1 ++ ;
                totalCost += costs[i][1];
            }
            else{
                bunker2 ++ ;
                totalCost += costs[i][2];
            }
        }
        else if (bunker1 == (n/2)) {
            totalCost += costs[i][2];
        }
        else if (bunker2 == (n / 2)) {  
            totalCost += costs[i][1];
        }
    }

return totalCost;
}
}
