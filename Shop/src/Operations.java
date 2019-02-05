import java.util.Random;
public class Operations {

    static Main items = new Main();
    static Random rand = new Random();

    public String [][] cart=new String[0][3];
    public int fmoney;
    public String purchasedI;
    public String [][]deletedItems=new String [0][3];

    public void credt(){
        int item=rand.nextInt(5);
        String code=items.products[item][0];
        cart=addItem(cart, code);
    }

    public void debt(){
        purchasedI=cart[cart.length-1][1];
        cart=deleteItem(cart,purchasedI);
        fmoney+=Integer.parseInt(findProductPrice(purchasedI));
        deletedItems=addItem(deletedItems, cart[cart.length-1][0]);
    }

    public void cancelDebt(String code){
        String pName=findProductName(code);
        deletedItems=deleteItem(deletedItems, pName);
        cart=addItem(cart, code);
    }

    public int toPay(String [][] cart){
        int prices=0;
        for(int j=0; j<cart.length; j++){
            prices+=Integer.parseInt(cart[j][2]);
        }
        return prices;
    }


    public String [][] deleteItem(String [][] oldCart, String itemToBuy){
        String [][] newCart=new String[oldCart.length-1][3];
        int oldCarti=0, newCarti=0;

        for (int i=0; i<oldCart.length; i++){
            if (oldCart[i][1].equals(itemToBuy)){
                oldCart[i]=null;
                break;
            }
        }

        //Rearrange array
        while (oldCarti<oldCart.length){
            if(oldCart[oldCarti]!=null){
                newCart[newCarti][0]=oldCart[oldCarti][0];
                newCart[newCarti][1]=oldCart[oldCarti][1];
                newCart[newCarti][2]=oldCart[oldCarti][2];
            }else{
                newCarti--;
            }
            newCarti++;
            oldCarti++;
        }

        return newCart;
    }


    public String [][] addItem(String [][] oldCart, String code){
        String [][] newCart=new String[oldCart.length+1][3];
        for (int i=0;i<oldCart.length; i++){
            for (int j=0; j<3;j++){
                newCart[i][j]=oldCart[i][j];
            }
        }

        newCart[newCart.length-1][0]=code;
        newCart[newCart.length-1][1]=findProductName(code);
        newCart[newCart.length-1][2]=findProductPrice(findProductName(code));

        return newCart;
    }


    public String findProductName(String code){
        String pName="";
        for (int i=0; i<items.products.length; i++){
            if (items.products[i][0].equals(code)){
                pName=items.products[i][1];
                break;
            }
        }
        return pName;
    }

    public String findProductPrice(String productN){
        String pPrice="";
        for (int i=0; i<items.products.length; i++){
            if (items.products[i][1].equals(productN)){
                pPrice=items.products[i][2];
                break;
            }
        }
        return pPrice;
    }


    public String paymentType(char type){
        String pType;
        if (type=='r'){
            pType="card";
        }else{
            pType="cash";
        }
        return pType;
    }


}
