package bsu.edu.cs222;

import bsu.edu.cs222.menu.DifficultyMenu;

public class DataSingleton {
    private static final DataSingleton instance = new DataSingleton();
    private String selectedDifficultyData;
    private DataSingleton(){}
    public static DataSingleton getInstance(){
        return instance;
    }
    public String getSelectedDifficultyData(){
        DifficultyMenu difficultyMenu = new DifficultyMenu();
        selectedDifficultyData = difficultyMenu.getSelectedDifficulty();
        return selectedDifficultyData;
    }
}