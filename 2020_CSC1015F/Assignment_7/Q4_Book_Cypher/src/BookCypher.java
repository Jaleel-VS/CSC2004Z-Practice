import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookCypher {

    HashMap<String, String> words = new HashMap<String, String>();
    Scanner scanner = new Scanner(System.in);
    FileWriter outputFile;

    public void createHashMap(String fileName) {
        int lines = 1;
        int wordPosition = 0;

        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                for (String word : line.split("\\s+")) {
                    wordPosition++;
                    String strippedWord = strip(word);

                    if (!words.containsKey(strippedWord) && !word.equals("")) {
                        words.put(strippedWord,
                                String.format("%d-%d", lines, wordPosition));
                    }
                }

                wordPosition = 0;

                lines++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private String strip(String s) {
        return s.replaceAll("\\p{Punct}|\\n", "").toLowerCase();
    }

    public void UserInterface() throws IOException {
        String BOOK_PROMPT = "Enter the book filename:";
        String MESSAGE_PROMPT = "Enter the message:";
        String OUTPUT_PROMPT = "Enter the output filename:";

        System.out.println(BOOK_PROMPT);
        String book = scanner.nextLine();

        System.out.println(MESSAGE_PROMPT);
        String message = scanner.nextLine();

        System.out.println(OUTPUT_PROMPT);
        String output = scanner.nextLine();

        if (fileFound(book)) {
            createHashMap(book);
            String secretMessage = getSecretMessage(message);
            outputFile = new FileWriter(output, false);
            outputFile.write(secretMessage);
            outputFile.close();
        }

        else {
            System.out.println("Book not found");
        }

    }

    private String getSecretMessage(String message) {
        StringBuilder sb = new StringBuilder();
        System.out.println("BEGIN");
        sb.append("BEGIN\n");

        for (String s : message.split(" ")) {
            String val = words.get(s);
            if (val == null) {
                sb.append(s + "\n");
                System.out.println(s);
            }

            else {
                sb.append(val + "\n");
                System.out.println(val);
            }
        }
        System.out.println("END");
        sb.append("END");

        return sb.toString();
    }

    public boolean fileFound(String fileName) {
        List<String> files = Stream.of(new File(".").listFiles(File::isFile))
                .map(f -> f.toString().substring(2))
                .collect(Collectors.toList());

        return files.contains(fileName);
    }

    public static void main(String[] args) throws IOException {
        BookCypher bCypher = new BookCypher();
        bCypher.UserInterface();
    }

}
