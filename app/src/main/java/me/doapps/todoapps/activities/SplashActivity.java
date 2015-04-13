package me.doapps.todoapps.activities;

import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import doapps.me.todoapps.R;
import me.doapps.todoapps.utils.FontUtil;

/**
 * Created by jonathan on 13/04/2015.
 */
public class SplashActivity extends ActionBarActivity {
    private LinearLayout linearSplash;
    private TextView textSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

        linearSplash = (LinearLayout) findViewById(R.id.linearSplash);
        textSplash = (TextView) findViewById(R.id.textSplash);

        textSplash.setTypeface(FontUtil.setRalewayExtraBold(this));

        startAnimations();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }

    private void startAnimations() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        linearSplash.clearAnimation();
        linearSplash.startAnimation(anim);

        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();

        textSplash.clearAnimation();
        textSplash.startAnimation(anim);
    }
}
