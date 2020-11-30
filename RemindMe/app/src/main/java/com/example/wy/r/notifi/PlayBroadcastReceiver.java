package com.example.wy.r.notifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.wy.r.MainActivity;


//开始播放或者停止播放
public class PlayBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "PlayBroadcastReceiver";
    @Override
    public void onReceive(Context context, Intent intent){
        final MainActivity musicActivity = MainActivity.getInstance();
        Log.e(TAG, "run: "+"开始或者暂停" );
        if(MainActivity.state == 0){
            MainActivity.state = 1;
            MainActivity.audioService.player.start();
        }else {
            MainActivity.state = 0;
            MainActivity.audioService.player.pause();

        }
        musicActivity.createNotifcation();
    }

}

