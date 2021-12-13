package day6.cookie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringReader;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Handler implements Runnable{
    private Socket clientSocket;

    public Handler(Socket socket)
    {this.clientSocket = socket;}           //changes input socket to name clientn socket in this class

    public void run()
        {
        try{double min = Math.ceil(1); double max = Math.floor(27);
        int random = (int)Math.round(Math.floor(Math.random() * (max - min) + min));
        
        //String i = String.valueOf(((Math.random()*(27-1)+1)));
        
        String line32 = Files.readAllLines(Paths.get("FortuneCookie.txt")).get(random);

        PrintStream ps = new PrintStream(clientSocket.getOutputStream());
        BufferedReader br = new BufferedReader(new StringReader(line32));
        
        System.out.println("Wishing You Luck!");  
        
        ps.print(br.readLine());}
        catch(IOException e){e.printStackTrace(); }
       
        } 

    }
