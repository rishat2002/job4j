package API;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student {
    private int score;
    private String surname;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Student(int score) {
        this.score = score;
    }
    public Student(String surname,int score) {
        this.surname = surname;
        this.score=score;
    }

    @Override
    public String toString() {
        return surname+" ";
    }
    @Override
    public boolean equals(Object a) {
        Student n=(Student) a;
        return this.getSurname().equals(n.surname);
    }

    @Override
    public int hashCode() {
        return score;
    }

}
