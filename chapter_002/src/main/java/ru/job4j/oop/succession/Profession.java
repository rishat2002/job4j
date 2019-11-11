package ru.job4j.oop.succession;

public class Profession {
    String name,surname,education;
    int age,expirence;
    public String getName() {
        return this.name;
    }
}
class Doctor extends Profession {
    public Diagnose heal(Pacient pacient) {
        return new Diagnose();
    }
    int successoperation;
    int unsuccessoperation;
}
class Enqineer extends Profession {
    int successprojects;
    int unsuccesprojects;
    boolean workbigcompany;
}
class Dentist extends  Doctor {
    boolean childrendentist;
    public void healtooth() {
    }
}
class Surgeon extends Doctor {
    boolean deathoperation;
    public void healpacient(){}
}
class Programmer extends Enqineer {
    boolean knowframeworks;
    boolean remotework;
    public void overProjects() {}
}
class Builder extends  Enqineer {
    boolean woodenhouse;
    public void overdrawing(){}
}
class Diagnose {
}
class Pacient {
}


