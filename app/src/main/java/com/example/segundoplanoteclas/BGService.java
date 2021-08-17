package com.example.segundoplanoteclas;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.widget.Toast;

public class BGService extends Service{


    @Override
    public void onCreate()
    {
        // TODO Auto-generated method stub
        super.onCreate();
        final BroadcastReceiver vReceiver = new BroadcastReceiver() {


            @Override
            public void onReceive(Context context, Intent intent) {

                PowerManager powerManager = (PowerManager) getSystemService(POWER_SERVICE);
                boolean isScreenOn = powerManager.isScreenOn();
                if (!isScreenOn)
                {

                    PowerManager pm = (PowerManager) getApplicationContext().getSystemService(Context.POWER_SERVICE);
                    @SuppressLint("InvalidWakeLockTag") WakeLock mWakeLock = pm.newWakeLock((PowerManager.SCREEN_DIM_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP), "YourServie");
                    mWakeLock.acquire();
                    // The screen has been locked
                    // do stuff...
                }
                else
                {
                    Toast.makeText(BGService.this, "Screen Is On", Toast.LENGTH_LONG).show();
                }

            }

        };
        registerReceiver(vReceiver, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // TODO Auto-generated method stub

        Toast.makeText(BGService.this, "Service is Started :)", Toast.LENGTH_LONG).show();
        return super.onStartCommand(intent, flags, startId);
        //43200000 schedules notification on every 12 hours
    }


    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        Toast.makeText(BGService.this, "Service is Stopped :(", Toast.LENGTH_LONG).show();
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }
}
