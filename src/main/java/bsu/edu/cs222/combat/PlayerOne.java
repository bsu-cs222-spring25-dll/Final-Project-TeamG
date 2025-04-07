package bsu.edu.cs222.combat;

public class PlayerOne extends CharacterBase {
    public int attackPower;
    public int defensePower;
    public PlayerOne(String name){
        super(name, 25);
        this.attackPower = 15;
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
