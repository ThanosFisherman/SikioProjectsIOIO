package com.example.sikio_c3;

import ioio.lib.api.IOIO;
import ioio.lib.api.PwmOutput;
import ioio.lib.api.exception.ConnectionLostException;
import ioio.lib.util.IOIOLooperAlt;

public class Looper extends IOIOLooperAlt
{
    PwmOutput piezo; // Piezo buzzers are pulse-modulated output
    int piezoPin = 11; // Pin for our piezo speaker
    boolean playTone = false;
    int freq = 523; // Variable to keep track of note frequency

    @Override
    public void setup(IOIO ioio) throws ConnectionLostException, InterruptedException
    {
        super.setup(ioio);
        // Open and close the piezo pin just to give us a connection and set the duty cycle
        piezo = ioio.openPwmOutput(piezoPin, freq);
        piezo.setDutyCycle(.5f);
        piezo.close(); // To stop from the piezo from making sound on startup
    }

    @Override
    protected void loop(IOIO ioio) throws ConnectionLostException, InterruptedException
    {
        // If a 'piano' key has been pressed, play that note for 100 ms
        if (playTone)
        {
            piezo = ioio.openPwmOutput(piezoPin, freq);
            piezo.setDutyCycle(0.2f);
            Thread.sleep(100);
            piezo.close(); // Turn off signal to piezo speaker
            playTone = false; // Set to false so note doesn't continuously play, and waits for another screen press
        }

    }
}
