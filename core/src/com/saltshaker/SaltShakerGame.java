package com.saltshaker;

import screens.SaltShakerScreen;

import com.badlogic.gdx.Game;

public class SaltShakerGame extends Game {

	SaltShakerScreen shakerScreen;

	@Override
	public void create() {
		shakerScreen = new SaltShakerScreen(this);
		setScreen(shakerScreen);
	}

}