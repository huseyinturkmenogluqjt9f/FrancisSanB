package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


/**
 * Created by Juan Pablo Martinez on 11/29/2015.
 */
public class MVMSTeleOp extends MVMSTeleOpTelemetry {
    DcMotor leftback_motor;     //identify all of the motors
    DcMotor rightback_motor;
    DcMotor leftfront_motor;
    DcMotor rightfront_motor;
    DcMotor tumbler;
    Servo Beacon;
    //DcMotor kicker;
   // DcMotor shooter;

    @Override
    public void init() {
        leftback_motor = hardwareMap.dcMotor.get("leftback_motor");     //link each motor to each
        leftfront_motor = hardwareMap.dcMotor.get("leftfront_motor");   //of the motors in the
        rightback_motor = hardwareMap.dcMotor.get("rightback_motor");   //configure file on the
        rightfront_motor = hardwareMap.dcMotor.get("rightfront_motor"); //phone
        tumbler = hardwareMap.dcMotor.get("tublr");
        Beacon = hardwareMap.servo.get("Bacon");
        //kicker = hardwareMap.dcMotor.get("kicker");
        //shooter = hardwareMap.dcMotor.get("shooter");
    }


    @Override
    public void loop() {                        //create a loop where the code goes

        float rightY = gamepad1.right_stick_y;  //create a float based off of the y axis of the left
        float leftY = -gamepad1.left_stick_y;   //and right joysticks
        boolean in = gamepad1.left_bumper;
        boolean out = gamepad1.right_bumper;
        boolean BeaconIn = gamepad1.a;
        //boolean kick = gamepad1.a;
        //float shoot = gamepad1.right_trigger;

        telemetry.addData("rightY", rightY);    //print out the current y axis of both joysticks
        telemetry.addData("leftY", leftY);
        telemetry.addData("out", out);
        telemetry.addData("in", in);
        telemetry.addData("in beacon", BeaconIn);
        //telemetry.addData("kick", kick);
        //telemetry.addData("shoot", shoot);

        leftY = (float) scaleInput(leftY);      //use the scaleInput function on the power to scale
        rightY = (float) scaleInput(rightY);    //it

        /*
        if (gamepad1.right_bumper) {
            leftY = leftY / 2;
            rightY = rightY / 2;
        }                                       //this is for dividing the motor power in half
        if (gamepad1.left_bumper) {
            leftY = leftY / 4;
            rightY = rightY / 4;
        }*/

        if (BeaconIn) {
            Beacon.setPosition(0.2);
            return;
        } else {
            Beacon.setPosition(-1.0);
        }

        leftback_motor.setPower(leftY);         //set the power to each corresponding motor
        rightback_motor.setPower(rightY);
        leftfront_motor.setPower(leftY);
        rightfront_motor.setPower(rightY);
        //shooter.setPower(shoot);

        /*if (kick) {
            kicker.setPower(1);
        }*/

        if (!out && !in) {
            tumbler.setPower(0);
        }
        if(out) {
            tumbler.setPower(1);
        }
        if(in) {
            tumbler.setPower(-1);
        }

    }
        /*if (out) {
            tumbler.setPower(-1);
        }
        if (in)  {
            tumbler.setPower(1);
            }

        if (!in || out)   {
            tumbler.setPower(0);
        }

        }
        }*/


    double scaleInput(double dVal)  {
        double[] scaleArray = { 0.0, 0.05, 0.09, 0.10, 0.12, 0.15, 0.18, 0.24,
                0.30, 0.36, 0.43, 0.50, 0.60, 0.72, 0.85, 1.00, 1.00 };


        // get the corresponding index for the scaleInput array.
        int index = (int) (dVal * 16.0);


        // index should be positive.
        if (index < 0) {
            index = -index;
        }


        // index cannot exceed size of array minus 1.
        if (index > 16) {
            index = 16;
        }


        // get value from the array.
        double dScale = 0.0;
        if (dVal < 0) {
            dScale = -scaleArray[index];
        } else {
            dScale = scaleArray[index];
        }


        // return scaled value.
        return dScale;
    }
}


