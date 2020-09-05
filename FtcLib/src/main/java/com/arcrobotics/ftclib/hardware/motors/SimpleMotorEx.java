package com.arcrobotics.ftclib.hardware.motors;

import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.controller.wpilibcontroller.SimpleMotorFeedforward;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * A simple example of a {@link MotorEx} object.
 *
 * @author Jackson
 */
public class SimpleMotorEx extends MotorEx {

    DcMotorEx motor;

    public SimpleMotorEx(SimpleMotor motor, double cpr,
                         PIDController veloController,
                         SimpleMotorFeedforward feedforward) {

        super(motor, cpr, veloController, feedforward);
        this.motor = (DcMotorEx)motor.motor;

    }

    public SimpleMotorEx(String name, HardwareMap hMap, double cpr,
                         PIDController veloController,
                         SimpleMotorFeedforward feedforward) {

        this(new SimpleMotor(name, hMap), cpr, veloController, feedforward);
        this.motor = (DcMotorEx)hMap.get(DcMotor.class, name);

    }

    public SimpleMotorEx(String name, HardwareMap hMap, double cpr) {

        this(new SimpleMotor(name, hMap), cpr, new PIDController(new double[]{1,0,0}),
                new SimpleMotorFeedforward(0,0,0));

    }

    public SimpleMotorEx(SimpleMotor motor, double cpr,
                         PIDController veloController) {

        super(motor, cpr, veloController);
        this.motor = (DcMotorEx)motor.motor;

    }

    public SimpleMotorEx(String name, HardwareMap hMap, double cpr,
                         PIDController veloController) {

        super(new SimpleMotor(name, hMap), cpr, veloController);
        this.motor = (DcMotorEx)hMap.get(DcMotor.class, name);

    }

    /**
     * Here we obtain the position of the output shaft in ticks.
     * We need to cast the motor object as a {@link SimpleMotor}
     * in order to get this position from the {@link com.qualcomm.robotcore.hardware.DcMotor}.
     *
     * @return the current position of the output shaft in ticks
     */
    @Override
    public int getCurrentPosition() {
        return ((SimpleMotor)motor).getCurrentPosition();
    }

}
