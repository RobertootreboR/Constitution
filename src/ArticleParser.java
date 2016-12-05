import java.io.IOException;
import java.nio.file.Files;

/**
 * Created by robert on 02.12.16.
 */
public class ArticleParser extends AbstractDocumentParser{



    ArticleParser(ParsingDetails details){
        super(details);
        this.mode="Art. ";
        this.startArticle=details.startWith.toString();
        this.endArticle=details.endWith.toString();

        /*t
            case Chapter:
                this.mode= "Rozdział ";
                this.startArticle=details.fromRomanToString(details.startWith);
                this.endArticle=details.fromRomanToString(details.endWith);*/


    }

    StringBuilder searchForArticles() throws IOException {
        return new StringBuilder(
                Files.lines(filePath)
                        .filter(e -> (ifSavingMode(e) && !isAllUpperCase(e) && !e.equals("©Kancelaria Sejmu")))
                        .map(e -> e + "\n")
                        .reduce("", String::concat)
        );
    }

    private static boolean isAllUpperCase(String s) {   // dates and other numeric strings return true!
        for(char c : s.toCharArray())
            if(Character.isLetter(c) && Character.isLowerCase(c))
                return false;

        return true;
    }




}