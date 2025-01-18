//If we ever get stuck, consult Leonard and Shayan's code - Phi
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;


public class HardwarePushBot17 {
    public DcMotorEx FLD = null; //front left wheel
    public DcMotorEx FRD = null; //front right wheel
    public DcMotorEx BLD = null; //back left wheel
    public DcMotorEx BRD = null; //back right wheel

    public DcMotorEx FLPulley = null; //Front left pulley
    public DcMotorEx BLPulley = null; //Back left pulley
    public DcMotorEx FRPulley = null; //Front right pulley
    public DcMotorEx BRPulley = null; //Back right pulley

    public Servo LClawPivot = null;
    public Servo RClawPivot = null;
    public Servo Claw = null;
    public Servo ClawTwist = null;

    public DcMotorEx DOWN = null; //vertical intake down
    public DcMotorEx UP = null; //vertical intake up

    HardwareMap hardwareMap = null;


    public void init(HardwareMap cMap) {
        hardwareMap = cMap;
        FLD = hardwareMap.get(DcMotorEx.class, "FLD");
        FRD = hardwareMap.get(DcMotorEx.class, "FRD");
        BLD = hardwareMap.get(DcMotorEx.class, "BLD");
        BRD = hardwareMap.get(DcMotorEx.class, "BRD");
        UP = hardwareMap.get(DcMotorEx.class, "UP");
        DOWN = hardwareMap.get(DcMotorEx.class, "DOWN");

        FLPulley = hardwareMap.get(DcMotorEx.class, "FLPulley");
        BLPulley = hardwareMap.get(DcMotorEx.class, "BLPulley");
        FRPulley = hardwareMap.get(DcMotorEx.class, "FRPulley");
        BRPulley = hardwareMap.get(DcMotorEx.class, "BRPulley");

        LClawPivot = hardwareMap.get(Servo.class, "LClawPivot");
        RClawPivot = hardwareMap.get(Servo.class, "RClawPivot");
        Claw = hardwareMap.get(Servo.class, "Claw");
        ClawTwist = hardwareMap.get(Servo.class, "ClawTwist");


        // To drive forward, most robots need the motor on one side to be reversed, because the axles point in opposite directions.
        // Pushing the left stick forward MUST make robot go forward. So adjust these two lines based on your first test drive.
        // Note: The settings here assume direct drive on left and right wheels.  Gear Reduction or 90 Deg drives may require direction flips
        FLD.setDirection(DcMotorEx.Direction.REVERSE);
        FRD.setDirection(DcMotorEx.Direction.FORWARD);
        BLD.setDirection(DcMotorEx.Direction.REVERSE);
        BRD.setDirection(DcMotorEx.Direction.FORWARD);

        UP.setDirection(DcMotorEx.Direction.REVERSE);
        DOWN.setDirection(DcMotorEx.Direction.REVERSE);

        FLD.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        FRD.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        BLD.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        BRD.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
    }
}