package dev.andeng.whiskerwallbreaker;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        VideoView videoView = findViewById(R.id.videoView);

        // Set the video path (assuming the video file is in res/raw)
        String path = "android.resource://" + getPackageName() + "/" + R.raw.splash;
        videoView.setVideoURI(Uri.parse(path));

        // Add media controller for play, pause, seekbar, etc.
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        // Start the video
        videoView.start();

        // Set a listener to go to the next activity when the video finishes
        videoView.setOnCompletionListener(mp -> {
            // Start your next activity here
            Intent intent = new Intent(SplashScreen.this, MainActivity.class);
            startActivity(intent);

            // Finish the current activity
            finish();
        });
    }
}
