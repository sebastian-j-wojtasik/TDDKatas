package BowlingGameKata;

public class Game {


    private int score = 0;
    private boolean isSpare = false;
    private boolean isStrike = false;


    void roll(int pinsDropped){
        if (pinsDropped <= 10 && pinsDropped >= 0){
            this.score += pinsDropped;
        }
    }

    void frame(int firstRoll, int secondRoll){
        if (isSpare) {
            roll(firstRoll*2);
            isSpare = false;
        }else{
            roll(firstRoll);
        }
        roll(secondRoll);
        if(firstRoll + secondRoll ==10){
            isSpare = true;
        }
    }

    int score(){
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
