package bsu.edu.cs222;

import bsu.edu.cs222.combat.BattleLogic;
import bsu.edu.cs222.combat.CharacterBase;
import bsu.edu.cs222.combat.EnemyMedium;
import bsu.edu.cs222.combat.PlayerSelection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BattleLogicTest {
    @Test
    public void testAttackRoundWithCharacters(){
        EnemyMedium enemyMedium = new EnemyMedium("Gobbo");
        PlayerSelection playerSelection = new PlayerSelection();
        CharacterBase player = playerSelection.getSelectedPlayer("Player Two");
        BattleLogic battleLogic = new BattleLogic();
        battleLogic.attackBattleTurnOrder(player, enemyMedium);
        assertTrue(enemyMedium.getHp() < 100, "Enemy HP should be reduced after attack.");
        assertTrue(battleLogic.getDamage() >= 0, "Damage should never be negative.");
    }
}
