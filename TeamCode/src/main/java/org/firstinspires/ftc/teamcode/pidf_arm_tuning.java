package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


@Config
@TeleOp(name="Pidf Arm tuning", group="LinearOpMode")
public class pidf_arm_tuning extends OpMode {
    private PIDController controller;

    public static double p = 0, i = 0, d = 0;
    public static double f = 0.075;

    private PIDController controller1;

    public static double p1 = 0 , i1 = 0, d1 = 0;
    public static double f1 = 0.075;

    public static int target = 500;
    private final double ticks_in_degree = 537.7 / 180.0;

    private DcMotorEx PivotL;
    private DcMotorEx PivotR;


    @Override
    public void init(){
        controller = new PIDController(p,i,d);
        controller1 = new PIDController(p1,i1,d1);
        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());


        PivotL = hardwareMap.get(DcMotorEx.class, "PivotL");
        PivotR = hardwareMap.get(DcMotorEx.class, "PivotR");
        PivotL.setDirection(DcMotorSimple.Direction.REVERSE);
        //PivotR.setDirection(DcMotorSimple.Direction.REVERSE);


    }

    @Override
    public void loop(){
        controller.setPID(p, i, d);
        controller1.setPID(p1, i1, d1);
        int armPos = PivotL.getCurrentPosition();
        int armPos1 = PivotR.getCurrentPosition();
        double pid = controller.calculate(armPos, target);
        double pid1 = controller1.calculate(armPos1, target);
        double ff = Math.cos(Math.toRadians(target / ticks_in_degree)) * f;
        double ff1 = Math.cos(Math.toRadians(target /ticks_in_degree)) * f1;
        double power = pid + ff;
        double power1 = pid1 + ff1;

        PivotL.setPower(power);
        PivotR.setPower(power);

        telemetry.addData("pos ", armPos);
        telemetry.addData("pos1 ", armPos1);
        telemetry.addData("target ",target);
        telemetry.update();

    }
}