package BowlingGameKata;

public class Game {


    private int score = 0;
    private boolean isSpare = false;
    private boolean isStrike = false;


    void roll(int pinsDropped){
        if(pinsDropped<=10 && pinsDropped>=0 || isStrike){
            this.score += pinsDropped;
        }
    }

    void frame(int firstRoll, int secondRoll){
        if (isSpare) {
            roll(firstRoll*2);
            if(firstRoll!=10){
                roll(secondRoll);
            }
            isSpare = false;
        }else if(isStrike){
            roll(firstRoll*2);
            if(firstRoll!=10){
                roll(secondRoll*2);
            }
            isStrike = false;
        }
        else{
            roll(firstRoll);
            if(firstRoll!=10){
                roll(secondRoll);
            }
        }

        if(firstRoll==10){
            isStrike =  true;
        }
        if(firstRoll + secondRoll ==10 && secondRoll != 0){
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
