package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import java.util.Timer;

/**
 * Created by Francis on 11/19/2016.
 * Stolen by Andrew on 11/22/2016
 */
public class Autonomousthree extends LinearOpMode{

    DcMotor leftfrontMotor;
    DcMotor leftbackMotor;
    DcMotor rightfrontMotor;
    DcMotor rightbackMotor;
    DcMotor tumbler;

    @Override
    public void runOpMode() throws InterruptedException {

        leftfrontMotor = hardwareMap.dcMotor.get("leftfront_motor");     //grab the configure file on the phone
        leftbackMotor = hardwareMap.dcMotor.get("leftback_motor");       //and compare it to the motors/sensors
        rightfrontMotor = hardwareMap.dcMotor.get("rightfront_motor");  //in the code
        rightbackMotor = hardwareMap.dcMotor.get("rightback_motor");
        tumbler = hardwareMap.dcMotor.get("tublr");

        waitForStart();

        tankdrive(-0.3, -0.3, 1400);
        tankdrive(-0.3, 0.3, 600);
        tankdrive(-0.3, -0.3, 1500);
        tankdrive(0,0,800);
        tankdrive(-0.3, 0.3,600);

    }

    private void tankdrive(double rightY, double leftY, long sleepAmount) throws InterruptedException{

        rightY = -rightY;

        leftfrontMotor.setPower(leftY); //set the according power to each motor
        leftbackMotor.setPower(leftY);
        rightfrontMotor.setPower(rightY);
        rightbackMotor.setPower(rightY);

        sleep(sleepAmount);

        leftfrontMotor.setPower(0); //set the according power to each motor
        leftbackMotor.setPower(0);
        rightfrontMotor.setPower(0);
        rightbackMotor.setPower(0);

    }


}