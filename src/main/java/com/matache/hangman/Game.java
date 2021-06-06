package com.matache.hangman;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

import static com.matache.hangman.Constants.MASK;

@Getter
public class Game {

    private String word;
    private String maskedWord;
    private Set<Character> used = new HashSet<>();
    private int attempts;

    public Game(String word) {
        this.word = word;

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < word.length(); i++){
            sb.append(MASK);
        }
        this.maskedWord = sb.toString();
        this.attempts = 0;
    }

    public void setMaskedWord(String maskedWord) {
        this.maskedWord = maskedWord;
    }

    public void attemptsUp(){
        this.attempts++;
    }
}
