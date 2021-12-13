package day6.cookie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.rmi.UnknownHostException;

public class fcclient {
    public static void main(String[] args) 
    {
    try{
        Socket socket = new Socket("localhost",12345);
        System.out.println("connected succesfully");

        BufferedReader bs =new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("response from server...");
        System.out.println("Client Side: " + bs.readLine());
        socket.close();
    }
    catch (UnknownHostException e) {
            
        // Catch block for IP errors
        System.out.println("IP not found for" + e);
    }
    catch (IOException e) {
        
        // Catch block for data stream errors
        System.out.println("Not found data for socket"
                           + e);
    }
    }
}
