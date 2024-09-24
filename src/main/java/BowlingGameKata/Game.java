package BowlingGameKata;

public class Game {


    private int score = 0;

    void roll(int pinsDropped){
        this.score += pinsDropped;
    }

    void frameRolls(int firstRoll, int secondRoll){
        roll(firstRoll);
        roll(secondRoll);
    }

    int score(){
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
