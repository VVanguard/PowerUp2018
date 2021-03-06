package org.usfirst.frc.team6014.robot;


public class Teleop {
	private static double hingeAngle;
	private static double lastAngle = 0;
	public static void init() {
		//Robot.arm.enable();	
		hingeAngle = Robot.arm.getCurrentAngle();
	}
	public static void periodic() {
		Robot.drive.arcadeDrive(Robot.oi.getRawRightY()*Robot.oi.getReverseFactor(),Robot.oi.getRawRightX());
		//Robot.drive.tankDrive(Robot.oi.getRawLeftY(), Robot.oi.getRawRightY());
		//Robot.drive.setMaxOutput((Robot.oi.getRawLeftY()+1)/2);
		/*if(Robot.oi.getAngleButton()) {
			Robot.arm.enable();
			Robot.arm.setAngle(Math.max(9, lastAngle));
			Robot.arm.hingePID();
			System.out.println("Button pressed.");
		}
		else {
			Robot.arm.disable();
			lastAngle = Robot.arm.getCurrentAngle();
			Robot.arm.setHingeSpeed(Robot.oi.getRawLeftY());
		}*/
		Robot.arm.setHingeSpeed(Robot.oi.getRawLeftY());
		if(Robot.oi.getIntakeButton()) {
			Robot.arm.setHolderSpeed(1.0);
		} else if(Robot.oi.getLaunchButton()) {
			Robot.arm.setHolderSpeed(-0.65);
		} else {
			Robot.arm.setHolderSpeed(0);
		}
		if(Robot.oi.getLeftTrigger()>0.5) {
			hingeAngle = 140;
		} else if(Robot.oi.getRightTrigger()>0.5) {
			hingeAngle = 60;
		}
		//Robot.arm.setAngle(hingeAngle);
		//Robot.arm.hingePID();
	}
}