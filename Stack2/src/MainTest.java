import org.junit.jupiter.api.Test;
import java.util.Random;

class MainTest {

    Main test=new Main();

    @Test
    public void stackOverflow(){
        boolean push=true;
        while (push){
            test.choose(1);
        }
    }

    @Test
    public void elementExt(){
        int [] stack=new int[0];

        assert(test.push(stack).length!=0);
    }

    @Test
    public void FillEmpty(){
        Random rand=new Random();

        int [] stack=new int[0];
        int elements=rand.nextInt(5);

        //Fill
        while(elements>0){
            stack=test.push(stack);
            elements--;
        }

        //Empty
        Empty();

    }

    @Test
    public void Empty(){
        int [] stack=new int[5];

        while (test.pop(stack).length>0){
            stack=test.pop(stack);
        }

        assert(test.pop(stack).length==0);
    }


}