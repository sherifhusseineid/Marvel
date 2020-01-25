package com.sherif.marvelcharacters.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.sherif.marvelcharacters.R;

import jp.wasabeef.glide.transformations.internal.Utils;

public class SplashActivity extends AppCompatActivity {
    private static final String TAG = SplashActivity.class.getSimpleName();

    ImageView ivLogo_activitySplash;
    LinearLayout layout_content_loading_activitySplash;
    ProgressBar mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ivLogo_activitySplash = findViewById(R.id.ivLogo_activitySplash);
        layout_content_loading_activitySplash = findViewById(R.id.layout_content_loading_activitySplash);
        mProgress = findViewById(R.id.splash_screen_progress_bar);

        new Thread(new Runnable() {
            public void run() {
                doDummyWorkProgress();
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        }).start();
    }

    private void doDummyWorkProgress() {
        // make progress working
        for (int progress = 0; progress < 100; progress += 20) {
            try {
                // thread every 500 mill second
                Thread.sleep(500);
                mProgress.setProgress(progress);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
