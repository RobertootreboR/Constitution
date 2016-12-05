import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by robert on 02.12.16.
 */
public class DocumentParser {
    private boolean savingMode;
    private boolean notFinishedYet;
    private String startArticle;
    private String endArticle;
    private Path filePath;
    private String mode;


    DocumentParser(ParsingDetails details){
        this.savingMode =false;
        this.notFinishedYet = true;
        this.filePath=details.filePath;
        switch(details.mode){
            case Article:
                this.mode="Art. ";
                this.startArticle=details.startWith.toString();
                this.endArticle=details.endWith.toString();
                break;
            case Chapter:
                this.mode= "Rozdział ";
                this.startArticle=details.fromRomanToString(details.startWith);
                this.endArticle=details.fromRomanToString(details.endWith);

        }
    }

    StringBuilder searchForArticles() throws IOException {
        return new StringBuilder(
                Files.lines(filePath)
                        .filter(e -> ifSavingMode(e))
                        .map(e -> e + "\n")
                        .reduce("", String::concat)
        );
    }

    private boolean ifSavingMode(String e) {
        if(e.startsWith(mode+startArticle)) savingMode=true;
        if(e.startsWith(mode+endArticle)) notFinishedYet =false;
            return (savingMode && notFinishedYet);
    }


}