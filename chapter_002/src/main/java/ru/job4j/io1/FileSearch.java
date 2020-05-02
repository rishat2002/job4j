package ru.job4j.io1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FileSearch {
    Queue<File> data = new LinkedList<>();
    List<String> filebase = new ArrayList<>();


    public void SearchFilesFullName(String source, String filenamesearch, String filetowrite) throws FileNotFoundException {
        File root = new File(source);
        data.offer(root);
        while (!data.isEmpty()) {
            File el = data.poll();
            if (!el.isDirectory()) {
                if (el.getName().equals(filenamesearch)) {
                    filebase.add(el.getAbsolutePath());
                }
            } else if (el.listFiles().length != 0) {
                for (File child : el.listFiles()) {
                    data.offer(child);
                }
            }
        }
        this.writeLogFile(filetowrite, filebase);

    }
    public void SearchFilesRegex(String source, String filenamesearch, String filetowrite) throws FileNotFoundException {
        File root = new File(source);
        data.offer(root);
        while (!data.isEmpty()) {
            File el = data.poll();
            if (!el.isDirectory()) {
                if (el.getName().matches(filenamesearch)) {
                    filebase.add(el.getAbsolutePath());
                }
            } else if (el.listFiles().length != 0) {
                for (File child : el.listFiles()) {
                    data.offer(child);
                }
            }
        }
        this.writeLogFile(filetowrite, filebase);

    }


    public void writeLogFile(String logPath, List<String> list) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new FileOutputStream(logPath));
        for (String s : list) {
            out.println(s);
        }
        out.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileSearch f = new FileSearch();
        f.SearchFilesFullName("C:\\projects\\job4j\\chapter_002\\src\\main\\java\\first", "mor.txt",
                "C:\\projects\\job4j\\chapter_002\\src\\main\\java\\ru\\job4j\\io1\\log");

    }
}
