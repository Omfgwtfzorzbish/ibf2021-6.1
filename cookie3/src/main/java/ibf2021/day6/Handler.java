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
    private Socket clientSocket;
   // public String s;

    public Handler(Socket socket)
    {this.clientSocket = socket;}           //changes input socket to name clientn socket in this class

    public void run()
    {  try
        {
            InputStream is = clientSocket.getInputStream();
            OutputStream os = clientSocket.getOutputStream();
            BufferedReader br =new BufferedReader(new InputStreamReader(is));
            PrintStream ps = new PrintStream(os);

        int temp =1;
        while(temp != 1)
            {   
                ps.println("WISH YOU LUCK");
                String msg = br.readLine();
               System.out.println("Message:"+ msg);
               
            
               if(msg == "get-cookie")
                {
                    try{
                        double min = Math.ceil(1); double max = Math.floor(27);
                        int random = (int)Math.round(Math.floor(Math.random() * (max - min) + min));
                        
                        //String i = String.valueOf(((Math.random()*(27-1)+1)));
                        
                        String line32 = Files.readAllLines(Paths.get("src/main/java/ibf2021/day6/FortuneCookie.txt")).get(random);
                
                       
                        BufferedReader br2 = new BufferedReader(new StringReader(line32));
                        
                        ps.print("Wishing You Luck!");  
                        ps.print(br2.readLine());
                        }
                        catch(IOException e){e.printStackTrace(); }
                

                }else if( msg == "exit")
                { temp=1; clientSocket.close(); br.close(); return; }
            }
            
        } catch (IOException e){e.printStackTrace();}
        
                

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
} 
