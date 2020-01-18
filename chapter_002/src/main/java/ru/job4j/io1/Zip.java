package ru.job4j.io1;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public List<File> filesForZip(String directory, String exclude) {
        Queue<File> data = new LinkedList<>();
        List<File> filebase = new ArrayList<>();
        File root = new File(directory);
        data.offer(root);
        while (!data.isEmpty()) {
            File el = data.poll();
            if (!el.isDirectory()) {
                if (!(el.getName().matches(exclude))) {
                    filebase.add(el);
                }
            } else if (el.listFiles().length != 0) {
                for (File child : el.listFiles()) {
                    data.offer(child);
                }
            }
        }
        return filebase;
    }

    public void puck(String directory, String exclude, String output) {
        List<File> files = this.filesForZip(directory, exclude);
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(output));
        ) {
            for (File entry1 : files) {
                FileInputStream fis = new FileInputStream(entry1);
                zout.putNextEntry(new ZipEntry(entry1.getAbsolutePath()));
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                zout.write(buffer);
            }
            zout.closeEntry();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void main(String[] args) throws IOException {
        Zip zip = new Zip();
        zip.puck("C:\\projects\\job4j\\chapter_002\\src\\main\\java\\first", ".*\\.txt", "C:\\zip\\out.zip");
    }

}
