package bsu.edu.cs222.combat;

public abstract class Character {

    public String name;
    public int maxHp;
    public int hp;
    public int winCount;

    public Character(String name, int maxHp, int winCount){
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.winCount = winCount;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public abstract int attack();
    public abstract int defend();

}

