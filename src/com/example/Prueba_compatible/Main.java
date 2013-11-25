package com.example.Prueba_compatible;



import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

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

        String[] array_paises=new String[]{"Rusia", "Letonia", "Estonia", "Lituania", "Ucrania", "Georgia", "Kazajistán"};
        ArrayList<String> paises=new ArrayList<String>(Arrays.asList(array_paises));

        ListView lista = (ListView)findViewById(R.id.listView);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, paises);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(this);

   }

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
}
