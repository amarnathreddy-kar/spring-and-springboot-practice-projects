package com.amar.springdemo;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService{

    //create an array of strings
    private String[] data = {
            "Beware of the wolf in sheep's clothing",
            "Diligence is the mother of good luck",
            "The journey is the reward!"
    };

    private Random rand = new Random();


    @Override
    public String getFortune() {
        //pick a random string from the array index
        int index = rand.nextInt(data.length);

        String theFortune = data[index];

        return theFortune;
    }
}
