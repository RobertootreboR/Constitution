/**
 * Created by robert on 02.12.16.
 */
public class ParsingDetails {
    final int startWith;
    final int endWith;
    final ParsingMode mode;

    ParsingDetails(int startWith, int endWith, ParsingMode mode){
        this.startWith = startWith;
        this.endWith = endWith;
        this.mode =mode;
    }
    public String toString(){
        return "You've chosen to display "+mode+"(s) from " + startWith+" to " +endWith;
    }


}