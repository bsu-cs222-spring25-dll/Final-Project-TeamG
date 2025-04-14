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
    //Suppressing "unused" warning because these setters/getters will be used in future iteration.
    @SuppressWarnings("unused")
    public void setName(String name) {
        this.name = name;
    }
    @SuppressWarnings("unused")
    public int getMaxHp() {
        return maxHp;
    }
    @SuppressWarnings("unused")
    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }
    public int getHp() {
        return Hp;
    }
    @SuppressWarnings("unused")
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