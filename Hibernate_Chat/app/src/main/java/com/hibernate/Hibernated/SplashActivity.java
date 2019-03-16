package com.hibernate.Hibernated;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {
    private ImageView icon;

    private static  int splashTimeOut = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        icon=(ImageView)findViewById(R.id.splashlogo);
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.hibernateanimation);
        icon.startAnimation(myanim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, StartActivity.class);
                startActivity(i);
                finish();
            }
        },splashTimeOut);
    }
}
