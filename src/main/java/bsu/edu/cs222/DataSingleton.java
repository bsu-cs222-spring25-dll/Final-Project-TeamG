package bsu.edu.cs222;

public class DataSingleton {
    private static final DataSingleton instance = new DataSingleton();
    DifficultyMenu difficultyMenu = new DifficultyMenu();

    private String selectedDifficultyData;

    private DataSingleton(){}

    public static DataSingleton getInstance(){
        return instance;
    }

    public String getSelectedDifficultyData(){
        selectedDifficultyData = difficultyMenu.getSelectedDifficulty();
        return selectedDifficultyData;
    }

}
