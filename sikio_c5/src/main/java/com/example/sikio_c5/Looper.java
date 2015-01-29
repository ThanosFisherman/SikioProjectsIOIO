package com.example.sikio_c5;

import ioio.lib.api.DigitalOutput;
import ioio.lib.api.IOIO;
import ioio.lib.api.PwmOutput;
import ioio.lib.api.exception.ConnectionLostException;
import ioio.lib.util.IOIOLooperAlt;

public class Looper extends IOIOLooperAlt
{
    DigitalOutput motor; // Declare motor as digital output
    int motorPin = 18; // Use pin 18
    boolean motorOn = false;
    long endTimeMillis = 0;
    long countdown = 0;

    @Override
    public void setup(IOIO ioio) throws ConnectionLostException, InterruptedException
    {
        super.setup(ioio);
        // Ready pin and turn motor off here
        motor = ioio.openDigitalOutput(motorPin);
        motor.write(false);
    }

    @Override
    protected void loop(IOIO ioio) throws ConnectionLostException, InterruptedException
    {

        try
        {
            countdown = (endTimeMillis - System.currentTimeMillis())/1000;
            // motorOn will be equal to 1 if timer is still counting down, so keep motor running
            if (motorOn)
            {
                if (countdown <=0)
                {
                    motorOn=false;
                    countdown=0;
                }
            }
            motor.write(motorOn);
            // Don't call this loop again for 100 milliseconds
            Thread.sleep(100);
        }
        catch (InterruptedException e)
        {
        }
    }
}
