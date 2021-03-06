package com.example.suzane.test;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button play;
    Button info;
    TextView niveau;
    TextView score;
    SharedPreferences sf;
    public static final String pref = "pref";
    public static final String scoreSh = "score";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sf = getSharedPreferences(pref, Context.MODE_PRIVATE);
        play = (Button) findViewById(R.id.play);
        info = (Button) findViewById(R.id.info);
        niveau = (TextView) findViewById(R.id.tv);
        score = (TextView) findViewById(R.id.score);

        play.setOnClickListener(this);
        info.setOnClickListener(this);
        if (sf.contains(scoreSh)){
            score.setText(sf.getString(scoreSh,null));
        }

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.play) {
            Intent i = new Intent(MainActivity.this,Game.class);
            i.putExtra("score",score.getText().toString());

            startActivity(i);
            finish();

        }else if (v.getId() == R.id.info) {
            Intent i = new Intent(MainActivity.this,Info.class);

            startActivity(i);
            finish();


        }


    }
}
