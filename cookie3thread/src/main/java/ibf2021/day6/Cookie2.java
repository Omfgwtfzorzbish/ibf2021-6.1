package ibf2021.day6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Cookie2{
    public Cookie2(){};

    public String getCookie(String s)throws IOException{
        double min = Math.ceil(1); double max = Math.floor(27);
            int random = (int)Math.round(Math.floor(Math.random() * (max - min) + min));
            String line32 = Files.readAllLines(Paths.get("src/main/java/ibf2021/day6/"+s)).get(random);
            return line32;
    }
    
}
