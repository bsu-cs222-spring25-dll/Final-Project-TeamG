package bsu.edu.cs222.combat;

import java.util.Scanner;

public class BattleLogic {
    DifficultySelection difficultySelection = new DifficultySelection();
    BattleWinCalculator battleWinCalculator = new BattleWinCalculator();
    PlayerSelection playerSelection = new PlayerSelection();
    Scanner scanner = new Scanner(System.in);
    int damage;
    int playerChoice;
    boolean battleKeepGoing;

    public void startRound(){
        String difficultyChoice = difficultySelection.getUserDifficultyChoice();
        CharacterBase enemy = difficultySelection.getSelectedEnemy(difficultyChoice);
        String userPlayerChoice = playerSelection.getPromptPlayerUserChoice();
        CharacterBase player = playerSelection.getSelectedPlayer(userPlayerChoice);
        System.out.printf("You've encountered %s ", enemy.getName());
        battleKeepGoing = true;

        while(battleKeepGoing){
            System.out.println("What do you wish to do?\n1)Attack\n2)Defend\n");
            playerChoice = Integer.parseInt(scanner.nextLine());
            if(playerChoice == 1){
                attackBattleTurnOrder(player, enemy);
            }
            else if(playerChoice == 2){
                defendBattleTurnOrder(player, enemy);
            }
            else{
                System.out.println("That wasn't a valid command, but the battle ends....\n");
                battleKeepGoing = false;
            }
        }
    }

    private void playerAttack(CharacterBase player, CharacterBase enemy){
        System.out.printf("\n%s struck %s! ", player.getName(), enemy.getName());
        damage = player.attack() - enemy.defend();
        if(damage < 0){
            damage = 0;
        } else {
            enemy.setHp(enemy.getHp() - damage);
        }
        if(enemy.getHp() < 0){
            enemy.setHp(0);
        }
        System.out.printf("\n%d damage was dealt to %s", damage, enemy.getName());
    }

    private void enemyAttack(CharacterBase player, CharacterBase enemy){
        System.out.printf("\n%s maimed %s! ", enemy.getName(), player.getName());
        damage = enemy.attack() - player.defend();
        if(damage < 0){
            damage = 0;
        } else {
            player.setHp(player.getHp() - damage);
        }
        if(player.getHp() < 0){
            player.setHp(0);
        }
        System.out.printf("%d damage was dealt to %s", damage, player.getName());
    }

    //Use these function for getting the output dialogue
    public void attackBattleTurnOrder(CharacterBase player, CharacterBase enemy){
        playerAttack(player, enemy);
        System.out.printf("%s now has %d health left! ", enemy.getName(), enemy.getHp());
        if(enemy.getHp() == 0){
            System.out.printf("\n%s has been defeated! The battle is now over.", enemy.getName());
            battleWinCalculator.increaseWinCount();
            battleKeepGoing = false;
        }
        else{
            enemyAttack(player, enemy);
            System.out.printf("\n%s has %d health remaining.\n", player.getName(), player.getHp());
            if(player.getHp() == 0){
                System.out.printf("\n%s has been slain and succumbs to the depths of despair...\nThe battle is over.\n", player.getName());
                battleKeepGoing = false;
            }
        }
    }

    //use this and the attackBattleTurnOrder function for the textbox dialogue in the battle menu
    public void defendBattleTurnOrder(CharacterBase player, CharacterBase enemy){
        System.out.printf("\n%s defended!\n", player.getName());
        int playerDefensePower = player.defend() * 2;
        System.out.printf("\nTheir defense is now %d! ", playerDefensePower);
        enemyAttack(player, enemy);
        System.out.printf("\n%s has %d health remaining.\n", player.getName(), player.getHp());
        if(player.getHp() == 0){
            System.out.printf("\n%s has been slain and succumbs to the depths of despair...\nThe battle is over.\n", player.getName());
            battleKeepGoing = false;
        }
    }

    public int getDamage() {
        return damage;
    }
}