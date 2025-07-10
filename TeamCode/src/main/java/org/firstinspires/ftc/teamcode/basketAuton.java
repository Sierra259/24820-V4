package org.firstinspires.ftc.teamcode;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.SleepAction;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Config
@Autonomous(name="Basket Auton", group="Autonomous")

public class basketAuton extends LinearOpMode {
    private static final Logger log = LoggerFactory.getLogger(basketAuton.class);
    public static boolean isUp = true;
    public static boolean isDown = false;
    public static boolean isHover = false;
    public static boolean armInUse = true;
    public class basket {
        public boolean isUp = true;
        public boolean isDown = false;
        public boolean isHover = false;
        public boolean armInUse = true;
        public Servo LPiv;
        public Servo RPiv;
        public Servo Twist;
        public Servo Claw;
        public DcMotorEx PivotL;
        public DcMotorEx PivotR;
        public DcMotorEx Up;
        public DcMotorEx Down;

        public basket(HardwareMap hardwareMap){
            Up = hardwareMap.get(DcMotorEx.class, "Up");
            Down = hardwareMap.get(DcMotorEx.class, "Down");


            PivotL = hardwareMap.get(DcMotorEx.class, "PivotL");
            PivotR = hardwareMap.get(DcMotorEx.class, "PivotR");


            LPiv = hardwareMap.get(Servo.class, "LPiv");
            RPiv = hardwareMap.get(Servo.class, "RPiv");
            Twist = hardwareMap.get(Servo.class, "Twist");
            Claw = hardwareMap.get(Servo.class, "Claw");

            PivotL.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
            PivotR.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
            Up.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
            Down.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);


            Up.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
            Down.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
            PivotL.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
            PivotR.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
            PivotR.setDirection(DcMotorEx.Direction.FORWARD);
            PivotL.setDirection(DcMotorEx.Direction.FORWARD);
        }

        public class liftUp implements Action{
            @Override
            public boolean run(@NonNull TelemetryPacket packet) {
                while(Down.getCurrentPosition() > -2200){
                    Down.setPower(-.85);
                    Up.setPower(.85);
//                    if (PivotL.getCurrentPosition() < -30) {
//                        PivotL.setPower(0.2);
//                        PivotR.setPower(0.2);
//                    } else if (PivotL.getCurrentPosition() < -320) {
//                        PivotL.setPower(0.7);
//                        PivotR.setPower(0.7);
//                    }
//                    else if (PivotL.getCurrentPosition() > 0){
//                        PivotL.setPower(-0.2);
//                        PivotR.setPower(-0.2);
//                    }
//                    else {
//                        PivotL.setPower(0);
//                        PivotR.setPower(0);
//                    }

                }
//                PivotL.setPower(0);
//                PivotR.setPower(0);
                Down.setPower(0);
                Up.setPower(0);
                return false;
            }
        }
        public Action liftUp(){
            return new basket.liftUp();
        }
        public class liftDown implements Action{
            @Override
            public boolean run(@NonNull TelemetryPacket packet) {
                while(Down.getCurrentPosition() <-100){
                    Down.setPower(.8);
                    Up.setPower(-.8);
//                    if (PivotL.getCurrentPosition() < -30) {
//                        PivotL.setPower(0.2);
//                        PivotR.setPower(0.2);
//                    } else if (PivotL.getCurrentPosition() < -320) {
//                        PivotL.setPower(0.7);
//                        PivotR.setPower(0.7);
//                    }
//                    else if (PivotL.getCurrentPosition() > 0){
//                        PivotL.setPower(-0.2);
//                        PivotR.setPower(-0.2);
//                    }
//                    else {
//                        PivotL.setPower(0);
//                        PivotR.setPower(0);
//                    }
                }
//                PivotL.setPower(0);
//                PivotR.setPower(0);
                Down.setPower(0);
                Up.setPower(0);
                return false;
            }
        }
        public Action liftDown(){
            return new basket.liftDown();
        }
        public class Pivot implements Action {
            @Override
            public boolean run(@NonNull TelemetryPacket packet) {
                while(armInUse) {
                    while (isUp) {
                        if (PivotL.getCurrentPosition() < -30) {
                            PivotL.setPower(0.2);
                            PivotR.setPower(0.2);
                        } else if (PivotL.getCurrentPosition() < -320) {
                            PivotL.setPower(0.7);
                            PivotR.setPower(0.7);
                        }
                        else if (PivotL.getCurrentPosition() > 0){
                            PivotL.setPower(-0.2);
                            PivotR.setPower(-0.2);
                        }
                        else {
                            PivotL.setPower(0);
                            PivotR.setPower(0);
                        }
                    }
                    while (isHover){
                        if(PivotL.getCurrentPosition() < 430){
                            PivotL.setPower(0.3);
                            PivotR.setPower(0.3);
                        }
                        else if (PivotL.getCurrentPosition() > 480){
                            PivotL.setPower(-0.6);
                            PivotR.setPower(-0.6);
                        }
                        else if (PivotL.getCurrentPosition() > 500){
                            PivotL.setPower(-0.85);
                            PivotR.setPower(-0.85);
                        }
                        else{
                            PivotL.setPower(-0.2);
                            PivotR.setPower(-0.2);
                        }
                    }
                    while (isDown) {
                        if(PivotL.getCurrentPosition() < 450){
                            PivotL.setPower(0.3);
                            PivotR.setPower(0.3);
                        }
                        else{
                            PivotL.setPower(0);
                            PivotR.setPower(0);
                        }
                    }
                }
                return false;
            }
        }
        public Action Pivot(){
            return new basket.Pivot();
        }
        public class intake implements Action{
            @Override
            public boolean run(@NonNull TelemetryPacket packet) {
                RPiv.setPosition(.3);
                return false;
            }
        }
        public Action intake(){
            return new basket.intake();
        }

        public class midtake implements Action{
            @Override
            public boolean run(@NonNull TelemetryPacket packet) {
                RPiv.setPosition(.6);
                return false;
            }
        }
        public Action midtake(){
            return new basket.midtake();
        }

        public class drop implements Action{
            @Override
            public boolean run(@NonNull TelemetryPacket packet) {
                RPiv.setPosition(.8);
                return false;
            }
        }
        public Action drop(){
            return new basket.drop();
        }

        public class Twist implements Action{
            @Override
            public boolean run(@NonNull TelemetryPacket packet) {
                Twist.setPosition(.35);
                return false;
            }
        }
        public Action Twist(){
            return new basket.Twist();
        }

        public class ClawTight implements Action{
            @Override
            public boolean run(@NonNull TelemetryPacket packet) {
                Claw.setPosition(.3);
                return false;
            }
        }
        public Action ClawTight(){
            return new basket.ClawTight();
        }
        public class ClawLoose implements Action{
            @Override
            public boolean run(@NonNull TelemetryPacket packet) {
                Claw.setPosition(.7);
                return false;
            }
        }
        public Action ClawLoose(){
            return new basket.ClawLoose();
        }

    }
//    public class intake {
////        public Servo LARM;
////        public Servo RARM;
//        public Servo Wrist;
//        public Servo claw;
//        public Servo Twist;
//        public Servo ls;
//        public Servo rs;
//
//        public intake(HardwareMap hardwareMap) {
////            LARM = hardwareMap.get(Servo.class, "LARM");
////            RARM = hardwareMap.get(Servo.class, "RARM");
//            Wrist = hardwareMap.get(Servo.class, "WRIST");
//            claw = hardwareMap.get(Servo.class, "FIN");
//            Twist = hardwareMap.get(Servo.class, "TWIST");
//            ls = hardwareMap.get(Servo.class, "LS");
//            rs = hardwareMap.get(Servo.class, "RS");
//        }
//        public class slidesin implements Action{
//            @Override
//            public boolean run(@NonNull TelemetryPacket packet){
//                ls.setPosition(1);
//                rs.setPosition(0);
//                return false;
//            }
//        }
//        public Action slidesin(){
//            return new slidesin();
//        }
//        public class twistFlip implements Action {
//            @Override
//            public boolean run(@NonNull TelemetryPacket packet) {
//                Twist.setPosition(0.42);
//                return false;
//            }
//        }
//
//        public Action twistFlip() {
//            return new intake.twistFlip();
//        }
//
//        public class twistFlat implements Action {
//            @Override
//            public boolean run(@NonNull TelemetryPacket packet) {
//                Twist.setPosition(0.08);
//                return false;
//            }
//        }
//
//        public Action twistFlat() {
//            return new intake.twistFlat();
//        }
//
//        public class closeClaw implements Action {
//            @Override
//            public boolean run(@NonNull TelemetryPacket packet) {
//                claw.setPosition(0.176);
//                return false;
//            }
//        }
//
//        public Action closeClaw() {
//            return new intake.closeClaw();
//        }
//
//        public class openClaw implements Action {
//            @Override
//            public boolean run(@NonNull TelemetryPacket packet) {
//                claw.setPosition(0.5);
//                return false;
//            }
//        }
//
//        public Action openClaw() {
//            return new intake.openClaw();
//        }
//
//        public class flipDown implements Action {
//            @Override
//            public boolean run(@NonNull TelemetryPacket packet) {
//                LARM.setPosition(0.4);
//                RARM.setPosition(0.6);
//                Wrist.setPosition(0.95);
//                return false;
//            }
//        }
//
//        public Action flipDown() {
//            return new intake.flipDown();
//        }
//
//        public class transfer implements Action {
//            @Override
//            public boolean run(@NonNull TelemetryPacket packet) {
//                RARM.setPosition(0.25);
//                LARM.setPosition(0.75);
//                Wrist.setPosition(0.25);
//                return false;
//            }
//        }
//
//        public Action transfer() {
//            return new intake.transfer();
//        }
//    }
//
//
//    public class outtake {
//        public Servo Lpiv;
//        public Servo Rpiv;
//        public Servo twist;
//        public Servo claw;
//
//        public outtake(HardwareMap hardwareMap) {
//            Lpiv = hardwareMap.get(Servo.class, "Lpiv");
//            Rpiv = hardwareMap.get(Servo.class, "Rpiv");
//            twist = hardwareMap.get(Servo.class, "FT");
//            claw = hardwareMap.get(Servo.class, "Toe");
//        }
//
//        public class openClaw implements Action {
//            @Override
//            public boolean run(@NonNull TelemetryPacket packet) {
//                claw.setPosition(0.8);
//                return false;
//            }
//        }
//
//        public Action openClaw() {
//            return new outtake.openClaw();
//        }
//
//        public class closeClaw implements Action {
//            @Override
//            public boolean run(@NonNull TelemetryPacket packet) {
//                claw.setPosition(0.5);
//                return false;
//            }
//        }
//
//        public Action closeClaw() {
//            return new outtake.closeClaw();
//        }
//
//
//        public class twistFlat implements Action {
//            @Override
//            public boolean run(@NonNull TelemetryPacket packet) {
//                twist.setPosition(0.2);
//                return false;
//            }
//        }
//
//        public Action twistFlat() {
//            return new outtake.twistFlat();
//        }
//
//        public class flipOut implements Action {
//            @Override
//            public boolean run(@NonNull TelemetryPacket packet){
//                Lpiv.setPosition(1);
//                Rpiv.setPosition(0.165);
//                twist.setPosition(0.9);
//                return false;
//            }
//        }
//        public Action flipOut(){
//            return new outtake.flipOut();
//        }
//        public class transfer implements Action {
//            @Override
//            public boolean run(@NonNull TelemetryPacket packet) {
//                Rpiv.setPosition(0.7);
//                twist.setPosition(0.2);
//                return false;
//            }
//        }
//
//        public Action transfer() {
//            return new outtake.transfer();
//        }
//        public class lowFlip implements Action{
//            @Override
//            public boolean run(@NonNull TelemetryPacket packet){
//                Rpiv.setPosition(0.0);
//                return false;
//            }
//        }
//        public Action lowFlip(){
//            return new outtake.lowFlip();
//        }
//        public class init implements Action {
//            @Override
//            public boolean run(@NonNull TelemetryPacket packet) {
//                Rpiv.setPosition(0.65);
//                return false;
//            }
//        }
//        public Action init(){
//            return new outtake.init();
//        }
//    }
//
//    public class lift {
//        public DcMotorEx up;
//        public DcMotorEx down;
//        int specimenPos = 1050;
//        int highBasket = 2950;
//
//        public lift(HardwareMap hardwareMap) {
//            up = hardwareMap.get(DcMotorEx.class, "UP");
//            down = hardwareMap.get(DcMotorEx.class, "DOWN");
//            up.setDirection(DcMotorEx.Direction.FORWARD);
//            down.setDirection(DcMotorEx.Direction.REVERSE);
//            up.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//            down.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        }
//
//        public class reset implements Action {
//            @Override
//            public boolean run(@NonNull TelemetryPacket packet) {
//                up.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
//                down.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
//                up.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
//                down.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
//                return false;
//            }
//        }
//
//        public Action reset() {
//            return new lift.reset();
//        }
//
//        public class specimen implements Action {
//            @Override
//            public boolean run(@NonNull TelemetryPacket packet) {
//                up.setTargetPosition(specimenPos);
//                down.setTargetPosition(specimenPos);
//                up.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
//                down.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
//                up.setPower(1);
//                down.setPower(1);
//                return false;
//            }
//        }
//
//        public Action specimen() {
//            return new lift.specimen();
//        }
//
//        public class highBasket implements Action {
//            @Override
//            public boolean run(@NonNull TelemetryPacket packet) {
//                up.setTargetPosition(highBasket);
//                down.setTargetPosition(highBasket);
//                up.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
//                down.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
//                up.setPower(1);
//                down.setPower(1);
//                return false;
//            }
//        }
//
//        public Action highBasket() {
//            return new lift.highBasket();
//        }
//
//        public class liftDown implements Action {
//            @Override
//            public boolean run(@NonNull TelemetryPacket packet) {
//                up.setTargetPosition(0);
//                down.setTargetPosition(0);
//                up.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
//                down.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
//                up.setPower(0.5);
//                down.setPower(0.5);
//                return false;
//            }
//        }
//        public Action liftDown(){
//            return new lift.liftDown();
//        }
//    }
    @Override
    public void runOpMode() {
        Pose2d beginPose = new Pose2d(-10, -60, Math.toRadians(0));
        MecanumDrive drive = new MecanumDrive(hardwareMap, beginPose);
        basket basket = new basket(hardwareMap);
//        intake intake = new intake(hardwareMap);
//        outtake outtake = new outtake(hardwareMap);
//        lift lift = new lift(hardwareMap);

        TrajectoryActionBuilder park = drive.actionBuilder(beginPose)
                .strafeToLinearHeading(new Vector2d(-46, -45), Math.toRadians(40));
//        TrajectoryActionBuilder Sample1 = drive.actionBuilder(beginPose)
//                .strafeToLinearHeading(new Vector2d(10, -30), Math.toRadians(90));
//        TrajectoryActionBuilder traj1 = drive.actionBuilder(beginPose)
//                .lineToY(-21);
//        TrajectoryActionBuilder up1 = drive.actionBuilder(new Pose2d(-5,-40,Math.toRadians(90))).lineToY(-24)
//                .lineToY(-37);
//        TrajectoryActionBuilder traj2 = drive.actionBuilder(beginPose)
//                .lineToY(-40);
//        TrajectoryActionBuilder traj3 = drive.actionBuilder(beginPose)
//                .splineToLinearHeading(new Pose2d(47, -56, Math.toRadians(270)), Math.toRadians(720));
//        TrajectoryActionBuilder backUp = drive.actionBuilder(beginPose)
//                .lineToY(50);
//        TrajectoryActionBuilder inspec = drive.actionBuilder(new Pose2d(47,-56,Math.toRadians(270)))
//                .lineToY(-58);
////                .splineToConstantHeading(new Vector2d(37.5,-24),Math.toRadians(90))
////                .splineToConstantHeading(new Vector2d(43,-7),Math.toRadians(0))
////                .strafeTo(new Vector2d(47,-55))
////                .splineToConstantHeading(new Vector2d(47,-16),Math.toRadians(75))
////                .splineToConstantHeading(new Vector2d(56,-10),Math.toRadians(180));
//        TrajectoryActionBuilder traj4 = drive.actionBuilder(beginPose)
////                .splineToLinearHeading(new Pose2d(0,-40,Math.toRadians(90)),Math.toRadians(90));
//                .strafeTo(new Vector2d(0,-40));
////                                .turnTo(Math.toRadians(90));
//        TrajectoryActionBuilder strafepush = drive.actionBuilder(beginPose)
//                .strafeTo(new Vector2d(10, -34))
//                .setTangent(Math.toRadians(270))
//                .splineToConstantHeading(new Vector2d(35, -34), Math.toRadians(65))
//                .splineToConstantHeading(new Vector2d(35,-12),Math.toRadians(100))
//                .strafeTo(new Vector2d(45,-12))
//                .strafeTo(new Vector2d(45,-55))
//                //Second push
//                .strafeTo(new Vector2d(45,-12))
//                .strafeTo(new Vector2d(55,-12))
//                .strafeTo(new Vector2d(55,-55))
//                .strafeToLinearHeading(new Vector2d(27,-57),-Math.toRadians(180));

//        Actions.runBlocking(new SequentialAction(
//                outtake.closeClaw(),
//                outtake.init(),
//                intake.openClaw(),
//                intake.twistFlat(),
//                new SleepAction(1),
//                intake.slidesin(),
//                intake.transfer(),
//                lift.reset())
//        );
        Actions.runBlocking(basket.ClawTight());

        waitForStart();
        if (isStopRequested()) return;
        Actions.runBlocking(
                new SequentialAction(
                        basket.midtake(),
                        park.build(),
                        new SequentialAction(
                                        basket.Twist(),
                                        basket.intake(),
                                        basket.liftUp(),
                                        new SequentialAction(
                                                basket.drop(),
                                                new SleepAction(0.5),
                                                basket.ClawLoose(),
                                                new SleepAction(0.3),
                                                basket.intake(),
                                                new SleepAction(0.5),
                                                basket.liftDown()
                                        )
                        )



                )

        );
    }
}

        //Second p
//                new ParallelAction(
//                    traj1.build(),
//                    new SequentialAction(
//                        lift.specimen(),
//                            outtake.flipOut(),
