import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by robert on 02.12.16.
 */
class ArgumentParser {

    ParsingDetails parseArguments(String[] args) throws FileNotFoundException {
        if (args.length < 3 || args.length > 4)
            throw new IllegalArgumentException("You have to pass 3 or 4 parameters!");

        if (!Files.exists(Paths.get(args[0])))
            throw new FileNotFoundException("Such a file doesn't exist! Check if you wrote everything correctly");

        if (args.length == 3) {
            switch (args[1]) {
                case "-a":
                    return parseArticleNum(args);
                case "-c":
                    return parseChapterNum(args);
                default:
                    throw new IllegalArgumentException("You passed wrong modifier or passed too few parameters for the \"-ar\" mode");
            }
        } else if (args[1].equals("-ar"))
            return parseArticleRange(args);
        else throw new IllegalArgumentException("Modifier which you've passed isn't valid.Try again.");
    }


    private ParsingDetails parseArticleNum(String[] args) {
        int start = Integer.parseInt(args[2]);
        if (start > 243 || start < 1)
            throw new IllegalArgumentException("Remember, that there are only 243 articles available!");
        return new ParsingDetails(start, start + 1, ParsingMode.Article, args[0]);
    }

    private ParsingDetails parseArticleRange(String[] args) {
        int start = Integer.parseInt(args[2]);
        int end = Integer.parseInt(args[3]);
        if (start < 1 || end > 243 || start >= end)
            throw new IllegalArgumentException("Remember, that there are only 243 articles available and the third parameter is bigger than the second one!");
        return new ParsingDetails(start, end, ParsingMode.Article, args[0]);
    }

    private ParsingDetails parseChapterNum(String[] args) {
        int start = Integer.parseInt(args[2]);
        if (start < 1 || start > 13)
            throw new IllegalArgumentException("Remember, that there are only 13 chapters available!");
        return new ParsingDetails(start, start + 1, ParsingMode.Chapter, args[0]);

    }


}


