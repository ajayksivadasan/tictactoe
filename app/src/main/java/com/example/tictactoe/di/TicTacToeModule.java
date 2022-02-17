package com.example.tictactoe.di;

import android.content.Context;

import com.example.tictactoe.utils.Common;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class TicTacToeModule {
    @Provides
    @Singleton
    public Common providesCommonClass(@ApplicationContext Context context) {
        return Common.getInstance(context);
    }
}
