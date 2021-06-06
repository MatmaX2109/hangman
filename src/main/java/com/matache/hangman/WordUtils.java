package com.matache.hangman;


import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class WordUtils implements RandomChose {
    final static String[] pollOfWords = {"house", "mouse", "mama", "chair", "blockbuster"};
//    final static String[] pollOfWords = {"mama"};

    public String getWord(){
        Random rand = new Random();
        List<String> listOfWords = Arrays.asList(pollOfWords);
        return listOfWords.get(rand.nextInt(listOfWords.size())).toLowerCase();
    }

    public boolean isWordFound(final Game game){
        if(game.getWord().equals(game.getMaskedWord())){
            System.out.println("Congratulations !!! You found the word !!!");
            return true;
        }
        return false;
    }

}
