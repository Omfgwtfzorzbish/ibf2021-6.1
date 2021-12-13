package day6.cookie;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;   
import java.io.StringReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
public class fc 
{
    public static void main(String[] args) throws IOException 
    {
        ServerSocket server = null;
        try
        {
        server = new ServerSocket(12345);
        server.setReuseAddress(true);
        System.out.println("Waiting for request");
        while(true)
        {
        Socket socket = server.accept();
        System.out.println("new request accepted");

        handler cookieHandler = new handler(socket);
        new Thread(cookieHandler).start();
/*
        double min = Math.ceil(1); double max = Math.floor(27);
        int random = (int)Math.round(Math.floor(Math.random() * (max - min) + min));
        
        //String i = String.valueOf(((Math.random()*(27-1)+1)));
        
        String line32 = Files.readAllLines(Paths.get("FortuneCookie.txt")).get(random);

        PrintStream ps = new PrintStream(socket.getOutputStream());
        BufferedReader br = new BufferedReader(new StringReader(line32));
        
        System.out.println("Wishing You Luck!");  
        }
        ps.print(br.readLine());
        socket.close();
        server.close();
        }  */
        }}
        catch (IOException e)
            {e.printStackTrace(); //throws line number and class name where error occurs
            System.out.println("NOt found data for socket" +e);
            }
        finally{
            if(server!=null){
                try{server.close();}
                catch(IOException e){e.printStackTrace();}

            }
        }

    }
}
