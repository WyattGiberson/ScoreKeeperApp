package com.hfad.scorekeeperapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int scoreLeft = 0;
    private int scoreRight = 0;
    private String teamLeft = "Home";
    private String teamRight = "Away";

    //KEYS for use with the bundle
    public static final String LEFT_KEY= "leftScore";
    public static final String TEAM_LEFT= "leftTeam";
    public static final String RIGHT_KEY= "rightScore";
    public static final String TEAM_RIGHT= "rightTeam";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //settup buttons and text views
        Button btnLeft = findViewById(R.id.btnLeft);
        Button btnRight = findViewById(R.id.btnRight);

        TextView leftScore = (TextView) findViewById(R.id.leftScore);
        TextView rightScore = (TextView) findViewById(R.id.rightScore);
        EditText leftTeam = (EditText) findViewById(R.id.editTextLeft);
        EditText rightTeam = (EditText) findViewById(R.id.editTextRight);

        //Restore
        if (savedInstanceState != null){
            scoreLeft = savedInstanceState.getInt(LEFT_KEY);
            scoreRight = savedInstanceState.getInt(RIGHT_KEY);
            teamLeft = savedInstanceState.getString(TEAM_LEFT);
            teamRight = savedInstanceState.getString(TEAM_RIGHT);
        }
        leftTeam.setText(teamLeft);
        rightTeam.setText(teamRight);
        leftScore.setText(String.valueOf(scoreLeft));
        rightScore.setText(String.valueOf(scoreRight));


        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreLeft = Integer.parseInt(leftScore.getText().toString());
                System.out.println(scoreLeft);
                scoreLeft = scoreLeft + 1;
                System.out.println(scoreLeft);
                leftScore.setText(String.valueOf(scoreLeft));
            }
        });
        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreRight = Integer.parseInt(rightScore.getText().toString());
                System.out.println(scoreRight);
                scoreRight = scoreRight + 1;
                System.out.println(scoreRight);
                rightScore.setText(String.valueOf(scoreRight));
            }
        });

    }
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState)
    {

        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt(LEFT_KEY, scoreLeft);
        savedInstanceState.putString(TEAM_LEFT, teamLeft);
        savedInstanceState.putInt(RIGHT_KEY, scoreRight);
        savedInstanceState.putString(TEAM_RIGHT, teamRight);
    }
}


