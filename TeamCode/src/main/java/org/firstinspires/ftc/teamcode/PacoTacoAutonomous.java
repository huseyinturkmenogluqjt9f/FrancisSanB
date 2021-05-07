package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Francis on 11/19/2016.
 * Stolen by Andrew on 11/22/2016
 */
public class PacoTacoAutonomous extends LinearOpMode{

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

        encoderDrive(1, 1, 1);

    }

    private void tankdrive(double rightY, double leftY, long sleepAmount) throws InterruptedException{

        rightY = -rightY;

        leftfrontMotor.setPower(leftY); //set the according power to each motor
        leftbackMotor.setPower(leftY);
        rightfrontMotor.setPower(rightY);
        rightbackMotor.setPower(rightY);

        sleep(sleepAmount);             //this is the amount the robot will run in milliseconds

        leftfrontMotor.setPower(0);     //make sure that the all motors are set to zero afterward
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
            //including Paco's lunch and Andrews Dinner
        }

        encoderTankDrive(0, 0);

        leftbackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightbackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftfrontMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightfrontMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    }
}
