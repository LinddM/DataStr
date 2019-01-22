import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    //Unit Testing
    @Test
    public static void UTest(){
        int sum=0;
        for(int i=1; i<=Main.N(); i++){
            sum+=i;
        }

        int actual=Main.N();

        Assertions.assertEquals(actual,sum);
    }
}