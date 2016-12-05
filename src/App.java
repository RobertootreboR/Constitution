import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * Created by robert on 01.12.16.
 */
public class App {

    public static void main(String[] args){

        ArgumentParser parser  =new ArgumentParser();
        try {
            ParsingDetails details = parser.parseArguments(args);
            System.out.println(details.toString());
            try {
                DocumentParser docParser= new DocumentParser(details);
                StringBuilder caly = docParser.searchForArticles();
                System.out.print(caly);

            }catch (IOException ex){
                System.out.print("blad!!1 "+ex);
            }

            if("lalala".matches("^[a-zA-Z]*")) {
                System.out.println("owszem");

            }



        }catch(FileNotFoundException ex){
            System.out.print(ex);
        }catch(NumberFormatException ex){
            System.out.print("2. and optionally 3. parameter must be numbers! " +ex);
        }catch(IllegalArgumentException ex){
            System.out.print(ex);
        }



    }
}