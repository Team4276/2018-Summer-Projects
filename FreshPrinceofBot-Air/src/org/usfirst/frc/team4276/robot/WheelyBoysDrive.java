package org.usfirst.frc.team4276.robot;
//ur mom gay
// import smart dash
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Joystick;

// created class
public class WheelyBoysDrive {
// naming different Vics and Joys
	Talon RDrive1;
	Talon RDrive2;
	Talon LDrive1;
	Talon LDrive2;
	Joystick RJoy;
	Joystick LJoy;
// created variable
	double leftDrivePower, rightDrivePower;
//porting stuff	
	public WheelyBoysDrive(int port1, int port2, int port3, int port4){
		
		RDrive1 = new Talon(port1);
		RDrive2 = new Talon(port2);
		LDrive1 = new Talon(port3);
		LDrive2 = new Talon(port4);
		RJoy = new Joystick(0);
		LJoy = new Joystick(1);
		
	}
// this is where the main process is performed	
	public void performMainProcessing(){
//receiving power		
		rightDrivePower = RJoy.getY();
		leftDrivePower = LJoy.getY();
		
	
//setting boundaries for movement forward	
	if(Math.abs(RJoy.getY()) > .2 || Math.abs(LJoy.getY()) > .2){
		rightDrivePower = RJoy.getY();
		leftDrivePower = LJoy.getY();
		
	}
	
	else{
		rightDrivePower = 0;
		leftDrivePower = 0;
		
	}
//setting boundaries for movement backwards	
	if(Math.abs(RJoy.getY()) < -.2 || Math.abs(LJoy.getY()) < -.2){
		rightDrivePower = RJoy.getY();
		leftDrivePower = LJoy.getY();
		
	}
	
	else{
		rightDrivePower = 0;
		leftDrivePower = 0;
	}
	
	}
//setting speed equal to motors
	public void setMotorSpeed() {
		RDrive1.set(rightDrivePower);
		RDrive2.set(rightDrivePower);
		LDrive1.set(leftDrivePower);
		LDrive2.set(leftDrivePower);
		}	
}
	
