package bsu.edu.cs222.combat;

import java.util.Scanner;

public class DifficultySelection {
    Scanner scanner = new Scanner(System.in);
    String selectedDifficultyChoice;
    CharacterBase enemy;

    public String getUserDifficultyChoice() {
        System.out.println("Please select the difficulty of the monster you wish to face.\nEasy\nMedium\nHard\n");
        selectedDifficultyChoice = scanner.nextLine();
        return selectedDifficultyChoice;
    }

    public String getSelectedDifficulty(){
        return selectedDifficultyChoice;
    }

    public DifficultySelection() {
        this.selectedDifficultyChoice = "";
        this.enemy = null;
    }

    public CharacterBase getSelectedEnemy(String difficulty){
        //getUserDifficultyChoice();
        while(!difficulty.equalsIgnoreCase("Easy") && !difficulty.equalsIgnoreCase("Medium") && !difficulty.equalsIgnoreCase("Hard")){
            System.out.println("Invalid input. Please try again. ");
            difficulty = scanner.nextLine();
        }
        this.selectedDifficultyChoice = difficulty.substring(0, 1).toUpperCase() + difficulty.substring(1).toLowerCase();
        switch(this.selectedDifficultyChoice){
            case "Easy":
                enemy = new EnemyEasy("Bunbun");
                break;
            case "Medium":
                enemy = new EnemyMedium("Gobbo");
                break;
            case "Hard":
                enemy = new EnemyHard("Howard");
                break;
        }
        return enemy;
    }

    public CharacterBase getEnemyType(){
        return enemy;
    }
}