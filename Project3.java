// Kiarash Hesampour
// Project #3

import java.io.*;
import java.util.*;

public class Project3 {
	PrintStream prt = System.out;	

	private void process(String fn) { 
		
            try (BufferedReader inpFile = new BufferedReader(new FileReader(fn))) {
				String line = inpFile.readLine();
				int inputLength = Integer.parseInt(line) , i , j , k;
				
				String[] arr = new String[inputLength];

				for ( i = 0; i < inputLength; i++) {
				    line = inpFile.readLine();
				    line = line.substring(2);
				    arr[i] = line;
				}

				String massage = inpFile.readLine();
				int[] numOfways = new int[massage.length() + 1];
				numOfways[0] = 1;

				for ( i = 0; i < massage.length(); i++) {
				    numOfways[i + 1] = 0;
				}

				for ( i = 0; i < massage.length(); i++) {
				    String tempMassage = massage;
				    tempMassage = tempMassage.substring(0, i + 1);

				    for ( j = 0; j <= tempMassage.length(); j++) {
				        String tempTempMassage = tempMassage;
				        tempTempMassage = tempTempMassage.substring(tempMassage.length() - j);

				        for ( k = 0;  k < inputLength;  k++) {
				            if (tempTempMassage.equals(arr[ k])) {
				                numOfways[i + 1] += numOfways[i + 1 - tempTempMassage.length()];
				            }
				        }
				    }
				}

				inpFile.close();
				prt.println(numOfways[massage.length()]);
        } catch(Exception e){prt.printf("\nI/O Error %s", e );}

	}  // end process method

    public static void main(String[] args) {
		String fn;
		fn = "input.txt";
		Project3 P = new Project3();
		P.process(fn); 	       
    }
}
