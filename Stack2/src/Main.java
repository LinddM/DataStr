import java.util.Random;
public class Main {

    static Random rand= new Random();

    public static void main(String[] args) {

        int op=rand.nextInt((4-1)+1)+1;

        choose(op);

    }

    public static void choose(int op){
        int [] stack=new int[0];
        do{
            switch (op){
                case 1:
                    //Push
                    stack=push(stack);
                    break;

                case 2:
                    //Pop
                    if (stack.length>=1){
                        stack=pop(stack);
                    }else{
                        break;
                    }
                    break;

                case 3:
                    while(stack.length>0){
                    stack=pop(stack);
                    }

                    break;

                default:
                    break;
            }

            op=rand.nextInt((4-1)+1)+1;
        }while(op!=4);
    }

    public static int[] push(int [] oldStack){
        int [] newStack= new int [oldStack.length+1];

        for(int i=0;i<oldStack.length; i++){
            newStack[i]=oldStack[i];
        }
        newStack[newStack.length-1]=rand.nextInt((9)+1);

        return newStack;
    }

    static int [] pop(int [] stack){
        int [] newStack= new int [stack.length-1];

        for(int i=0;i<newStack.length; i++){
            newStack[i]=stack[i];
        }
        return newStack;
    }

}
