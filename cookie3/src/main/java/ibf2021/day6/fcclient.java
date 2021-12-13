package ibf2021.day6;


import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.rmi.UnknownHostException;
import java.util.Scanner;

public class fcclient {
    
    public static void main(String[] args) throws UnknownHostException, IOException
    {

        Socket socket = new Socket("localhost",12345);
        BufferedReader br =new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
        System.out.println("connected succesfully");
        Scanner scan = new Scanner(System.in);
        String svrMsg = "";
        String line = scan.nextLine();

        while(line!="close"){
            pw.println(line);
            pw.flush();
                svrMsg= br.readLine();    
            System.out.println("Server:" + svrMsg);
            line=scan.nextLine();
        }
        scan.close();
        socket.close();
        return;
    }
}