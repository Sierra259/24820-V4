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
        @Override
        public void runOpMode(){
            //initalizer pivots

            PivotL = hardwareMap.get(DcMotorEx.class, "PivotL");
            PivotR = hardwareMap.get(DcMotorEx.class, "PivotR");
            //reset pivots
            PivotR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            PivotL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            PivotL.setDirection(DcMotorSimple.Direction.REVERSE);


            waitForStart();
            while (opModeIsActive()) {
                telemetry.addData("PL", PivotL.getCurrentPosition());
                telemetry.addData("PR", PivotR.getCurrentPosition());
                telemetry.update();
            }
        }


    }

