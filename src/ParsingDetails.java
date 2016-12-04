import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by robert on 02.12.16.
 */

public class ParsingDetails {
    final int startWith;
    final int endWith;
    final ParsingMode mode;
    final Path filePath;

    ParsingDetails(int startWith, int endWith, ParsingMode mode, String filePath){
        this.startWith = startWith;
        this.endWith = endWith;
        this.mode =mode;
        this.filePath = Paths.get(filePath);
    }
    
    public String toString(){
        return "You've chosen to display "+mode+"(s) from " + startWith+" to " +endWith+ " from "  + filePath;
    }


}