package com.matache.hangman;

public interface Guess {
    boolean guess(char c, Game game);
    boolean isWordFound(final Game game);
    }
