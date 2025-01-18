//package org.firstinspires.ftc.teamcode;
//
//import androidx.annotation.NonNull;
//
//import com.acmerobotics.dashboard.config.Config;
//import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
//import com.acmerobotics.roadrunner.Action; *
//import com.acmerobotics.roadrunner.InstantAction; *
//import com.acmerobotics.roadrunner.ParallelAction; *
//import com.acmerobotics.roadrunner.Pose2d; tells the robot where to go on the mat in relation to a plane (x & y) heading
//import com.acmerobotics.roadrunner.SequentialAction;
//import com.acmerobotics.roadrunner.SleepAction;
//import com.acmerobotics.roadrunner.Trajectory; *
//import com.acmerobotics.roadrunner.TrajectoryActionBuilder; *
//import com.acmerobotics.roadrunner.TrajectoryBuilder; *
//import com.acmerobotics.roadrunner.Vector2d; tells the robot where to go on the mat in relation to a plane (x & y) w/o a heading
//import com.acmerobotics.roadrunner.ftc.Actions;
//import com.arcrobotics.ftclib.command.ParallelRaceGroup; *
//import com.qualcomm.hardware.sparkfun.SparkFunOTOS; *
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.Disabled;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.hardware.CRServo; *
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.DcMotorEx;
//import com.qualcomm.robotcore.hardware.DcMotorSimple; *
//import com.qualcomm.robotcore.hardware.HardwareMap;
//import com.qualcomm.robotcore.hardware.Servo;
//import org.firstinspires.ftc.teamcode.MecanumDrive;
//import org.slf4j.Logger; *
//import org.slf4j.LoggerFactory; *
//
//
//
//
//@Config
//@Autonomous(name="Specimen Auton", group="Autonomous")
//
//public class Auton1 extends LinearOpMode {
//    private static final Logger log = LoggerFactory.getLogger(Auton1.class);
//
//    public class intake {
//        public Servo LARM;
//        public Servo RARM;
//        public Servo Wrist;
//        public Servo claw;
//        public Servo Twist;
//        public Servo ls;
//        public Servo rs;
//
//        public intake(HardwareMap hardwareMap) {
//            LARM = hardwareMap.get(Servo.class, "LARM");
//            RARM = hardwareMap.get(Servo.class, "RARM");
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
//    public class colorSensor {
//        public ColorSensor color;
//
//        public colorSensor(HardwareMap hardwareMap) {
//            color = hardwareMap.get(ColorSensor.class, "CS");
//        }
//
//    }
//    @Override
//    public void runOpMode() {
//        Pose2d beginPose = new Pose2d(10, -60, Math.toRadians(90));
//        MecanumDrive drive = new MecanumDrive(hardwareMap, beginPose);
//        intake intake = new intake(hardwareMap);
//        outtake outtake = new outtake(hardwareMap);
//        lift lift = new lift(hardwareMap);
//
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
//
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
//        waitForStart();
//        if (isStopRequested()) return;
//        Actions.runBlocking(strafepush.build());
//
//        //Second p
////                new ParallelAction(
////                    traj1.build(),
////                    new SequentialAction(
////                        lift.specimen(),
////                            outtake.flipOut(),
