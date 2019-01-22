import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println(Main.N());
    }

    public static int N(){

        Scanner obj = new Scanner(System.in);

        //User input
        System.out.println("Enter N");
        int n=obj.nextInt();
        int cont=0;

        //Sum numbers behind N (including N)
        while(n!=0){
            cont+=n;
            n--;
        }
        return cont;
    }

}
