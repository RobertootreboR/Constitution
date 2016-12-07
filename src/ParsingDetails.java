import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by robert on 02.12.16.
 */

class ParsingDetails {
    final Integer startWith;
    final Integer endWith;
    final ParsingMode mode;
    final Path filePath;
    String[] romanDigits = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV"};


    ParsingDetails(int startWith, int endWith, ParsingMode mode, String filePath) {
        this.startWith = startWith;
        this.endWith = endWith;
        this.mode = mode;
        this.filePath = Paths.get(filePath);
    }

    public String toString() {
        return "You've chosen to display " + mode + "(s) from " + startWith + " to " + endWith + " from " + filePath;
    }

    String fromRomanToString(Integer x) {
        return romanDigits[x - 1];
    }


}