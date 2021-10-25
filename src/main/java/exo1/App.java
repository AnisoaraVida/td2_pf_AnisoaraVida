package exo1;

import static exo1.Somme.*;

public class App {

    public static void main(String[] args){
        // Q1
        System.out.println("Question 1");
        System.out.println(sommerint.sommer(1,2));
        System.out.println(sommerLong.sommer(1L,2L));
        System.out.println(sommeDouble.sommer(1.0,2.0));
        System.out.println(sommerString.sommer("1","2"));

        System.out.println("Question 2");
    }

}
