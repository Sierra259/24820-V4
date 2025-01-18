package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="Training")
public class LearningTeleOp extends LinearOpMode{
    // Class Gamepad Documentation:

    // https://ftctechnh.github.io/ftc_app/doc/javadoc/com/qualcomm/robotcore/hardware/Gamepad.html

    HardwarePushBot17 robot = new HardwarePushBot17();

    @Override

    public void runOpMode() {
        robot.init(hardwareMap);

        robot.FLD.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

        robot.FRD.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

        robot.BLD.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

        robot.BRD.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

        robot.DOWN.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        robot.UP.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        telemetry.setMsTransmissionInterval(50);

        waitForStart();

        int IclawCount = 0;
        int IflipCount = 1;
        int ItwistCount = 0;



        double speed = 0.5;

        double lefty;

        double righty;

        double leftx;

        double rightx;

        double rightj; //right joystick

        double leftj; //left joystick


        boolean buttonL;

        boolean buttonR;


        double triggerR;

        double triggerL;


        double intakeSpeed;

        double intakeSpeedMultiplier = 0.85;


        double armPower = 1.0;

        double armSpeed = 1.0;

//        double liftPosition = 0.0;


        boolean dpadUp;

        boolean dpadDown;

        boolean dpadRight;

        boolean dpadLeft;


        boolean a;

        boolean b;

        boolean x;

        boolean y;


        while (opModeIsActive()) {

            //Gamepad 1

            lefty = -gamepad1.left_stick_y;

            righty = -gamepad1.right_stick_y;

            leftx = gamepad1.left_stick_x;

            rightx = gamepad1.right_stick_x;

            //Gamepad 2

            leftj = gamepad2.left_stick_y;

            rightj = gamepad2.right_stick_y;

            buttonL = gamepad2.left_bumper;

            buttonR = gamepad2.right_bumper;

            triggerL = gamepad2.left_trigger;

            triggerR = gamepad2.right_trigger;

            dpadUp = gamepad2.dpad_up;

            dpadLeft = gamepad2.dpad_left;

            dpadRight = gamepad2.dpad_right;

            dpadDown = gamepad2.dpad_down;

            y = gamepad2.y;  // Up

            x = gamepad2.x;  // Left

            b = gamepad2.b; // Right

            a = gamepad2.a; // Down

            if(gamepad1.a)
            {
                speed = 0.9;
            }

            else if(gamepad1.b)
            {
                speed = 0.75;
            }

            else if(gamepad1.x)
            {
                speed = 0.5;
            }

            else if(gamepad1.y)
            {
                speed = 0.3;
            }

            robot.Claw.setPosition(0.5);
            //all claw code
            waitForStart();

        }
    }

}
