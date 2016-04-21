package com.myapp.user.randroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String[] datos = new String[]{
            "Carmen", "Jazmin", "Michelle", "Daisy", "Guadalupe", "Santiago", "Iker", "Raul", "Jessica", "Jacqueline",
            "Esteban", "Jesus", "Yadira", "Aylin","Ivan"};
    private Integer[] imgid={
            R.mipmap.audi,
            R.mipmap.candado,
            R.mipmap.cora,
            R.mipmap.estrella,
            R.mipmap.audi,
            R.mipmap.mano,
            R.mipmap.monos,
            R.mipmap.reloj,
            R.mipmap.nota,
            R.mipmap.ic_launcher,
            R.mipmap.audi,
            R.mipmap.cora,
            R.mipmap.reloj,
            R.mipmap.estrella,
            R.mipmap.cora
    };
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListAdapter adapter=new ListAdapter(this,datos,imgid);
        lista=(ListView)findViewById(R.id.lista);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Slecteditem = datos[+position];
                Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void SigAct(View v){
        Intent siguiente= new Intent(this, ActGridView.class);
        startActivity(siguiente);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
   /* public void main2Activity(View view) {
        Intent i = new Intent(this, Main2Activity.class );
        startActivity(i);
    }*/
}
