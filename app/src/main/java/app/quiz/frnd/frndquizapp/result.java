package app.quiz.frnd.frndquizapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class result extends Activity {

    TextView tv;
    TextView tvBacktoHome;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        tv = (TextView) findViewById(R.id.result);
        tvBacktoHome = (TextView) findViewById(R.id.tvBacktoHome);

        tv.setText("Your Final Result is "+quiz.correct+"/"+quiz.questions.length);

        tvBacktoHome.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent launchActivity1 = new Intent(getApplicationContext(), Home.class);
                        startActivity(launchActivity1);
                    }
                }
        );
    }
}
