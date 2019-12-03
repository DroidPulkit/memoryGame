package com.remandeep.memoryGame;

import android.content.Context;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class RandomNumberGenerator {

    private Context mContext;

    private ArrayList<Integer> numbers = new ArrayList<Integer>();


    RandomNumberGenerator(Context context, int howManyNumbers, String maxNumber){
        mContext = context;
        generateNumbers(howManyNumbers, maxNumber);
    }


    private void generateNumbers(int howManyNumbers, String maxNumber){
        int min = 0;
        int max = Integer.valueOf(maxNumber);

        for (int i=0; i < howManyNumbers; i++){
            int rand = new Random().nextInt(max - min + 1) + min  ;
            numbers.add(rand);
        }
    }

    //We will again randomise the position of all the numbers and then give to activity
    ArrayList<Integer> getListOfNumber(){
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.addAll(numbers);
        a.addAll(numbers);
        Collections.shuffle(a);

        return a;
    }



}
