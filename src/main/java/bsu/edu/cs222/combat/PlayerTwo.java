package bsu.edu.cs222.combat;

public class PlayerTwo extends CharacterBase {
    public int attackPower;
    public int defensePower;
    public PlayerTwo(String name){
        super(name, 50);
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
