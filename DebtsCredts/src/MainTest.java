import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MainTest {

    Main test=new Main();
    Operations data = new Operations();

    @Test
    public void addCredit(){
        for (int i=0; i<5; i++){
            test.type='c';
            test.option(1);
        }
        assert(data.credt!=null);
    }

    @Test
    public void addDebit(){
        for (int i=0; i<10; i++){
            test.type='d';
            test.option(1);
        }
        assert(data.debt!=null);
    }

    @Test
    public void show(){
        test.option(2);
    }

    @Test
    public void average(){
        test.option(3);
    }

    @Test
    public void max(){
        test.option(4);
    }

    @Test
    public void count(){
        test.option(5);
    }

    @Test
    public void showArrays(){
        test.option(6);
    }

    @Test
    public void deleteCredit(){
        addCredit();

        test.type='c';

        test.option(7);
        test.code=data.debt[3].code;
        assert(data.debt[3]==null);

        test.option(7);
        test.code=data.debt[5].code;
        assert(data.debt[5]==null);

        test.option(7);
        test.code=data.debt[7].code;

    }
}