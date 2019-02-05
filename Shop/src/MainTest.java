import org.junit.jupiter.api.Test;

class MainTest {

    static Main shop=new Main();
    static Operations backshop= new Operations();

    @Test
    void buyItem(){
        int buy=0;
        while(buy<10){
            shop.choose(1);
            buy++;
        }

    }

    @Test
    void pay(){
        buyItem();
        int pay=0;
        shop.paymentType='r';
        while(pay<5){
            shop.choose(2);
            pay++;
        }
    }

    @Test
    void balance(){
        buyItem();
        //Show items
        shop.choose(3);
        //Buy an item
        shop.choose(2);
        //Show remaining items
        shop.choose(3);
        //Show balance
        shop.choose(4);
    }

    @Test
    //Buy 2 items and show the most expensive one and the average price by item
    void purchaseMetrics(){
        shop.choose(1);
        shop.choose(1);
        shop.choose(3);
        shop.choose(5);
    }

    @Test
    //Cancel payments 2 and 4
    void failPayments(){
        int buy=0;
        while(buy<5){
            shop.choose(1);
            buy++;
        }
        int pay=0;
        while(pay<4){
            shop.choose(2);
            pay++;
        }

        shop.choose(3);

        shop.cancelCode=backshop.deletedItems[1][0];
        shop.choose(6);

        shop.cancelCode=backshop.deletedItems[3][0];
        shop.choose(6);

        shop.choose(3);


    }

}