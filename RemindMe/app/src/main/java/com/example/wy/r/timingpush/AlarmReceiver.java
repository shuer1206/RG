package com.example.wy.r.timingpush;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Toast;

import com.example.wy.r.MainActivity;
import com.example.wy.r.R;


public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "收到消息", Toast.LENGTH_SHORT).show();
        MediaPlayer.create(context, R.raw.sea).start();
        Bundle bundle = intent.getExtras();
        intent = new Intent(context, MainActivity.class);
        intent.putExtras(bundle);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }



}
