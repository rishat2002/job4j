package ru.job4j.сondition;

import ru.job4j.io1.Consolechat;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class Exp2 {
    public void writeLogFile(File file, List<String> list) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new FileOutputStream(file));
        for (String s : list) {
            out.println(s);
        }
        out.close();
    }
    public static void main(String[] args) throws IOException {
        File file=new File("C:\\projects\\job4j\\chapter_002\\src\\main\\java\\API\\rom.txt");
        file.createNewFile();
    }

}
