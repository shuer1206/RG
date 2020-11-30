package com.example.wy.r.timingpush;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.RequiresApi;

import com.example.wy.r.MainActivity;
import com.example.wy.r.R;



public class AlertService extends Service {
    private Context mContext;
    private NotificationManager notificationManager;
    private Notification.Builder mBuilder;
    private Notification notification;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        notificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        mBuilder = new Notification.Builder(mContext);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Intent intent2=new Intent();
        intent2.setClass(this, MainActivity.class);//点击通知需要跳转的activity
        PendingIntent contentIntent = PendingIntent.getActivity(mContext,0, intent2,
                PendingIntent.FLAG_UPDATE_CURRENT);
        notification = mBuilder.setContentTitle(intent.getStringExtra("title"))
                .setContentText(intent.getStringExtra("contentText"))
                .setSmallIcon(R.mipmap.pic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(mContext.getResources(), R.mipmap.pic_launcher))
                .setContentIntent(contentIntent)
                .setDefaults(Notification.DEFAULT_SOUND)
                .build();
        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        notificationManager.notify(0, notification);
        return START_REDELIVER_INTENT;
    }
}