package bsu.edu.cs222.combat;
//This was taken from a tutorial and is meant to serve as an example of how we should go about developing our battle system.
import java.util.Scanner;

public class GameLogic {
    static Scanner scan = new Scanner(System.in);
    static Player player;
    public static boolean isGameRunning;

    //encounters
    public static String[] encounters = {"Battle", "Battle", "Battle", "Rest", "Rest"};

    //enemy types
    public static String[] enemies = {"Ghost", "Zombie", "Goblin", "Witch", "Mummy"};

    //story elements
    public static int place = 0;
    public static int act = 1;
    public static String[] places = {"Area One", "Area Two", "Area Three", "Area Final"};

    public static int readUserInput(String prompt, int userChoice){
        int input;
        do{
            System.out.println(prompt);
            try{
                input = Integer.parseInt(scan.next());
            }catch(Exception e){
                input = -1;
                System.out.println("Please enter an integer");
            }
        }while (input < 1 || input > userChoice);
        return input;
    }

    public static void clearConsoleLogs(){
        for(int i = 0; i < 10; i++){
            System.out.println();
        }
    }

    public static void printDivider(int n){
        for(int i = 0; i < n; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printHeading(String title){
        printDivider(5);
        System.out.println(title);
        printDivider(5);
    }

    public static void waitForUserInput(){
        System.out.println("\nEnter anything to continue...");
        scan.next();
    }

    public static void startGame(){
        boolean nameSet = false;
        String name;
        printTitleScreen();
        do {
            clearConsoleLogs();
            printHeading("What's your name?");
            name = scan.next();
            clearConsoleLogs();
            printHeading("Your name is " + name + ".\nIs this correct?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int input = readUserInput("-> ", 2);
            if(input == 1){
                nameSet = true;
            }
        }while(!nameSet);
        player = new Player(name);
        isGameRunning = true;
        gameLoop();
    }

    public static void printTitleScreen(){
        clearConsoleLogs();
        printDivider(10);
        printDivider(5);
        System.out.println("RPG TEST");
        printDivider(10);
        printDivider(5);
    }

    public static void gameLoop(){
        while(isGameRunning){
            printMainGameMenu();
            int input = readUserInput("-> ", 3);
            if(input == 1){
                continueGameJourney();
            } else if(input == 2){
                characterInfo();
            } else {
                isGameRunning = false;
            }
        }
    }

    public static void printMainGameMenu(){
        clearConsoleLogs();
        printHeading(places[place]);
        System.out.println("Choose an action:");
        printDivider(20);
        System.out.println("1. Continue on your journey");
        System.out.println("2. Character Info");
        System.out.println("3. Exit Game");
    }

    public static void characterInfo(){
        clearConsoleLogs();
        printHeading("Character Info");
        System.out.println(player.name + "\tHP: " + player.hp + "/" + player.maxHp);
        printDivider(20);
        System.out.println(player.name + "\tAttack Power: " + player.attackPower);
        System.out.println(player.name + "\tDefense Power: " + player.defensePower);
        printDivider(20);
        System.out.println(player.name + "\tWin Count: " + player.winCount);
        printDivider(20);
        waitForUserInput();
    }
    public static void checkAct(){
        if(player.winCount >= 10 && act == 1){
            act = 2;
            place = 1;
            //assign enemy values
            enemies[0] = "Ghost";
            enemies[1] = "Zombie";
            enemies[2] = "Goblin";
            enemies[3] = "Witch";
            enemies[4] = "Mummy";
            //assign event values
            encounters[0] = "Battle";
            encounters[1] = "Battle";
            encounters[2] = "Battle";
            encounters[3] = "Rest";
            encounters[4] = "Rest";
            //restore back to max HP
            player.hp = player.maxHp;
        }else if(player.winCount >= 25 && act == 2){
            act = 3;
            place = 2;
            //assign enemy values
            enemies[0] = "Zombie";
            enemies[1] = "Goblin";
            enemies[2] = "Witch";
            enemies[3] = "Mummy";
            enemies[4] = "Ghost";
            //assign event values
            encounters[0] = "Battle";
            encounters[1] = "Rest";
            encounters[2] = "Battle";
            encounters[3] = "Rest";
            encounters[4] = "Battle";
            //restore to max HP
            player.hp = player.maxHp;
        }else if(player.winCount >= 50 && act == 3){
            act = 4;
            place = 3;
            System.out.println("You beat the game yippie");
            isGameRunning = false;
        }
    }

    public static void continueGameJourney(){
        checkAct();
        if (act != 4){
            randomEncounter();
        }
    }

    public static void randomEncounter(){
        int encounter = (int) (Math.random() * encounters.length);
        if(encounters[encounter].equals("Battle")){
            randomBattle();
        }else{
            takeRest();
        }
    }

    public static void takeRest(){
        clearConsoleLogs();
        printHeading("Do you want to take a rest?");
        System.out.println("1. Yes\n2. No");
        int input = readUserInput("-> ", 2);
        if (input == 1){
            clearConsoleLogs();
            if(player.hp < player.maxHp){
                player.hp = player.maxHp;
            }
            System.out.println("The player decided to take a rest. HP has been fully restored");
        }else{
            System.out.println("You are already at full HP. There is no point to resting");
        }
        waitForUserInput();
    }

    public static void randomBattle(){
        clearConsoleLogs();
        printHeading("You ran into an enemy. Prepare for battle");
        waitForUserInput();
        battle(new Enemy(enemies[(int)(Math.random()*enemies.length)], player.winCount));
    }

    public static void battle(Enemy enemy){
        while(true){
            clearConsoleLogs();
            printHeading(enemy.name + "\nHP: " + enemy.hp + "/" + enemy.maxHp);
            printHeading(player.name + "\nHP: " + player.hp + "/" + player.maxHp);
            System.out.println("Choose an action: ");
            printDivider(20);
            System.out.println("1. Fight\n2. Heal\n3. Forfeit");
            int input = readUserInput("-> ", 3);
            //react to player input
            if(input == 1){
                //fight
                int dmg = player.attack() - enemy.defend();
                int dmgTook = enemy.attack() - player.defend();
                //check if damage is negative
                if(dmgTook < 0){
                    //add some dmg if player defends very well
                    dmg -= dmgTook/2;
                    dmgTook = 0;
                }
                if(dmg < 0){
                    dmg = 0;
                }
                //damage dealt to both parties
                player.hp -= dmgTook;
                enemy.hp -= dmg;
                //print battle info
                clearConsoleLogs();
                printHeading("Battle");
                System.out.println("You dealt " + dmg + " damage to the " + enemy.name);
                printDivider(15);
                System.out.println("The " + enemy.name + " dealt " + dmgTook + " damage to you");
                waitForUserInput();
                //check to see if player is dead
                if(player.hp <= 0){
                    playerDied();
                    break;
                } else if(enemy.hp <= 0) {
                    printHeading("Player is Victorious");
                    player.winCount += (enemy.playerWinCount + 1);
                    System.out.println("Player now has " + player.winCount + " wins!");
                    waitForUserInput();
                    break;
                }
            } else if (input == 2) {
                //heal
                clearConsoleLogs();
                if(player.hp < player.maxHp){
                    printHeading("Do you want to heal?");
                    System.out.println("1. Yes\n2. No");
                    input = readUserInput("-> ", 2);
                    if(input == 1){
                        player.hp = player.maxHp;
                        clearConsoleLogs();
                        printHeading("HP fully restored");
                        waitForUserInput();
                    }
                }else{
                    clearConsoleLogs();
                    printHeading("You are already at full hp");
                }
            }else{
                //endbattle
                clearConsoleLogs();
                if(act != 4){
                    printHeading("Player chose to end the battle");
                    waitForUserInput();
                    break;
                }else{
                    printHeading("Player cannot escape the Final Battle");
                    waitForUserInput();
                }
            }
        }
    }

    public static void playerDied(){
        clearConsoleLogs();
        printHeading("Player has died");
        printHeading("Player had earned " + player.winCount + " victories on their journey");
        isGameRunning = false;
    }

}
