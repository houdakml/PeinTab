package houda.exam.peintab.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import houda.exam.peintab.globel.Constants;
import houda.exam.peintab.R;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                openNextePage();
                finish();
            }
        }, Constants.Splash_Delay);

    }

    private void openNextePage() {
        SharedPreferences sharedPref =  getSharedPreferences(Constants.MY_PREF, Context.MODE_PRIVATE);
        boolean is_connected = sharedPref.getBoolean(Constants.PREF_IS_CONNECTED,false);

        if(is_connected){
            startActivity(new Intent(Splash.this, Home.class));

        }
        else
        {
            startActivity(new Intent(Splash.this, Login.class));

        }
    }
}