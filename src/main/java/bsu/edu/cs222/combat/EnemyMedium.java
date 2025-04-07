package bsu.edu.cs222.combat;

public class EnemyMedium extends CharacterBase {
    public int attackPower;
    public int defensePower;

    public EnemyMedium(String name){
        super(name, 20);
        this.attackPower = 10;
        this.defensePower = 8;
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
