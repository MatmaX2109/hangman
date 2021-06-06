package com.matache.hangman;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class HangmanApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(HangmanApplication.class, args);
    }

    AppRun appRun;

    public HangmanApplication(AppRun appRun) {
        this.appRun = appRun;
    }

    @Override
    public void run(String... args) {
        appRun.run();
    }
}
