package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import java.util.Timer;

/**
 * Created by yunqing on 11/19/2016.
 */
public class Cookie_Autonomous extends LinearOpMode{

    DcMotor leftfrontMotor;
    DcMotor leftbackMotor;
    DcMotor rightfrontMotor;
    DcMotor rightbackMotor;
    DcMotor tumbler;

    @Override
    public void runOpMode() throws InterruptedException {
        leftfrontMotor = hardwareMap.dcMotor.get("leftfront_motor");
        leftbackMotor = hardwareMap.dcMotor.get("leftback_motor");
        rightfrontMotor = hardwareMap.dcMotor.get("rightfront_motor");
        rightbackMotor = hardwareMap.dcMotor.get("rightback_motor");
        tumbler = hardwareMap.dcMotor.get("tumbler");

        waitForStart();

        tankDrive(1, 1, 1000);
    }

    private void tankDrive(double leftY, double rightY,long sleepAmount) throws InterruptedException {
        rightY = -rightY;


        leftfrontMotor.setPower(leftY);
        leftbackMotor.setPower(leftY);
        rightfrontMotor.setPower(rightY);
        rightbackMotor.setPower(rightY);

        sleep (sleepAmount);

        leftfrontMotor.setPower(0);
        leftbackMotor.setPower(0);
        rightfrontMotor.setPower(0);
        rightbackMotor.setPower(0);






    }
}

