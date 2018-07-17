
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

import java.util.Scanner;

/**
 * 
 * @author Zaheer 216001758
 *
 */
public class Handler implements Runnable
{
    private Socket connectionToClient;
    private Scanner reader = null;
    private OutputStream out = null; 
	private Writer writer = null;
	private boolean online = false;
	private boolean running = true;
    
    /**
     * Constructor
     * @param newConnectionToClient Socket that connects to the client
     */
    public Handler(Socket newConnectionToClient)
    {
    	//Bind streams
    	connectionToClient = newConnectionToClient;
    	try {
			out = new BufferedOutputStream(connectionToClient.getOutputStream());
			writer = new OutputStreamWriter(out);
			reader =  new Scanner(newConnectionToClient.getInputStream());
			
		} catch (IOException ex) {
			
			ex.printStackTrace();
		}
    	
    }
    
    @Override
    public void run()
    {
    	//Process commands from client	
    	while(running)
    	{
    		 try
             {
    			if(reader.hasNext())
    			{
    				//read command
	       			 String line = reader.nextLine().trim();
	       			 String lineSec[] = line.split("\\s");
	       			 
	       			 String command = lineSec[0];
	       			 
	       			 if(online)
	       			 {
	       				 if(command.equals("LOGIN"))
	           			 {
	           				 //allow user to make other requests
	       					 writer.write("OK Logged in\r\n");
	       					 writer.flush();
	           				 
	           			 }else if(command.equals("LOGOUT"))
	           			 {
	           				//disconnect the user
	           				online = false;
	           				writer.write("OK Goodbye\r\n");
	           				writer.flush();
	           			 }
	           			 else
	           			 {
	           				 //unknown command
	           				 writer.write("ERR Unknown command\r\n");
	           				 writer.flush();
	           			 }
	       			 }else
	       			 {
	       				 if(command.equals("LOGIN"))
	           			 {
	           				 //LOGIN process
	       					 if(lineSec.length == 3)
	       					 {
	       						 if(matchUser(lineSec[1], lineSec[2]))
	               				 {
	               					 online = true;
	               					 writer.write("OK Welcome\r\n");
	               					 writer.flush();
	               				 }
	       						 else
	       						 {
	       							 writer.write("ERR Wrong Credentials\r\n");
	               					 writer.flush(); 
	       						 }
	       					 }else
	       					 {
	       						 writer.write("ERR Provide User name and Password\r\n");
	           					 writer.flush();
	       					 }
	       					 
	           			 }else if(command.equals("LOGOUT"))
	           			 {
	           				//disconnect the user
           				 	online = false;
           				 	writer.write("OK Goodbye\r\n");
            				writer.flush();
	           				 
	           			 }else if(command.equals("REG"))
	           			 {
	           				register(lineSec[1], lineSec[2]);
           				 	writer.write("OK Registered\r\n");
            				writer.flush();
	           				 
	           			 }else
	           			 {
	           				 //user must login before sending other commands
	           				 writer.write("ERR Login first\r\n");
	           				 writer.flush();
	           			 }
	       			 }
	    		}
    			 
             }catch(Exception ex)
             {
            	 ex.printStackTrace();
             }
    		 
    	}
    }
    
    /**
     * Checks if the user name and password are valid
     * @param username The user name
     * @param password The password
     * @return True if valid and false if invalid
     */
    private boolean matchUser(String username,String password)
    {
		boolean found = false;
		File userFile = new File("data/users.txt");
		try
		{
		    Scanner scan = new Scanner(userFile);
		    while(scan.hasNextLine()&&!found)
		    {
			String line = scan.nextLine();
			String lineSec[] = line.split("\\s");
	    		
			//Compare user 
			found = username.equals(lineSec[0].trim()) && password.equals(lineSec[1].trim());
			
		    }
		    scan.close();
		}
		catch(IOException ex)
		{
		    ex.printStackTrace();
		}
		
		return found;
    }
    
    private void register(String username,String password)
    {     
    	try {
			FileWriter writer = new FileWriter("data/users.txt", true);
			writer.write("\r\n");   // write new line
			writer.write(username+" "+password);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
}
