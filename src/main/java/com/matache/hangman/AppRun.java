package com.matache.hangman;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class AppRun {

    RandomChose randomChose;
    GuessImpl guess;

    public AppRun(RandomChose randomChose, GuessImpl guess) {
        this.randomChose = randomChose;
        this.guess = guess;
    }

    private String typeLetter(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Type a letter = ");

        String letter;
        do{
            letter = scanner.nextLine();
            if(letter.length() > 1){
                System.out.println("Insert just 1 caracter !!! ");
            }
        }while (letter.length() != 1);

        return letter.toLowerCase();
    }

    private boolean hasAttempts(int maxAttempts, int attempts){
        if(maxAttempts > attempts){
            return true;
        }
        System.out.println("Max attempts reached !!!");
        return false;
    }


    public void run(){

        final int maxAttempts = 1;

        String secretWord = randomChose.getWord();
        Game game =  new Game(secretWord);
        System.out.println("secretWord = "+game.getWord());


        do{
            System.out.println("MaskedWord = "+game.getMaskedWord());
            System.out.println("used = " + game.getUsed());

            String letter = typeLetter();

            guess.guess(letter.charAt(0), game);

        }while (!guess.isWordFound(game) && hasAttempts(maxAttempts, game.getAttempts()));
    }
}
