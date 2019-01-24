import java.util.Random;
import java.util.Scanner;
public class Stack {

    //Set an array length. Push random numbers, Pop last element or Delete all elements

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random rand=new Random();

        int op, stackFill=0;

        System.out.println("Enter stack length");
        int stackLength=input.nextInt();

        int stack[]=new int[stackLength];


        do{
            System.out.println("\n1. Push\n2. Pop\n3. Delete\n4. Stack\n0. Exit");
            op=input.nextInt();

            switch(op){

                case 1:
                    if(stackFill==stackLength){
                        System.out.println("Full Stack, choose Pop or Delete");
                        break;

                    }else {
                        int element = rand.nextInt((9-1)+1);
                        Push(element, stackFill, stack);
                        stackFill++;
                    }

                    break;

                case 2:
                    if(stackFill==0){
                        System.out.println("Empty Stack, choose Push");
                        break;
                    }else {
                        Pop(stackFill, stack);
                        stackFill--;
                    }

                    break;

                case 3:
                    Delete(stack);
                    stackFill=0;

                    break;

                case 4:
                    for (int i=0; i<stackLength; i++){
                        System.out.print(stack[i]+" ");
                    }

                    break;
            }

        }while(op!=0);

    }

    public static void Push (int element, int stackFill, int[] stack){
        stack[stackFill]=element;
    }

    public static void Pop(int stackFill, int[] stack){
        stack[stackFill-1]=0;
    }

    public static void Delete(int [] stack){
        for (int i=0; i<stack.length; i++){
            stack[i]=0;
        }
    }
}