package bsu.edu.cs222.combat;

public class BattleWinCalculator {
    int battleWinNumber;

    public int getBattleWinNumber() {
        return battleWinNumber;
    }

    public void increaseWinCount(){
        battleWinNumber++;
    }

    public void setBattleWinNumber(int battleWinNumber) {
        this.battleWinNumber = battleWinNumber;
    }
}