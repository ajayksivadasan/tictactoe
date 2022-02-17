package com.example.tictactoe.ui.game;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import com.example.tictactoe.R;
import com.example.tictactoe.databinding.ActivityGameBinding;
import com.example.tictactoe.ui.game.model.Cells;
import com.example.tictactoe.ui.game.model.Player;
import com.example.tictactoe.ui.main.MainActivity;
import com.example.tictactoe.utils.Common;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class GameActivity extends AppCompatActivity {
    ActivityGameBinding gameBinding;
    @Inject
    Common commonClass;

    boolean player1 = true;
    Context context;
    Cells[][] cells = new Cells[3][3];
    int currentRow;
    int currentCol;
    List<RawColumn> rawColumnList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        context = this;
        super.onCreate(savedInstanceState);
        gameBinding = DataBindingUtil.setContentView(this, R.layout.activity_game);
        selectColumn();
        clearCells();
        setOnClickListeners();
        gameBinding.btGoBack.setOnClickListener(v -> {
            onBackPressed();
        });
        gameBinding.btReset.setOnClickListener(v -> {
            resetGame();
        });

    }

    @Override
    public void onBackPressed() {
        finish();
        startActivity(new Intent(context, MainActivity.class));
    }

    private void resetGame() {
        gameBinding.btA1.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        gameBinding.btA2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        gameBinding.btA3.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        gameBinding.btB1.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        gameBinding.btB2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        gameBinding.btB3.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        gameBinding.btC1.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        gameBinding.btC2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        gameBinding.btC3.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        rawColumnList.clear();
        clearCells();
    }

    private int isGameFinished() {
        int isGameFinished = 0;
        if (rawColumnList.isEmpty()) {
            return 0;
        } else {
            Player player;
            if (!player1) {
                player = Player.X;
                if ((cells[currentRow][0].getValue() == player         // 3-in-the-row
                        && cells[currentRow][1].getValue() == player
                        && cells[currentRow][2].getValue() == player)
                        || (cells[0][currentCol].getValue() == player      // 3-in-the-column
                        && cells[1][currentCol].getValue() == player
                        && cells[2][currentCol].getValue() == player)
                        || (currentRow == currentCol            // 3-in-the-diagonal
                        && cells[0][0].getValue() == player
                        && cells[1][1].getValue() == player
                        && cells[2][2].getValue() == player)
                        || (currentRow + currentCol == 2    // 3-in-the-opposite-diagonal
                        && cells[0][2].getValue() == player
                        && cells[1][1].getValue() == player
                        && cells[2][0].getValue() == player)) {
                    return 2;
                }
            } else {
                player = Player.O;
                if ((cells[currentRow][0].getValue() == player         // 3-in-the-row
                        && cells[currentRow][1].getValue() == player
                        && cells[currentRow][2].getValue() == player)
                        || (cells[0][currentCol].getValue() == player      // 3-in-the-column
                        && cells[1][currentCol].getValue() == player
                        && cells[2][currentCol].getValue() == player)
                        || (currentRow == currentCol            // 3-in-the-diagonal
                        && cells[0][0].getValue() == player
                        && cells[1][1].getValue() == player
                        && cells[2][2].getValue() == player)
                        || (currentRow + currentCol == 2    // 3-in-the-opposite-diagonal
                        && cells[0][2].getValue() == player
                        && cells[1][1].getValue() == player
                        && cells[2][0].getValue() == player)) {
                    return 1;
                }
            }
            if (rawColumnList.size() == 9) {
                return 4;
            }
        }


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
            if (!checkAlreadyInserted("a", 1) && isGameFinished() == 0) {
                currentCol = 0;
                currentRow = 0;
                if (player1) {
                    cells[0][0].setPlayer(Player.X);
                    gameBinding.btA1.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(context, R.drawable.ic_baseline_close_24), null, null);
                } else {
                    cells[0][0].setPlayer(Player.O);
                    gameBinding.btA1.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(context, R.drawable.ic_baseline_circle_24), null, null);
                }
                rawColumnList.add(new RawColumn("a", 1, selectColumn()));
                showGameFinished(isGameFinished());
            }
        });
        gameBinding.btA2.setOnClickListener(v -> {
            if (!checkAlreadyInserted("a", 2) && isGameFinished() == 0) {
                currentCol = 1;
                currentRow = 0;
                if (player1) {
                    cells[0][1].setPlayer(Player.X);
                    gameBinding.btA2.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(context, R.drawable.ic_baseline_close_24), null, null);
                } else {
                    cells[0][1].setPlayer(Player.O);
                    gameBinding.btA2.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(context, R.drawable.ic_baseline_circle_24), null, null);
                }
                rawColumnList.add(new RawColumn("a", 2, selectColumn()));
                showGameFinished(isGameFinished());
            }
        });
        gameBinding.btA3.setOnClickListener(v -> {
            if (!checkAlreadyInserted("a", 3) && isGameFinished() == 0) {
                currentCol = 2;
                currentRow = 0;
                if (player1) {
                    cells[0][2].setPlayer(Player.X);
                    gameBinding.btA3.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(context, R.drawable.ic_baseline_close_24), null, null);
                } else {
                    cells[0][2].setPlayer(Player.O);
                    gameBinding.btA3.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(context, R.drawable.ic_baseline_circle_24), null, null);
                }
                rawColumnList.add(new RawColumn("a", 3, selectColumn()));
                showGameFinished(isGameFinished());
            }
        });
        gameBinding.btB1.setOnClickListener(v -> {
            if (!checkAlreadyInserted("b", 1) && isGameFinished() == 0) {
                currentCol = 0;
                currentRow = 1;
                if (player1) {
                    cells[1][0].setPlayer(Player.X);
                    gameBinding.btB1.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(context, R.drawable.ic_baseline_close_24), null, null);
                } else {
                    cells[1][0].setPlayer(Player.O);
                    gameBinding.btB1.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(context, R.drawable.ic_baseline_circle_24), null, null);
                }
                rawColumnList.add(new RawColumn("b", 1, selectColumn()));
                showGameFinished(isGameFinished());
            }
        });
        gameBinding.btB2.setOnClickListener(v -> {
            if (!checkAlreadyInserted("b", 2) && isGameFinished() == 0) {
                currentCol = 1;
                currentRow = 1;
                if (player1) {
                    cells[1][1].setPlayer(Player.X);
                    gameBinding.btB2.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(context, R.drawable.ic_baseline_close_24), null, null);
                } else {
                    cells[1][1].setPlayer(Player.O);
                    gameBinding.btB2.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(context, R.drawable.ic_baseline_circle_24), null, null);
                }
                rawColumnList.add(new RawColumn("b", 2, selectColumn()));
                showGameFinished(isGameFinished());
            }
        });
        gameBinding.btB3.setOnClickListener(v -> {
            if (!checkAlreadyInserted("b", 3) && isGameFinished() == 0) {
                currentCol = 2;
                currentRow = 1;
                if (player1) {
                    cells[1][2].setPlayer(Player.X);
                    gameBinding.btB3.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(context, R.drawable.ic_baseline_close_24), null, null);
                } else {
                    cells[1][2].setPlayer(Player.O);
                    gameBinding.btB3.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(context, R.drawable.ic_baseline_circle_24), null, null);
                }
                rawColumnList.add(new RawColumn("b", 3, selectColumn()));
                showGameFinished(isGameFinished());
            }
        });
        gameBinding.btC1.setOnClickListener(v -> {
            if (!checkAlreadyInserted("c", 1) && isGameFinished() == 0) {
                currentCol = 0;
                currentRow = 2;
                if (player1) {
                    cells[2][0].setPlayer(Player.X);
                    gameBinding.btC1.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(context, R.drawable.ic_baseline_close_24), null, null);
                } else {
                    cells[2][0].setPlayer(Player.O);
                    gameBinding.btC1.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(context, R.drawable.ic_baseline_circle_24), null, null);
                }
                rawColumnList.add(new RawColumn("c", 1, selectColumn()));
                showGameFinished(isGameFinished());
            }
        });
        gameBinding.btC2.setOnClickListener(v -> {
            if (!checkAlreadyInserted("c", 2) && isGameFinished() == 0) {
                currentCol = 1;
                currentRow = 2;
                if (player1) {
                    cells[2][1].setPlayer(Player.X);
                    gameBinding.btC2.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(context, R.drawable.ic_baseline_close_24), null, null);
                } else {
                    cells[2][1].setPlayer(Player.O);
                    gameBinding.btC2.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(context, R.drawable.ic_baseline_circle_24), null, null);
                }
                rawColumnList.add(new RawColumn("c", 2, selectColumn()));
                showGameFinished(isGameFinished());
            }

        });
        gameBinding.btC3.setOnClickListener(v -> {
            if (!checkAlreadyInserted("c", 3) && isGameFinished() == 0) {
                currentCol = 2;
                currentRow = 2;
                if (player1) {
                    cells[2][2].setPlayer(Player.X);
                    gameBinding.btC3.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(context, R.drawable.ic_baseline_close_24), null, null);
                } else {
                    cells[2][2].setPlayer(Player.O);
                    gameBinding.btC3.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(context, R.drawable.ic_baseline_circle_24), null, null);
                }
                rawColumnList.add(new RawColumn("c", 3, selectColumn()));
                showGameFinished(isGameFinished());
            }
        });
    }

    private void showGameFinished(int gameFinished) {
        switch (gameFinished) {
            case 1:
                commonClass.getToast("Player 1 Wins");
                showAlertDialog(1);
                break;
            case 2:
                commonClass.getToast("Player 2 Wins");
                break;
            case 4:
                commonClass.getToast("Draw");
                break;
            default:
                break;
        }
    }

    private void showAlertDialog(int playerNo) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Game Finished");
        builder.setMessage("Player " + playerNo + " Wins\n Do you want to Replay?");
        builder.setPositiveButton("yes", (dialog, which) -> {
            dialog.dismiss();
            resetGame();
        });
        builder.setNegativeButton("No Go Back", (dialog, which) -> {
            dialog.dismiss();
            onBackPressed();
        });
        builder.setCancelable(false);
        builder.show();
    }

    private void clearCells() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = new Cells();
            }
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