package com.matache.hangman;

import org.springframework.stereotype.Service;

import static com.matache.hangman.Constants.MASK;


@Service
public class GuessImpl implements Guess{

    public boolean guess(char c, Game game){

        StringBuilder tempWord = new StringBuilder();

        boolean found = false;
        for (int i = 0; i<game.getWord().length(); i++){
            if(game.getWord().charAt(i) == c && game.getMaskedWord().charAt(i) == MASK){
                tempWord.append(c);
                found = true;
            }else {
                if(game.getMaskedWord().charAt(i) == MASK){
                    tempWord.append(MASK);
                }else{
                    tempWord.append(game.getMaskedWord().charAt(i));
                }
            }
        }
        if(!found){
            game.getUsed().add(c);
            game.attemptsUp();
        }
        game.setMaskedWord(tempWord.toString());
        return game.getWord().equals(game.getMaskedWord());
    }

    public boolean isWordFound(final Game game){
        if(game.getWord().equals(game.getMaskedWord())){
            System.out.println("Congratulations !!! You found the word !!!");
            return true;
        }
        return false;
    }

}
