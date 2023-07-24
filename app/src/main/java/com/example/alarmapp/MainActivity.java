package com.example.alarmapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    static  final  int ALARM_REQ_CODE=100;
    long triggerTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //EditText e1=findViewById(R.id.edtTime);
        AlarmManager alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);

        findViewById(R.id.btnset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int time = Integer.parseInt(((EditText)(findViewById(R.id.edtTime))).getText().toString());
                long integerTime=System.currentTimeMillis()+(time*1000);

                Intent iBroadcast= new Intent(MainActivity.this, MyReceiver.class);

                PendingIntent pi=PendingIntent.getBroadcast(MainActivity.this, ALARM_REQ_CODE,iBroadcast ,PendingIntent.FLAG_UPDATE_CURRENT);

                alarmManager.set(AlarmManager.RTC_WAKEUP, triggerTime,pi);
            }
        });


    }
}