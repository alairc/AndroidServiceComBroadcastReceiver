package com.alairc.servicecombroadcastreceiver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.alairc.servicecombroadcastreceiver.Services.ServicoTeste;

public class MainActivity extends Activity implements View.OnClickListener{
    Button button_start;
    Button button_stop;
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_start = (Button) findViewById(R.id.button_start);
        button_stop = (Button) findViewById(R.id.button_stop);

        button_start.setOnClickListener(this);
        button_stop.setOnClickListener(this);
    }

    public void startService(View view){
        //Intent it = new Intent("SERVICO_TEST");
        //A partir da API 19, é necessário chamar o serviço de forma explicita
        Intent it = new Intent(MainActivity.this, ServicoTeste.class);
        startService(it);
    }

    public void stopService(View view){
        //Intent it = new Intent("SERVICO_TEST");
        //A partir da API 19, é necessário chamar o serviço de forma explicita
        Intent it = new Intent(MainActivity.this, ServicoTeste.class);
        stopService(it);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_start:
                startService(v);
                break;
            case R.id.button_stop:
                stopService(v);
                break;
        }
    }
}
