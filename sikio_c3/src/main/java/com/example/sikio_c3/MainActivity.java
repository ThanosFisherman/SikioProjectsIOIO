package com.example.sikio_c3;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;

import ioio.lib.spi.Logger;
import ioio.lib.util.IOIOLooper;
import ioio.lib.util.android.IOIOActivity;


public class MainActivity extends IOIOActivity
{

    private Looper loop;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loop = new Looper();
    }

    @Override
    protected IOIOLooper createIOIOLooper()
    {
        return loop;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        switch (event.getAction())
        {
            case MotionEvent.ACTION_MOVE:
               loop.playTone = true;
                loop.freq = (int) (event.getX() + 100);
                break;
            case MotionEvent.ACTION_UP:
                loop.playTone = false;
                break;
        }
        return true;
    }

}
