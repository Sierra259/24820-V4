package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp(name="PushBotTeleOp")
public class PushBotTeleOp extends LinearOpMode{
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
//        robot.PivotL.setTargetPosition(0);
//        robot.PivotR.setTargetPosition(0);
//        robot.PivotL.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
//        robot.PivotR.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
//        robot.PivotL.setTargetPositionTolerance(1);
//        robot.PivotR.setTargetPositionTolerance(1);
//        robot.PivotL.setPower(0.2);
//        robot.PivotR.setPower(0.2);
        robot.RPiv.setPosition(.7); // lower this = facing forward
        robot.LPiv.setPosition(.3); // lower this = facing back
        robot.Twist.setPosition(0.35); //lower --> higher = clockwise (.35 is flat)
        robot.Claw.setPosition(.4); // lower = more grip (.3 holds a specimen with decent leeway)
        waitForStart();
        // Initialize Servo Positions



        double rightj;

        double leftj;
        double speed = 0.8;

        double lefty;

        double righty;

        double leftx;

        double rightx;


        boolean buttonL;

        boolean buttonR;


        double triggerR;

        double triggerL;


        double intakeSpeed;

        double intakeSpeedMultiplier = 0.85;


        double armPower;

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


        long nextLBTimestamp = 0;

        long nextRBTimestamp = 0;

        boolean isBPSUp = true;

        boolean isFPSUp = true;

        // Is Position BackBoard Correct?
        boolean isPosBBC = false;


//        while (opModeInInit())
//        {
//            telemetry.addData("Right Front", robot.DSRF.getDistance(DistanceUnit.INCH));
//            telemetry.addData("Right Back", robot.DSRB.getDistance(DistanceUnit.INCH));
//            telemetry.addData("Left Front", robot.DSLF.getDistance(DistanceUnit.INCH));
//            telemetry.addData("Left Back", robot.DSLB.getDistance(DistanceUnit.INCH));
//            telemetry.update();
//        }

        while (opModeIsActive()) {

            // Gamepad 1

            lefty = -gamepad1.left_stick_y;

            righty = -gamepad1.right_stick_y;

            leftx = gamepad1.left_stick_x;

            rightx = gamepad1.right_stick_x;


            // Gamepad 2
            leftj = gamepad2.left_stick_y;

            rightj = gamepad2.right_stick_y;

            armPower = gamepad2.left_stick_y;

            intakeSpeed = gamepad2.right_stick_y;

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

                speed = 0.5;

            }

//            if(gamepad2.a{}){
//
//            }

            double FLDp = lefty + leftx;
            double FRDp = righty - rightx;
            double BLDp = lefty - leftx;
            double BRDp = righty + rightx;

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
            if(leftj!=0){
                robot.Down.setPower(.5 * leftj);
                robot.Up.setPower(.5 * -leftj);
            }
            else{
                robot.Down.setPower(0);
                robot.Up.setPower(0);
            }
            if(rightj!=0){
                robot.PivotL.setPower(.1 * rightj);
                robot.PivotR.setPower(.1 * -rightj);
            }
            else{
                robot.PivotL.setPower(0);
                robot.PivotR.setPower(0);
            }

            if(gamepad2.a){
                robot.LPiv.setPosition(1);
                robot.RPiv.setPosition(0);

            }
            if(gamepad2.right_trigger>0){
                robot.Claw.setPosition(0.4);
            }
            else{
                robot.Claw.setPosition(0.7);
            }
            if(gamepad2.b){
                robot.LPiv.setPosition(0);
                robot.RPiv.setPosition(1);
            }
            if(gamepad2.x){
                robot.Twist.setPosition(0.45);
            }
            if(gamepad2.y){
                robot.PivotL.setTargetPosition(0);
                robot.PivotR.setTargetPosition(0);
                robot.PivotL.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
                robot.PivotR.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
                robot.PivotL.setTargetPositionTolerance(1);
                robot.PivotR.setTargetPositionTolerance(1);
                robot.PivotL.setPower(0.4);
                robot.PivotR.setPower(0.4);
            }
            if(gamepad2.right_bumper){
                robot.PivotL.setTargetPosition(30);
                robot.PivotR.setTargetPosition(30);
                robot.PivotL.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
                robot.PivotR.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
                robot.PivotL.setTargetPositionTolerance(1);
                robot.PivotR.setTargetPositionTolerance(1);
                robot.PivotL.setPower(0.4);
                robot.PivotR.setPower(0.4);
            }

            // Gamepad 2

//            if (liftPosition + armSpeed*armPower >= 0) {
//
//                liftPosition += armPower*armSpeed;
//
//                robot.LL.setPower(armSpeed*armPower);
//
//                robot.RL.setPower(armSpeed*armPower);
//
//            }

//            robot.IN.setPower(intakeSpeed*intakeSpeedMultiplier);
//            robot.LL.setPower(armSpeed*armPower);
//            robot.RL.setPower(armSpeed*armPower);
            telemetry.update();


        }

    }

}
