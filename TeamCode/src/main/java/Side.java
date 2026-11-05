import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;


public class Side {
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
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD
        );
    }
    public void loop() {
        
    }
}
