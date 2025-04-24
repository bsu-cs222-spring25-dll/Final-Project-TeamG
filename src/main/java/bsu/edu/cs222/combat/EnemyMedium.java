package bsu.edu.cs222.combat;

public class EnemyMedium extends CharacterBase {
    public int attackPower;
    public int defensePower;
    public EnemyMedium(String name){
        super(name, 70);
        this.attackPower = 15;
        this.defensePower = 9;
    }

    @Override
    public int attack(){
        return attackPower;
    }

    @Override
    public int defend(){
        return defensePower;
    }
}