package com.alejandrablandon.crepeswaffles;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    private static final long SPLASH_DELAY = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); //Establece el nodo

        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE); //Quitar AppBar
        SharedPreferences preferencias= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor= preferencias.edit();
        editor.putString("cerrar", "no");
        editor.commit();

        setContentView(R.layout.activity_splash);

        TimerTask task= new TimerTask(){
            @Override
            public void run(){
                Intent i= new Intent().setClass(SplashActivity.this,LogginActivity.class);
                startActivity(i);
                finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, SPLASH_DELAY);
    }
}
