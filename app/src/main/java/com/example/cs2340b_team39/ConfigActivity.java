package com.example.cs2340b_team39;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;
public class ConfigActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);
        Button startGame = findViewById(R.id.startgame);

        startGame.setOnClickListener(v -> {
            EditText name = findViewById(R.id.plain_text_input);
            int characterId;
            RadioGroup difficultyRadioGroup = findViewById(R.id.radioGroup);
            RadioGroup characterGroup = findViewById(R.id.radioGroup2);
            double difficulty = 1;
            switch (difficultyRadioGroup.getCheckedRadioButtonId()) {
                case R.id.radioButton:
                    difficulty = 0;
                    break;
                case R.id.radioButton2:
                    difficulty = 1;
                    break;
                case R.id.radioButton3:
                    difficulty = 2;
                    break;
                default:
                    difficulty = 1;
                    break;
            }
            switch (characterGroup.getCheckedRadioButtonId()) {
                case R.id.imageButton:
                    characterId = 0;
                    break;
                case R.id.imageButton2:
                    characterId = 1;
                    break;
                case R.id.imageButton3:
                    characterId = 2;
                    break;
                default:
                    characterId = 0;
                    break;
            }
            GameActivity.createPlayer(String.valueOf(name.getText()), characterId, difficulty);
            Intent game = new Intent(ConfigActivity.this, GameActivity.class);
            startActivity(game);
            finish();
        });
    }

}
