package com.matache.hangman;


import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@Service
public class WordUtils implements RandomChose, InsertLetter {
    final static String[] pollOfWords = {"house", "mouse", "mama", "chair", "blockbuster"};

    public String getWord(){
        Random rand = new Random();
        List<String> listOfWords = Arrays.asList(pollOfWords);
        return listOfWords.get(rand.nextInt(listOfWords.size())).toLowerCase();
    }

    public String typeLetter(){
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
}
