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

        peintabList.add(new Peintab(R.drawable.vase_iris,"Irises","Vincent van Gogh", "1937",Constants.TEXT_DESCRIPTION_IRISES));
        peintabList.add(new Peintab(R.drawable.portrait_of_wally,"Portrait of Wally","Egon Schiele", "1912",Constants.TEXT_DESCRIPTION_PORTAIT_OF_WALLY));
        peintabList.add(new Peintab(R.drawable.weeping_woman,"The Weeping Woman","Pablo Picasso", "1937",Constants.TEXT_DESCRIPTION_THE_WEEPING_WOMAN));
        peintabList.add(new Peintab(R.drawable.grenouillere,"La Grenouillère","Pierre-Auguste Renoir", "1869",Constants.TEXT_DESCRIPTION_LA_GRENOUILLERE));
        peintabList.add(new Peintab(R.drawable.mona_lisa,"Mona Lisa","Leonardo da Vinci", "1503–1506, perhaps continuing until 1517",Constants.TEXT_DESCRIPTION_MONA_LISA));
        peintabList.add(new Peintab(R.drawable.girl_with_pearl_earring,"Girl with a Pearl Earring","Johannes Vermeer", "1665",Constants.TEXT_DESCRIPTION_GIRL_PEARL_EARRING));
        peintabList.add(new Peintab(R.drawable.the_persistence_of_memory,"The Persistence of Memory","Salvador Dalí", "1931",Constants.TEXT_DESCRIPTION_THE_PERSISTENCE_OF_MEMORY));
        peintabList.add(new Peintab(R.drawable.adele_bloch_bauer,"Portrait of Adele Bloch-Bauer I","Gustav Klimt", "1907",Constants.TEXT_DESCRIPTION_LADY_IN_GOLD));
        peintabList.add(new Peintab(R.drawable.the_milkmaid,"The Milkmaid","J.Vermeer.", "1657–1658", Constants.TEXT_DESCRIPTION_THE_MILKMAID));
        peintabList.add(new Peintab(R.drawable.starry_night,"The Starry Night","Vincent van Gogh", "1889",Constants.TEXT_DESCRIPTION_THE_STARRY_NIGHT));


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
