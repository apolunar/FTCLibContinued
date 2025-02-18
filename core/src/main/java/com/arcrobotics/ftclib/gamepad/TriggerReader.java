package com.arcrobotics.ftclib.gamepad;

public class TriggerReader implements KeyReader {

    private final GamepadEx gamepad;

    private final GamepadKeys.Trigger trigger;

    /**
     * Last state of the button
     **/
    private boolean lastState;

    /**
     * Current state of the button
     **/
    private boolean currState;
    
    /**
     * Current threshold
     **/
    private final double threshold;

    /**
     * Initializes controller variables
     *
     * @param gamepad The controller joystick
     * @param trigger The controller button
     **/
    public TriggerReader(GamepadEx gamepad, GamepadKeys.Trigger trigger) {
        this(gamepad, trigger, 0.5);
    }
    
    public TriggerReader(GamepadEx gamepad, GamepadKeys.Trigger trigger, double threshold) {
        this.gamepad = gamepad;
        this.trigger = trigger;
        this.threshold = threshold;

        currState = this.gamepad.getTrigger(trigger) > this.threshold;
        
        lastState = currState;
    }

    /**
     * Reads button value
     **/
    public void readValue() {
        lastState = currState;
        currState = this.gamepad.getTrigger(trigger) > this.threshold;
    }

    /**
     * Checks if the button is down
     **/
    public boolean isDown() {
        return currState;
    }

    /**
     * Checks if the button was just pressed
     **/
    public boolean wasJustPressed() {
        return (!lastState && currState);
    }

    /**
     * Checks if the button was just released
     **/
    public boolean wasJustReleased() {
        return (lastState && !currState);
    }

    /**
     * Checks if the button state has changed
     **/
    public boolean stateJustChanged() {
        return (lastState != currState);
    }

}
