public class Metrics{

    Operations shop=new Operations();


    public int avPricebyItem(String cart[][]){
        int av=0;
        for (int i=0;i<cart.length; i++){
            av+=Integer.parseInt(cart[i][2]);
        }
        av/=cart.length;
        return av;
    }

    public String mostExpensiveItem(String cart[][]){
        String item="";
        int first=Integer.parseInt(cart[0][2]);
        item=cart[0][1];
        for (int i=1;i<cart.length; i++){
            if (Integer.parseInt(cart[i][2])>first){
                first=Integer.parseInt(cart[i][2]);
                item=cart[i][1];
            }
        }

        return item;
    }



}
