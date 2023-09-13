package com.example.tp5_android;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private ConWifi conWifi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registrarBroadcast();

        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M
                && checkSelfPermission(Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE},1000);
        }
    }

    private void registrarBroadcast(){
        conWifi = new ConWifi();
        registerReceiver(this.conWifi, new IntentFilter("android.net.wifi.supplicant.CONNECTION_CHANGE"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.conWifi);
    }
}