package com.ktgames.comets.desktop;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ktgames.comets.CometsGame;

public class DesktopLauncher {
	public static void main (String[] arg)
	{
		Game comets = new CometsGame();
		LwjglApplication launcher = new LwjglApplication(comets, "Comets", 1200, 1200);
	}
}
