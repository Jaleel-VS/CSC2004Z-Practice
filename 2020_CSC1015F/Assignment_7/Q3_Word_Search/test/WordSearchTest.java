import static org.junit.Assert.assertEquals;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.Test;



public class WordSearchTest {
    @Test
    public void test1() throws IOException{
        String userInput = String.format("EnglishWords.txt%sr?v?r",
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
    
        String expected = "[rover, raver, river]";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
    
        WordSearch.main(null); // call the main method
    
        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];
    
        // checkout output
        assertEquals(expected,actual);
    }

    @Test
    public void test2() throws IOException{
        String userInput = String.format("words.txt",
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
    
        String expected = "Sorry, could not find file 'words.txt'.";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
    
        WordSearch.main(null); // call the main method
    
        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];
    
        // checkout output
        assertEquals(expected,actual);
    }

    @Test
    public void test3() throws IOException{
        String userInput = String.format("EnglishWords.txt%s???bron",
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
    
        String expected = "Sorry, matches for '???bron' could not be found.";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
    
        WordSearch.main(null); // call the main method
    
        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];
    
        // checkout output
        assertEquals(expected,actual);
    }
}