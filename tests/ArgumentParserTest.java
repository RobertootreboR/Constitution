import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

/**
 * Created by robert on 05.12.16.
 */
public class ArgumentParserTest {
    @Test
    public void parseArguments() throws Exception {
        String[] ar125127 = new String[]{"/home/robert/Pobrane/obiektowe-lab-master/lab8/konstytucja.txt", "-ar", "125", "127"};
        String[] ar125 = new String[]{"/home/robert/Pobrane/obiektowe-lab-master/lab8/konstytucja.txt", "-a", "125"};
        String[] c2 = new String[]{"/home/robert/Pobrane/obiektowe-lab-master/lab8/konstytucja.txt", "-c", "2"};
        assertEquals(new ArgumentParser().parseArguments(ar125127).toString(), "You've chosen to display Article(s) from 125 to 127 from /home/robert/Pobrane/obiektowe-lab-master/lab8/konstytucja.txt");
        assertEquals(new ArgumentParser().parseArguments(ar125).toString(), "You've chosen to display Article(s) from 125 to 126 from /home/robert/Pobrane/obiektowe-lab-master/lab8/konstytucja.txt");
        assertEquals(new ArgumentParser().parseArguments(c2).toString(), "You've chosen to display Chapter(s) from 2 to 3 from /home/robert/Pobrane/obiektowe-lab-master/lab8/konstytucja.txt");


    }


    @Rule
    public final ExpectedException exception1 = ExpectedException.none();

    @Test
    public void testParametersQuantity1() throws FileNotFoundException {
        String[] ar125127 = new String[]{"/home/robert/Pobrane/obiektowe-lab-master/lab8/konstytucja.txt", "-ar", "123", "125", "126"};
        exception1.expect(IllegalArgumentException.class);
        new ArgumentParser().parseArguments(ar125127);
    }

    @Rule
    public final ExpectedException exception2 = ExpectedException.none();

    @Test
    public void testParametersQuantity2() throws FileNotFoundException {
        String[] ar1255 = new String[]{"/home/robert/Pobrane/obiektowe-lab-master/lab8/konstytucja.txt", "-ar", "123"};
        exception2.expect(IllegalArgumentException.class);
        new ArgumentParser().parseArguments(ar1255);
    }

    @Rule
    public final ExpectedException exception3 = ExpectedException.none();

    @Test
    public void testFileNotFound() throws FileNotFoundException {
        String[] ar1255 = new String[]{"/home/robert/Pobrane/obiektowe-lab-master/lab8/konstytucja.txtTT", "-ar", "123", "125"};
        exception3.expect(FileNotFoundException.class);
        new ArgumentParser().parseArguments(ar1255);
    }

    @Rule
    public final ExpectedException exception4 = ExpectedException.none();

    @Test
    public void testModifier() throws FileNotFoundException {
        String[] ar1255 = new String[]{"/home/robert/Pobrane/obiektowe-lab-master/lab8/konstytucja.txt", "-arka noego", "123"};
        exception4.expect(IllegalArgumentException.class);
        new ArgumentParser().parseArguments(ar1255);
    }

    @Rule
    public final ExpectedException exception5 = ExpectedException.none();

    @Test
    public void testFormatException() throws FileNotFoundException {
        String[] ar1255 = new String[]{"/home/robert/Pobrane/obiektowe-lab-master/lab8/konstytucja.txt", "-a", "12$3a"};
        exception5.expect(NumberFormatException.class);
        new ArgumentParser().parseArguments(ar1255);
    }

    @Rule
    public final ExpectedException exception6 = ExpectedException.none();

    @Test
    public void testOutOfRangeIllegalArgEx() throws FileNotFoundException {
        String[] ar1255 = new String[]{"/home/robert/Pobrane/obiektowe-lab-master/lab8/konstytucja.txt", "-c", "125"};
        exception6.expect(IllegalArgumentException.class);
        new ArgumentParser().parseArguments(ar1255);
    }


}