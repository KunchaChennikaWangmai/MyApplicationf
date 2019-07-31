package com.chennikawangmai.myapplicationf;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;

import java.util.Objects;

import static com.chennikawangmai.myapplicationf.App.CHANNEL_1_ID;

public class MainActivity extends AppCompatActivity {

 public  class HsetIntentReceiver extends BroadcastReceiver {
        //private String TAG = "HeadSet";
        public String g;

        //public HeadsetIntentReceiver() { }
        @Override
        public void onReceive(Context context, Intent intent) {
            if(Objects.requireNonNull(intent.getAction()).equals(Intent.ACTION_HEADSET_PLUG)) {
                int state = intent.getIntExtra("state", -1);

                g=new String();

                if(state==0)
                {
                // g="Headset unplugged";
              //  tv.setText("Headset unplugged");




                    Notification notification = new NotificationCompat.Builder(context, CHANNEL_1_ID)
                            .setSmallIcon(R.drawable.ic_launcher_background)
                            .setContentTitle("Headset status")
                            .setContentText("Headset unplugged")
                            .setPriority(NotificationCompat.PRIORITY_HIGH)
                            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                            .build();

                    notificationManager.notify(1, notification);



                }
                else if(state==1)
                {
                   // g="Headset plugged";
                   // tv.setText("Headset plugged");
                    Notification notification = new NotificationCompat.Builder(context, CHANNEL_1_ID)
                            .setSmallIcon(R.drawable.ic_launcher_background)
                            .setContentTitle("Headset status")
                            .setContentText("Headset plugged")
                            .setPriority(NotificationCompat.PRIORITY_HIGH)
                            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                            .build();
                    notificationManager.notify(1,notification);
                }
                else
                    g="Error";
            }
            else
            {
                g="not getting a value";
            }

        }

    }



  //  TextView tv;
    public int state=0;
    String j;
    private NotificationManagerCompat notificationManager;
     public   HsetIntentReceiver receiver;
//Button b;

public int i;

    public String k;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_main);
        k=new String();
//tv=(TextView)findViewById(R.id.texttt);
//b=(Button)findViewById(R.id.buttonl)

      IntentFilter receiverFilter = new IntentFilter(Intent.ACTION_HEADSET_PLUG);
        receiver=new HsetIntentReceiver();

        registerReceiver( receiver, receiverFilter );




        notificationManager = NotificationManagerCompat.from(this);

    }


   /* public void sendnotification(View v) {


        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Headset status")
                .setContentText(j)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManager.notify(1, notification);
}*/
    @Override
    public void onResume()
    {
        IntentFilter filter=new IntentFilter(Intent.ACTION_HEADSET_PLUG);
        registerReceiver(receiver,filter);
        super.onResume();
    }

   /* public void sendOnChannel2(View v) {
        String title = editTextTitle.getText().toString();
        String message = editTextMessage.getText().toString();

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .build();

        notificationManager.notify(2, notification);
    }*/

//        <reciever
//            android:name=".HeadsetIntentReciever">
//            <intent-filter>
//                <action android:name="android.intent.action.HEADSET_PLUG" />
//
//            </intent-filter>
//
//        </reciever>
  /* @Override public void onPause()
    {
        unregisterReceiver(receiver);
        super.onPause();
    }*/
}