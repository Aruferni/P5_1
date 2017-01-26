package com.example.albertfernie.p5_1;

import android.content.Context;
import android.os.Handler;
import java.util.TimerTask;


/**
 * Created by albertfernie on 08/11/2016.
 */

public class MyTimerTask extends TimerTask {
    Handler handler = new Handler();
    Context context;
    public MyTimerTask(Context context){this.context=context;}
    public void run() {
        handler.post(new Runnable() {
            public void run() {
                ((MainActivity) context).taskTimer();
            }});
    }
}
