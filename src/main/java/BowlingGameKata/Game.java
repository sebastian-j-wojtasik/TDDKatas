package BowlingGameKata;

import java.util.List;

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
            spareRoll(firstRoll, secondRoll);
        }else if(isStrike){
            strikeRoll(firstRoll, secondRoll);
        }
        else{
            standardRoll(firstRoll, secondRoll);
        }
        strikeCheck(firstRoll);
        spareCheck(firstRoll, secondRoll);
    }
    void frame(int firstRoll, int secondRoll, int thirdRoll){
        if (isSpare) {
            spareRoll(firstRoll, secondRoll);
        }else if(isStrike){
            strikeRoll(firstRoll, secondRoll);
        }
        else{
            standardRoll(firstRoll, secondRoll);
        }
        strikeCheck(firstRoll);
        spareCheck(firstRoll, secondRoll);
    }

    void gamePlayed(List<Integer> frames){
        frame(frames.get(0),frames.get(1));
        frame(frames.get(2),frames.get(3));
        frame(frames.get(4),frames.get(5));
        frame(frames.get(6),frames.get(7));
        frame(frames.get(8),frames.get(9));
        frame(frames.get(10),frames.get(11));
        frame(frames.get(12),frames.get(13));
        frame(frames.get(14),frames.get(15));
        frame(frames.get(16),frames.get(17));
        frame(frames.get(18),frames.get(19));
    }

    private void spareRoll(int firstRoll, int secondRoll) {
        roll(firstRoll * 2);
        if (firstRoll != 10) {
            roll(secondRoll);
        }
        isSpare = false;
    }

    private void strikeRoll(int firstRoll, int secondRoll) {
        roll(firstRoll *2);
        if(firstRoll !=10){
            roll(secondRoll *2);
        }
        isStrike = false;
    }

    private void standardRoll(int firstRoll, int secondRoll) {
        roll(firstRoll);
        if(firstRoll !=10){
            roll(secondRoll);
        }
    }

    private void strikeCheck(int firstRoll) {
        if(firstRoll ==10){
            isStrike =  true;
        }
    }

    private void spareCheck(int firstRoll, int secondRoll) {
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
