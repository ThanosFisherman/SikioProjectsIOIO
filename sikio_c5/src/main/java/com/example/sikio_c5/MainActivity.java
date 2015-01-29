package com.example.sikio_c5;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import ioio.lib.util.IOIOLooper;
import ioio.lib.util.android.IOIOActivity;


public class MainActivity extends IOIOActivity implements TextView.OnEditorActionListener
{
    private Looper loop;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loop = new Looper();
        EditText edtSecs = (EditText) findViewById(R.id.editSecs);
        edtSecs.setOnEditorActionListener(this);
    }

    @Override
    protected IOIOLooper createIOIOLooper()
    {
        return loop;
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event)
    {
        if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_NULL)
        {
          loop.endTimeMillis = System.currentTimeMillis() + Long.valueOf(v.getText().toString()) * 1000;
            return true;
        }
        return false;
    }
}
