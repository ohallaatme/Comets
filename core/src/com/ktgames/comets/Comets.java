package com.ktgames.comets;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.logging.Level;

public class Comets extends BaseGame
{
	public void create()
	{
		super.create();
		setActiveScreen(new LevelScreen());
	}
}
