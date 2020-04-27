package ru.job4j.find;

import java.util.Arrays;

public class ArgumentParse {
    private final String[] args;
    public ArgumentParse(String[] args) {
        this.args = args;
        if (args.length!=7 || !args[0].equals("-d") || !args[2].equals("-n") || !args[5].equals("-o"))  {
            try {
                throw new Exception("Данные введены не правильно");
            } catch (Exception e) {
                e.printStackTrace();
            }
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

    public static void main(String[] args) {

    }
}
