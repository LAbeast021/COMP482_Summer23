// Kiarash Hesampour
// Project #3

import java.io.*;
import java.util.*;

public class Project3 {
	PrintStream prt = System.out;	

	private void process(String fn) { 
		try {
            BufferedReader inpFile = new BufferedReader(new FileReader(fn));
			
            String line = inpFile.readLine();
            int inputLength = Integer.parseInt(line), counter0 , counter1 , counter2 ;
            String[] message = new String[inputLength];

            for ( counter0 = 0; counter0 < inputLength; counter0++) {
                line = inpFile.readLine();
                line = line.substring(2);
                message[counter0] = line;
            }

            String massage = inpFile.readLine();
            int[] numOfways = new int[massage.length() + 1];
            numOfways[0] = 1;

            for ( counter0 = 0; counter0 < massage.length(); counter0++) {
                numOfways[counter0 + 1] = 0;
            }

            for ( counter0 = 0; counter0 < massage.length(); counter0++) {
                String tempMassage = massage;
                tempMassage = tempMassage.substring(0, counter0 + 1);

                for ( counter1 = 0; counter1 <= tempMassage.length(); counter1++) {
                    String tempTempMassage = tempMassage;
                    tempTempMassage = tempTempMassage.substring(tempMassage.length() - counter1);

                    for ( counter2 = 0; counter2 < inputLength; counter2++) {
                        if (tempTempMassage.equals(message[counter2])) {
                            numOfways[counter0 + 1] += numOfways[counter0 + 1 - tempTempMassage.length()];
                        }
                    }
                }
            }

            inpFile.close();
            prt.println(numOfways[massage.length()]);
        } 
		catch(Exception e){prt.printf("\nI/O Error %s", e );}

	}  // end process method

    public static void main(String[] args) {
		String fn;
		fn = "input.txt";
		Project3 P = new Project3();
		P.process(fn); 	       
    }
}
