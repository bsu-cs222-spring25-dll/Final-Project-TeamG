package bsu.edu.cs222;

import bsu.edu.cs222.combat.PlayerSelection;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerSelectionTest {
    @Test
    public void testSelectPlayer(){
        PlayerSelection playerSelection = new PlayerSelection();
        playerSelection.getSelectedPlayer("Player One");
        assertEquals("Player One", playerSelection.getPlayer().getName(), "Player selection should be stored correctly.");
    }
}