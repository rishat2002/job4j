import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import ru.job4j.io1.Analizy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AnalizyTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void AnalizyTest() throws IOException {
        Analizy a = new Analizy();
        File file = folder.newFile("target.txt");
        File file1 = folder.newFile("source.txt");
        try(FileWriter writer = new FileWriter(file1.getAbsolutePath()))
        {
            // запись всей строки
            String text = "200 10:56:01\n" +
                    "500 10:57:01\n" +
                    "400 10:58:01\n" +
                    "200 10:59:01\n" +
                    "500 11:01:02\n" +
                    "200 11:02:02";
            writer.write(text);
            // запись по символам
            writer.append('\n');
            writer.append('E');

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        a.unavailable(file1.getAbsolutePath(),
                file.getAbsolutePath());
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        List<String> result = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            result.add(line);
        }
        List<String> expected = List.of("10:57:01;10:59:01", "11:01:02;11:02:02");

    }
}
