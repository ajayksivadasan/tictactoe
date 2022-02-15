package com.example.tictactoe.utils;

import android.content.Context;
import android.widget.Toast;

public class Common {
    private Context context;

    public Common(Context context) {
        this.context = context;
    }

    public void getToast(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
