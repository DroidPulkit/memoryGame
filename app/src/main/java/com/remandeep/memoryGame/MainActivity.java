package com.remandeep.memoryGame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button setting = findViewById(R.id.mainMenuSetting);
        Button exit = findViewById(R.id.mainMenuExit);
        Button start = findViewById(R.id.mainMenuStart);
        setting.setOnClickListener(this);
        exit.setOnClickListener(this);
        start.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mainMenuSetting : {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
                break;
            }

            case R.id.mainMenuExit : {
                finish();
                break;
            }

            case R.id.mainMenuStart : {
                SharePrefHelper sharePrefHelper = new SharePrefHelper(MainActivity.this);
                String gameSizeValue = sharePrefHelper.getGameSize();
                if (gameSizeValue.equals("4")) {
                    Intent intent = new Intent(MainActivity.this, Game1Activity.class);
                    startActivity(intent);
                } else if (gameSizeValue.equals("5")) {
                    Intent intent = new Intent(MainActivity.this, Game2Activity.class);
                    startActivity(intent);
                } else if (gameSizeValue.equals("6")) {
                    Intent intent = new Intent(MainActivity.this, Game3Activity.class);
                    startActivity(intent);
                }
            }
        }
    }
}
