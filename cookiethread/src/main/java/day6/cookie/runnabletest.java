package day6.cookie;

public class runnabletest {
    public static void main(String[] args) {
        Runnable r1 = () -> {
            for(int i=0;i<50;i++){
            System.out.println("First!");
        };
        new Thread(r1).start();

        new Thread( () -> {
            for(int i = 0; i<50; i++)
            System.out.println("Second");}).start();
/*
        new Thread(new Runnable() {public void run(){
            for (int i = 0; i<50; i++)
            system.out.println("Second");
        }})
        }) */
    }
}
