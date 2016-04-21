package com.myapp.user.animacionimagen;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView text;
    Button girar;
    Button mover;
    Button transparencia;
    Button ampliar;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        img = (ImageView) findViewById(R.id.img);
        girar =(Button) findViewById(R.id.girar);
        mover = (Button) findViewById(R.id.mover);
        transparencia = (Button) findViewById(R.id.transparencia);
        ampliar = (Button) findViewById(R.id.ampliar);
        text =(TextView) findViewById(R.id.text);

        girar.setOnClickListener(this);
        mover.setOnClickListener(this);
        transparencia.setOnClickListener(this);
        ampliar.setOnClickListener(this);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.girar:
                Animation giro;
                giro = AnimationUtils.loadAnimation(this,R.animator.girar);
                giro.reset();
                img.startAnimation(giro);
                break;
            case R.id.mover:
                Animation movimiento;
                movimiento = AnimationUtils.loadAnimation(this, R.animator.mover);
                movimiento.reset();
                img.startAnimation(movimiento);
                break;
            case R.id.ampliar:
                Animation aumentar;
                aumentar = AnimationUtils.loadAnimation(this, R.animator.ampliar);
                aumentar.reset();
                img.startAnimation(aumentar);
                break;
            case R.id.transparencia:
                Animation transparencia;
                transparencia = AnimationUtils.loadAnimation(this, R.animator.transparencia);
                transparencia.reset();
                img.startAnimation(transparencia);
                break;
            default:
                break;
        }
    }
}

