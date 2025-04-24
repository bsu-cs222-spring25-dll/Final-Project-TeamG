package bsu.edu.cs222.combat;

public abstract class CharacterBase {
    public String name;
    public int maxHp, Hp;
    public int attackPower;
    public int defensePower;

    public CharacterBase(String name, int maxHp){
        this.name = name;
        this.maxHp = maxHp;
        this.Hp = maxHp;
    }

    public String getName() {
        return name;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getHp() {
        return Hp;
    }

    public void setHp(int hp) {
        Hp = hp;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public void setDefensePower(int defensePower) {
        this.defensePower = defensePower;
    }

    public abstract int attack();
    public abstract int defend();
}