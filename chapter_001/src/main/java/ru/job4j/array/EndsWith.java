package ru.job4j.array;

public class EndsWith {
    public static boolean endsWith(char[] word, char[] post) {
        boolean result = true;
        int n=post.length-1;
    for (int i=word.length-1;i>=word.length-1-n;i--) {
        if (!(word[i]==post[n])){
            result=false;
        }
        n--;
    }
        return result;
}
}
