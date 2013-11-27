package com.example.Prueba_compatible;



import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class Main extends FragmentActivity implements OnItemClickListener {
    String country;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        String[] array_paises=new String[]{"Rusia","Letonia","Estonia","Lituania","Bielorrusia","Ucrania","Moldavia",
                "Georgia","Armenia","Azerbaiyán","Kazajistán","Kirguistán","Uzbekistán","Tayikistán","Turkmenistán"};
        ArrayList <String> paises=new ArrayList<String>(Arrays.asList(array_paises));
        // recupero el ListView, creo un adapter con los paises y lo enchufo al ListView
        ListView lista = (ListView)findViewById(R.id.listView);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, paises);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(this);
        registerForContextMenu(lista);
   }


    /**
    *    Gestiona los clicks en los paises del ListView
    * */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long arg0) {
        country=parent.getItemAtPosition(position).toString();

        if(getResources().getConfiguration().orientation== Configuration .ORIENTATION_LANDSCAPE) {
            FragmentManager manager=getSupportFragmentManager();
            CountryInfoFragment fragment=(CountryInfoFragment)manager.findFragmentById(R.id.fragmentoDetallePais);
            fragment.loadWebViewContent(country);
        } else {
            Intent intent = new Intent(getApplicationContext(), CountryDetailActivity.class);
            intent.putExtra(CountryDetailActivity.COUNTRY, country);
            startActivity(intent);
        }
    }


    /**
     *  Infla el menú
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }


    /**
     * Mostrar icono de "compartir" sólo en formato apaisado (esto es, cuando hay algo que compartir)
     */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean landscape=(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE);
        MenuItem share=menu.getItem(menu.size()-1);
        share.setVisible(landscape);
        return true;
    }


    /**
     *  Reaccionar al pulsar un icono del menú
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (country==null)     {
            return super.onOptionsItemSelected(item);
        } else {
            switch(item.getItemId()) {
                case R.id.mnuShare:
                    Intent sendIntent=new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.shareIntent1stPart) + country +
                            getString(R.string.shareIntent2ndtPart) + country);
                    sendIntent.setType("text/plain");
                    startActivity(sendIntent);
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }
        }
    }


    /**
     *  Mostrar menú contextual
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        //Quiero sacar el país en el que he pulsado, lo tengo en menuInfo.
        //lo recupero como un AdapterContextMenuInfo
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        //en info.targetView tengo el textView pulsado. Saco el texto y lo convierto a string.
        country = ((TextView)info.targetView).getText().toString();
        getMenuInflater().inflate(R.menu.main,menu);
    }


    /**
     *  Gestionar clicks en menú contextual
     */
    @Override
    public boolean onContextItemSelected(MenuItem item) {
       return(onOptionsItemSelected(item));
    }
}
