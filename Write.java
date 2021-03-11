package projects;

import java.io.FileWriter;
import java.io.IOException;

public class Write {
	
	
	public static void main(String[] args) throws IOException {
		Mainjson json=new Mainjson();
		String str=json.main();
		
		
		try (FileWriter file = new FileWriter("C:\\Users\\NRAD\\Desktop\\test\\test.txt")) {
	        file.write(str.toString());
	        System.out.println("Successfully Copied JSON Object to File...");
	        System.out.println("\nJSON Object: " + str);
	  }  
	}
	
	

}
