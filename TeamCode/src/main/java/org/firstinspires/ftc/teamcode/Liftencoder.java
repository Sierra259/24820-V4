package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Config
    @TeleOp
    public class Liftencoder extends LinearOpMode {
    public DcMotorEx PivotL;
    public DcMotorEx PivotR;
    public DcMotorEx Down;
    public DcMotorEx Up;
        @Override
        public void runOpMode(){
            //initalizer pivots
            Up = hardwareMap.get(DcMotorEx.class, "Up");
            Down = hardwareMap.get(DcMotorEx.class, "Down");
            Up.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            Down.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            PivotL = hardwareMap.get(DcMotorEx.class, "PivotL");
            PivotR = hardwareMap.get(DcMotorEx.class, "PivotR");
            //reset pivots
            PivotR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            PivotL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            //change later!!
//            PivotL.setDirection(DcMotorSimple.Direction.REVERSE);


            waitForStart();
            while (opModeIsActive()) {
                telemetry.addData("PL", PivotL.getCurrentPosition());
                telemetry.addData("PR", PivotR.getCurrentPosition());
                telemetry.addData("UpLift", Up.getCurrentPosition());
                telemetry.addData("DownLift", Down.getCurrentPosition());
                telemetry.update();
            }
        }


    }

