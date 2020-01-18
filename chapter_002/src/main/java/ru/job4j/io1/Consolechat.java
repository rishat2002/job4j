package ru.job4j.io1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Consolechat {
    private final String endPhrase="end";
    private final String stopPhrase="stop";
    private final String continueChat="continue";
    public List<String> randomPhrase(String source) throws IOException {
        FileReader fr = new FileReader(new File(source));
        BufferedReader br = new BufferedReader(fr);
        String line;
        List<String> listWithPhrase = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            listWithPhrase.add(line);
        }
        br.close();
        fr.close();
        return listWithPhrase;
    }

    public List<String> chat(String source, String logfile) throws IOException {
        List<String>listWithPhrase=this.randomPhrase(source);
        Scanner in = new Scanner(System.in);
        String s = "slovo";
        List<String> allchat = new ArrayList<>();
        while (!s.equals(endPhrase)) {
            s = in.nextLine();
            allchat.add("Пользователь:" + System.lineSeparator() + s);
            if (s.equals(stopPhrase)) {
                String con = "more";
                while ((!con.equals(continueChat) && (!con.equals("end")))) {
                    con = in.nextLine();
                    allchat.add("Пользователь:" + System.lineSeparator() + con);
                }
                s = con;
            } else if (!s.equals(endPhrase)) {
                String ran = "Console:" + System.lineSeparator() + listWithPhrase.get((int) (Math.random() * (listWithPhrase.size())));
                allchat.add(ran);
                System.out.println(ran);
            }
        }
        this.writeLogFile(logfile, allchat);
        return allchat;
    }

    public void writeLogFile(String logPath, List<String> list) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new FileOutputStream(logPath));
        for (String s : list) {
            out.println(s);
        }
        out.close();
    }

    public static void main(String[] args) throws IOException {
        Consolechat con = new Consolechat();
        con.chat(".\\src\\main\\java\\ru\\job4j\\io1\\app.properties", "C:\\projects\\job4j\\chapter_002\\src\\main\\java\\ru\\job4j\\io1\\dialog.LOG");

    }
}
