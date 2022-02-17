package com.example.tictactoe.utils;

import android.content.Context;
import android.widget.Toast;

public class Common {
    private final Context context;

    private Common(Context context) {
        this.context = context;
    }

    public static Common getInstance(Context context) {
        return new Common(context);
    }

    public void getToast(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
