package com.immr.studentplanner.receivers;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;
import android.widget.Toast;

import com.immr.studentplanner.R;

import static com.immr.studentplanner.Channel.CHANNEL_1_ID;

public class AlarmReceiver extends BroadcastReceiver {

    private NotificationManagerCompat notificationManager;

    @Override
    public void onReceive(Context context, Intent intent) {


        String title = intent.getStringExtra("TITLE");
        String content = intent.getStringExtra("CODE");

        String text = "";

        if(content.equals("1")){
            text += "There is the " + title + " assessment today!";
        }
        if(content.equals("2")){
            text += title + " course begins today !";
        }
        if(content.equals("3")){
            text += title + " course ends today !";
        }

        Log.d("TEXT", text);

        Toast.makeText(context, text, Toast.LENGTH_LONG).show();

        notificationManager = NotificationManagerCompat.from(context);

        Notification notify = new NotificationCompat.Builder(context, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_announcement_black_24dp)
                .setContentTitle("Alert!")
                .setContentText(text)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManager.notify(1, notify);


    }
}
