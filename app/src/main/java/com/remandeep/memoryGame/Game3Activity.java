package com.remandeep.memoryGame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class Game3Activity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<Integer> numbers = new ArrayList<Integer>();

    Button endGame;
    Chronometer timer;
    TextView score;
    Button cell1, cell2, cell3, cell4, cell5, cell6, cell7,
            cell8, cell9, cell10, cell11, cell12,
            cell13, cell14, cell15, cell16, cell17,
            cell18, cell19, cell20, cell21, cell22, cell23, cell24, cell25,
            cell26, cell27, cell28, cell29, cell30, cell31, cell32, cell33, cell34, cell35, cell36;

    SharePrefHelper sharePrefHelper;

    HashMap<String, Button> buttonSelector = new HashMap<String, Button>();

    Boolean firstBtnSelected = false;
    Boolean twoBtnSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game3);

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
        cell17 = findViewById(R.id.gameCell17);
        cell18 = findViewById(R.id.gameCell18);
        cell19 = findViewById(R.id.gameCell19);
        cell20 = findViewById(R.id.gameCell20);
        cell21 = findViewById(R.id.gameCell21);
        cell22 = findViewById(R.id.gameCell22);
        cell23 = findViewById(R.id.gameCell23);
        cell24 = findViewById(R.id.gameCell24);
        cell25 = findViewById(R.id.gameCell25);
        cell26 = findViewById(R.id.gameCell26);
        cell27 = findViewById(R.id.gameCell27);
        cell28 = findViewById(R.id.gameCell28);
        cell29 = findViewById(R.id.gameCell29);
        cell30 = findViewById(R.id.gameCell30);
        cell31 = findViewById(R.id.gameCell31);
        cell32 = findViewById(R.id.gameCell32);
        cell33 = findViewById(R.id.gameCell33);
        cell34 = findViewById(R.id.gameCell34);
        cell35 = findViewById(R.id.gameCell35);
        cell36 = findViewById(R.id.gameCell36);

        sharePrefHelper = new SharePrefHelper(this);

        //Listeners
        endGame.setOnClickListener(this);

        //Start timer
        timer.setBase(SystemClock.elapsedRealtime());
        timer.start();

        String maxNumber = sharePrefHelper.getNumberRange();

        //Get Random numbers
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator(this, 18, maxNumber);
        numbers = randomNumberGenerator.getListOfNumber();

        //First assign the numbers to the buttons
        initCells();

        //Now we can show all the values for the waiting time
        String waitingTime = sharePrefHelper.getStartingWait();
        showAllCellForTime(waitingTime);

        //Find if we need to show timer or not
        Boolean enableTimer = sharePrefHelper.getTimer();
        if (!enableTimer){
            timer.stop();
            findViewById(R.id.timerLayout).setVisibility(View.GONE);
        }

        enableClickAndShowNumber();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.gameScreenEndGameBtn: {
                if (timer != null) {
                    timer.stop();
                }

                String finalScore = score.getText().toString();
                String time = timer.getText().toString();

                Intent intent = new Intent(Game3Activity.this, ResultActivity.class);
                intent.putExtra("score", finalScore);
                intent.putExtra("time", time);
                startActivity(intent);
                finish();

                //Then move to the result screen
            }
        }
    }

    void initCells() {
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
        cell17.setTag(numbers.get(16));
        cell18.setTag(numbers.get(17));
        cell19.setTag(numbers.get(18));
        cell20.setTag(numbers.get(19));
        cell21.setTag(numbers.get(20));
        cell22.setTag(numbers.get(21));
        cell23.setTag(numbers.get(22));
        cell24.setTag(numbers.get(23));
        cell25.setTag(numbers.get(24));
        cell26.setTag(numbers.get(25));
        cell27.setTag(numbers.get(26));
        cell28.setTag(numbers.get(27));
        cell29.setTag(numbers.get(28));
        cell30.setTag(numbers.get(29));
        cell31.setTag(numbers.get(30));
        cell32.setTag(numbers.get(31));
        cell33.setTag(numbers.get(32));
        cell34.setTag(numbers.get(33));
        cell35.setTag(numbers.get(34));
        cell36.setTag(numbers.get(35));
    }

    void showAllCellForTime(String time) {
        cell1.setText(cell1.getTag().toString());
        cell2.setText(cell2.getTag().toString());
        cell3.setText(cell3.getTag().toString());
        cell4.setText(cell4.getTag().toString());
        cell5.setText(cell5.getTag().toString());
        cell6.setText(cell6.getTag().toString());
        cell7.setText(cell7.getTag().toString());
        cell8.setText(cell8.getTag().toString());
        cell9.setText(cell9.getTag().toString());
        cell10.setText(cell10.getTag().toString());
        cell11.setText(cell11.getTag().toString());
        cell12.setText(cell12.getTag().toString());
        cell13.setText(cell13.getTag().toString());
        cell14.setText(cell14.getTag().toString());
        cell15.setText(cell15.getTag().toString());
        cell16.setText(cell16.getTag().toString());
        cell17.setText(cell17.getTag().toString());
        cell18.setText(cell18.getTag().toString());
        cell19.setText(cell19.getTag().toString());
        cell20.setText(cell20.getTag().toString());
        cell21.setText(cell21.getTag().toString());
        cell22.setText(cell22.getTag().toString());
        cell23.setText(cell23.getTag().toString());
        cell24.setText(cell24.getTag().toString());
        cell25.setText(cell25.getTag().toString());
        cell26.setText(cell26.getTag().toString());
        cell27.setText(cell27.getTag().toString());
        cell28.setText(cell28.getTag().toString());
        cell29.setText(cell29.getTag().toString());
        cell30.setText(cell30.getTag().toString());
        cell31.setText(cell31.getTag().toString());
        cell32.setText(cell32.getTag().toString());
        cell33.setText(cell33.getTag().toString());
        cell34.setText(cell34.getTag().toString());
        cell35.setText(cell35.getTag().toString());
        cell36.setText(cell36.getTag().toString());

        int wait = Integer.valueOf(time) * 1000;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                cell1.setText("");
                cell2.setText("");
                cell3.setText("");
                cell4.setText("");
                cell5.setText("");
                cell6.setText("");
                cell7.setText("");
                cell8.setText("");
                cell9.setText("");
                cell10.setText("");
                cell11.setText("");
                cell12.setText("");
                cell13.setText("");
                cell14.setText("");
                cell15.setText("");
                cell16.setText("");
                cell17.setText("");
                cell18.setText("");
                cell19.setText("");
                cell20.setText("");
                cell21.setText("");
                cell22.setText("");
                cell23.setText("");
                cell24.setText("");
                cell25.setText("");
                cell26.setText("");
                cell27.setText("");
                cell28.setText("");
                cell29.setText("");
                cell30.setText("");
                cell31.setText("");
                cell32.setText("");
                cell33.setText("");
                cell34.setText("");
                cell35.setText("");
                cell36.setText("");

            }
        }, wait);
    }

    void enableClickAndShowNumber() {
        setOnClick(cell1);
        setOnClick(cell2);
        setOnClick(cell3);
        setOnClick(cell4);
        setOnClick(cell5);
        setOnClick(cell6);
        setOnClick(cell7);
        setOnClick(cell8);
        setOnClick(cell9);
        setOnClick(cell10);
        setOnClick(cell11);
        setOnClick(cell12);
        setOnClick(cell13);
        setOnClick(cell14);
        setOnClick(cell15);
        setOnClick(cell16);
        setOnClick(cell17);
        setOnClick(cell18);
        setOnClick(cell19);
        setOnClick(cell20);
        setOnClick(cell21);
        setOnClick(cell22);
        setOnClick(cell23);
        setOnClick(cell24);
        setOnClick(cell25);
        setOnClick(cell26);
        setOnClick(cell27);
        setOnClick(cell28);
        setOnClick(cell29);
        setOnClick(cell30);
        setOnClick(cell31);
        setOnClick(cell32);
        setOnClick(cell33);
        setOnClick(cell34);
        setOnClick(cell35);
        setOnClick(cell36);
    }

    void setOnClick(final Button c) {
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!twoBtnSelected) {
                    c.setText(c.getTag().toString());
                    if (!firstBtnSelected) {
                        buttonSelector.put("firstCell", c);
                        firstBtnSelected = true;
                        c.setEnabled(false);
                    } else {
                        Button firstBtn = buttonSelector.get("firstCell");
                        if (firstBtn.getTag().toString() == c.getTag().toString()) {
                            //Probably a match of numbers
                            //Disabling the btns onclicklistener
                            c.setEnabled(false);
                            //Remove the hashmap
                            buttonSelector.clear();
                            //Update the score
                            String s = score.getText().toString();
                            String finalS = String.valueOf(Integer.valueOf(s) + 1);
                            score.setText(finalS);
                        } else {
                            //No match of number
                            //We will keep showing the number for the 3 seconds
                            twoBtnSelected = true;

                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    //making 2nd btn txt empty
                                    c.setText("");
                                    //making 1st btn txt empty
                                    Button firstBtn = buttonSelector.get("firstCell");
                                    firstBtn.setText("");
                                    //Remove the hashmap
                                    buttonSelector.clear();
                                    twoBtnSelected = false;
                                }
                            }, 3000);
                            firstBtn.setEnabled(true);
                        }
                        //As second button is clicked, always make this false
                        firstBtnSelected = false;
                    }
                }
            }
        });
    }
}
