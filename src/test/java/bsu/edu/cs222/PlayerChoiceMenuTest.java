package bsu.edu.cs222;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerChoiceMenuTest {
    @Test
    public void testSelectPlayer(){
        PlayerChoiceMenu playerChoiceMenu = new PlayerChoiceMenu();
        playerChoiceMenu.selectPlayer("Player One");
        assertEquals("Player One", playerChoiceMenu.getSelectedPlayer(), "Player selection should be stored correctly.");
    }
}