package ibf2021.day6;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Handler implements Runnable
{
    private Socket socket;
    private int id;
    private String cookie;
    
    Cookie2 Serv= new Cookie2();
  
    public Handler(Socket socket, int id, String cookie)
    {this.socket = socket;
    this.id=id;
    this.cookie=cookie;}           //changes input socket to name clientn socket in this class

    @Override
    public void run(){
        PrintWriter out = null;
        BufferedReader in = null;
        String clientMsg = "";
        System.out.println("Connection ID: " + id);

        try{
         out = new PrintWriter(socket.getOutputStream(),true);
         in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        clientMsg = in.readLine();} catch(IOException e){System.out.println("oops");}
       
    while(!"close".equals(clientMsg) && null != clientMsg)
   
    {System.out.println("Client: " + clientMsg);
    
    try{
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
    }  
                

      /*  try{
        double min = Math.ceil(1); double max = Math.floor(27);
        int random = (int)Math.round(Math.floor(Math.random() * (max - min) + min));
        
        //String i = String.valueOf(((Math.random()*(27-1)+1)));
        
        String line32 = Files.readAllLines(Paths.get("src/main/java/ibf2021/day6/FortuneCookie.txt")).get(random);

        PrintStream ps = new PrintStream(clientSocket.getOutputStream());
        BufferedReader br = new BufferedReader(new StringReader(line32));

        
        System.out.println("Wishing You Luck!");  
        ps.print(br.readLine());
        clientSocket.close();}
        catch(IOException e){e.printStackTrace(); }*/

        
    
} 
