package com.example.tictactoe.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.tictactoe.R;
import com.example.tictactoe.databinding.ActivityMainBinding;
import com.example.tictactoe.ui.game.GameActivity;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mainBinding;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.btPlayGame.setOnClickListener(v -> {
            startActivity(new Intent(context, GameActivity.class));
        });
    }

}