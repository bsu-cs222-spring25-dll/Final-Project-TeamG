package bsu.edu.cs222.combat;

public class EnemyHard extends CharacterBase {
    public int attackPower;
    public int defensePower;

    public EnemyHard(String name){
        super(name, 20);
        this.attackPower = 25;
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
