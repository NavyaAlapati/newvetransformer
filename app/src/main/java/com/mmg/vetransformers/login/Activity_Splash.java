package com.mmg.vetransformers.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.view.animation.Animation.AnimationListener;

import com.mmg.vetransformers.R;

public class Activity_Splash extends Activity implements AnimationListener {
    Animation animFadeIn, animFadeOut;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imageView = findViewById(R.id.imageView);
        animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.together);
        animFadeIn.setAnimationListener(this);
        imageView.startAnimation(animFadeIn);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {

                Intent mLogin = new Intent(Activity_Splash.this,Activity_Login.class);
                startActivity(mLogin);
                finish();

            }
        }, 2000);





    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
