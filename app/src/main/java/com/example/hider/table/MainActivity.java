package com.example.hider.table;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;




public class MainActivity extends AppCompatActivity {
    private Button reStar;
    static TextView tvscore;
    private GameView gameView;
    private static int score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvscore = findViewById(R.id.score);
        reStar = findViewById(R.id.reStar);
        gameView = findViewById(R.id.gameview);
        reStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score = 0;
                gameView.startGame();
            }
        });


    }
    public static void addScore(int i){
        score +=i;
        tvscore.setText(score+"");
    }


}
