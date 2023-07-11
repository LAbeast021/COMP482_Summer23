// Kiarash Hesampour
// Project #3

import java.io.*;
import java.util.*;

public class Project3 {
	PrintStream prt = System.out;	

	private void process(String fn) { 
		try {
            BufferedReader reader = new BufferedReader(new FileReader(fn));
            String line = reader.readLine();
            int inputLength = Integer.parseInt(line);
            String[] dictionary = new String[inputLength];

            for (int counter0 = 0; counter0 < inputLength; counter0++) {
                line = reader.readLine();
                line = line.substring(2);
                dictionary[counter0] = line;
            }

            String massage = reader.readLine();
            int[] numOfways = new int[massage.length() + 1];
            numOfways[0] = 1;

            for (int counter0 = 0; counter0 < massage.length(); counter0++) {
                numOfways[counter0 + 1] = 0;
            }

            for (int counter0 = 0; counter0 < massage.length(); counter0++) {
                String tempMassage = massage;
                tempMassage = tempMassage.substring(0, counter0 + 1);

                for (int counter1 = 0; counter1 <= tempMassage.length(); counter1++) {
                    String tempTempMassage = tempMassage;
                    tempTempMassage = tempTempMassage.substring(tempMassage.length() - counter1);

                    for (int counter2 = 0; counter2 < inputLength; counter2++) {
                        if (tempTempMassage.equals(dictionary[counter2])) {
                            numOfways[counter0 + 1] += numOfways[counter0 + 1 - tempTempMassage.length()];
                        }
                    }
                }
            }

            reader.close();
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
