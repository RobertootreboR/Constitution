import java.io.IOException;
import java.nio.file.Files;

/**
 * Created by robert on 02.12.16.
 */
class ArticleParser extends AbstractDocumentParser {


    ArticleParser(ParsingDetails details) {
        super(details);
        this.mode = "Art. ";
        this.startArticle = details.startWith.toString();
        this.endArticle = details.endWith.toString();
    }

    StringBuilder searchForArticles() throws IOException {
        return new StringBuilder(
                Files.lines(filePath)
                        .filter(e -> (ifSavingMode(e)
                                && !ifAllUpperCase(e)
                                && !e.equals("©Kancelaria Sejmu")
                                && !e.startsWith("Rozdział")))
                        .map(AbstractDocumentParser::formatLine)
                        .reduce("", String::concat)
        );
    }

    private static boolean ifAllUpperCase(String s) {   // dates and other numeric strings return true!
        for (char c : s.toCharArray())
            if (Character.isLetter(c) && Character.isLowerCase(c))
                return false;

        return true;
    }

}