/*package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="PushBotTeloOpE")
public class TeleOp17 extends LinearOpMode{
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



//        robot.ILextend.setPosition(1); // 1 is all the way inside
//        robot.IRextend.setPosition(0);
//        robot.ILwrist.setPosition(0.38);// 0 is all the way down
//        robot.IRwrist.setPosition(0.62); //
//        robot.IRflip.setPosition(.1); // down all the way at 1
//        robot.Iclaw.setPosition(0.3); // open at .6 close at .3
//        robot.Itwist.setPosition(.8); // horizontal at .1
//
//        robot.OLflip.setPosition(0.25); // in at 0
//        robot.ORflip.setPosition(0.75);
//        robot.Oclaw.setPosition(.8); // open at .8 close at .4
//        robot.Otwist.setPosition(.2); // horizontal at .2



        waitForStart();
        /* Initialize Servo Positions
        For the servos, there is a minimum and a maximum place it can turn to. Useally, in code, it is 0 to 1, 0 being min. and
        1 being max. It is important to understand at which place, either min or max or in somewhere in the middle, the servo has to turn at the beginning.
        Here we defined the initial position the servos must take when the robot starts. The robots servos will pull all the intakes inside
        PS. It might be different for your guys's robot so ask the builders about how the robot should start when powered up*/


      /*  int OtwistCount = 0;
        int OclawCount = 0;
        int OflipCount = 0;

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


        long nextLBTimestamp = 0;

        long nextRBTimestamp = 0;

        boolean isBPSUp = true;

        boolean isFPSUp = true;

        // Is Position BackBoard Correct?
        boolean isPosBBC = false;

        double multiply = 1;

//        while (opModeInInit())
//        {
//            telemetry.addData("Right Front", robot.DSRF.getDistance(DistanceUnit.INCH));
//            telemetry.addData("Right Back", robot.DSRB.getDistance(DistanceUnit.INCH));
//            telemetry.addData("Left Front", robot.DSLF.getDistance(DistanceUnit.INCH));
//            telemetry.addData("Left Back", robot.DSLB.getDistance(DistanceUnit.INCH));
//            telemetry.update();
//        }
/*
        while (opModeIsActive()) {

            // Gamepad 1

            lefty = -gamepad1.left_stick_y;

            righty = -gamepad1.right_stick_y;

            leftx = gamepad1.left_stick_x;

            rightx = gamepad1.right_stick_x;


            // Gamepad 2

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
            */

            /*
            This portion of the code works with the claw. Talk to the builders and drivers to what buttons they want
            to pick the pixels directly.
             */


/*
            if(gamepad2.dpad_up)
            {
                if (OtwistCount == 0){
                    robot.Otwist.setPosition(0.2);
                    OtwistCount++;
                    sleep(200);
                }
                else if (OtwistCount == 1){
                    robot.Otwist.setPosition(0.5);
                    OtwistCount--;
                    sleep(200);
                }
            }

            if(gamepad2.left_trigger>.1)
            {
                if (OclawCount == 0){
                    robot.Oclaw.setPosition(0.8);
                    OclawCount++;
                    sleep(200);
                }
                else if (OclawCount == 1){
                    robot.Oclaw.setPosition(0.5);
                    OclawCount--;
                    sleep(200);
                }
            }

            if(gamepad2.left_bumper)
            {
                if (OflipCount == 0){
                    robot.OLflip.setPosition(0.7); // in at 0
                    robot.ORflip.setPosition(0.3);
                    robot.Otwist.setPosition(0.5);
                    OflipCount++;
                    sleep(200);
                }
                else if (OflipCount == 1){
                    robot.Otwist.setPosition(0.5);
                    robot.OLflip.setPosition(0.3); // in at 0
                    robot.ORflip.setPosition(0.7);

                    OflipCount--;
                    sleep(200);
                }
            }
*/


/*
            if (rightj>.1) {
                robot.ILextend.setPosition(0.7); // 1 is all the way inside
                robot.IRextend.setPosition(0.3);
            }else if (rightj<-.1 ){
                robot.ILextend.setPosition(0.95); // 1 is all the way inside
                robot.IRextend.setPosition(0.05);
            }
            if(gamepad2.right_trigger>.1)
            {
                if (IclawCount == 0){
                    robot.Iclaw.setPosition(0.6);
                    IclawCount++;
                    sleep(200);
                }
                else if (IclawCount == 1){
                    robot.Iclaw.setPosition(0.3);
                    IclawCount--;
                    sleep(200);
                }
            }

            if(gamepad2.right_bumper)
            {
                if (IflipCount == 0){
                    robot.ILwrist.setPosition(0.26);// 0 is all the way down
                    robot.IRwrist.setPosition(0.74);
                    robot.IRflip.setPosition(.95);

                    IflipCount++;
                    sleep(200);
                }
                else if (IflipCount == 1){
                    robot.ILwrist.setPosition(0.32);// 0 is all the way down
                    robot.IRwrist.setPosition(0.68);
                    robot.IRflip.setPosition(1); // all the way down at 1

                    IflipCount--;
                    sleep(200);
                }
            }

            if(gamepad2.x)
            {
                if (ItwistCount == 0){
                    robot.Itwist.setPosition(.1);
                    ItwistCount++;
                    sleep(200);
                }
                else if (ItwistCount == 1){
                    robot.Itwist.setPosition(.45);
                    ItwistCount--;
                    sleep(200);
                }
            }
            if (gamepad2.y) {
                robot.ILextend.setPosition(1); // 1 is all the way inside
                robot.IRextend.setPosition(0);
                robot.ILwrist.setPosition(0.38);// 0 is all the way down
                robot.IRwrist.setPosition(0.62);
                robot.IRflip.setPosition(.1); // down all the way at 1
                robot.Iclaw.setPosition(0.3); // open at .6 close at .3
                robot.Itwist.setPosition(.8); // horizontial at .1

                robot.OLflip.setPosition(0.25); // in at 0
                robot.ORflip.setPosition(0.75);
                robot.Oclaw.setPosition(.8); // open at .8 close at .4
                robot.Otwist.setPosition(.2); // horizontil at .2
            }

            if (gamepad2.a) {
                robot.Oclaw.setPosition(.4); // open at .8 close at .5
                sleep(100);
                robot.Iclaw.setPosition(0.6); // open at .6 close at .3
            }
            */

            /*
            Below we use buttons to switch between the positions of the servos. You will need to do testing to see at what position
            do the servos need to be for the robot to work properly. For example, if set to a bigger position than necessary, the servos might break.
            Here you will need the builders to detached attachments on the servos and then trail and error to see which initial and ending positions
            work best for the robot to score.
            */
//
/*
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


            // Gamepad 2

            double UPp = leftj;
            double DOWNp = -rightj;

            if(leftj!=0){
                robot.DOWN.setPower(1 * leftj);
                robot.UP.setPower(1 * -leftj);
            }
            else{
                robot.DOWN.setPower(0);
                robot.UP.setPower(0);
            }
//
//            if (rightj>0 && (lspos < 1 || lspos > 0)){
//                lspos += 0.01;
//                robot.LS.setPosition(lspos);
//                robot.RS.setPosition(1-lspos);
//                sleep(50);
//            }
//            else if (rightj<0 && (lspos < 1 || lspos > 0)){
//                lspos -= 0.01;
//                robot.LS.setPosition(lspos);
//                robot.RS.setPosition(1-lspos);
//                sleep(50);
            }


            telemetry.update();


        }

    }
*/