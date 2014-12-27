package com.accelerometer;

import com.badlogic.gdx.Gdx;

/**
 * @author Ahaeflig
 * 
 *         Singleton implementation of a class that provide useful way to deal
 *         with the accelerometer
 */
public enum AccelerometerTracker {
	INSTANCE;

	private static final double SHAKE_TRIGGER = 1.6;
	private static final float GRAVITY_EARTH = (float) 9.81;
	private float mXGrav = 1;
	private float mYGrav = 1;
	private float mZGrav = 1;

	/**
	 * @return the singleton instance of the accelerometer
	 */
	public static AccelerometerTracker getInstance() {
		return INSTANCE;
	}

	private void pollGrav() {
		mXGrav = Gdx.input.getAccelerometerX() / GRAVITY_EARTH;
		mYGrav = Gdx.input.getAccelerometerY() / GRAVITY_EARTH;
		mZGrav = Gdx.input.getAccelerometerZ() / GRAVITY_EARTH;
	}

	/**
	 * This method is to be called in every step of the physics' calculation
	 * since polling is the only way to check if the device is being shaked
	 * 
	 * @return true if the device is shaking (enough to trigger the event) false
	 *         otherwise
	 */
	public boolean isShaking() {
		pollGrav();
		if (Math.sqrt((mXGrav * mXGrav) + (mYGrav * mYGrav) + (mZGrav * mZGrav)) >= SHAKE_TRIGGER) {
			return true;
		}
		return false;
	}

	/**
	 * @return the X axis force of the accelerometer
	 */
	public float getmXGrav() {
		return mXGrav;
	}

	/**
	 * @return the Y axis force of the accelerometer
	 */
	public float getmYGrav() {
		return mYGrav;
	}

	/**
	 * @return the Z axis force of the accelerometer
	 */
	public float getmZGrav() {
		return mZGrav;
	}

}
