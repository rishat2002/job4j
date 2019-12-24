package ru.job4j.lam;

import java.util.List;
import java.util.Set;

public class Holder {
    String stud;
    String sect;

    public String getStud() {
        return stud;
    }

    public void setStud(String stud) {
        this.stud = stud;
    }

    public String getSect() {
        return sect;
    }

    public void setSect(String sect) {
        this.sect = sect;
    }

    Holder(String stud, String sect) {
        this.stud = stud;
        this.sect = sect;
    }
}
