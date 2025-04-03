package bsu.edu.cs222;

import bsu.edu.cs222.combat.Enemy;
import org.junit.jupiter.api.Test;

public class EnemyDisplayTest {
    @Test
    public void testEnemyDisplay() {
        Enemy enemy = new Enemy("Bob", 0);
        int enemyHP = enemy.getHp();
        System.out.printf("%d", enemyHP);
    }
}