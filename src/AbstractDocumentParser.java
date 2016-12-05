import java.nio.file.Path;

/**
 * Created by robert on 05.12.16.
 */
abstract class AbstractDocumentParser {
    protected boolean savingMode;
    protected boolean notFinishedYet;
    protected String startArticle;
    protected String endArticle;
    protected Path filePath;
    protected String mode;

    protected AbstractDocumentParser(ParsingDetails details) {
        this.savingMode = false;
        this.notFinishedYet = true;
        this.filePath = details.filePath;
    }


    protected boolean ifSavingMode(String e) {
        if (e.startsWith(mode + startArticle)) savingMode = true;
        if (e.startsWith(mode + endArticle)) notFinishedYet = false;
        return (savingMode && notFinishedYet);
    }

    protected static String formatLine(String s) {
        if (!s.endsWith("-"))
            return s + "\n";
        else {
            StringBuilder line = new StringBuilder(s);
            line.deleteCharAt(line.length() - 1);         // deleting the '-' from the end of a line
            int lastSpace = line.lastIndexOf(" ");       // finding last occurence of 'space', which is before the last word
            line.setCharAt(lastSpace, '\n');             // replacing that space with new line
            return new String(line);
        }
    }

}

