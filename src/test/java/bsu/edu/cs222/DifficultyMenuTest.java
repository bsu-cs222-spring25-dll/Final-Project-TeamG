package bsu.edu.cs222;

import bsu.edu.cs222.menu.DifficultyMenu;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifficultyMenuTest {
    @Test
    public void testSelectDifficulty(){
        DifficultyMenu difficultyMenu = new DifficultyMenu();
        difficultyMenu.selectDifficulty("Easy");
        assertEquals("Easy", difficultyMenu.getSelectedDifficulty(), "Difficulty selection should be stored correctly.");
    }
}