package bsu.edu.cs222.combat;

public class Enemy extends Character{
    int playerWinCount;

    public Enemy(String name, int playerWinCount) {
        super(name,(int) (Math.random() * playerWinCount + playerWinCount/3 + 5), (int) (Math.random() * (playerWinCount/4 + 2) + 1));
        this.playerWinCount = playerWinCount;
    }

    @Override
    public int attack() {
        return (int) (Math.random() * playerWinCount/4 + 1) + playerWinCount/4 + 3;
    }

    @Override
    public int defend() {
        return (int) (Math.random() * playerWinCount/4 + 1) + playerWinCount/4 + 3;
    }
}

