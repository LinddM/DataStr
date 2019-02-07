import java.net.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws Exception {


        //URL lorem = new URL("https://loremipsum.io");
        File lorem = new File("Filename");
        BufferedReader in = new BufferedReader(new FileReader(lorem));

        String inputLine, text = "";
        while ((inputLine = in.readLine()) != null)
            text+=inputLine;
        in.close();

        char [] charArray = text.toCharArray();

        Characters data = new Characters();

        for (int i=0; i<data.dictionary(charArray).length; i++){
            if(data.dictionary(charArray)[i].repeatedTimes>1){
                System.out.print(data.dictionary(charArray)[i]);
            }
        }

    }

}
