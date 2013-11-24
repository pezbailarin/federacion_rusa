package com.example.Prueba_compatible;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Main extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        String[] paises={"Rusia", "Letonia", "Estonia", "Lituania", "Ucrania", "Georgia", "Kazajistán"};
        ListView lista = (ListView)findViewById(R.id.listView);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, paises);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String country=parent.getItemAtPosition(position).toString();
                Intent i=new Intent(getApplicationContext(),CountryDetailActivity.class);
                i.putExtra(CountryDetailActivity.COUNTRY, country );
                startActivity(i);
            }
        });



    }
}
