package bsu.edu.cs222.combat;

import java.util.Scanner;

public class PlayerSelection {
    Scanner scanner = new Scanner(System.in);
    String userPlayerChoice;
    Character player;

    public String getPromptPlayerUserChoice(){
        System.out.println("Please select the player you want\nPlayer One\nPlayer Two\n");
        userPlayerChoice = scanner.nextLine();
        return userPlayerChoice;
    }

    public Character getSelectedPlayer(){
        getPromptPlayerUserChoice();
        if(userPlayerChoice.equals("Player One")){
            player = new PlayerOne("Player One");
        }
        else if(userPlayerChoice.equals("Player Two")){
            player = new PlayerTwo("Player Two");
        }
        return player;
    }

    public Character getPlayer(){
        return player;
    }

}
