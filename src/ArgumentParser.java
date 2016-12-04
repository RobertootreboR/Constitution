import java.util.IllegalFormatException;

/**
 * Created by robert on 02.12.16.
 */
public class ArgumentParser {
    ParsingDetails parseArguments(String[] args) {
        if (args.length == 2) {
            switch (args[0]) {
                case "-a":
                    return parseArticleNum(args[1]);
                case "-c":
                    return parseChapterNum(args[1]);
                default:
                    throw new IllegalArgumentException("You passed wrong \"mode parameter\" or passed too few parameters for \"-ar\" mode");
            }
        } else if (args.length == 3 && args[0].equals("-ar"))
            return parseArticleRange(args);

        throw new IllegalArgumentException("You can only pass 2 or 3 parameters!");
    }

    private ParsingDetails parseArticleNum(String arg) {
        int start = Integer.parseInt(arg);
        if (start > 243) throw new IllegalArgumentException("Remember, that there are only 243 articles available!");
        return new ParsingDetails(start, start + 1, ParsingMode.Article);
    }

    private ParsingDetails parseArticleRange(String[] args){
        int start = Integer.parseInt(args[1]);
        int end = Integer.parseInt(args[2]);
        if (end > 243 || start >= end) throw new IllegalArgumentException("Remember, that there are only 243 articles available and third parameter is bigger than second one!");
        return new ParsingDetails(start, end, ParsingMode.Article);
    }

    private ParsingDetails parseChapterNum(String arg) {
        int start = Integer.parseInt(arg);
        if (start > 13) throw new IllegalArgumentException("Remember, that there are only 13 chapters available!");
        return new ParsingDetails(start, start + 1, ParsingMode.Chapter);

    }


}


