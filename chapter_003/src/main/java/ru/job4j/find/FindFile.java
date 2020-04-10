package ru.job4j.find;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class FindFile {
    private final String[] args;

    public FindFile(String[] args) {
        this.args = args;
    }

    public void findFile() {
        if (this.getParameter()[2].equals("-f")) {
            this.writeFile(this.getParameter()[3], this.searchFullName(this.getParameter()[0], this.getParameter()[1]));
        }
        if (this.getParameter()[2].equals("-r")) {
            this.writeFile(this.getParameter()[3], this.searchRegexName(this.getParameter()[0], this.getParameter()[1]));
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

    public List<File> files(String directory) {
        Queue<File> data = new LinkedList<>();
        List<File> filebase = new ArrayList<>();
        File root = new File(directory);
        data.offer(root);
        while (!data.isEmpty()) {
            File el = data.poll();
            if (!el.isDirectory()) {
                filebase.add(el);
            } else if (el.listFiles().length != 0) {
                for (File child : el.listFiles()) {
                    data.offer(child);
                }
            }
        }
        return filebase;
    }

    public List<File> searchFullName(String directory, String fileName) {
        return this.files(directory).stream().filter(x -> x.getName()
                .equals(fileName)).collect(Collectors.toList());
    }

    public List<File> searchRegexName(String directory, String regex) {
        return this.files(directory).stream().filter(x -> x.getName()
                .matches(regex)).collect(Collectors.toList());
    }

    public void writeFile(String path, List<File> f) {
        try (FileWriter writer = new FileWriter(path, false)) {
            f.stream().forEach(x -> {
                try {
                    writer.write(x.getName()+"\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        FindFile f = new FindFile(args);
        f.findFile();
    }
}
//1. Создать программу для поиска файла.
//2. Программа должна искать данные в заданном каталоге и подкаталогах.
//3. Имя файла может задаваться, целиком, по маске, по регулярному выражение(не обязательно).
//4. Программа должна собираться в jar и запускаться через java -jar find.jar -d c:/ -n *.txt -m -o log.txt
//Ключи
//-d - директория в которая начинать поиск.
//-n - имя файл, маска, либо регулярное выражение.
//-m - искать по макс, либо -f - полное совпадение имени. -r регулярное выражение.
//-o - результат записать в файл.
//5. Программа должна записывать результат в файл.
//6. В программе должна быть валидация ключей и подсказка.