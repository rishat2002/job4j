package ru.job4j.io1;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class AnalizyTest {

    @Test
    public void unavailable() throws IOException {
        Analizy a=new Analizy();
        a.unavailable("C:\\projects\\job4j\\chapter_002\\src\\main\\java\\ru\\job4j\\io1\\log",
                "C:\\projects\\job4j\\chapter_002\\src\\main\\java\\ru\\job4j\\io1\\target.txt");
        File file = new File("C:\\projects\\job4j\\chapter_002\\src\\main\\java\\ru\\job4j\\io1\\target.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        List<String> result=new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            result.add(line);
        }
        List<String> expected=List.of("10:57:01;10:59:01","11:01:02;11:02:02");
        assertThat(result,is(expected));
    }
}