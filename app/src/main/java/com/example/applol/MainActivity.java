package com.example.applol;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mpl;
    Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnlogin=(Button) findViewById(R.id.btnlogin);
        mpl=MediaPlayer.create(this, R.raw.button_login_sound);
        btnlogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                mpl.start();

            }
        });




    VideoView videoView= findViewById(R.id.fondo);
    String videoPath="android.resource://"+getPackageName()+"/"+R.raw.fondo;
    Uri uri=Uri.parse(videoPath);
    videoView.setVideoURI(uri);
    videoView.start();

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }});

    ///Controles para repoductor
    ///MediaController mediaController=new MediaController(this);
    ///videoView.setMediaController(mediaController);
    ///mediaController.setAnchorView(videoView);

    }


}
