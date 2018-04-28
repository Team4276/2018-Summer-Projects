package org.usfirst.frc.team4276.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4276.robot.XCube;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.Joystick;

public class iiiiintake {

	VictorSP RIntake;
	VictorSP LIntake;
	
	//ADJUST THESE**********************
	double outIntakePower = 1;
	double inIntakePower = -1;
	//**********************************

	/*
	 * public iiiiintake(int port5, int port6) { RIntake = new VictorSP(port5);
	 * LIntake = new VictorSP(port6); }
	 */
	public iiiiintake(int port5, int port6) {
		RIntake = new VictorSP(port5);
		LIntake = new VictorSP(port6);
	}

	public void performMainProcessing() {
		if (Robot.xboxController.getRawButton(XCube.RB) == true) {
			RIntake.set(outIntakePower);
			LIntake.set(outIntakePower);
		} else if (Robot.xboxController.getRawButton(XCube.LB) == true) {
			RIntake.set(inIntakePower);
			LIntake.set(inIntakePower);
		} else {
			RIntake.set(0);
			LIntake.set(0);
		}
	}
}
