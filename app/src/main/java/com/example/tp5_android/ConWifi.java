package com.example.tp5_android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.widget.Toast;

public class ConWifi extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
            if (intent.getBooleanExtra("connected", false)) {
                //realizar llamada al numero 2664553747 cuando se conecte a la red wifi
                Intent intent1 = new Intent(Intent.ACTION_CALL);
                intent1.setData(Uri.parse("tel:2664553747"));
                context.startActivity(intent1);
            }else{
                //mostrar mensaje de que no hay conexion a internet con un toast
                Toast toast = Toast.makeText(context, "No hay conexion a internet", Toast.LENGTH_LONG);
                toast.show();
            }
    }
}
