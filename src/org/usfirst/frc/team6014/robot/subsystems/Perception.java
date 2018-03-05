/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6014.robot.subsystems;

import org.usfirst.frc.team6014.robot.RobotMap;

import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.AnalogInput;

/**
 * A subsystem for sensors and vision processing.
 */
public class Perception extends Subsystem {
	
	final AnalogInput sonar = new AnalogInput(RobotMap.sonar);

	public Perception() {
	}
	
	@Override
	public void initDefaultCommand() {
	}

	public double getSonarDistance() {
                double voltage = sonar.getVoltage();
                double mms = (voltage / 5.0) * 5000.0;
                return mms / 10.0;
        }

}
