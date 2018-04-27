package org.usfirst.frc.team4276.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4276.robot.XCube;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.Joystick;

public class iiiiintake {

	Joystick xbox;
	VictorSP RIntake;
	VictorSP LIntake;
	double outIntakePower = 1;
	double inIntakePower = -1;
/*
	public iiiiintake(int port5, int port6) {
		RIntake = new VictorSP(port5);
		LIntake = new VictorSP(port6);
	}
*/
	public iiiiintake(int port5, int port6) {
		RIntake = new VictorSP(port5);
		LIntake = new VictorSP(port6);
		xbox = new Joystick(3);
	}

	public void performMainProcessing() {
		if (xbox.getRawButton(XCube.RB) == true) {
			RIntake.set(outIntakePower);
			LIntake.set(outIntakePower);
		} else {
			outIntakePower = 0;
		}
		if (xbox.getRawButton(XCube.LB) == true) {
			RIntake.set(inIntakePower);
			LIntake.set(inIntakePower);
		} else {
			inIntakePower = 0;
		}
	}
}
