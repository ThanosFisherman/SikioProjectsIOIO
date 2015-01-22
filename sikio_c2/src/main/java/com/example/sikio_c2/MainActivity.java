package com.example.sikio_c2;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import ioio.lib.spi.Logger;
import ioio.lib.util.IOIOLooper;
import ioio.lib.util.android.IOIOActivity;


public class MainActivity extends IOIOActivity implements Looper.IInputListener
{
    private TextView txtButton, txtPot;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtButton = (TextView) findViewById(R.id.txtButton);
        txtPot = (TextView) findViewById(R.id.txtPot);
    }

    @Override
    protected IOIOLooper createIOIOLooper()
    {
        return new Looper(this);
    }

    @Override
    public void onButtonListenInput(final boolean val)
    {
       runOnUiThread(new Runnable()
       {
           @Override
           public void run()
           {
               txtButton.setText("Button Value: " + String.valueOf(val));
           }
       });
    }

    @Override
    public void onPotListenInput(final float val)
    {
        runOnUiThread(new Runnable()
        {
            @Override
            public void run()
            {
                txtPot.setText("Pot value: " + String.valueOf(val));
                Float color = val * 255f;
                txtPot.setBackgroundColor(Color.rgb(color.intValue(),0,0));
            }
        });
    }
}
