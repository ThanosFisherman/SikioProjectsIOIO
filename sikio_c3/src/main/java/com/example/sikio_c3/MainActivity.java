package com.example.sikio_c3;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

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
        Button btnMario = (Button) findViewById(R.id.btnMario);
        btnMario.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                loop.playMario = true;
            }
        });
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
                loop.freq = (int) (event.getX() + 100);
                loop.playTone = true;
                break;
            case MotionEvent.ACTION_UP:
                loop.playTone = false;
                break;
        }
        return true;
    }

}
