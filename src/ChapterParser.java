import java.io.IOException;
import java.nio.file.Files;

/**
 * Created by robert on 05.12.16.
 */
public class ChapterParser extends AbstractDocumentParser {

    ChapterParser(ParsingDetails details){
        super(details);
        this.mode= "Rozdział ";
        this.startArticle=details.fromRomanToString(details.startWith);
        this.endArticle=details.fromRomanToString(details.endWith);
    }

    StringBuilder searchForChapter() throws IOException {
        return new StringBuilder(
                Files.lines(filePath)
                        .filter(e -> (ifSavingMode(e) && !isNumeric(e) && !e.equals("©Kancelaria Sejmu")))
                        .map(e -> e + "\n")
                        .reduce("", String::concat)
        );
    }
    private static boolean isNumeric(String s){
        for(char c : s.toCharArray())
            if(Character.isLetter(c)) return false;
        return true;
    }
}
