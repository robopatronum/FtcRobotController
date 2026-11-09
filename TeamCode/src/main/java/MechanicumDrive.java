import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;


public class MechanicumDrive {
    private DcMotor front_left_motor, back_left_motor, front_right_motor, back_right_motor;
    private IMU imu;

    public void init(HardwareMap hwMap) {
        front_left_motor = hwMap.get(DcMotor.class,"motor_1");
        front_right_motor = hwMap.get(DcMotor.class,"motor_2");
        back_left_motor = hwMap.get(DcMotor.class,"motor_3");
        back_right_motor = hwMap.get(DcMotor.class,"motor_4");

        front_left_motor.setDirection(DcMotor.Direction.REVERSE);
        back_left_motor.setDirection(DcMotorSimple.Direction.REVERSE);

        front_left_motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        front_right_motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        back_left_motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        back_left_motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        imu = hwMap.get(IMU.class,"imu");
        RevHubOrientationOnRobot RevOrientation = new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD);
        imu.initialize(new IMU.Parameters((RevOrientation)));
    }
    public void drive(double forward, double strafe, double rotate) {

        double frontLeftPower = forward + strafe + rotate;
        double backLeftPower = forward - strafe + rotate;
        double frontRightPower = forward - strafe - rotate;
        double backRightPower = forward - strafe + rotate;

        double maxPower = 1.0;
        double maxSpeed = 1.0;

        maxPower = Math.max(maxPower, Math.abs(frontLeftPower));
        maxPower = Math.max(maxPower, Math.abs(backLeftPower));
        maxPower = Math.max(maxPower, Math.abs(frontRightPower));
        maxPower = Math.max(maxPower, Math.abs(backRightPower));

        front_left_motor.setPower(maxSpeed * frontLeftPower / maxPower);
        back_left_motor.setPower(maxSpeed * backLeftPower / maxPower);
        front_right_motor.setPower(maxSpeed * frontRightPower / maxPower);
        back_right_motor.setPower(maxSpeed * backRightPower / maxPower);
    }

    public void driveFieldRelative(double forward, double strafe, double rotate){

        double theta = Math.atan2(forward, strafe);
        double r = Math.hypot(strafe, forward);

        theta = AngleUnit.normalizeRadians(theta-
                imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS));

        double newForward = r * Math.sin(theta);
        double newStrafe = r * Math.cos(theta);

        this.drive(newForward, newStrafe, rotate);
    }
}