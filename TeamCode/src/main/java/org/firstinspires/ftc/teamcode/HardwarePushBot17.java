//If we ever get stuck, consult Leonard and Shayan's code - Phi
package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;




public class HardwarePushBot17 {
    public DcMotorEx FLD = null;
    public DcMotorEx FRD = null;
    public DcMotorEx BLD = null;
    public DcMotorEx BRD = null;


    public DcMotorEx Up = null;
    public DcMotorEx Down = null;
    public DcMotorEx PivotR = null;
    public DcMotorEx PivotL = null;


    public Servo LPiv = null;
    public Servo RPiv = null;
    public Servo Twist = null;
    public Servo Claw = null;
    HardwareMap hardwareMap = null;


    public void init(HardwareMap cMap) {
        hardwareMap = cMap;
        FLD  = hardwareMap.get(DcMotorEx.class, "FLD");
        FRD = hardwareMap.get(DcMotorEx.class, "FRD");
        BLD = hardwareMap.get(DcMotorEx.class, "BLD");
        BRD = hardwareMap.get(DcMotorEx.class, "BRD");
        Up = hardwareMap.get(DcMotorEx.class, "Up");
        Down = hardwareMap.get(DcMotorEx.class, "Down");


        PivotL = hardwareMap.get(DcMotorEx.class, "PivotL");
        PivotR = hardwareMap.get(DcMotorEx.class, "PivotR");


        LPiv = hardwareMap.get(Servo.class, "LPiv");
        RPiv = hardwareMap.get(Servo.class, "RPiv");
        Twist = hardwareMap.get(Servo.class, "Twist");
        Claw = hardwareMap.get(Servo.class, "Claw");


        // To drive forward, most robots need the motor on one side to be reversed, because the axles point in opposite directions.
        // Pushing the left stick forward MUST make robot go forward. So adjust these two lines based on your first test drive.
        // Note: The settings here assume direct drive on left and right wheels.  Gear Reduction or 90 Deg drives may require direction flips
        FLD.setDirection(DcMotorEx.Direction.REVERSE);
        FRD.setDirection(DcMotorEx.Direction.FORWARD);
        BLD.setDirection(DcMotorEx.Direction.FORWARD);
        BRD.setDirection(DcMotorEx.Direction.FORWARD);


        //arm pivot
        PivotR.setDirection(DcMotorEx.Direction.FORWARD);
        PivotL.setDirection(DcMotorEx.Direction.FORWARD);






        FLD.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        FRD.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        BLD.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        BRD.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);


        PivotL.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        PivotR.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        Up.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        Down.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);


        Up.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        Down.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        PivotL.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        PivotR.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
    }
}
