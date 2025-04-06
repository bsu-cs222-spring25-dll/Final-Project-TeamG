package bsu.edu.cs222;

import bsu.edu.cs222.combat.EnemyHard;
import org.junit.jupiter.api.Test;

public class EnemyDisplayTest {
    @Test
    public void testEnemyDisplay() {
        EnemyHard enemyHard = new EnemyHard("Bob");
        int enemyHP = enemyHard.getHp();
        System.out.printf("%d", enemyHP);
    }
}