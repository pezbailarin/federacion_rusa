package com.example.Prueba_compatible;
  //TODO entender por qué uso setContentView y además uso name en el layout (¿se conectan mutuamente?)
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Created with IntelliJ IDEA.
 * User: Cesar
 * Date: 24/11/13
 * Time: 20:40
 * To change this template use File | Settings | File Templates.
 */

public class CountryDetailActivity extends FragmentActivity {
    public static final String COUNTRY="country";
    private String country="";

        /*
        * Ejecutada al crearse la actividad
        */
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_country_detail);

            Intent i=getIntent();
            country=i.getStringExtra(COUNTRY);
        }

        // getter para poder acceder al país desde otra actividad
        public String getCountry() {
            return country;
        }
    }