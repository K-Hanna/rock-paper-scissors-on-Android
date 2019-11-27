package com.example.android.rps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private String firstName;
    private int scorePlayer, scoreComp;
    IPlay play = new Play();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submit (View v) {
        EditText nameField = findViewById(R.id.name);
        firstName = nameField.getText().toString();
    }

    public void ok(View view){
        EditText nameField = findViewById(R.id.name);
        nameField.setEnabled(false);
    }

   private void score_player(){
        scorePlayer = play.getPlayer().getPointPlayer();
        displayForPlayer(scorePlayer);
    }
    private void score_comp(){
        scoreComp = play.getComp().getPointComp();
        displayForComp(scoreComp);
    }

    private void displayForPlayer(int score) {
        TextView scoreView = findViewById(R.id.score_player);
        scoreView.setText(String.valueOf(score));
    }
    private void displayForComp(int score) {
        TextView scoreView = findViewById(R.id.score_comp);
        scoreView.setText(String.valueOf(score));
    }

    private void displayMove(){
        ImageView moveView = findViewById(R.id.move);
        String move = play.check();
        switch (move){
            case "Paper wraps rock.":
                moveView.setImageResource(R.drawable.pk);
                break;
            case "Rock crushes scissors.":
                moveView.setImageResource(R.drawable.kn);
                break;
            case "Scissors cut paper.":
                moveView.setImageResource(R.drawable.np);
                break;
            case " ":
                moveView.setImageResource(R.drawable.none);
                break;
        }
        score_comp();
        score_player();
    }
    private void displayMoveComp(){
        ImageView moveCompView = findViewById(R.id.move_comp);
        play.getComp().setMoveComp();
        String move = play.getComp().getMoveComp();
        switch (move){
            case "rock":
                moveCompView.setImageResource(R.drawable.k);
                break;
            case "paper":
                moveCompView.setImageResource(R.drawable.p);
                break;
            case "scissors":
                moveCompView.setImageResource(R.drawable.n);
                break;
            case "":
                moveCompView.setImageResource(R.drawable.none);
                break;
        }
    }
    private void resetMoves(){
        ImageView moveCompView = findViewById(R.id.move_comp);
        moveCompView.setImageResource(R.drawable.none);
        ImageView moveView = findViewById(R.id.move);
        moveView.setImageResource(R.drawable.none);
        ImageView movePlayerView = findViewById(R.id.move_player);
        movePlayerView.setImageResource(R.drawable.none);
    }
    public void rock(View view){
        ImageView movePlayerView = findViewById(R.id.move_player);
        movePlayerView.setImageResource(R.drawable.k);
        play.setPlayer("rock");
        displayMoveComp();
        displayMove();
    }
    public void paper(View view){
        ImageView movePlayerView = findViewById(R.id.move_player);
        movePlayerView.setImageResource(R.drawable.p);
        play.setPlayer("paper");
        displayMoveComp();
        displayMove();
    }
    public void scissors(View view){
        ImageView movePlayerView = findViewById(R.id.move_player);
        movePlayerView.setImageResource(R.drawable.n);
        play.setPlayer("scissors");
        displayMoveComp();
        displayMove();
    }
    private void disabledButtons(){
        ImageButton rock = findViewById(R.id.rock);
        rock.setEnabled(false);
        ImageButton paper = findViewById(R.id.paper);
        paper.setEnabled(false);
        ImageButton scissors = findViewById(R.id.scissors);
        scissors.setEnabled(false);
    }
    private void enabledButtons(){
        ImageButton rock = findViewById(R.id.rock);
        rock.setEnabled(true);
        ImageButton paper = findViewById(R.id.paper);
        paper.setEnabled(true);
        ImageButton scissors = findViewById(R.id.scissors);
        scissors.setEnabled(true);
    }

    public void finish(View view){
        TextView textView = findViewById(R.id.message);
        EditText nameField = findViewById(R.id.name);
        firstName = nameField.getText().toString();
        String message = play.message(firstName);
        textView.setText(message);
        disabledButtons();
    }
    public void reset(View view){
        TextView textView = findViewById(R.id.message);
        EditText nameField = findViewById(R.id.name);
        nameField.setEnabled(true);
        play.getPlayer().setPointPlayer(0);
        play.getComp().setPointComp(0);
        score_comp();
        score_player();
        textView.setText("");
        resetMoves();
        enabledButtons();
    }
}

