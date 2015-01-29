package com.example.sikio_c5;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import ioio.lib.util.IOIOLooper;
import ioio.lib.util.android.IOIOActivity;


public class MainActivity extends IOIOActivity implements TextView.OnEditorActionListener, Looper.IMotorMonitor
{
    private Looper loop;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loop = new Looper(this);
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
            hideKeyboard(v);
            loop.endTimeMillis = System.currentTimeMillis() + Long.valueOf(v.getText().toString()) * 1000;

            loop.motorOn = true;
            return true;
        }
        return false;
    }

    private void hideKeyboard(View v)
    {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null)
        {
            imm.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);
        }
    }

    @Override
    public void onSecsCountdown(final int secs)
    {
        runOnUiThread(new Runnable()
        {
            @Override
            public void run()
            {
                ((TextView)findViewById(R.id.textView2)).setText("Seconds: " + secs);
            }
        });
    }
}
