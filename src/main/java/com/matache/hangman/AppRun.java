package com.matache.hangman;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class AppRun {

    RandomChose randomChose;
    GuessImpl guess;
    InsertLetter insertLetter;

    public AppRun(RandomChose randomChose, GuessImpl guess, InsertLetter insertLetter) {
        this.randomChose = randomChose;
        this.guess = guess;
        this.insertLetter = insertLetter;
    }

    private boolean hasAttempts(int maxAttempts, int attempts){
        if(maxAttempts > attempts){
            return true;
        }
        System.out.println("Max attempts reached !!!");
        return false;
    }

    public void run(){

        final int maxAttempts = 10;

        boolean canContinue = true;
        int rounds = 0;
        while(canContinue) {

            rounds++;

            System.out.println("Points = " + (rounds-1) * 10);

            String secretWord = randomChose.getWord();
            Game game = new Game(secretWord);
            System.out.println("secretWord = " + game.getWord());

            do {
                System.out.println("MaskedWord = " + game.getMaskedWord());
                System.out.println("used = " + game.getUsed());

                String letter = insertLetter.typeLetter();

                guess.guess(letter.charAt(0), game);

                canContinue = hasAttempts(maxAttempts, game.getAttempts());
            } while (!guess.isWordFound(game) && canContinue);
        }
    }
}
