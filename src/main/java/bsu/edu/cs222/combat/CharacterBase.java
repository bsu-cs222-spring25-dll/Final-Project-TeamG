package bsu.edu.cs222.combat;

public abstract class CharacterBase {
    public String name;
    public int maxHp, Hp;

    public CharacterBase(String name, int maxHp){
        this.name = name;
        this.maxHp = maxHp;
        this.Hp = maxHp;
    }
    public String getName() {
        return name;
    }
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
    public abstract int attack();
    public abstract int defend();
}