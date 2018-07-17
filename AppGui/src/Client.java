import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


import javax.swing.SwingUtilities;

/**
 * 
 * @author Zaheer 216001758
 *
 */
public class Client
{
	private static final int PORT = 2018;
	private static final String HOST = "localhost";
	
	private Socket socket = null;
	private BufferedReader in = null;
	private PrintWriter out = null;
	
    public static void main(String[] argv)
    {
    	SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				
				Client client = new Client();
				Frame frame = new Frame(client);
				frame.setVisible(true);
			}
    		
    	});
    }
    
    /**
     * connects to the server
     */
    public void connect() throws IOException
    {
		socket = new Socket(HOST, PORT);
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);
			
    }
    
    /**
     * Logs in to server
     * @param username The user name
     * @param password The password
     * @return The response
     */
    public String login(String username, String password)
    {
    	String response = "";
    	out.println("LOGIN " + username + " " + password);
    	try {
			response = in.readLine();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    	
    	return response;
    }
    
    /**
     * Logs out from the server
     * @return The response
     */
    public String logout()
    {
    	String response = "";
    	out.println("LOGOUT");
    	try {
			response = in.readLine();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    	
    	return response;
    }
    
    /** Receive login from user and send to server to try login
     * @param username
     * @param password
     * @return
     */
    public String register(String username, String password)
    {
    	String response = "";
    	out.println("REG " + username + " " + password);
    	try {
			response = in.readLine();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    	
    	return response;
    }
   
    /**
     * Disconnects the client
     */
    public void disconnect()
    {
    	try {
			out.close();
			in.close();
			socket.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    }
}

