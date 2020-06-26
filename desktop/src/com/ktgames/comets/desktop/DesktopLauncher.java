package com.ktgames.comets.desktop;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ktgames.comets.Comets;

public class DesktopLauncher {
	public static void main (String[] arg)
	{
		Game comets = new Comets();
		LwjglApplication launcher = new LwjglApplication(comets, "Comets", 800, 600);
	}
}
