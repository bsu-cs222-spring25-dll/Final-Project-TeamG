package bsu.edu.cs222.combat;

public class EnemyEasy extends CharacterBase {
    public int attackPower;
    public int defensePower;
    public EnemyEasy(String name){
        super(name, 20);
        this.attackPower = 5;
        this.defensePower = 5;
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