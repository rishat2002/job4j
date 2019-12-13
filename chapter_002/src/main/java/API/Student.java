package API;

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
    public Student(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return surname+" ";
    }
}
