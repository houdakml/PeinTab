package houda.exam.peintab.Data;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;


import houda.exam.peintab.controller.Home;
import houda.exam.peintab.controller.Login;
import houda.exam.peintab.globel.Constants;

public class DataStorage {

    public static void GeneratSharedPref(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(Constants.MY_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(Constants.PREF_IS_CONNECTED, true);
        editor.apply();


    }


    public static void DeleteSharedPref(Context context){
        SharedPreferences sharedPref =context.getSharedPreferences(Constants.MY_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(Constants.PREF_IS_CONNECTED,false);
        editor.apply();




    }


}
