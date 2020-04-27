package ru.job4j.find;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FileFind {
    private  FindPredicate findPredicate;

    public FileFind(FindPredicate findPredicate) {
        this.findPredicate = findPredicate;
    }
    public List<File> files(String directory, String filename) {
        Queue<File> data = new LinkedList<>();
        List<File> filebase = new ArrayList<>();
        File root = new File(directory);
        data.offer(root);
        while (!data.isEmpty()) {
            File el = data.poll();
            if (!el.isDirectory() ) {
                if (findPredicate.findMethod().compareString(el.getName(),filename)){
                    filebase.add(el);}
            } else if (el.listFiles().length != 0) {
                for (File child : el.listFiles()) {
                    data.offer(child);
                }
            }
        }
        return filebase;
    }

    public static void main(String[] args) {
    }
}
