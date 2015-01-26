package com.example.sikio_c4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import ioio.lib.spi.Logger;
import ioio.lib.util.IOIOLooper;
import ioio.lib.util.android.IOIOActivity;


public class MainActivity extends IOIOActivity implements View.OnClickListener
{
    private SeekBar seek;
    private Looper loop;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seek = (SeekBar) findViewById(R.id.seekBar);
        loop = new Looper();
        Button btn0,btn45,btn90,btn135,btn180;
        btn0 = (Button)findViewById(R.id.btn0);
        btn45 = (Button)findViewById(R.id.btn45);
        btn90 = (Button)findViewById(R.id.btn90);
        btn135 = (Button)findViewById(R.id.btn135);
        btn180 = (Button)findViewById(R.id.btn180);
        btn0.setOnClickListener(this);
        btn45.setOnClickListener(this);
        btn90.setOnClickListener(this);
        btn135.setOnClickListener(this);
        btn180.setOnClickListener(this);
        setupSeekBar();
    }

    @Override
    protected IOIOLooper createIOIOLooper()
    {
        return loop;
    }

    private void setupSeekBar()
    {
        seek.setMax(100);
        seek.setProgress(0);
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
               // int degree = ((int) (180.0F * progress) / 100); //moires
                //int seekpos = 100 * degree / 180; //antistixi thesi baras me vasi tis moires
               // int tomillis = 2500 * progress / 100; //metatrwpi ton microseconds se millisecons kanonika me auta ta values alla to servo trwei kwllimata
                int tomillis = (2400 * progress / 100) + 25;
                loop.progress = tomillis;
                Logger.log.i("LOOPA", String.valueOf(tomillis));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btn0:
                seek.setProgress(0);
                break;
            case R.id.btn45:
                seek.setProgress(100 * 82 / 180);
                break;
            case R.id.btn90:
                seek.setProgress(100 * 90 / 180);
                break;
            case R.id.btn135:
                seek.setProgress(100 * 135 / 180);
                break;
            case R.id.btn180:
                seek.setProgress(100 * 180 / 180);
                break;
        }
    }
}
