package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


@TeleOp(name="PushBotTeleOpTwoDriv")
public class PushBotTeleOpTwoDriv extends LinearOpMode{
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

        robot.PivotL.setDirection(DcMotorSimple.Direction.FORWARD);
        robot.PivotL.setDirection(DcMotorSimple.Direction.FORWARD);

        robot.PivotL.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        robot.PivotR.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);




        telemetry.setMsTransmissionInterval(50);
//        robot.PivotL.setTargetPosition(0);
//        robot.PivotR.setTargetPosition(0);
//        robot.PivotL.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
//        robot.PivotR.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
//        robot.PivotL.setTargetPositionTolerance(1);
//        robot.PivotR.setTargetPositionTolerance(1);
//        robot.PivotL.setPower(0.2);
//        robot.PivotR.setPower(0.2);
//        robot.RPiv.setPosition(.2); // lower this = facing forward
//        robot.LPiv.setPosition(.8); // lower this = facing back
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
        boolean hoverPos = false;
        double hoverTime = 0;
        boolean clawOn = true;
        double clawTime = 0;
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




//            if(gamepad1.a)
//
//            {
//
//                speed = 0.9;
//
//            }
//
//            else if(gamepad1.b)
//
//            {
//
//                speed = 0.75;
//
//            }
//
//            else if(gamepad1.x)
//
//            {
//
//                speed = 0.5;
//
//            }
//
//            else if(gamepad1.y)
//
//            {
//
//                speed = 0.5;
//
//            }


            if(gamepad2.right_bumper){
                speed = .5;
            }
            else{
                speed = .8;
            }



//            double FLDp = lefty + leftx;
//            double FRDp = righty - rightx;
//            double BLDp = lefty - leftx;
//            double BRDp = righty + rightx;

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
//            if(leftj!=0){
//                robot.Down.setPower(.5 * leftj);
//                robot.Up.setPower(.5 * -leftj);
//            }
//            else{
//                robot.Down.setPower(0);
//                robot.Up.setPower(0);
//            }

            if(gamepad2.a){
                double newTime = getRuntime() - hoverTime;

                if(newTime > 0.2){
                    hoverPos = !hoverPos;
                }
                hoverTime = getRuntime();
            }
            // || robot.PivotR.getCurrentPosition() > 40
            // || robot.PivotR.getCurrentPosition() > 320
            //Soft-Stop for Pivot
            //
            if (robot.PivotL.getCurrentPosition() < -30){
                robot.PivotL.setPower(0.2);
                robot.PivotR.setPower(0.2);
            }
            else if(robot.PivotL.getCurrentPosition() < -320){
                robot.PivotL.setPower(0.7);
                robot.PivotR.setPower(0.7);
            }
            else if (hoverPos){
                if(robot.PivotL.getCurrentPosition() < 400){
                    robot.PivotL.setPower(0.1);
                    robot.PivotR.setPower(0.1);
                }
                else if (robot.PivotL.getCurrentPosition() > 450){
                    robot.PivotL.setPower(-0.5);
                    robot.PivotR.setPower(-0.5);
                }
                else{
                    robot.PivotL.setPower(-0.2);
                    robot.PivotR.setPower(-0.2);
                }

            }
            else if (robot.Down.getCurrentPosition() > -1000 || robot.PivotL.getCurrentPosition() > 300) {

                if(leftj!=0){
                    if(leftj<0) {
                        if(robot.PivotL.getCurrentPosition() > 300 && robot.Down.getCurrentPosition() < -1000){
                            robot.PivotL.setPower(.5 * leftj);
                            robot.PivotR.setPower(.5 * leftj);
                        }
                        else{
                            robot.PivotL.setPower(.8 * leftj);
                            robot.PivotR.setPower(.8 * leftj);
                        }

                    }
                    else{
                        if(robot.PivotL.getCurrentPosition() > 550){

                            robot.PivotL.setPower(.1 * leftj);
                            robot.PivotR.setPower(.1 * leftj);
                        }
                        else{
                            robot.PivotL.setPower(.4 * leftj);
                            robot.PivotR.setPower(.4 * leftj);
                        }
                    }
                }
                else{
                    robot.PivotL.setPower(0);
                    robot.PivotR.setPower(0);
                }
            }
            else if (robot.PivotL.getCurrentPosition() > 0){
                robot.PivotL.setPower(-0.2);
                robot.PivotR.setPower(-0.2);
            }
            else{
                robot.PivotL.setPower(0);
                robot.PivotR.setPower(0);
            }


            if(gamepad2.x){ // gamepad2test
                robot.RPiv.setPosition(1);
//                robot.LPiv.setPosition(1);

            }
            if(gamepad2.y){
                robot.RPiv.setPosition(.7);
            }
            if(gamepad2.b) { // gamepad2test
                robot.RPiv.setPosition(.3);
//                robot.LPiv.setPosition(.55);
            }
            if(gamepad2.right_trigger>0 || gamepad1.left_trigger>0){
                double newTime = getRuntime() - clawTime;

                if(newTime > 0.2){
                    clawOn = !clawOn;
                }
                clawTime = getRuntime();
            }

            if(clawOn){ // gamepad2test
                robot.Claw.setPosition(0.4);
            }
            else{
                robot.Claw.setPosition(0.7);
            }



            if(gamepad2.dpad_up || gamepad2.left_trigger>0){
                robot.Twist.setPosition(0.35);
            }
            if(gamepad2.dpad_left){
                robot.Twist.setPosition(0.55);
            }
            if(gamepad2.dpad_right){
                robot.Twist.setPosition(0.15);
            }
            if(gamepad2.dpad_down  || gamepad2.left_bumper){
                robot.Twist.setPosition(0.75);
            }
//            if(gamepad1.y){ //!!! Dont run encoder missing
//                robot.PivotL.setTargetPosition(-100);
//                robot.PivotR.setTargetPosition(-100);
//                robot.PivotL.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
//                robot.PivotR.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
//                robot.PivotL.setTargetPositionTolerance(1);
//                robot.PivotR.setTargetPositionTolerance(1);
//                robot.PivotL.setPower(0.7);
//                robot.PivotR.setPower(0.7);
//            }
//            if(gamepad1.x){//!!! Dont run encoder missing
//                robot.PivotL.setTargetPosition(100);
//                robot.PivotR.setTargetPosition(100);
//                robot.PivotL.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
//                robot.PivotR.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
//                robot.PivotL.setTargetPositionTolerance(1);
//                robot.PivotR.setTargetPositionTolerance(1);
//                robot.PivotL.setPower(0.7);
//                robot.PivotR.setPower(0.7);
//            }


            if(rightj!=0){
                if (robot.Down.getCurrentPosition() < -1500 && robot.PivotL.getCurrentPosition() > 300){
                    if (rightj > 0) {
                        robot.Down.setPower(.8 * rightj);
                        robot.Up.setPower(-.8 * rightj);
                    }
                    else{
                        robot.Down.setPower(0);
                        robot.Up.setPower(0);
                    }
                }
                else if (robot.Down.getCurrentPosition() > -100){
                    if (rightj < 0) {
                        robot.Down.setPower(.8 * rightj);
                        robot.Up.setPower(-.8 * rightj);
                    }
                    else{
                        robot.Down.setPower(0);
                        robot.Up.setPower(0);
                    }
                }
                else if (robot.Down.getCurrentPosition() < -2050){
                    if (rightj > 0) {
                        robot.Down.setPower(.7 * rightj);
                        robot.Up.setPower(-.7 * rightj);
                    }
                    else{
                        robot.Down.setPower(0);
                        robot.Up.setPower(0);
                    }
                }
                else if (robot.Down.getCurrentPosition() > -500){
                    if (rightj < 0) {
                        robot.Down.setPower(.8 * rightj);
                        robot.Up.setPower(-.8 * rightj);
                    }
                    else{
                        robot.Down.setPower(.3 * rightj);
                        robot.Up.setPower(-.3 * rightj);
                    }
















                    





































































































































































                }
                else if (robot.Down.getCurrentPosition() < -1800){
                    if (rightj > 0) {
                        robot.Down.setPower(.9 * rightj);
                        robot.Up.setPower(-.9 * rightj);
                    }
                    else{
                        robot.Down.setPower(.4 * rightj);
                        robot.Up.setPower(-.4 * rightj);
                    }
                }
                else{
                    robot.Down.setPower(.95 *rightj);
                    robot.Up.setPower(-.95 *rightj);
                }
            }
            else{
                robot.Down.setPower(0);
                robot.Up.setPower(0);
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
            telemetry.addData("PL", robot.PivotL.getCurrentPosition());
            telemetry.addData("PR", robot.PivotR.getCurrentPosition());
            telemetry.addData("UpLift", robot.Up.getCurrentPosition());
            telemetry.addData("DownLift", robot.Down.getCurrentPosition());
            telemetry.addData("ClawTime", clawTime);
            telemetry.update();




        }


    }


}
