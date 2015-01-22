package com.example.sikio_c2;

import android.os.Bundle;

import ioio.lib.util.IOIOLooper;
import ioio.lib.util.android.IOIOActivity;


public class MainActivity extends IOIOActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected IOIOLooper createIOIOLooper()
    {
        return new Looper();
    }

}
