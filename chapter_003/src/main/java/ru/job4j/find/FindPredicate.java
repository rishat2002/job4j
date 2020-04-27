package ru.job4j.find;

public class FindPredicate {
    private String [] argForfind;
    public FindPredicate(String[] argForfind) {
        this.argForfind = argForfind;
    }
    public MetodSearch findMethod() {
        MetodSearch m=null;
        if (argForfind[2].equals("-f")) {
            return m=new FullCompare();
        }
        if (argForfind[2].equals("-r")) {
            return m=new RegexCompare();
        }
        return m;
    }
}
