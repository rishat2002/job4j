package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
    Ball tastyBall=new Ball();
    Hare hungryHare=new Hare();
    Wolf greyWolf=new Wolf();
    Fox cleverFox=new Fox();
    hungryHare.tryEat(tastyBall);
    greyWolf.tryEat(tastyBall);
    cleverFox.tryEat(tastyBall);
    }
    static class Ball {
    }
    static class Hare {
        public void tryEat(Ball ball) {
        }
    }
    static class Wolf {
        public void tryEat(Ball ball) {
        }
    }
    static class Fox {
        public void tryEat(Ball ball) {
        }
    }
}
