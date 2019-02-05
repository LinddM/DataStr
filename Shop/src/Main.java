public class Main {

    //Array sort by: code, name, price
    public static String [][] products = {{"ns1","shoes","150"},
            {"nc1","hoodie","90"},
            {"nc2","shorts","55"},
            {"nc3","pants","70"},
            {"nc4","leggings","65"}};

    static int op;
    static char paymentType; //'r' for card, 's' for cash
    static String cancelCode;

    //Functional program

    static Operations shop=new Operations();
    static Metrics data = new Metrics();

    public static void main(String[] args) {
        choose(op);
    }

    public static void choose(int op){
        switch (op){
            case 1:
                //Credt
                shop.credt();
                break;

            case 2:
                //Debt
                shop.debt();
                System.out.println("You purchased "+shop.purchasedI+" with "+shop.paymentType(paymentType));
                break;

            case 3:
                //Print receipt
                System.out.println("Code-Item-Price");
                for (int i=0;i<shop.cart.length; i++){
                    for (int j=0; j<3;j++){
                        System.out.print(shop.cart[i][j]+" ");
                    }
                    System.out.println("");
                }
                break;
            case 4:
                //Balance
                System.out.println("Money spent: "+shop.fmoney);
                System.out.println("To pay "+shop.toPay(shop.cart));
                break;

            case 5:
                //Average price by item, most expensive product
                System.out.println("Average price by item $"+data.avPricebyItem(shop.cart));
                System.out.println("Most expensive item: "+data.mostExpensiveItem(shop.cart));
                break;

            case 6:
                //Cancel payment
                shop.cancelDebt(cancelCode);
                break;
        }
    }
}
