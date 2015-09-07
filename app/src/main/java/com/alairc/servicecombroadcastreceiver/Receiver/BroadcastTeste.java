package com.alairc.servicecombroadcastreceiver.Receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.alairc.servicecombroadcastreceiver.MainActivity;
import com.alairc.servicecombroadcastreceiver.Service.ServicoTeste;

/**
 * Created by Alairc on 07/09/2015.
 */
public class BroadcastTeste extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.i("Script", "onReceive()");
        //intent = new Intent("SERVICO_TEST");
        //A partir da API 19, é necessário chamar o serviço de forma explicita
        Intent it = new Intent(context, ServicoTeste.class);
        context.startService(it);
    }
}
