package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;

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
        telemetry.setMsTransmissionInterval(50);

        waitForStart();

        int IclawCount = 0;
        int IflipCount = 1;
        int ItwistCount = 0;



        double speed = 0.5;

        double lefty_1;

        double righty_1;

        double leftx_1;

        double rightx_1;

        double righty_2; //right joystick

        double lefty_2; //left joystick

        double rightx_2;

        double leftx_2;

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

        boolean isPosBBC = false;

        while (opModeIsActive()) {

            //Gamepad 1

            lefty_1 = -gamepad1.left_stick_y;

            righty_1 = -gamepad1.right_stick_y;

            leftx_1 = gamepad1.left_stick_x;

            rightx_1 = gamepad1.right_stick_x;

            //Gamepad 2

            lefty_2 = gamepad2.left_stick_y;

            leftx_2 = -gamepad2.left_stick_y;

            righty_2 = gamepad2.right_stick_y;

            rightx_2 = -gamepad2.right_stick_y;

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

            double FLDp = lefty_1 + leftx_1;
            double FRDp = righty_1 - rightx_1;
            double BLDp = lefty_1 - leftx_1;
            double BRDp = righty_1 + rightx_1;

            // Gamepad 1
            if (isPosBBC) {
                if ((FLDp > 0 && BRDp > 0 && FRDp < 0 && BLDp < 0) || FLDp < 0 && BRDp < 0 && FRDp > 0 && BLDp > 0)
                {
                    robot.FLD.setPower(speed * FLDp);

                    robot.FRD.setPower(speed * FRDp);

                    robot.BLD.setPower(speed * BLDp);

                    robot.BRD.setPower(speed * BRDp);
                }
            }
            else {
                robot.FLD.setPower(speed * FLDp);

                robot.FRD.setPower(speed * FRDp);

                robot.BLD.setPower(speed * BLDp);

                robot.BRD.setPower(speed * BRDp);
            }

            double FLPulleyp = lefty_2 + leftx_2;
            double FRPulleyp = righty_2 - rightx_2;
            double BLPulleyp = lefty_2 - leftx_2;
            double BRPulleyp = righty_2 + rightx_2;

            // Gamepad 2
            if (isPosBBC) {
                if ((FLPulleyp > 0 && BRPulleyp > 0 && FRPulleyp < 0 && BLPulleyp < 0) || FLPulleyp < 0 && BRPulleyp < 0 && FRPulleyp > 0 && BLPulleyp > 0)
                {
                    robot.FLPulley.setPower(speed * FLPulleyp);

                    robot.FRPulley.setPower(speed * FRPulleyp);

                    robot.BLPulley.setPower(speed * BLPulleyp);

                    robot.BRPulley.setPower(speed * BRPulleyp);
                }
            }
            else {
                robot.FLPulley.setPower(speed * FLPulleyp);

                robot.FRPulley.setPower(speed * FRPulleyp);

                robot.BLPulley.setPower(speed * BLPulleyp);

                robot.BRPulley.setPower(speed * BRPulleyp);
            }

        }


    }

}
