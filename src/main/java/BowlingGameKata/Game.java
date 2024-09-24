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
