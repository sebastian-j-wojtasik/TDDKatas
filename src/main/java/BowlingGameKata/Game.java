package BowlingGameKata;

public class Game {


    private int score = 0;

    void roll(int pinsDropped){
        if (pinsDropped <= 10 && pinsDropped >= 0){
            this.score += pinsDropped;
        }
    }

    void frame(int firstRoll, int secondRoll){
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
