package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Aakarsh on 11/21/2016.
 */
public class Autonomous2 extends LinearOpMode {

    DcMotor leftfrontMotor;     //identify the motors and sensors
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

        tankdrive(-0.3, -0.3, 800);
        tankdrive(-0.3, 0.3, 550);
        tankdrive(-0.4, -0.4, 1000);
        tankdrive(0.3, 0.3, 205);
        tankdrive(-0.3, 0.3, 4050);
        tankdrive(0.3, 0.3, 2600);
        tumblerDrive(-1, 1000);


    }

    private void tankdrive(double leftY, double rightY, long sleepAmount) throws InterruptedException {

        rightY = -rightY;               //flip the power of the right side

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

    private void tumblerDrive(double power, long sleepAmount) throws InterruptedException {

        tumbler.setPower(power);

        sleep(sleepAmount);

        tumbler.setPower(0);
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
        encoderAmount = encoderAmount * 1440;


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