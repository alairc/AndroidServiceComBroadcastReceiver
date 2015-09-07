package com.alairc.servicecombroadcastreceiver.Services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Alairc on 07/09/2015.
 */
public class ServicoTeste extends Service {
    public ArrayList<Worker> threads = new ArrayList<Worker>();

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        Log.i("Script","onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Log.i("Script","onStarCommand()");

        Worker w = new Worker(startId);
        w.start();
        threads.add(w);

        return(super.onStartCommand(intent, flags, startId));
    }

    class Worker extends Thread{
        public int count = 0;
        public int startId;
        public boolean ativo = true;

        public Worker(int startId){
            this.startId = startId;
        }

        public void run(){
            while (ativo && count <= 10){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }

                count++;
                Log.i("Script","COUNT :" + count);
            }
            stopSelf(startId);
        }

    }

    @Override
    public void onDestroy(){
        super.onDestroy();

        for(int i = 0, tam = threads.size(); i < tam; i++){
            threads.get(i).ativo = false;
        }
    }

}
