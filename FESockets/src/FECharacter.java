package src;

import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;
import java.io.LineNumberReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class FECharacter {
	public static void main(String[] args) {
		/*File file = new File(".");
		for(String fileNames : file.list()) System.out.println(fileNames);
		*/
		String csvFile = "FEcsv.csv";
        String line = "";
        String cvsSplitBy = ",";
        Map<String, String> contactNum = new HashMap<>();
        ServerSocket serverSocket = null; 
		
        try (LineNumberReader br = new LineNumberReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                // Skip the headings of the CSV file
            	if (br.getLineNumber() > 1) {
            		String[] contact = line.split(cvsSplitBy);
                    contactNum.put(contact[0],contact[1]);
            	}
            }
            
            try { 
   	         serverSocket = new ServerSocket(5587); 
   	        } 
	   	    catch (IOException e) 
	   	        { 
	   	         System.err.println("Could not listen on port: 5587."); 
	   	         System.exit(1); 
	   	        } 
	
	   	    Socket clientSocket = null; 
	   	    System.out.println ("Waiting for connection.....");
	
	   	    try { 
	   	         clientSocket = serverSocket.accept(); 
	   	        } 
	   	    catch (IOException e) 
	   	        { 
	   	         System.err.println("Accept failed."); 
	   	         System.exit(1); 
	   	        } 
            
            
            System.out.println ("Connection successful");
    	    System.out.println ("Waiting for input.....");
    	    
    	    Socket socket = serverSocket.accept();
    	    
    	    //Sending the response back to the client.
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
            
            //Iterate and send contact info
            for (Map.Entry<String, String> entry : contactNum.entrySet()) {
                String contactName = entry.getKey();
                bw.write(contactName);
                bw.flush();
                
                String contactNumVal = entry.getValue();
                bw.write(contactNumVal);
                bw.flush();
            }
            
         
    	    

    	    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), 
    	                                      true); 
    	    BufferedReader in = new BufferedReader( 
    	            new InputStreamReader(clientSocket.getInputStream())); 

    	    String inputLine; 

    	    while ((inputLine = in.readLine()) != null) 
    	        { 
    	         System.out.println ("Server: " + inputLine); 
    	         out.println(inputLine); 

    	         if (inputLine.equals("Bye.")) 
    	             break; 
    	        } 

    	    out.close(); 
    	    in.close(); 
    	    clientSocket.close(); 
    	    serverSocket.close(); 
            
            

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
		
        
	}
}