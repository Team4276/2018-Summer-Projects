package org.usfirst.frc.team4276.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4276.robot.XCube;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.Encoder;

public class TheSinglePivoteer {
	
	VictorSP pivotMotor;

	double armPosition = -90;
	double armSetpoint = -90;
	double armPositionError = 0;
	double armPositionErrorLast = 0;
	private double accumulatedError = 0;
	private double rateError = 0;

	private boolean manualOveride = false;
	private boolean initializePID = true;
	private double timeNow;
	private double timePrevious;
	private double timeStep;

	final double PROPORTIONAL_GAIN = 0;
	final double INTEGRAL_GAIN = 0;
	final double DERIVATIVE_GAIN = 0;
	final double TORQUE_GAIN = 0;
	final double UPPER_LIMIT = 90;
	final double LOWER_LIMIT = -90;
	final double DEGREES_PER_PULSE = 1; // placeholder

	public TheSinglePivoteer(int port0) {

		pivotMotor = new VictorSP(port0);

	}
/*
	private double computeMovementPower() {
		double assignedPower;
		if (initializePID == true) {
			timeNow = Robot.systemTimer.get();
			armPosition = pivotMotor.getSensorCollection().getQuadraturePosition() * DEGREES_PER_PULSE;
			armPositionError = armSetpoint - armPosition;
			accumulatedError = 0.0;
			assignedPower = 0.0;
			initializePID = false;
		} else {
			armPositionErrorLast = armPositionError;
			timePrevious = timeNow;
			timeNow = Robot.systemTimer.get();
			armPosition = pivotMotor.getSensorCollection().getQuadraturePosition() * DEGREES_PER_PULSE;
			timeStep = timeNow - timePrevious;

			armPositionError = armSetpoint - armPosition; // proportional
			accumulatedError = accumulatedError + (armPositionErrorLast + armPositionError) / 2 * timeStep; // integral
																											// using
																											// trapezoidal
																											// approximation
			rateError = -pivotMotor.getSensorCollection().getQuadratureVelocity() * DEGREES_PER_PULSE * 10; // derivative
																											// (*10
																											// because
																											// returns
																											// counts/100ms)

			assignedPower = PROPORTIONAL_GAIN * armPositionError + INTEGRAL_GAIN * accumulatedError
					+ DERIVATIVE_GAIN * rateError;
		}
		return assignedPower;
	}

	public double findHoldingPower() {
		double assignedPower = 0;

		/**
		 * torque = m*(g+a)*Xcom*cos(theta)
		 * 
		 * assuming a = 0 for now
		 * 
		 */
/*
		double mass = 6.8; // placeholder
		double gravity = 9.8;
		double acceleration = 0; // placeholder
		double xCM = .203; // placeholder
		double theta = Math.PI * armPosition / 180;

		assignedPower = TORQUE_GAIN * (mass * (gravity + acceleration) * xCM * Math.cos(theta));

		return assignedPower;
	}
*/
	public void findSetpoint() {

		if (Robot.xboxController.getRawButton(XCube.Start)
				&& (Math.abs(Robot.xboxController.getRawAxis(XCube.LAxisY)) > .075)) {
			manualOveride = true;
		} else if (Robot.xboxController.getRawButton(XCube.X)) {
			manualOveride = false;
			armSetpoint = 0;
		} else {
			manualOveride = false;
			if (Robot.xboxController.getRawAxis(XCube.LAxisY) > .5) {
				armSetpoint++;
			} else if (Robot.xboxController.getRawAxis(XCube.LAxisY) < -.5) {
				armSetpoint--;
			}
		}
		if (armSetpoint > UPPER_LIMIT) {
			armSetpoint = UPPER_LIMIT;
		} else if (armSetpoint < LOWER_LIMIT) {
			armSetpoint = LOWER_LIMIT;
		}

	}

	public void assignMotorPower(double staticPower, double activePower) {
		if (manualOveride) {

		} else {
			pivotMotor.set(activePower);
		}
		pivotMotor.set(staticPower + activePower);
	}

	public void giveReadouts() {
		SmartDashboard.putNumber("Arm Angle Commanded", armSetpoint);
		SmartDashboard.putNumber("Arm Angle Estimated", armPosition);
	}

	public void performMainProcessing() {
		findSetpoint();
	}

	public void performMainProcessing(double setPoint) {
		armSetpoint = setPoint;
		giveReadouts();
	}

	public void updateTelemetry() {
		SmartDashboard.putNumber("Arm Angle:", armPosition);
	}

	}
