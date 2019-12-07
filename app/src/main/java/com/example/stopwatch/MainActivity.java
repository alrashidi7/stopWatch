package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class MainActivity extends AppCompatActivity {
    Button open;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        open = findViewById(R.id.open);
        title = findViewById(R.id.title);
        YoYo.with(Techniques.SlideInDown).duration(2000).playOn(title);

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.animation);
        Animation animation2 = AnimationUtils.loadAnimation(this,R.anim.animation2);

        title.startAnimation(animation2);
        open.setAnimation(animation);
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });



    }

}
