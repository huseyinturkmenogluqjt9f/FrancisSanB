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
    /////////////////////////DcMotor tumbler;

    @Override
    public void runOpMode() throws InterruptedException {

        leftfrontMotor = hardwareMap.dcMotor.get("leftfront_motor");     //grab the configure file on the phone
        leftbackMotor = hardwareMap.dcMotor.get("leftback_motor");       //and compare it to the motors/sensors
        rightfrontMotor = hardwareMap.dcMotor.get("rightfront_motor");  //in the code
        rightbackMotor = hardwareMap.dcMotor.get("rightback_motor");
        tumbler = hardwareMap.dcMotor.get("tublr");

        waitForStart();

        /*tankdrive(-0.3, -0.3, 1200); //use rightY leftY for this cod
        tankdrive(-0.3, 0.3, 1600);

        tankdrive(-0.3, -0.3, 1000);
        tankdrive(0.3, -0.3, 1600);
        tankdrive(-0.3, -0.3, 400);
        tankdrive(0, 0, 500);
        tankdrive(0.3, 0.3, 400);

        tankdrive(-0.3, 0.3, 1600);
        tankdrive(-0.3, -0.3, 1000);
        tankdrive(-0.3, 0.3, 600);
        tankdrive(-0.3, -0.3, 2000);*/

//*
        /*tankdrive(-0.3, -0.3, 1200);
        tankdrive(0.3, -0.3, 1800);
        tankdrive(-0.3, -0.3, 1600);
        tankdrive(-0.3, 0.3, 2300);
        tankdrive(0.3, 0.3, 2200);
        tumblerdrive(-0.6, 1000);

        tankdrive(-0.3, -0.3, 2500);
        tankdrive(0.3, -0.3, 3000);
        tankdrive(0.3, 0.3, 2500);
       // encoderdrive(0.5, 0.5, 1);
       */
        tankdrive(-0.3, -0.3, 800) ;
        tankdrive(0.3, -0.3, 550);
        tankdrive(-0.4, -0.4, 1000);
        tankdrive(0.3, 0.3, 205);
        tankdrive(0.3, -0.3, 4075);
        tankdrive(0.3, 0.3, 2600);
        tumblerdrive(-1, 1000);
    }

























    private void tumblerdrive(double power, long sleepamount){
        tumbler.setPower(power);
        sleep(sleepamount);
        tumbler.setPower(0);
    }
    private void tankdrive(double leftY, double rightY, long sleepAmount) throws InterruptedException{

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
    private void encoderTankDrive(double leftY, double rightY) throws InterruptedException {
        rightY = -rightY;


        leftfrontMotor.setPower(leftY); //set the according power to each motor
        leftbackMotor.setPower(leftY);
        rightfrontMotor.setPower(rightY);
        rightbackMotor.setPower(rightY);
    }


    private void encoderDrive(double rightY, double leftY, int encoderAmount) throws InterruptedException {
        rightY = -rightY;
        encoderAmount = encoderAmount*1440;


        leftbackMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightbackMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        leftfrontMotor.setTargetPosition(encoderAmount);
        rightfrontMotor.setTargetPosition(encoderAmount);


        leftbackMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightbackMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        encoderTankDrive(rightY, leftY);


        while (leftbackMotor.isBusy() && rightbackMotor.isBusy()) {
            //just so that it is running, nothing has to be in here
            //including Paco's lunch
        }


        encoderTankDrive(0, 0);


        leftbackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightbackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftfrontMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightfrontMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }


}