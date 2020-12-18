package houda.exam.peintab.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import houda.exam.peintab.globel.Constants;
import houda.exam.peintab.model.Peintab;
import houda.exam.peintab.R;

public class Home extends AppCompatActivity {
    ArrayList<Peintab> peintabList = new ArrayList<>();

    TextView tv_logout;
    RecyclerView rv_tableaux;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tv_logout=findViewById(R.id.logout);
        rv_tableaux=findViewById(R.id.recy_v_tab);
        tv_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutUser();
            }
        });

        peintabList.add(new Peintab(R.drawable.vase_avec_iris,"Vase avec iris","Pablo Picasso", "1937","La femme qui pleure est une œuvre de Pablo Picasso datant de 1937"));
        peintabList.add(new Peintab(R.drawable.splash,"La femme qui pleure","Pablo Picasso", "1937","La femme qui pleure est une œuvre de Pablo Picasso datant de 1937"));
        peintabList.add(new Peintab(R.drawable.fast,"La femme qui pleure","Pablo Picasso", "1937","La femme qui pleure est une œuvre de Pablo Picasso datant de 1937"));
        peintabList.add(new Peintab(R.drawable.fast,"La femme qui pleure","Pablo Picasso", "1937","La femme qui pleure est une œuvre de Pablo Picasso datant de 1937"));
        peintabList.add(new Peintab(R.drawable.fast,"La femme qui pleure","Pablo Picasso", "1937","La femme qui pleure est une œuvre de Pablo Picasso datant de 1937"));
        peintabList.add(new Peintab(R.drawable.fast,"La femme qui pleure","Pablo Picasso", "1937","La femme qui pleure est une œuvre de Pablo Picasso datant de 1937"));
        peintabList.add(new Peintab(R.drawable.fast,"La femme qui pleure","Pablo Picasso", "1937","La femme qui pleure est une œuvre de Pablo Picasso datant de 1937"));
        peintabList.add(new Peintab(R.drawable.fast,"La femme qui pleure","Pablo Picasso", "1937","La femme qui pleure est une œuvre de Pablo Picasso datant de 1937"));
        peintabList.add(new Peintab(R.drawable.fast,"La femme qui pleure","Pablo Picasso", "1937","La femme qui pleure est une œuvre de Pablo Picasso datant de 1937"));
        peintabList.add(new Peintab(R.drawable.fast,"La femme qui pleure","Pablo Picasso", "1937","La femme qui pleure est une œuvre de Pablo Picasso datant de 1937"));


        Adapter adapter=new Adapter(peintabList,getApplicationContext());

            rv_tableaux.setAdapter(adapter);
            rv_tableaux.setLayoutManager(new LinearLayoutManager(getApplicationContext()));




    }


    private void logoutUser(){
        SharedPreferences sharedPref =  getSharedPreferences(Constants.MY_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(Constants.PREF_IS_CONNECTED,false);
        editor.apply();
        startActivity(new Intent(Home.this, Login.class));
        finish();
    }

}
