package ru.job4j.find;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindFile {
    private final String[] args;
    public FindFile(String[] args) {
        this.args = args;
        if (args.length!=7 || !args[0].equals("-d") || !args[2].equals("-n") || !args[5].equals("-o"))  {
            try {
                throw new Exception("Данные введены не правильно");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void findFile() {
        if (this.getParameter()[2].equals("-f")) {
            this.writeFile(this.getParameter()[3],
                    this.files(this.getParameter()[0],this.getParameter()[1],new FullCompare()));
        }
        if (this.getParameter()[2].equals("-r")) {
            this.writeFile(this.getParameter()[3], this.files(this.getParameter()[0],this.getParameter()[1],new RegexCompare()));
        }
    }

    public String[] getParameter() {
        String[] parameterList = new String[4];
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-d")) {
                parameterList[0] = args[i + 1];
            }
            if (args[i].equals("-n")) {
                parameterList[1] = args[i + 1];
            }
            if (args[i].equals("-f")) {
                parameterList[2] = args[i];
            }
            if (args[i].equals("-r")) {
                parameterList[2] = args[i];
            }
            if (args[i].equals("-o")) {
                parameterList[3] = args[i + 1];
            }
        }
        return parameterList;
    }

    public List<File> files(String directory,String filename,MetodSearch metod) {
        Queue<File> data = new LinkedList<>();
        List<File> filebase = new ArrayList<>();
        File root = new File(directory);
        data.offer(root);
        while (!data.isEmpty()) {
            File el = data.poll();
            if (!el.isDirectory() ) {
                if (metod.compareString(el.getName(),filename)){
                filebase.add(el);}
            } else if (el.listFiles().length != 0) {
                for (File child : el.listFiles()) {
                    data.offer(child);
                }
            }
        }
        return filebase;
    }


    public void writeFile(String path, List<File> f) {
        try (FileWriter writer = new FileWriter(path, false)) {
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
        FindFile f = new FindFile(args);
        f.findFile();
    }
}
