package bsu.edu.cs222;

import bsu.edu.cs222.combat.Enemy;

public class EnemyDisplayTest {
    public static void main(String[] args) {
        Enemy enemy = new Enemy("Bob", 0);
        int enemyHP = enemy.getHp();
        System.out.printf("%d", enemyHP);
    }
}