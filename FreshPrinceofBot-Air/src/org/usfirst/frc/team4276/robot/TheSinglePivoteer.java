package org.usfirst.frc.team4276.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4276.robot.XCube;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.Encoder;

public class TheSinglePivoteer {

	VictorSP pivotMotor;
//ADJUST THESE*********
	double upSpeed = 0.3;
	double downSpeed = -0.16;
//**********************

	public TheSinglePivoteer(int port0) {

		pivotMotor = new VictorSP(port0);

	}

	public void performMainProcessing() {
		if ((Robot.xboxController.getRawAxis(XCube.LAxisY) > 0.5)) {
			pivotMotor.set(upSpeed);
			SmartDashboard.putBoolean("UP", true);
			SmartDashboard.putBoolean("DOWN", false);
		} else if ((Robot.xboxController.getRawAxis(XCube.LAxisY) < -0.5)) {
			pivotMotor.set(downSpeed);
			SmartDashboard.putBoolean("UP", false);
			SmartDashboard.putBoolean("DOWN", true);
		} else {
			pivotMotor.set(0);
			SmartDashboard.putBoolean("UP", false);
			SmartDashboard.putBoolean("DOWN", false);
		}
	}

}
