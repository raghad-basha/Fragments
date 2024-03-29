package com.raghad.getlocation;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button start ;
    Button end ;
    TextView result ;
    private BroadcastReceiver broadcastReceiver;

    @Override
    protected void onPostResume() {
        if (broadcastReceiver==null){
         broadcastReceiver = new BroadcastReceiver() {
             @Override
             public void onReceive(Context context, Intent intent) {
              result.append("\n"+intent.getExtras().get("coordinates"));
             }
         };
        }
        registerReceiver(broadcastReceiver, new IntentFilter("Location_Updates"));

        super.onPostResume();
    }

    @Override
    protected void onDestroy() {
        if(broadcastReceiver!=null){
            unregisterReceiver(broadcastReceiver);
        }
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = (Button) findViewById(R.id.start);
        end = (Button) findViewById(R.id.end);
        result =(TextView) findViewById(R.id.textView);

        if (! runTimePermission()){
          enable_buttons();
        }
    }

    private void enable_buttons() {
     start.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent  i = new Intent(getApplicationContext(),GPS_Services.class);
             startService(i);
         }
     });
     end.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent  i = new Intent(getApplicationContext(),GPS_Services.class);
             stopService(i);
         }
     });
    }

    private boolean runTimePermission(){
   if (Build.VERSION.SDK_INT >= 23
       && ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
           && ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){

       requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
         Manifest.permission.ACCESS_COARSE_LOCATION} ,100);
    return  true;
   }
return  false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100 ){
           if(grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED)
           {
               enable_buttons();
           }
           else runTimePermission();
        }
    }
}
