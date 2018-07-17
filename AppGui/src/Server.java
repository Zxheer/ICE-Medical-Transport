import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author Zaheer 216001758
 *
 */

public class Server
{
	private static final int PORT = 2018; 
	
    public static void main(String[] argv)
    {
    	//Setup server socket and pass on handling of request
    	ServerSocket serverSocket = null;
    	
    	try{	
    		serverSocket = new ServerSocket(PORT);
			while(true)
			{
				try{
					//wait for a new connection
					System.out.println("ICE waiting for connection...");
					Socket socket = serverSocket.accept();
					System.out.println("Connection established to ICE");
					//run new thread to handle the client
					Thread thread = new Thread(new Handler(socket));
					thread.start();
					
				}catch(IOException ex){
					System.err.println(ex);
				}
			}
			
		}catch(IOException ex)
		{
			System.err.println(ex);
			
		}finally
		{
			//close socket
			if(serverSocket != null)
			{
				try {
					serverSocket.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
    }
}
