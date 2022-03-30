import static org.junit.Assert.assertEquals;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class BookCypherTest {
    @Test
    public void test1() throws IOException {
        String userInput = String.format(
                "ImportanceOfBeingEarnest.txt%smeet me at the usual time and place%ssecret.txt",
                System.lineSeparator(),
                System.lineSeparator());

        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String newLine = System.getProperty("line.separator");
        String expected = String.join(newLine, "BEGIN",
                "492-5",
                "129-9",
                "4-10",
                "1-1",
                "174-3",
                "71-1",
                "4-13",
                "253-6",
                "END");

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        BookCypher.main(null); // call the main method

        List<String> lines = Arrays.asList(baos.toString().split(System.lineSeparator()));

        String actual = String.join(newLine, lines.subList(3, lines.size()));

        assertEquals(expected, actual);
    }
}