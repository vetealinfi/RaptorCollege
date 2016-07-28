package com.codebake.raptor.raptorcollege;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash2);


        MediaPlayer mMediaPlayer = new MediaPlayer();
        mMediaPlayer = MediaPlayer.create(this, R.raw.raptor);
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mMediaPlayer.setLooping(false);
        mMediaPlayer.start();

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {


                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(Splash2Activity.this,MainActivity.class);
                Splash2Activity.this.startActivity(mainIntent);
                Splash2Activity.this.finish();
            }
        }, 5000);




    }
}
