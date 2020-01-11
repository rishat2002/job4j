package ru.job4j.io1;

import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

public class SearchTest {
    Search txtsearch=new Search();
    @Test
    public void files() {
        List<String> listExts=List.of("txt","fxml");
        List<File>newlist=txtsearch.files("C:\\projects\\job4j\\chapter_002\\src\\main\\java\\first",listExts);
        for (File file:newlist) {
            System.out.println(file.getName());
        }
    }
}