package ibf2021.day6;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class fc 
{
    
    public static void main(String[] args) throws IOException 
    {
    Socket socket; ServerSocket serverSocket; Cookie2 Serv= new Cookie2();

   String cookie = "FortuneCookie.txt";  //"src/main/java/ibf2021/day6/FortuneCookie.txt"
    if(args != null && args.length >=1)
            {cookie = args[0];}
            else{System.out.println("System will us FortuneCookie.txt");}
        //String line32 = Files.readAllLines(Paths.get("FortuneCookie.txt")).get(2);
        //System.out.println(line32);
        serverSocket = new ServerSocket(12345);
        socket = serverSocket.accept();
            
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
       String  clientMsg = in.readLine();

        while(!"close".equals(clientMsg) && null != clientMsg)
       
        {System.out.println("Client: " + clientMsg);
        try
        {
          if("get-cookie".equals(clientMsg))
          {System.out.println("Sending Cookie");
          /*  double min = Math.ceil(1); double max = Math.floor(27);
            int random = (int)Math.round(Math.floor(Math.random() * (max - min) + min));
            String line32 = Files.readAllLines(Paths.get("src/main/java/ibf2021/day6/"+cookie)).get(random);*/
            String line32 = Serv.getCookie(cookie);
          out.println("Wishing You Luck: " +line32);
            out.flush();
            clientMsg = in.readLine();
        }
          else{
            out.println("Server: Invalid Command");
            out.flush();
            clientMsg = in.readLine();
          }
        }
        catch (IOException e)
            {e.printStackTrace(); //throws line number and class name where error occurs
            System.out.println("NOt found data for socket" +e); break;
            }
        }
    serverSocket.close();
    socket.close();
    }
}
