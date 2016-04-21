package com.myapp.user.grabacionaudio;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;



import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements MediaPlayer.OnCompletionListener{
    TextView estado;
    Button grabar, detener, reproducir;
    File  archivo;
    MediaRecorder recorder;
    MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        estado =  (TextView) findViewById(R.id.estado);
        grabar = (Button) findViewById(R.id.grabar);
        detener = (Button) findViewById(R.id.detener);
        reproducir = (Button) findViewById(R.id.reproducir);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
    public void  grabar(View v){
        recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        File phat = new File(Environment.getExternalStorageDirectory().getPath());
        try{
            archivo = File.createTempFile("temporal", ".3gp", phat);
        }catch (IOException e){
        }
        recorder.setOutputFile(archivo.getAbsolutePath());
        try {
            recorder.prepare();
        }catch (IOException e){
        }
        recorder.start();
        estado.setText("Grabando");
        grabar.setEnabled(false);
        detener.setEnabled(true);
    }

    public void detener(View v){
        recorder.stop();
        recorder.release();
        player = new MediaPlayer();
        player.setOnCompletionListener(this);
        try {
            player.setDataSource(archivo.getAbsolutePath());
        }catch (IOException e){
        }
        try {
            player.prepare();
        }catch (IOException e){
        }
        grabar.setEnabled(true);
        detener.setEnabled(false);
        reproducir.setEnabled(true);
        estado.setText("Listo para reproducir");
    }

    public void reproducir(View v){
        player.start();
        grabar.setEnabled(false);
        detener.setEnabled(false);
        reproducir.setEnabled(false);
        estado.setText("Reproducendo");
    }

    public void onCompletion(MediaPlayer mp){
        grabar.setEnabled(true);
        grabar.setEnabled(true);
        reproducir.setEnabled(true);
        estado.setText("Listo");
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
