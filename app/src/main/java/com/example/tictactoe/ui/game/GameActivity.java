package com.example.tictactoe.ui.game;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import com.example.tictactoe.R;
import com.example.tictactoe.databinding.ActivityGameBinding;
import com.example.tictactoe.utils.Common;

import java.util.ArrayList;
import java.util.List;

public class GameActivity extends AppCompatActivity {
    ActivityGameBinding gameBinding;
    boolean player1 = true;
    Context activity;
    List<RawColumn> rawColumnList = new ArrayList<>();
    Common commonClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        commonClass = new Common(activity);
        gameBinding = DataBindingUtil.setContentView(this, R.layout.activity_game);
        selectColumn();
        setOnClickListeners();
        isGameFinished();
    }

    private int isGameFinished() {
        int isGameFinished = 0;
        String checkListPlayer1 = "";
        String checkListPlayer2 = "";
        if (rawColumnList.isEmpty()) {
            return 0;
        }
        for (RawColumn player : rawColumnList) {
            if (player.getPlayer1()) {
                checkListPlayer1 = player.getRaw() + player.getColumn() + ",";
            } else {
                checkListPlayer2 = player.getRaw() + player.getColumn() + ",";
            }
        }
        String[] player1Split = checkListPlayer1.split(",");

        //a1,a2,a3= win
        //b1,b2,b3= win
        //c1,c2,c3= win
        //a1,b1,c1= win
        //a2,b2,c2= win
        //a3,b3,c3= win
        //a1,b2,c3= win
        //a3,b2,c1= win
        return isGameFinished;
    }

    private void setOnClickListeners() {
        gameBinding.btA1.setOnClickListener(v -> {
            if (!checkAlreadyInserted("a", 1)) {
                if (player1) {
                    gameBinding.btA1.setCompoundDrawables(null, ContextCompat.getDrawable(activity, R.drawable.ic_baseline_close_24), null, null);
                } else {
                    gameBinding.btA1.setCompoundDrawables(null, ContextCompat.getDrawable(activity, R.drawable.ic_baseline_circle_24), null, null);
                }
                rawColumnList.add(new RawColumn("a", 1, selectColumn()));
            }
            showGameFinished(isGameFinished());
        });
        gameBinding.btA2.setOnClickListener(v -> {
            if (!checkAlreadyInserted("a", 2)) {
                if (player1) {
                    gameBinding.btA2.setCompoundDrawables(null, ContextCompat.getDrawable(activity, R.drawable.ic_baseline_close_24), null, null);
                } else {
                    gameBinding.btA2.setCompoundDrawables(null, ContextCompat.getDrawable(activity, R.drawable.ic_baseline_circle_24), null, null);
                }
                rawColumnList.add(new RawColumn("a", 2, selectColumn()));
            }
            showGameFinished(isGameFinished());
        });
        gameBinding.btA3.setOnClickListener(v -> {
            if (!checkAlreadyInserted("a", 3)) {
                if (player1) {
                    gameBinding.btA3.setCompoundDrawables(null, ContextCompat.getDrawable(activity, R.drawable.ic_baseline_close_24), null, null);
                } else {
                    gameBinding.btA3.setCompoundDrawables(null, ContextCompat.getDrawable(activity, R.drawable.ic_baseline_circle_24), null, null);
                }
                rawColumnList.add(new RawColumn("a", 3, selectColumn()));
            }
            showGameFinished(isGameFinished());
        });
        gameBinding.btB1.setOnClickListener(v -> {
            if (!checkAlreadyInserted("b", 1)) {
                if (player1) {
                    gameBinding.btB1.setCompoundDrawables(null, ContextCompat.getDrawable(activity, R.drawable.ic_baseline_close_24), null, null);
                } else {
                    gameBinding.btB1.setCompoundDrawables(null, ContextCompat.getDrawable(activity, R.drawable.ic_baseline_circle_24), null, null);
                }
                rawColumnList.add(new RawColumn("b", 1, selectColumn()));
            }
            showGameFinished(isGameFinished());
        });
        gameBinding.btB2.setOnClickListener(v -> {
            if (!checkAlreadyInserted("b", 2)) {
                if (player1) {
                    gameBinding.btB2.setCompoundDrawables(null, ContextCompat.getDrawable(activity, R.drawable.ic_baseline_close_24), null, null);
                } else {
                    gameBinding.btB2.setCompoundDrawables(null, ContextCompat.getDrawable(activity, R.drawable.ic_baseline_circle_24), null, null);
                }
                rawColumnList.add(new RawColumn("b", 2, selectColumn()));
            }
            showGameFinished(isGameFinished());
        });
        gameBinding.btB3.setOnClickListener(v -> {
            if (!checkAlreadyInserted("b", 3)) {
                if (player1) {
                    gameBinding.btB3.setCompoundDrawables(null, ContextCompat.getDrawable(activity, R.drawable.ic_baseline_close_24), null, null);
                } else {
                    gameBinding.btB3.setCompoundDrawables(null, ContextCompat.getDrawable(activity, R.drawable.ic_baseline_circle_24), null, null);
                }
                rawColumnList.add(new RawColumn("b", 3, selectColumn()));
            }
            showGameFinished(isGameFinished());
        });
        gameBinding.btC1.setOnClickListener(v -> {
            if (!checkAlreadyInserted("c", 1)) {
                if (player1) {
                    gameBinding.btC1.setCompoundDrawables(null, ContextCompat.getDrawable(activity, R.drawable.ic_baseline_close_24), null, null);
                } else {
                    gameBinding.btC1.setCompoundDrawables(null, ContextCompat.getDrawable(activity, R.drawable.ic_baseline_circle_24), null, null);
                }
                rawColumnList.add(new RawColumn("c", 1, selectColumn()));
            }
            showGameFinished(isGameFinished());
        });
        gameBinding.btC2.setOnClickListener(v -> {
            if (!checkAlreadyInserted("c", 2)) {
                if (player1) {
                    gameBinding.btC2.setCompoundDrawables(null, ContextCompat.getDrawable(activity, R.drawable.ic_baseline_close_24), null, null);
                } else {
                    gameBinding.btC2.setCompoundDrawables(null, ContextCompat.getDrawable(activity, R.drawable.ic_baseline_circle_24), null, null);
                }
                rawColumnList.add(new RawColumn("c", 2, selectColumn()));
            }
            showGameFinished(isGameFinished());
        });
        gameBinding.btC3.setOnClickListener(v -> {
            if (!checkAlreadyInserted("c", 3)) {
                if (player1) {
                    gameBinding.btC3.setCompoundDrawables(null, ContextCompat.getDrawable(activity, R.drawable.ic_baseline_close_24), null, null);
                } else {
                    gameBinding.btC3.setCompoundDrawables(null, ContextCompat.getDrawable(activity, R.drawable.ic_baseline_circle_24), null, null);
                }
                rawColumnList.add(new RawColumn("c", 3, selectColumn()));
            }
            showGameFinished(isGameFinished());
        });
    }

    private void showGameFinished(int gameFinished) {
        switch (gameFinished) {
            case 1:
                commonClass.getToast("Player1 Wins");
                break;
            case 2:
                commonClass.getToast("Player2 Wins");
                break;
            default:
                break;
        }
    }

    private boolean checkAlreadyInserted(String rawName, int column) {
        boolean alreadySelected = false;
        for (RawColumn raw : rawColumnList) {
            if (raw.getRaw().equals(rawName) && raw.getColumn() == column) {
                alreadySelected = true;
                alreadySelected(rawName + column);
                break;
            }
        }
        return alreadySelected;
    }

    private void alreadySelected(String rawColumn) {
        commonClass.getToast(rawColumn + " is Already Selected");
    }

    private boolean selectColumn() {
        player1 = !player1;
        return !player1;
    }

    public void onClick(View v) {
        //a1,a2,a3= win
        //b1,b2,b3= win
        //c1,c2,c3= win
        //a1,b1,c1=win
        //a1,b2,c3= win
        //a3,b2,c1=win
    }

    private static class RawColumn {
        private String raw;
        private int column;
        private boolean player1;

        public RawColumn(String raw, int column, boolean player1) {
            this.raw = raw;
            this.column = column;
            this.player1 = player1;
        }

        public int getColumn() {
            return column;
        }

        public void setColumn(int column) {
            this.column = column;
        }

        public String getRaw() {
            return raw;
        }

        public void setRaw(String raw) {
            this.raw = raw;
        }

        public boolean getPlayer1() {
            return player1;
        }

        public void setPlayer1(boolean player1) {
            this.player1 = player1;
        }
    }
}