package com.example.tictactoe.ui.game.view_model;


import androidx.lifecycle.ViewModel;

import com.example.tictactoe.utils.Common;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

@HiltViewModel
public class GameViewModel extends ViewModel {
    Disposable disposable;
    @Inject
    Common common;

    @Inject
    public GameViewModel() {
        disposable = new CompositeDisposable();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.dispose();
    }
}
