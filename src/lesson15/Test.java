package lesson15;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        try {


            System.out.println(new Date());
            Thread.sleep(10000);

            System.out.println(new Date());
        }
        catch (Exception e){
            System.out.println("Exception!!!");
        }
    }

}
