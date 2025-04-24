package bsu.edu.cs222;

import bsu.edu.cs222.combat.BattleWinCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BattleWinCalcTest {
    @Test
    public void testInitialWinCountZero(){
        BattleWinCalculator winCalculator = new BattleWinCalculator();
        assertEquals(0, winCalculator.getBattleWinNumber(), "Initial win count should be 0.");
    }
    @Test
    public void testWinCountIncrease(){
        BattleWinCalculator winCalculator = new BattleWinCalculator();
        winCalculator.increaseWinCount();
        winCalculator.increaseWinCount();
        assertEquals(2, winCalculator.getBattleWinNumber(), "Win count should increase with each win.");
    }
}