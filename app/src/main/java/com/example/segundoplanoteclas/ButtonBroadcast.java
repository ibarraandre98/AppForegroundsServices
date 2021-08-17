package com.example.segundoplanoteclas;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.BatteryManager;
import android.os.Build;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

public class ButtonBroadcast extends BroadcastReceiver {

    public ButtonBroadcast(){
        super();
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction().equals("android.media.VOLUME_CHANGED_ACTION")){
            System.out.println("VOLUME_CHANGED_ACTION");
            Toast.makeText(context, "VOLUME_CHANGED_ACTION", Toast.LENGTH_SHORT).show();
        }

        if(Intent.ACTION_SCREEN_ON.equals(intent.getAction())){
            System.out.println("ACTION_SCREEN_ON");
            Toast.makeText(context, "ACTION_SCREEN_ON", Toast.LENGTH_SHORT).show();
        }

        if(intent.getAction().equals(Intent.ACTION_SCREEN_OFF)){
            System.out.println("ACTION_SCREEN_OFF");
            Toast.makeText(context, "ACTION_SCREEN_OFF", Toast.LENGTH_SHORT).show();
        }

        if (Intent.ACTION_MEDIA_BUTTON.equals(intent.getAction())) {
            System.out.println("MEDIA_BUTTON");
            Toast.makeText(context, "MEDIA_BUTTON", Toast.LENGTH_SHORT).show();
        }

        if(intent.getAction().equals("android.intent.action.MEDIA_NEXT")){
            System.out.println("MEDIA_NEXT");
            Toast.makeText(context, "MEDIA_NEXT", Toast.LENGTH_SHORT).show();
        }

        if(intent.getAction().equals("android.media.EXTRA_VOLUME_STREAM_VALUE")){
            System.out.println("EXTRA_VOLUME_STREAM_VALUE");
            Toast.makeText(context, "EXTRA_VOLUME_STREAM_VALUE", Toast.LENGTH_SHORT).show();
        }

        if(ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())){
            Toast.makeText(context, "CONNECTIVITY_ACTION", Toast.LENGTH_SHORT).show();
            System.out.println("CONNECTIVITY_ACTION");
        }
    }
}
