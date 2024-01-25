package org.example;

import java.util.HashMap;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        HashMap<Integer, Boolean> results = new HashMap<>(); // не понял, как нужно было использовать данную коллекцию, но согласно ТЗ она должна быть
        final Boolean winWithChangeChoice = true;
        final Boolean loseWithChangeChoice = false;
        int countOfWinsByFirstChoice = 0;
        int countOfWinsByChangedChoice = 0;

        for (int i = 1; i <= 1000; i++) {
            int carDoor = rand.nextInt(3);
            int chosenDoor = rand.nextInt(3);
            if (chosenDoor != carDoor) {
                results.put(i, winWithChangeChoice);
            } else {
                countOfWinsByFirstChoice++;
                results.put(i, loseWithChangeChoice);
            }
        }

        for (Boolean value : results.values()) {
            if (value) countOfWinsByChangedChoice++;
        }

        System.out.println("Wins if you change choice: " + countOfWinsByChangedChoice);
        System.out.println("Wins if you will stay on your choice: " + countOfWinsByFirstChoice);
    }
}
