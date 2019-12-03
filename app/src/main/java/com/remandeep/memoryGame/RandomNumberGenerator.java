package com.remandeep.memoryGame;

import android.content.Context;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class RandomNumberGenerator {

    Context mContext;

    ArrayList<Integer> numbers = new ArrayList<Integer>();


    RandomNumberGenerator(Context context, int howManyNumbers){
        mContext = context;
        generateNumbers(howManyNumbers);
    }


    private void generateNumbers(int howManyNumbers){

        for (int i=0; i < howManyNumbers; i++){
            int rand = (new Random().nextInt(91) + 10 ) * 10;
            numbers.add(rand);
            numbers.add(rand);
        }
    }

    //We will again randomise the position of all the numbers and then give to activity
    ArrayList<Integer> getListOfNumber(){
        Collections.shuffle(numbers);
        return numbers;
    }



}
