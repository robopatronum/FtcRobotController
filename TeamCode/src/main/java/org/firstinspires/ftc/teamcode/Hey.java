package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
@TeleOp
public class Hey extends OpMode {
    private DcMotor left_wheel, right_wheel;



    public void init() {

        left_wheel = hardwareMap.get(DcMotor.class, "motor_1");
        right_wheel  = hardwareMap.get(DcMotor.class,"motor_2");
/*
        left_wheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        right_wheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        left_wheel.setDirection(DcMotorSimple.Direction.FORWARD);
        right_wheel.setDirection((DcMotorSimple.Direction.REVERSE));

 */
    }

    @Override
    public void loop() {

        if (gamepad1.right_stick_x >= 0.3 && gamepad1.left_stick_y > 0.3) {
            left_wheel.setPower(0.0);
            right_wheel.setPower(-0.2);
        }else if (gamepad1.right_stick_x >= 0.3 && gamepad1.left_stick_y < 0.3) {
            left_wheel.setPower(-0.2);
            right_wheel.setPower(-0.2);
        }else if (gamepad1.left_bumper && gamepad1.left_stick_y >= 0.3) {
            left_wheel.setPower(-0.5);
            right_wheel.setPower(0.5);
        }else if (gamepad1.right_stick_x >= 0.3 && gamepad1.left_stick_y == 0.0){

            left_wheel.setPower(0.0);
            right_wheel.setPower(0.0);
            /*
        }else if (gamepad1.left_bumper  && gamepad1.left_stick_y == 0.0) {
            left_wheel.setPower(0.0);
            right_wheel.setPower(0.0);
        }else if ((gamepad1.left_bumper && gamepad1.left_stick_y <= 0.3)) {
            left_wheel.setPower(0.5);
            right_wheel.setPower(-0.5);
*/
        }else if (gamepad1.left_stick_y >= 0.3 ) {
            left_wheel.setPower(-0.2);
            right_wheel.setPower(0.2);
        }else if (gamepad1.left_stick_y <= -0.3) {
            left_wheel.setPower(0.2);
            right_wheel.setPower(-0.2);
        }else{
            left_wheel.setPower(0.0);
            right_wheel.setPower(0.0);//Stops the motor
        }
    }
}
