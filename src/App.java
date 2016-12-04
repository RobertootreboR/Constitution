import java.io.FileNotFoundException;


/**
 * Created by robert on 01.12.16.
 */
public class App {

    public static void main(String[] args){

        ArgumentParser parser  =new ArgumentParser();
        try {
            ParsingDetails details = parser.parseArguments(args);
            System.out.print(details.toString());
        }catch(FileNotFoundException ex){
            System.out.print(ex);
        }catch(NumberFormatException ex){
            System.out.print("2. and optionally 3. parameter must be numbers! " +ex);
        }catch(IllegalArgumentException ex){
            System.out.print(ex);
        }


    }
}