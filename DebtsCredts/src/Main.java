import java.util.Random;
public class Main {


    static int op, code;

    static Random rand= new Random();

    static char type;

    static Transaction t;
    static Operations operation = new Operations();


    public static void main(String[] args) {

        option(op);

    }

    static void option(int op){

            switch (op){
                case 1:
                    //add debt or credt
                    int amount=rand.nextInt((10000-500)+1)+500;

                    if (type=='c'){
                        if (operation.availableC<5){
                            t=new Transaction(generateCode(),amount, type);
                            operation.add(t);
                        }else{
                            System.out.println("Full credits");
                        }
                    }
                    if (type=='d'){
                        if (operation.availableC<10) {
                            t=new Transaction(generateCode(),amount, type);
                            operation.add(t);
                        }else{
                            System.out.println("Full debits");
                        }
                    }

                    break;

                case 2:
                    //show debit, credit and total
                    System.out.println("Total Credits: "+operation.TotalC());
                    System.out.println("Total Debits: "+operation.TotalD());
                    System.out.println("Balance: "+ (operation.TotalD()-operation.TotalC()));

                    break;

                case 3:
                    //show average credits and debts
                    System.out.println("Average credits "+operation.averageC());
                    System.out.println("Average debits "+operation.averageD());

                    break;

                case 4:
                    //Max debts or credts
                    System.out.println("Max credit "+operation.maxC());
                    System.out.println("Max debit "+operation.maxD());
                    break;

                case 5:
                    //debts and credts count
                    System.out.println("Debit count "+operation.countD);
                    System.out.println("Credit count "+operation.countC);

                    break;

                case 6:
                    //Print arrays
                    Carray(operation);
                    Darray(operation);
                    break;

                case 7:
                    if (type=='c'){
                        if (operation.availableC>0){
                            operation.delete(code, type);
                        }else{
                            System.out.println("Empty credits");
                        }
                    }
                    if (type=='d'){
                        if (operation.availableC>0) {
                            operation.delete(code, type);
                        }else{
                            System.out.println("Empty debits");
                        }
                    }

                    break;
                    default:
                        break;
            }
    }

    static int generateCode(){
        Random rand=new Random();
        int code=rand.nextInt((50-10)+1)+10;
        return code;
    }

    static void Carray(Operations operation){
        if (operation.availableC>0){
            System.out.println("Amount  Code");
            for (int i=0; i<5; i++){
                if(operation.credt[i]==null){
                    System.out.println("0   0");
                }else {
                    System.out.println(operation.credt[i].amount+"  "+operation.credt[i].code);
                }
            }

        }else{
            System.out.println("Empty credits");
        }
    }

    static void Darray(Operations operation){
        if (operation.availableD>0){
            System.out.println("Amount  Code");
            for (int i=0; i<10; i++){
                if(operation.debt[i]==null){
                    System.out.println("0   0");
                }else {
                    System.out.print(operation.debt[i].amount + "  " + operation.credt[i].code);
                }
            }
        }else{
            System.out.println("Empty debits");
        }
    }
}
