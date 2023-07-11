// Kiarash Hesampour
// Project #3

// import java.io.BufferedReader;
// import java.io.File;
// import java.io.FileReader;
// import java.io.IOException;
// import java.util.Scanner;

import java.io.*;
import java.util.*;

public class Project3 {
	PrintStream prt = System.out;	

	private void process(String fn) { 
		int i, j , people;	  
		try{ 
			Scanner inf = new Scanner(new File(fn)); 
           
		}catch(Exception e){prt.printf("\nI/O Error %s", e );}

	}  // end process method
    public static void main(String[] args) {

		String fn;
		fn = "input.txt";
		Project3 P = new Project3();
		P.process(fn); 	 

       
    }
}
 try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            String line = reader.readLine();
            int inputLength = Integer.parseInt(line);
            String[] dictionary = new String[inputLength];

            for (int counter0 = 0; counter0 < inputLength; counter0++) {
                line = reader.readLine();
                line = line.substring(2);
                dictionary[counter0] = line;
            }

            String massage = reader.readLine();
            int[] OPT = new int[massage.length() + 1];
            OPT[0] = 1;

            for (int counter0 = 0; counter0 < massage.length(); counter0++) {
                OPT[counter0 + 1] = 0;
            }

            for (int counter0 = 0; counter0 < massage.length(); counter0++) {
                String tempMassage = massage;
                tempMassage = tempMassage.substring(0, counter0 + 1);

                for (int counter1 = 0; counter1 <= tempMassage.length(); counter1++) {
                    String tempTempMassage = tempMassage;
                    tempTempMassage = tempTempMassage.substring(tempMassage.length() - counter1);

                    for (int counter2 = 0; counter2 < inputLength; counter2++) {
                        if (tempTempMassage.equals(dictionary[counter2])) {
                            OPT[counter0 + 1] += OPT[counter0 + 1 - tempTempMassage.length()];
                        }
                    }
                }
            }

            reader.close();
            System.out.println(OPT[massage.length()]);
        } catch (IOException e) {
            System.out.println("Unable to open file");
        }

