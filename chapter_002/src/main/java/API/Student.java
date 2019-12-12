package API;

public class Student {
    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Student(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return String.valueOf(score)+" ";
    }
}
