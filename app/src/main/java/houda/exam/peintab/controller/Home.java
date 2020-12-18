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

        peintabList.add(new Peintab(R.drawable.vase_iris,"Irises","Vincent van Gogh", "1937","Irises is one of several paintings of irises by the Dutch artist Vincent van Gogh, and one of a series of paintings he made at the Saint Paul-de-Mausole asylum in Saint-Rémy-de-Provence, France, in the last year before his death in 1890."));
        peintabList.add(new Peintab(R.drawable.portrait_of_wally,"Portrait of Wally","Egon Schiele", "1912","Portrait of Wally is a 1912 oil painting by Austrian painter Egon Schiele of Walburga Wally Neuzil, a woman whom he met in 1911 when he was 21 and she was 17. She became his lover and model for several years, depicted in a number of Schiele's most striking paintings."));
        peintabList.add(new Peintab(R.drawable.weeping_woman,"The Weeping Woman","Pablo Picasso", "1937","The Weeping Woman (English: Femme an pleurs) is an oil on canvas painting by Pablo Picasso, which he created in France in 1937"));
        peintabList.add(new Peintab(R.drawable.grenouillere,"La Grenouillère","Pierre-Auguste Renoir", "1869","La Grenouillère is an 1869 oil on canvas painting by Pierre-Auguste Renoir, now in the Nationalmuseum in Stockholm."));
        peintabList.add(new Peintab(R.drawable.mona_lisa,"Mona Lisa","Leonardo da Vinci", "1503–1506, perhaps continuing until 1517","The Mona Lisa (Italian: Monna Lisa or La Gioconda , French: La Joconde is a half-length portrait painting by Italian artist Leonardo da Vinci."));
        peintabList.add(new Peintab(R.drawable.girl_with_pearl_earring,"Girl with a Pearl Earring","Johannes Vermeer", "1665","Girl with a Pearl Earring (Dutch: Meisje met de parel) is an oil painting by Dutch Golden Age painter Johannes Vermeer, dated 1665."));
        peintabList.add(new Peintab(R.drawable.the_persistence_of_memory,"The Persistence of Memory","Salvador Dalí", "1931","The Persistence of Memory (Spanish: La persistencia de la memoria) is a 1931 painting by artist Salvador Dalí and one of the most recognizable works of Surrealism."));
        peintabList.add(new Peintab(R.drawable.adele_bloch_bauer,"Portrait of Adele Bloch-Bauer I","Gustav Klimt", "1907","Portrait of Adele Bloch-Bauer I (also called The Lady in Gold or The Woman in Gold) is a painting by Gustav Klimt, completed between 1903 and 1907"));
        peintabList.add(new Peintab(R.drawable.the_milkmaid,"The Milkmaid","J.Vermeer.", "1657–1658","The Milkmaid (Dutch: De Melkmeid or Het Melkmeisje), sometimes called The Kitchen Maid, is an oil-on-canvas painting of a \"milkmaid\", in fact, a domestic kitchen maid, by the Dutch artist Johannes Vermeer."));
        peintabList.add(new Peintab(R.drawable.starry_night,"The Starry Night","Vincent van Gogh", "1889","The Starry Night is an oil on canvas painting by Dutch Post-Impressionist painter Vincent van Gogh. Painted in June 1889, it depicts the view from the east-facing window of his asylum room at Saint-Rémy-de-Provence, just before sunrise, with the addition of an imaginary village"));


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
