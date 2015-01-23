package com.example.sikio_c3;

import ioio.lib.api.IOIO;
import ioio.lib.api.PwmOutput;
import ioio.lib.api.exception.ConnectionLostException;
import ioio.lib.spi.Logger;
import ioio.lib.util.BaseIOIOLooper;
import ioio.lib.util.IOIOLooperAlt;

public class Looper extends IOIOLooperAlt
{
    PwmOutput piezo; // Piezo buzzers are pulse-modulated output
    int piezoPin = 11; // Pin for our piezo speaker
    boolean playTone = true;
    int freq = 523; // Variable to keep track of note frequency

    @Override
    public void setup(IOIO ioio) throws ConnectionLostException, InterruptedException
    {
        super.setup(ioio);
    }

    @Override
    protected void loop(IOIO ioio) throws ConnectionLostException, InterruptedException
    {

    }
}
