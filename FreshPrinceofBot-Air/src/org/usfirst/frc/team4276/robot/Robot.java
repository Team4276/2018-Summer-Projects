/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4276.robot;

import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends SampleRobot {

	public static Joystick xboxController;
	TheSinglePivoteer ArmPivoter;
	iiiiintake Maniulator;
	WheelyBoysDrive DriveTrain;


	public Robot() {
		xboxController = new Joystick(3);
		ArmPivoter = new TheSinglePivoteer(0);;
		Maniulator = new iiiiintake(5,6);
		DriveTrain = new WheelyBoysDrive(1, 2, 3, 4);
	}

	@Override
	public void robotInit() {

	}

	@Override
	public void autonomous() {
	
		}
	
	@Override
	public void operatorControl() {

		while (isOperatorControl() && isEnabled()) {
			DriveTrain.performMainProcessing();
			Maniulator.performMainProcessing();
			ArmPivoter.performMainProcessing();

			Timer.delay(.005);
			
		}
	}
	public void test() {
	}
}
