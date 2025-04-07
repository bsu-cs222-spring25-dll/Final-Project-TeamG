package bsu.edu.cs222.combat;

import java.util.Scanner;

public class DifficultySelection {
    Scanner scanner = new Scanner(System.in);
    String selectedDifficulty;
    Character enemy;


    public String getUserDifficultyChoice() {
        System.out.println("Please select the difficulty of the monster you wish to face.\nEasy\nMedium\nHard\n");
        selectedDifficulty = scanner.nextLine();
        return selectedDifficulty;
    }

    public String getSelectedDifficulty(){
        return selectedDifficulty;

    }

    public void DifficultySelection(String selectedDifficulty, Character enemy) {
        this.selectedDifficulty = selectedDifficulty;
        this.enemy = enemy;
    }

    public Character getSelectedEnemy(){
        getUserDifficultyChoice();
        if(selectedDifficulty.equals("Easy")){
            enemy = new EnemyEasy("Bunbun");
        }
        else if(selectedDifficulty.equals("Medium")){
            enemy = new EnemyMedium("Gobbo");
        }
        else if(selectedDifficulty.equals("Hard")){
            enemy = new EnemyHard("Howard");
        }
        return enemy;
    }

    public Character getEnemyType(){
        return enemy;
    }
}
