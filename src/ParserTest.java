import org.junit.Assert;

import static org.junit.Assert.*;

/**
 * Created by robert on 05.12.16.
 */
public class ParserTest {
    @org.junit.Test
    public void main() {
        String[] ar125127 = new String[] {"/home/robert/Pobrane/obiektowe-lab-master/lab8/konstytucja.txt", "-ar", "125", "127"};
        String[] a125 = new String[] {"/home/robert/Pobrane/obiektowe-lab-master/lab8/konstytucja.txt", "-a", "125"};
        String[] c2 = new String[] {"/home/robert/Pobrane/obiektowe-lab-master/lab8/konstytucja.txt", "-c", "2"};

        try{
            assertEquals(new ArgumentParser().parseArguments(ar125127).toString(),"You've chosen to display Article(s) from 125 to 127 from /home/robert/Pobrane/obiektowe-lab-master/lab8/konstytucja.txt");
            assertEquals(new ArgumentParser().parseArguments(a125).toString(),"You've chosen to display Article(s) from 125 to 126 from /home/robert/Pobrane/obiektowe-lab-master/lab8/konstytucja.txt");
            assertEquals(new ArgumentParser().parseArguments(c2).toString(),"You've chosen to display Chapter(s) from 2 to 3 from /home/robert/Pobrane/obiektowe-lab-master/lab8/konstytucja.txt");

        }catch(Exception ex ){
            System.out.print("En exception has been caught. Something's wrong then :( " +ex);
        }

    }

}