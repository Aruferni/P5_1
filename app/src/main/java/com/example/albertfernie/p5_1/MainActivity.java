package com.example.albertfernie.p5_1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    private Timer timer ;
    private MyTimerTask task;
    private Context context;
    private int interval=1000;
    Button bt1=null, bt2=null, bt3=null;
    TextView tvS=null, tvM=null, tvMen=null;
    int s=0, m=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        traerReferencias();
    }

    public void ButtonStart(View view){
        startTimer();
        bt1.setText("Continue");
        bt1.setClickable(false);
        bt2.setClickable(true);
        bt3.setClickable(false);
        if(m>=45) tvMen.setText("2ª parte");
    }

    public void ButtonStop(View view){
        stopTimer();
        bt1.setClickable(true);
        bt2.setClickable(false);
        bt3.setClickable(true);
    }

    public void ButtonReset(View view){
        bt1.setText("Start");
        s=0;
        m=0;
        if(s<10) tvS.setText("0"+String.valueOf(s));
        else tvS.setText(String.valueOf(s));
        tvM.setText("0"+String.valueOf(m));
    }

    public void ButtonContinuar (View view){
        startTimer();
        tvMen.setText("2ª parte");
    }

    public void taskTimer(){
        //el código que queremos ejecutar en timer
        s++;
        if(s<10) tvS.setText("0"+String.valueOf(s));
        else tvS.setText(String.valueOf(s));
        if(m<10) tvM.setText("0"+String.valueOf(m));
        else tvM.setText(String.valueOf(m));
        if(s==59){
            m++;
            s=0;
            if(s<10) tvS.setText("0"+String.valueOf(s));
            else tvS.setText(String.valueOf(s));
            if(m<10) tvM.setText("0"+String.valueOf(m));
            else tvM.setText(String.valueOf(m));
            if(m==45){
                s=0;
                stopTimer();
                tvS.setText("0"+String.valueOf(s));
                tvM.setText(String.valueOf(m));
                tvMen.setText("Final de la 1ª parte.");
                bt1.setText("2ª parte");
                bt1.setClickable(true);
                bt2.setClickable(false);
                bt3.setClickable(true);
            }
        }
        if(m==90){
            s=0;
            stopTimer();
            tvS.setText("0"+String.valueOf(s));
            tvM.setText(String.valueOf(m));
            tvMen.setText("Final del partido");
            bt1.setClickable(true);
            bt2.setClickable(false);
            bt3.setClickable(true);
        }
    }

    private void startTimer(){
        timer=null;
        context = this;
        task=new MyTimerTask(context);
        timer= new Timer("miTimer");
        timer.schedule(task, 0, interval);
    }

    private void stopTimer(){
        timer.cancel();
        timer=null;
        task=null;
    }

    private void traerReferencias(){
        bt1=(Button) findViewById(R.id.btStart);
        bt2=(Button) findViewById(R.id.btStop);
        bt3=(Button) findViewById(R.id.btReset);
        tvS=(TextView) findViewById(R.id.tvSec);
        tvM=(TextView) findViewById(R.id.tvMin);
        tvMen=(TextView) findViewById(R.id.tvMensaje);
    }

    /*public void msToast(String text){
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }*/

    //start
    public void btStartEventOnClick(View view){
        Log.i("Depuracion", "esto es un mensaje ");
        startTimer();
    }
}//Fin de class
