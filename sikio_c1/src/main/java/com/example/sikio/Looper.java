package com.example.sikio;

import ioio.lib.api.DigitalOutput;
import ioio.lib.api.IOIO;
import ioio.lib.api.exception.ConnectionLostException;
import ioio.lib.util.IOIOLooperAlt;

public class Looper extends IOIOLooperAlt
{
    // Declare the IO pins we will use as outputs for the RGB LED.
    private DigitalOutput redLed, greenLed, blueLed;

    public boolean redOn = false ,greenOn = false ,blueOn = false;
    @Override
    public void setup(IOIO ioio) throws ConnectionLostException, InterruptedException
    {
        // Here are variables to store the pins on the IOIO board we want to use.
        final int redPin = 3; // Pin 3 of the IOIO is the output to the red leg of the RGB LED.
        final int greenPin = 2;
        final int bluePin = 1;
        // Ready each pin for use as an output.
        redLed = ioio.openDigitalOutput(redPin);
        greenLed = ioio.openDigitalOutput(greenPin);
        blueLed = ioio.openDigitalOutput(bluePin);
    }

    @Override
    protected void loop(IOIO ioio) throws ConnectionLostException, InterruptedException
    {
        try
        {
            // Turn each LED on or off based on their status variables.
            redLed.write(redOn);
            greenLed.write(greenOn);
            blueLed.write(blueOn);
            // Don't call this loop again for 100 milliseconds
            Thread.sleep(100);
        }
        catch (InterruptedException e)
        {
        }
    }
}
