package app.quiz.frnd.frndquizapp;

import android.app.Activity;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

/**
 * Created by DRSH on 4/18/2016.
 */


public class TToSpeech extends Activity {

    TextToSpeech ttsobject;
    int result;
    EditText et;
    String text;
    TextView tvBacktoHome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.texttospeech);

        tvBacktoHome = (TextView) findViewById(R.id.tvBacktoHome);

        et = (EditText) findViewById(R.id.editText);

        tvBacktoHome.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
               Intent launchActivity1 = new Intent(getApplicationContext(), Home.class);
               startActivity(launchActivity1);
               }
               }
        );

        ttsobject = new TextToSpeech(TToSpeech.this, new TextToSpeech.OnInitListener() {

            @Override
            public void onInit(int status) {

                if (status == TextToSpeech.SUCCESS) {
                    result = ttsobject.setLanguage(Locale.ENGLISH);
                } else {
                    Toast.makeText(getApplicationContext(), "Feature not supported in your device.",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void doSomething(View v) {
        switch (v.getId()) {
            case R.id.bspeak:

                if (result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA) {

                    Toast.makeText(getApplicationContext(), "Feature not supported in your device.",
                            Toast.LENGTH_SHORT).show();

                } else {
                    text = et.getText().toString();

                    ttsobject.speak(text, TextToSpeech.QUEUE_FLUSH, null);
                }

                break;

            case R.id.bstopspeaking:

                if (ttsobject != null) {

                    ttsobject.stop();
                }

                break;
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (ttsobject != null) {

            ttsobject.stop();
            ttsobject.shutdown();
        }

    }
}


