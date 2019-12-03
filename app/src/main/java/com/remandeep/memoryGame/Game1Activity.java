package com.remandeep.memoryGame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import java.util.ArrayList;

public class Game1Activity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<Integer> numbers = new ArrayList<Integer>();

    Button endGame;
    Chronometer timer;
    TextView score;
    Button cell1, cell2, cell3, cell4, cell5, cell6, cell7, cell8, cell9, cell10, cell11, cell12, cell13, cell14, cell15, cell16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1);

        //Init
        endGame = findViewById(R.id.gameScreenEndGameBtn);
        timer = findViewById(R.id.gameScreenTimer);
        score = findViewById(R.id.gameScreenScore);
        cell1 = findViewById(R.id.gameCell1);
        cell2 = findViewById(R.id.gameCell2);
        cell3 = findViewById(R.id.gameCell3);
        cell4 = findViewById(R.id.gameCell4);
        cell5 = findViewById(R.id.gameCell5);
        cell6 = findViewById(R.id.gameCell6);
        cell7 = findViewById(R.id.gameCell7);
        cell8 = findViewById(R.id.gameCell8);
        cell9 = findViewById(R.id.gameCell9);
        cell10 = findViewById(R.id.gameCell10);
        cell11 = findViewById(R.id.gameCell11);
        cell12 = findViewById(R.id.gameCell12);
        cell13 = findViewById(R.id.gameCell13);
        cell14 = findViewById(R.id.gameCell14);
        cell15 = findViewById(R.id.gameCell15);
        cell16 = findViewById(R.id.gameCell16);

        //Listeners
        endGame.setOnClickListener(this);

        //Start timer
        timer.setBase(SystemClock.elapsedRealtime());
        timer.start();

        //Get Random numbers
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator(this, 4);
        numbers = randomNumberGenerator.getListOfNumber();

        //First assign the numbers to the buttons
        initCells();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.gameScreenEndGameBtn : {
                if (timer != null){
                    timer.stop();
                }

                String finalScore = score.getText().toString();
                String time = timer.getText().toString();

                Intent intent = new Intent(Game1Activity.this, ResultActivity.class);
                intent.putExtra("score", finalScore);
                intent.putExtra("time", time);
                startActivity(intent);

                //Then move to the result screen
            }
        }
    }

    void initCells(){
        cell1.setTag(numbers.get(0));
        cell2.setTag(numbers.get(1));
        cell3.setTag(numbers.get(2));
        cell4.setTag(numbers.get(3));
        cell5.setTag(numbers.get(4));
        cell6.setTag(numbers.get(5));
        cell7.setTag(numbers.get(6));
        cell8.setTag(numbers.get(7));
        cell9.setTag(numbers.get(8));
        cell10.setTag(numbers.get(9));
        cell11.setTag(numbers.get(10));
        cell12.setTag(numbers.get(11));
        cell13.setTag(numbers.get(12));
        cell14.setTag(numbers.get(13));
        cell15.setTag(numbers.get(14));
        cell16.setTag(numbers.get(15));
    }
}
