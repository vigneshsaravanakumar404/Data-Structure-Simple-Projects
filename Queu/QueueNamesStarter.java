import java.io.*;
import java.util.*;

public class QueueNamesStarter{

	public static void main(String[]args){

		// Declare and initialize Queue and Priority Queue

		try{
			File file = new File("randomNames.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line="";
			while((line=br.readLine())!= null) // if line not null store as String
			{
				//add line to data Structures
			}
			br.close();
		}
			catch (IOException io){
				System.err.println("File Error: "+io);
		}

		// Print in Queue Order
	}


}
