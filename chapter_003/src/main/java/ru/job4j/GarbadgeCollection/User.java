package ru.job4j.GarbadgeCollection;

public class User {
    private int n;
    private String m;

    public User() {

    }
    public User(int n, String m) {
        this.n = n;
        this.m = m;
    }

    @Override
    public void finalize() {
        try {
            super.finalize();
            System.out.println("finalize");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new User(i, "lol");
        }
        System.gc();
        System.out.println("Used memory "+(Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory())/(1024*1024)+" mb"); }
}
