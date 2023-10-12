package com.example.cs2340b_team39.View;

import android.content.Intent;
//import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cs2340b_team39.R;
import com.example.cs2340b_team39.ViewModel.ViewModel;

public class ConfigActivity extends AppCompatActivity {
    private static int sprite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);
        Button startGame = findViewById(R.id.startgame);
        TextView configureError = findViewById(R.id.textView7);
        configureError.setVisibility(View.INVISIBLE);

        startGame.setOnClickListener(v -> {
            EditText name = findViewById(R.id.plain_text_input);
            int characterId;
            RadioGroup difficultyRadioGroup = findViewById(R.id.radioGroup);
            RadioGroup characterGroup = findViewById(R.id.radioGroup2);
            double difficulty;
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
                difficulty = -1;
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
                characterId = -1;
                break;
            }
            //System.out.println((name.getText()));
            //System.out.println(difficulty);
            //System.out.println(characterId);
            //isBlank() throwing an error for some reason so I'm leaving it off for now
            String spriteName = String.valueOf(name.getText());
            if (ViewModel.validateCredentials(spriteName, (int) difficulty, characterId)) {
                ViewModel.createPlayer(String.valueOf(name.getText()), characterId, difficulty);
                Intent game = new Intent(ConfigActivity.this, GameActivity.class);
                sprite = characterId;
                startActivity(game);
                //finish();
            } else {
                //TextView configureError = findViewById(R.id.textView7);
                configureError.setVisibility(View.VISIBLE);
            }
            //GameActivity.createPlayer(String.valueOf(name.getText()), characterId, difficulty);
            //Intent game = new Intent(ConfigActivity.this, GameActivity.class);
            //startActivity(game);
            //finish();
        });
    }
    public static int getSprite() {
        return sprite;
    }

}
