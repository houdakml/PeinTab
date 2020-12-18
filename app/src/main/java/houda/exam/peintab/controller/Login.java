package houda.exam.peintab.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import houda.exam.peintab.globel.Constants;
import houda.exam.peintab.globel.Control;
import houda.exam.peintab.R;

public class Login extends AppCompatActivity {
     EditText edt_mail,edt_password;
     Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edt_mail =findViewById(R.id.mail);
        edt_password=findViewById(R.id.password);
        btn_login=findViewById(R.id.login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
    }

    private void loginUser() {

        String email=edt_mail.getText().toString();
        String password=edt_password.getText().toString();

        if( Control.isValidEmail(email) && Control.isValidPassword(password)){

            SharedPreferences sharedPref =  getSharedPreferences(Constants.MY_PREF, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putBoolean(Constants.PREF_IS_CONNECTED,true);
            editor.apply();
            startActivity(new Intent(Login.this, Home.class));
            finish();
        }
        else if(!Control.isValidEmail(email)){
            Toast.makeText(getApplicationContext(),Constants.MSG_TEST_MAIL,Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getApplicationContext(),Constants.MSG_TEST_PASSWORD,Toast.LENGTH_LONG).show();
        }


    }


}