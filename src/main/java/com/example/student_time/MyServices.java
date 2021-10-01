package com.example.student_time;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyServices extends Service {
    MediaPlayer m1;
    @Nullable
    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }
    @Override
    public void onCreate()
    {
        super.onCreate();
        m1=MediaPlayer.create(this,R.raw.sun);
        m1.setLooping(true);
    }
    //
//    @Override
//    public void onStart(Intent intent,int startId)
//    {
//        super.onStart(intent,startId);
//        m1.start();
//    }

    @Override

    public int onStartCommand(Intent intent,int flags,int startId)
    {
        Toast.makeText(this,"Service Started",Toast.LENGTH_SHORT).show();
        m1.start();
        return super.onStartCommand(intent,flags,startId);
    }
    @Override
    public void onDestroy()
    {
        super.onDestroy();
        m1.stop();
    }

}
