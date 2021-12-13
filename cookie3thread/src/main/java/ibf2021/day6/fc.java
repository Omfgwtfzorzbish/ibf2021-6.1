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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class fc 
{
    
    public static void main(String[] args) throws IOException 
    { Socket socket; ServerSocket serverSocket; 
      String cookie = "FortuneCookie.txt";  //"src/main/java/ibf2021/day6/FortuneCookie.txt"
  
    if(args != null && args.length >=1)
            {cookie = args[0];}
            else{System.out.println("System will use FortuneCookie.txt");}
        
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        serverSocket = new ServerSocket(12345);
        System.out.println("listening at port 12345... ...");
        try{
          while(true){
            socket=serverSocket.accept();
            int id = (int) (Math.random()*100);
            Handler worker = new Handler(socket,id,cookie);
            threadPool.submit(worker);
          }
        }finally{serverSocket.close();}

    }
}
