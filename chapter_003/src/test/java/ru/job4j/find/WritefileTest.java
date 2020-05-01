package ru.job4j.find;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import ru.job4j.io1.Analizy;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WritefileTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();
    @Test
    public void findTest() throws IOException {
        File file = folder.newFile("target.txt");
        String[] arg = {"-d", "C:\\projects\\job4j\\chapter_003\\src\\main\\java\\ru\\job4j\\ro", "-n", ".*txt", "-r", "-o", file.getAbsolutePath()};
        String[] param = new ArgumentParse(arg).getParameter();
        FindPredicate f = new FindPredicate(param);
        new Writefile().writeFile(param[3], new FileFind(f).files(param[0], param[1]));
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            List<String> trueResult = Arrays.asList("mvn.txt", "tl.txt", "som.txt");
            String s;
            int i=0;
            while((s=br.readLine())!=null)
            {
                Assert.assertEquals(s,trueResult.get(i));
                i++;
            }
        }  catch(IOException e) {
            e.printStackTrace();
        }
    }
}
