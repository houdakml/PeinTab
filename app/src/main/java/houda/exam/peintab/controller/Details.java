package houda.exam.peintab.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import houda.exam.peintab.globel.Constants;
import houda.exam.peintab.R;

public class Details extends AppCompatActivity {

    ImageView img_pt;
    TextView title,painter,date,desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        img_pt=findViewById(R.id.tabl);
        title=findViewById(R.id.tit);
        painter=findViewById(R.id.art);
        date=findViewById(R.id.date);
        desc=findViewById(R.id.description);



        Intent it= getIntent();
        getDataFromAdapter(it);

    }

    private void getDataFromAdapter(Intent intent) {
        img_pt.setImageResource(intent.getIntExtra(Constants.INTENT_PUT_IMAGE,0));
        title.setText(intent.getStringExtra(Constants.INTENT_PUT_TITILE));
        painter.setText(intent.getStringExtra(Constants.INTENT_PUT_PAINTER));
        date.setText(intent.getStringExtra(Constants.INTENT_PUT_DATE));
        desc.setText(intent.getStringExtra(Constants.INTENT_PUT_DESCRIPTION));
    }

}