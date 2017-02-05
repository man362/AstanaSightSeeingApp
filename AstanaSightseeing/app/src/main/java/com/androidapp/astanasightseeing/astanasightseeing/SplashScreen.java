package com.androidapp.astanasightseeing.astanasightseeing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        overridePendingTransition(R.anim.slidein, R.anim.slideout);

        Thread splashThread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    while (waited < 3000) {
                        sleep(100);
                        waited += 100;
                    }
                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    finish();
                    Intent i = new Intent(SplashScreen.this,LanguagePage.class);
                    startActivity(i);
                }
            }
        };
        splashThread.start();
    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        System.out.println("----main activity---onStart---");
        overridePendingTransition(R.anim.slidein, R.anim.slideout);
    }


}
