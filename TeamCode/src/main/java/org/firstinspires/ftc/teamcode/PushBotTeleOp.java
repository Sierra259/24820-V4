//package org.firstinspires.ftc.teamcode;
//
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//import com.qualcomm.robotcore.hardware.DcMotorEx;
//
//@TeleOp(name="PushBotTeleOp")
//public class PushBotTeleOp extends LinearOpMode{
//    // Class Gamepad Documentation:
//
//    // https://ftctechnh.github.io/ftc_app/doc/javadoc/com/qualcomm/robotcore/hardware/Gamepad.html
//
//    HardwarePushBot17 robot = new HardwarePushBot17();
//
//    @Override
//
//    public void runOpMode() {
//        robot.init(hardwareMap);
//
//        robot.FLD.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
//
//        robot.FRD.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
//
//        robot.BLD.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
//
//        robot.BRD.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
//
//
//        telemetry.setMsTransmissionInterval(50);
////        robot.Rpiv.setPosition(1);
//
//        waitForStart();
//        // Initialize Servo Positions
//
//
//
//        double rightj;
//
//        double leftj;
//        double speed = 0.8;
//
//        double lefty;
//
//        double righty;
//
//        double leftx;
//
//        double rightx;
//
//
//        boolean buttonL;
//
//        boolean buttonR;
//
//
//        double triggerR;
//
//        double triggerL;
//
//
//        double intakeSpeed;
//
//        double intakeSpeedMultiplier = 0.85;
//
//
//        double armPower;
//
//        double armSpeed = 1.0;
//
////        double liftPosition = 0.0;
//
//
//        boolean dpadUp;
//
//        boolean dpadDown;
//
//        boolean dpadRight;
//
//        boolean dpadLeft;
//
//
//        boolean a;
//
//        boolean b;
//
//        boolean x;
//
//        boolean y;
//
//
//        long nextLBTimestamp = 0;
//
//        long nextRBTimestamp = 0;
//
//        boolean isBPSUp = true;
//
//        boolean isFPSUp = true;
//
//        // Is Position BackBoard Correct?
//        boolean isPosBBC = false;
//
//
////        while (opModeInInit())
////        {
////            telemetry.addData("Right Front", robot.DSRF.getDistance(DistanceUnit.INCH));
////            telemetry.addData("Right Back", robot.DSRB.getDistance(DistanceUnit.INCH));
////            telemetry.addData("Left Front", robot.DSLF.getDistance(DistanceUnit.INCH));
////            telemetry.addData("Left Back", robot.DSLB.getDistance(DistanceUnit.INCH));
////            telemetry.update();
////        }
//
//        while (opModeIsActive()) {
//
//            // Gamepad 1
//
//            lefty = -gamepad1.left_stick_y;
//
//            righty = -gamepad1.right_stick_y;
//
//            leftx = gamepad1.left_stick_x;
//
//            rightx = gamepad1.right_stick_x;
//
//
//            // Gamepad 2
//            leftj = gamepad2.left_stick_y;
//
//            rightj = gamepad2.right_stick_y;
//
//            armPower = gamepad2.left_stick_y;
//
//            intakeSpeed = gamepad2.right_stick_y;
//
//            buttonL = gamepad2.left_bumper;
//
//            buttonR = gamepad2.right_bumper;
//
//            triggerL = gamepad2.left_trigger;
//
//            triggerR = gamepad2.right_trigger;
//
//            dpadUp = gamepad2.dpad_up;
//
//            dpadLeft = gamepad2.dpad_left;
//
//            dpadRight = gamepad2.dpad_right;
//
//            dpadDown = gamepad2.dpad_down;
//
//            y = gamepad2.y;  // Up
//
//            x = gamepad2.x;  // Left
//
//            b = gamepad2.b; // Right
//
//            a = gamepad2.a; // Down
//
//            // Gamepad 1 Code
//            //if(gamepad1.right_trigger>0)
//            {
//
///*                if(robot.DSRF.getDistance(DistanceUnit.INCH) <= 5 || robot.DSLF.getDistance(DistanceUnit.INCH) <= 5)
//                {
//                    while (robot.DSRF.getDistance(DistanceUnit.INCH) > 1 || robot.DSLF.getDistance(DistanceUnit.INCH) > 1)
//                    {
//                        speed = 0.3;
//                    }
//                    isPosBBC=true;
//                }
//                else {
//                    isPosBBC=false;
//                }
//*/            }
//
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
//            // Gamepad 2 Code
//
//            if (gamepad2.dpad_down){
//                robot.Rpiv.setPosition(1);
//                robot.Lpiv.setPosition(0);
//            }
//            if (gamepad2.dpad_up){
//                robot.Rpiv.setPosition(0.4);
//                robot.Lpiv.setPosition(0.6d);
//            }
//
//            if(gamepad2.left_trigger>0){
//                robot.claw.setPosition(0.2);
//            }
//            else{
//                robot.claw.setPosition(1);
//            }
//
//            // Gamepad 2 Code
//
////            if (buttonR && gamepad2.timestamp > nextRBTimestamp)
////
////            {
////
////                // Control BPS: Back Pixel Servo
////
////                nextRBTimestamp = gamepad2.timestamp + 300;
////
////
////                if (isBPSUp)
////
////                {
////
////                    // Set BPS to down position
////
////
////            if (buttonL && gamepad2.timestamp > nextLBTimestamp)
////
////            {
////
////                // Control BPS: Back Pixel Servo
////
////                nextLBTimestamp = gamepad2.timestamp + 300;
////
////
////                if (isFPSUp)
////
////                {
////
////                    // Set FPS to down position
////
////                    robot.FPS.setPosition(0);
////
////                }
////
////                else {
////
////                    // Set FPS to up position
////
////                    robot.FPS.setPosition(.4);
////
////                }
////
////
////                isFPSUp = !isFPSUp;
////
////            }
//
//            /*if ( > 0) {
//                robot.twist.setPosition();
//            }
//            else {
//                robot.twist.setPosition();
//            }
//             */
//
////            Known Issue: Lift Speed Controls are probably not working
////            if (dpadUp)
////
////            {
////
////                armSpeed = 1.0;
////
////            }
////
////            else if (dpadLeft)
////
////            {
////
////                armSpeed = 0.75;
////
////            }
////
////            else if (dpadRight)
////
////            {
////
////                armSpeed = 0.5;
////
////            }
////
////            else if (dpadDown)
////
////            {
////
////                armSpeed = 0.25;
////
////            }
////
//////            Known Issue: Intake Speed Controls are probably not working
////            if (y)
////
////            {
////
////                intakeSpeedMultiplier = 1;
////
////            }
////
////            else if (x)
////
////            {
////
////                intakeSpeedMultiplier = 0.7;
////
////            }
//
////            else if (b)
////
////            {
////
////                intakeSpeedMultiplier = 0.6;
////
////            }
////
////            else if (a)
////
////            {
////
////                intakeSpeedMultiplier = 0.5;
////
////            }
////                    robot.BPS.setPosition(0);
////
////
////
////                }
////
////                else {
////
////                    // Set BPS to up position
////
////                    robot.BPS.setPosition(.4);
////
////                }
////
////
////                isBPSUp = !isBPSUp;
////
////            }
////
//
//            double FLDp = lefty + leftx;
//            double FRDp = righty - rightx;
//            double BLDp = lefty - leftx;
//            double BRDp = righty + rightx;
//
//            // Gamepad 1
//            if (isPosBBC) {
//                if ((FLDp > 0 && BRDp > 0 && FRDp < 0 && BLDp < 0) || FLDp < 0 && BRDp < 0 && FRDp > 0 && BLDp > 0)
//                {
//                    robot.FLD.setPower(speed * FLDp);
//
//                    robot.FRD.setPower(speed * FRDp);
//
//                    robot.BLD.setPower(speed * BLDp);
//
//                    robot.BRD.setPower(speed * BRDp);
//                }
//            }
//            else {
//                robot.FLD.setPower(speed * FLDp);
//
//                robot.FRD.setPower(speed * FRDp);
//
//                robot.BLD.setPower(speed * BLDp);
//
//                robot.BRD.setPower(speed * BRDp);
//            }
//            if(leftj!=0){
//                robot.DOWN.setPower(1 * leftj);
//                robot.UP.setPower(1 * -leftj);
//            }
//            else{
//                robot.DOWN.setPower(0);
//                robot.UP.setPower(0);
//            }
//
//            // Gamepad 2
//
////            if (liftPosition + armSpeed*armPower >= 0) {
////
////                liftPosition += armPower*armSpeed;
////
////                robot.LL.setPower(armSpeed*armPower);
////
////                robot.RL.setPower(armSpeed*armPower);
////
////            }
//
////            robot.IN.setPower(intakeSpeed*intakeSpeedMultiplier);
////            robot.LL.setPower(armSpeed*armPower);
////            robot.RL.setPower(armSpeed*armPower);
//            telemetry.update();
//
//
//        }
//
//    }
//
//}