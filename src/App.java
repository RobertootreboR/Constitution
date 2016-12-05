import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * Created by robert on 01.12.16.
 */
public class App {

    public static void main(String[] args) {

        try {
            ParsingDetails details = new ArgumentParser().parseArguments(args);
            System.out.println(details);
            System.out.print(parseDoc(details));

        } catch (FileNotFoundException ex) {
            System.out.print(ex);
        } catch (NumberFormatException ex) {
            System.out.print("2. and optionally 3. parameter must be numbers! " + ex);
        } catch (IllegalArgumentException ex) {
            System.out.print(ex);
        } catch (IOException ex) {
            System.out.print("We have some problems with the file. Check if it's OK and try again " + ex);
            ex.printStackTrace();
        }
    }

    private static StringBuilder parseDoc(ParsingDetails details) throws IOException {
        switch (details.mode) {
            case Article:
                return new ArticleParser(details).searchForArticles();
            case Chapter:
                return new ChapterParser(details).searchForChapter();
        }
        throw new IllegalArgumentException("something is wrong with Parsing Mode!");
    }
}