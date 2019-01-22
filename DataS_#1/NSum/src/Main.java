import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

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

        //Print result
        System.out.println(cont);
    }
}
