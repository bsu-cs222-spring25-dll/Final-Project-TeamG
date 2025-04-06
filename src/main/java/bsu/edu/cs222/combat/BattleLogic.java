package bsu.edu.cs222.combat;

//import bsu.edu.cs222.DifficultyMenu;
import java.util.Scanner;

public class BattleLogic {
    //DifficultyMenu difficultyMenu = new DifficultyMenu();

    enemy = getEnemyType();
    EnemyHard enemy = new EnemyHard("Howard");
    PlayerOne player = new PlayerOne("PlayerOne");
    Scanner scanner = new Scanner(System.in);

    int damage;

    String playerName = player.getName();
    String enemyName = enemy.getName();

    int playerAttackPower = player.attack();
    int playerDefensePower = player.defend();
    int playerHP = player.getHp();

    int enemyAttackPower = enemy.attack();
    int enemyDefensePower = enemy.defend();
    int enemyHP = enemy.getHp();

    public Character getEnemyType(){

    }




    public static void main(String[] args) {
        BattleLogic battle = new BattleLogic();
        battle.startRound();
    }

    public void startRound(){

        boolean battleKeepGoing = true;
        int playerChoice;

        System.out.printf("You've encountered %s", enemyName);
        while(battleKeepGoing){
            System.out.println("What do you wish to do?\n1)Attack\n2)Defend\n");
            playerChoice = Integer.parseInt(scanner.nextLine());
            if(playerChoice == 1){
                playerAttack();
                System.out.printf("%s now has %d health left! ", enemyName, enemyHP);
                if(enemyHP == 0){
                    System.out.printf("\n%s has been defeated! The battle is now over.", enemyName);
                    battleKeepGoing = false;
                }
                else{
                    enemyAttack();
                    System.out.printf("\n%s has %d health remaining.\n", playerName, playerHP);
                    if(playerHP == 0){
                        System.out.printf("\n%s has been slain and succumbs to the depths of despair...\nThe battle is over.\n");
                        battleKeepGoing = false;
                    }
                }

            }
            else if(playerChoice == 2){
                System.out.printf("\n%s defended!\n", playerName);
                playerDefensePower = playerDefensePower * 2;
                System.out.printf("\nTheir defense is now %d! ", playerDefensePower);
                enemyAttack();
                playerDefensePower = playerDefensePower/2;
                System.out.printf("\n%s has %d health remaining.\n", playerName, playerHP);
                if(playerHP == 0){
                    System.out.printf("\n%s has been slain and succumbs to the depths of despair...\nThe battle is over.\n");
                    battleKeepGoing = false;
                }


            }
            else{
                System.out.println("That wasn't a valid command, but the battle ends....\n");
                battleKeepGoing = false;
            }
        }
    }

    private int playerAttack(){
        System.out.printf("\n%s struck %s! ", playerName, enemyName);
        damage = playerAttackPower - enemyDefensePower;
        if(damage < 0){
            damage = 0;
            System.out.printf("%d damage was dealt to %s. ", damage, enemyName);
            enemyHP -= damage;
            if(enemyHP < 0){
                enemyHP = 0;
            }
            else{
            }
        }
        else{
            System.out.printf("\n%d damage was dealt to %s. ", damage, enemyName);
            enemyHP -= damage;
            if(enemyHP < 0){
                enemyHP = 0;
            }
            else{

            }

        }

        return enemyHP;
    }

    private int enemyAttack(){
        System.out.printf("\n%s maimed %s! ", enemyName, playerName);
        damage = enemyAttackPower - playerDefensePower;
        if(damage < 0){
            damage = 0;
            System.out.printf("%d damage was dealt to %s. ", damage, playerName);
            playerHP -= damage;
            if(playerHP < 0){
                playerHP = 0;
            }
            else{
            }
        }
        else{
            System.out.printf("%d damage was dealt to %s. ", damage, playerName);
            playerHP -= damage;
            if(playerHP < 0){
                playerHP = 0;
            }
            else{
            }
        }
        return playerHP;
    }


}
