package app.quiz.frnd.frndquizapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

public class Home extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button buttonStart = (Button) findViewById(R.id.buttonStart);
        Button buttonCalc = (Button) findViewById(R.id.buttonCalc);
        Button buttonVideo = (Button) findViewById(R.id.buttonVideo);
        Button buttonTTS = (Button) findViewById(R.id.buttonTTS);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), quiz.class);
                startActivity(in);
            }
        });

        buttonCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),Calculator.class);
                startActivity(in);
            }
        });

        buttonVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),Video.class);
                startActivity(in);
            }
        });

        buttonTTS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),TToSpeech.class);
                startActivity(in);
            }
        });
    }
}

