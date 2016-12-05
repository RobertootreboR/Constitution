import java.nio.file.Path;

/**
 * Created by robert on 05.12.16.
 */
public abstract class AbstractDocumentParser {
    protected boolean savingMode;
    protected boolean notFinishedYet;
    protected String startArticle;
    protected String endArticle;
    protected Path filePath;
    protected String mode;

    AbstractDocumentParser(ParsingDetails details){
        this.savingMode =false;
        this.notFinishedYet = true;
        this.filePath=details.filePath;
        switch(details.mode){
            case Article:

                break;
            case Chapter:
                this.mode= "Rozdział ";
                this.startArticle=details.fromRomanToString(details.startWith);
                this.endArticle=details.fromRomanToString(details.endWith);

        }
    }



    protected boolean ifSavingMode(String e) {
        if(e.startsWith(mode+startArticle)) savingMode=true;
        if(e.startsWith(mode+endArticle)) notFinishedYet =false;
        return (savingMode && notFinishedYet);
    }
}
