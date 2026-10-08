package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class Game_Pad_1 extends OpMode {

    @Override
    public void init() {

    }


    @Override
    public void loop() {
        // runs 50x* a second

        double speedForward = -gamepad1.left_stick_y/2.0;
        double diffXJoysticks = gamepad1.left_stick_x - gamepad1.right_stick_x;
        double sumTriggers = gamepad1.left_trigger + gamepad1.right_trigger;
        telemetry.addData("x_left_stick", gamepad1.left_stick_x);
        telemetry.addData("y_left_stick", gamepad1.left_stick_y);
        telemetry.addData("x_right_stick", gamepad1.right_stick_x);
        telemetry.addData("y_right_stick", gamepad1.right_stick_y);
        telemetry.addData("Difference x", diffXJoysticks);
        telemetry.addData("Sum of triggers", sumTriggers);

        telemetry.addData("a button", gamepad1.a);
        telemetry.addData("b button", gamepad1.b);



    }
}
