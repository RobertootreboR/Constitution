import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by robert on 02.12.16.
 */

public class ParsingDetails {
    final Integer startWith;
    final Integer endWith;
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
    String fromRomanToString(Integer x){
        switch(x){
            case 1: return "I";
            case 2: return "II";
            case 3: return "III";
            case 4: return "IV";
            case 5: return "V";
            case 6: return "VI";
            case 7: return "VII";
            case 8: return "VIII";
            case 9: return "IX";
            case 10: return "X";
            case 11: return "XI";
            case 12: return "XII";
            case 13: return "XIII";
        }
        throw new IllegalArgumentException("this function converts only numbers from 1 to 13.");
    }


}