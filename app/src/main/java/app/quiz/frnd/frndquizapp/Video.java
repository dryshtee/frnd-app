package app.quiz.frnd.frndquizapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;


/**
 * Created by DRSH on 4/17/2016.
 */
public class Video extends Activity {
    VideoView vid;
    TextView tvBacktoHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video);

        tvBacktoHome = (TextView) findViewById(R.id.tvBacktoHome);
        vid = (VideoView)findViewById(R.id.videoView);

        tvBacktoHome.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
              Intent launchActivity1 = new Intent(getApplicationContext(), Home.class);
              startActivity(launchActivity1);
              }
              }
        );

        String urlpath = "android.resource://" + getPackageName() + "/" + R.raw.abcsong;
        vid.setVideoURI(Uri.parse(urlpath));
        vid.start();

    }
}
