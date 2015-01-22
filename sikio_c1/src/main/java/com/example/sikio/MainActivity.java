package com.example.sikio;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ioio.lib.util.IOIOLooper;
import ioio.lib.util.android.IOIOActivity;


public class MainActivity extends IOIOActivity implements View.OnClickListener
{
    private Looper loop;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loop = new Looper();
        Button btnRed, btnBlue, btnGreen;
        btnRed = (Button) findViewById(R.id.btnRed);
        btnGreen = (Button) findViewById(R.id.btnGreen);
        btnBlue = (Button) findViewById(R.id.btnBlue);
        btnRed.setOnClickListener(this);
        btnBlue.setOnClickListener(this);
        btnGreen.setOnClickListener(this);
    }

    @Override
    protected IOIOLooper createIOIOLooper()
    {
        return loop;
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btnRed:
                loop.redOn = !loop.redOn;
                break;
            case R.id.btnGreen:
                loop.greenOn = !loop.greenOn;
                break;
            case R.id.btnBlue:
                loop.blueOn = !loop.blueOn;
                break;


        }
    }
}
