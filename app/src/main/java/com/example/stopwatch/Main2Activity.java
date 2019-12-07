package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class Main2Activity extends AppCompatActivity {
    Long time;
    ImageView rotater;
    Button starter, ender, pouse;
    Animation start_rotate, stop_rotate,button_rotate,animation2,animation1;
    Chronometer currentTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        rotater = findViewById(R.id.timer);
        currentTime = findViewById(R.id.time);
        starter = findViewById(R.id.startTimer);
        ender = findViewById(R.id.endTimer);
        pouse = findViewById(R.id.pouseTimer);

         animation1 = AnimationUtils.loadAnimation(this,R.anim.animation1);
         animation2 = AnimationUtils.loadAnimation(this,R.anim.animation2);
        start_rotate = AnimationUtils.loadAnimation(Main2Activity.this,R.anim.rotate);
        stop_rotate = AnimationUtils.loadAnimation(Main2Activity.this,R.anim.stop_rotate);
        button_rotate= AnimationUtils.loadAnimation(Main2Activity.this,R.anim.animation);

        starter.setAnimation(animation2);
        pouse.setAnimation(animation1);
        ender.setAnimation(button_rotate);

        starter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (time == null){
                    rotater.startAnimation(start_rotate);
                    currentTime.setBase(SystemClock.elapsedRealtime()  );

                    currentTime.start();

                }else {

                rotater.startAnimation(start_rotate);
                currentTime.setBase(SystemClock.elapsedRealtime() - time );

                currentTime.start();
                }
                }
        });
        pouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentTime.stop();
                rotater.setAnimation(stop_rotate);

                time = SystemClock.elapsedRealtime()- currentTime.getBase();
            }
        });

        ender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rotater.setAnimation(stop_rotate);
                currentTime.stop();
                time = 0l;

            }
        });


    }


}
