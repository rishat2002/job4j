package ru.job4j.array;

public class ArrayChar1 {
    public static boolean startsWith(char[] word, char[] pref) {
        boolean result = true;
        for (int i=0;i<pref.length;i++) {
            if ((word[i]!=(pref[i]))) {
                result=false;
             break;
            }
        }
        return result;
    }
}