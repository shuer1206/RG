package com.example.wy.r.notifi;



import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.wy.r.MainActivity;

//下一曲
public class NextBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "NextBroadcastReceiver";
    @Override
    public void onReceive(Context context, Intent intent){
        final MainActivity musicActivity = MainActivity.getInstance();
        musicActivity.runOnUiThread(new Runnable() {

            @Override
            public void run() {
                Log.e(TAG, "run: "+"下一曲");
                musicActivity.audioService.onCreate();
            }
        });

    }
}
