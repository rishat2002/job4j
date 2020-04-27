package ru.job4j.find;

import org.apache.logging.log4j.core.util.JsonUtils;
import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Writefile {

    public void writeFile(String path, List<File> f) {
        try (FileWriter writer = new FileWriter(path)) {
            f.stream().forEach(x -> {
                try {
                    writer.write(x.getName());
                    writer.write(System.getProperty("line.separator"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            writer.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String[]param=new ArgumentParse(args).getParameter();
        FindPredicate f=new FindPredicate(param);
        new Writefile().writeFile(param[3],new FileFind(f).files(param[0],param[1]));
    }
}
