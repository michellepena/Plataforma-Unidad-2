package com.myapp.user.cuentaclicks;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    int clicks = 0;
    private int cont=0;
    private TextView tvCont;
    private LinearLayout btnIncrementar;
    private int contkey = 0;
    private int contFoc = 0;
    protected int conT=0;
    public static final String DEBUG_TAG = "GesturesActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final Button onClick = (Button)findViewById(R.id.onClick);
        onClick.setText("No has pulsado el boton");
        onClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicks++;
                onClick.setText("Has pulsado el boton " + clicks + " veces");
            }
        });

        tvCont=(TextView)findViewById(R.id.id_contador);
        btnIncrementar=(LinearLayout)findViewById(R.id.btn_Pulsar);

        btnIncrementar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                update_cont();
            }

            private void update_cont() {
                cont++;
                String contador = String.valueOf(cont);
                tvCont.setText(contador);
            }
        });
        btnIncrementar.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                // TODO Auto-generated method stub
                crear_dialogo().show();
                return false;
            }

            private Dialog crear_dialogo() {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(false);
                builder.setMessage("¿Desea reiniciar el contador?");
                builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        reiniciar();

                    }
                });

                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        dialog.cancel();
                    }
                });

                return builder.create();

            }

            private void reiniciar() {
                cont = 0;
                String contador = String.valueOf(cont);
                tvCont.setText(contador);
            }
        });
        EditText campoDescuento = (EditText) findViewById(R.id.campo_descuento);
        final TextView texto2 =(TextView)findViewById(R.id.texto1);

        campoDescuento.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // ¿v tiene el foco?
                if (hasFocus) {
                    ImageView iconoDescuento = (ImageView) findViewById(R.id.icono_descuento);

                }
                contFoc++;
                texto2.setText("Has pulsado el boton " + contFoc + " veces");
            }
        });

        final TextView texto1 =(TextView)findViewById(R.id.texto);

        final EditText nombreEditText = (EditText)findViewById(R.id.nombre);
        nombreEditText.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    contkey++;
                    texto1.setText("Has pulsado el boton " + contkey + " veces");
                    return true;
                }
                return false;
            }
        });

    }

    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub

        int action = MotionEventCompat.getActionMasked(event);
        final TextView texto3 =(TextView)findViewById(R.id.texto3);
        switch (action) {
            case (MotionEvent.ACTION_MOVE):
                Log.d(DEBUG_TAG, "La acción ha sido MOVER");
                return true;
            case (MotionEvent.ACTION_CANCEL):
                Log.d(DEBUG_TAG, "La accion ha sido CANCEL");
                return true;
            default:
                conT++;
                texto3.setText("Has implementado este evento " + conT + " veces");
                return super.onTouchEvent(event);
        }
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



}
