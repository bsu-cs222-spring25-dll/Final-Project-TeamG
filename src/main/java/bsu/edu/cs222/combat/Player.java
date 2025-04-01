package bsu.edu.cs222.combat;

import java.util.Scanner;

public class Player extends Character{
    static Scanner scan = new Scanner(System.in);
    public int attackPower;
    public int defensePower;

    public Player(String name) {
        super(name, 100, 0);
        this.attackPower = 5;
        this.defensePower = 5;
    }

    @Override
    public int attack() {
        return (int) (Math.random() * winCount/4 + attackPower * 3 + 3) + winCount/10 + attackPower * 2 + defensePower + 1;
    }

    @Override
    public int defend() {
        return (int) (Math.random() * winCount/4 + defensePower * 3 + 3) + winCount/10 + defensePower * 2 + attackPower + 1;
    }

}
