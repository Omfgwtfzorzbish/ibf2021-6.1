package day6.miniProject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Arrlist {
    Set <String> set = new HashSet<String>();

    public void addSet(String s){
        set.add(s);
    }

    public Boolean setContatin(String s){
        Boolean x =set.contains(s);
        System.out.println("true");
        return x;
    }
    public void getAll(){
        for(String x : set){
       System.out.println(x);}
    }

    public void setRemove(String s){
        List<String> setList = new ArrayList<String>();
        for(String x : set)
        {setList.add(x);
            if(x.equals(s))
            {setList.remove(setList.indexOf(s));}
        }
    }
    public void get (int i){
        List<String> setList = new ArrayList<String>();
        for(String x : set)
        {setList.add(x);}
        
        if(i <= setList.size()){System.out.println(setList.get(i));} else{System.err.println("out of bounds");}
    }

    
}
