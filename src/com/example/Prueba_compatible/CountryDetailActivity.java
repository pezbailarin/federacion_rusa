package com.example.Prueba_compatible;
  //TODO entender por qué uso setContentView y además uso name en el layout (¿se conectan mutuamente?)
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

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
            if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                super.onBackPressed();
            }
        }

        // getter para poder acceder al país desde otra actividad
        public String getCountry() {
            return country;
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_country_detail,menu);
        return true;
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
            switch(item.getItemId()) {
                case R.id.mnuShare:
                    Intent sendIntent=new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.shareIntent1stPart)+country+
                            getString(R.string.shareIntent2ndtPart) + country);
                    sendIntent.setType("text/plain");
                    startActivity(sendIntent);
                    return true;
                default:
                    return super.onMenuItemSelected(featureId, item);
            }
    }



}