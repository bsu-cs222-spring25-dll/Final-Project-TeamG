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

    public void DifficultySelection(String selectedDifficultyChoice, CharacterBase enemy) {
        this.selectedDifficultyChoice = selectedDifficultyChoice;
        this.enemy = enemy;
    }

    public CharacterBase getSelectedEnemy(String selectedDifficultyChoice){
        //getUserDifficultyChoice();
        if(selectedDifficultyChoice.equals("Easy")){
            enemy = new EnemyEasy("Bunbun");
        }
        else if(selectedDifficultyChoice.equals("Medium")){
            enemy = new EnemyMedium("Gobbo");
        }
        else if(selectedDifficultyChoice.equals("Hard")){
            enemy = new EnemyHard("Howard");
        }
        return enemy;
    }

    public CharacterBase getEnemyType(){
        return enemy;
    }
}
