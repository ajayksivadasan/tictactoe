package com.example.tictactoe.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tictactoe.R;
import com.example.tictactoe.ui.game.GameActivity;

public class MainActivity extends AppCompatActivity {
    Button btPlayGame;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        initIds();
        btPlayGame.setOnClickListener(v -> {
            startActivity(new Intent(context, GameActivity.class));
        });
    }

    private void initIds() {
        btPlayGame = findViewById(R.id.btPlayGame);
    }
}