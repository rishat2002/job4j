package ru.job4j.io1;

import ru.job4j.LearnSet.Node;

import java.io.File;
import java.util.*;

public class Search {

    public List<File> files(String parent, List<String> ext){
        Queue<File> data = new LinkedList<>();
        List<File>filebase=new ArrayList<>();
        File root=new File(parent);
        data.offer(root);
        while (!data.isEmpty()) {
            File el =  data.poll();
            if (!el.isDirectory()) {
                for(String n:ext) {
                    if (n.equals(this.getFileExtension(el))) {
                        filebase.add(el);
                    }
                }
            }
            else if(el.listFiles().length!=0){
                for (File child : el.listFiles()) {
                    data.offer(child);
                }
            }
        }
        return filebase;
    }
    public String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0 && !file.isDirectory())
            return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
}
//File file = new File(path);
//file.listFiles() - возвращает список всех каталогов и файлов находящихся в папке  file.
//file.isDirectory() - проверяет, что файл является директорией.
//file.getName() - возвращает имя файла с расширением.
