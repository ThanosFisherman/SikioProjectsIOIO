package com.example.sikio_c2;

import ioio.lib.api.AnalogInput;
import ioio.lib.api.DigitalInput;
import ioio.lib.api.IOIO;
import ioio.lib.api.exception.ConnectionLostException;
import ioio.lib.spi.Logger;
import ioio.lib.util.IOIOLooperAlt;

public class Looper extends IOIOLooperAlt
{

    public interface IInputListener
    {
        public void onButtonListenInput(boolean val);
        public void onPotListenInput(float val);
    }
    private IInputListener listener;

    public Looper(IInputListener listener)
    {
        this.listener = listener;
    }

    // Declare the IO pins for the button and potentiometer.
    DigitalInput button; // Our button is a DigitalInput
    AnalogInput pot; // Our potentiometer is an AnalogInput

    // Variables to store pin numbers
    int buttonPin = 7;
    int potPin = 40;

    // Variables to store analog and digital values
    float potVal; // Our analog values range between 0 and 1
    boolean buttonVal; // Digital is either 0 OR 1 (true or false)

    @Override
    public void setup(IOIO ioio) throws ConnectionLostException, InterruptedException
    {
        // Opening the input pins.
        button = ioio.openDigitalInput(buttonPin);
        pot = ioio.openAnalogInput(potPin);

        potVal = pot.read();
        buttonVal = button.read();
    }

    @Override
    protected void loop(IOIO ioio) throws ConnectionLostException, InterruptedException
    {
        try
        {
            // While we're running, read our potentiometer and button values. The pot value is a
            // number between 0 and 1. Button value is either a 0 or 1.
            if (potVal != pot.read() )
            {
                potVal = pot.read();
                Logger.log.i("POT Value",String.valueOf(potVal));
                listener.onPotListenInput(potVal);
            }
            if (buttonVal != button.read())
            {
                buttonVal = button.read();
                Logger.log.i("Button Value",String.valueOf(buttonVal));
                listener.onButtonListenInput(buttonVal);
            }
            // Don't call this loop again for 100 milliseconds
            Thread.sleep(100);

        }
        catch (InterruptedException e)
        {
        }
    }
}
