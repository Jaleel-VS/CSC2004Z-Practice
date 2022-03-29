import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordSearch {

    Scanner input = new Scanner(System.in);
    boolean wordFileFound = false;
    String wordFilePath;
    List<String> words;
    List<String> wordsFound = new ArrayList<>();
    SimpleMatch s = new SimpleMatch();

    String START_MESSAGE = "***** Word Search *****";
    String FILE_PROMPT = "Enter the name of the words file:";
    String SEARCH_PROMPT = "Enter a search pattern:";
    String FILE_NOT_FOUND = "Sorry, could not find file '%s'.%n";
    String MATCH_NOT_FOUND = "Sorry, matches for '%s' could not be found.%n";
    
    public void createWordsList(String path) throws IOException {
        wordFilePath = path;

        if (fileFound(path)) {
            wordFileFound = true;
            List<String> rawFile = Files.readAllLines(Paths.get(path));
            words = rawFile.subList(rawFile.indexOf("START"), rawFile.size());
        }
        
    }

    public void run() throws IOException {
        System.out.println(START_MESSAGE);
        System.out.println(FILE_PROMPT);

        String wordsFile = input.nextLine();
        createWordsList(wordsFile);

        if (wordFileFound) {
            System.out.println(SEARCH_PROMPT);
            String pattern = input.nextLine();
            getMatchingWords(pattern);

            if (wordsFound.size() == 0) {
                System.out.printf(MATCH_NOT_FOUND, pattern);
            }

            else {
                System.out.println(wordsFound);
            }
        }

        else {
            System.out.printf(FILE_NOT_FOUND, wordFilePath);
        }


    }

    private void getMatchingWords(String pattern) {
        for (String word: words) {
            if (s.doesMatch(pattern, word)) {
                wordsFound.add(word);
            }
        }
    }

    public boolean fileFound(String fileName) {
        List<String> files = Stream.of(new File(".").listFiles(File::isFile))
                                            .map(f -> f.toString().substring(2))
                                            .collect(Collectors.toList());

        return files.contains(fileName);
    }
public static void main(String[] args) throws IOException {
    WordSearch wws = new WordSearch();
    wws.run();
}



}
