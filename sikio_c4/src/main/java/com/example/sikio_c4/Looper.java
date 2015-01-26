package com.example.sikio_c4;

import ioio.lib.api.IOIO;
import ioio.lib.api.PwmOutput;
import ioio.lib.api.exception.ConnectionLostException;
import ioio.lib.util.IOIOLooperAlt;

public class Looper extends IOIOLooperAlt
{
    PwmOutput servo;  // Declaring Servo PWM output on the IOIO
    int servoPin = 5; // Pin for the Servo PWM signal
    public int progress = 0;

    @Override
    public void setup(IOIO ioio) throws ConnectionLostException, InterruptedException
    {
        super.setup(ioio);
        // Initialize PWM pin for Servo and set initial duty cycle
        servo = ioio.openPwmOutput(servoPin, 50); // Pin 5, 50Hz (period = 20ms)
        servo.setDutyCycle(.0f); // Sets angle of Servo
    }

    @Override
    protected void loop(IOIO ioio) throws ConnectionLostException, InterruptedException
    {
        // Set new Servo angle based on duty cycle set by cursor position
        servo.setPulseWidth( progress);
        // Don't call this loop again for 100 milliseconds
        Thread.sleep(100);
    }
}
