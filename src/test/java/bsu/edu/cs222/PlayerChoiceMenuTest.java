package bsu.edu.cs222;

import bsu.edu.cs222.menus.PlayerChoiceMenu;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerChoiceMenuTest {
    //test does not work atm due to combat system
    //please do not run
    @Test
    public void testSelectPlayer(){
        PlayerChoiceMenu playerChoiceMenu = new PlayerChoiceMenu();
        playerChoiceMenu.selectPlayer("Player One");
        assertEquals("Player One", playerChoiceMenu.getSelectedPlayer(), "Player selection should be stored correctly.");
    }
}