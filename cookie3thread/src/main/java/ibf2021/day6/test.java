package ibf2021.day6;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class test {
    public static void main(String[] args) {
        File file = new File("C:/Users/Fernep/Desktop/TFIP ASSIGN/day 6/ibf2021-day6/cookie3/src/main/java/ibf2021/day6/FortuneCookie.txt");
        boolean exists = file.exists();
        if (file.exists() && file.isFile())
        {
          System.out.println("file exists, and it is a file");
        }
        String f = Paths.get("FortuneCookie.txt").toString();
        System.out.println(f);

       try{
        String line32 = Files.readAllLines(Paths.get("src/main/java/ibf2021/day6/FortuneCookie.txt")).get(2);
        System.out.println(line32);
       }catch(IOException e){System.err.println("l");};
        
       
    }
}
