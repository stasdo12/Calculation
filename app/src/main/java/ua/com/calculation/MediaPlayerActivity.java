package ua.com.calculation;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MediaPlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);


        ImageButton car1 = findViewById(R.id.car_id);
        ImageButton car2 = findViewById(R.id.police_id);
        MediaPlayer sound1 = MediaPlayer.create(MediaPlayerActivity.this, R.raw.sound1);
        MediaPlayer sound2 =MediaPlayer.create(MediaPlayerActivity.this, R.raw.sound_2);

        car1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlayButton(sound1, sound2);
            }
        });

        car2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlayButton(sound2, sound1);
            }
        });


    }

    private void soundPlayButton(MediaPlayer sound1,MediaPlayer sound2 ) {
        if (sound1.isPlaying()){
            sound1.pause();
            sound2.seekTo(0);
            sound1.setLooping(false);
        }

        if (sound2.isPlaying()){
            sound2.pause();
            sound2.seekTo(0);
            sound2.setLooping(false);
        }

        sound1.start();
        sound1.setLooping(true);
//        sound.seekTo(1000);

    }
}

