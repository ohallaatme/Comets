package com.ktgames.comets;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.logging.Level;

public class CometsGame extends BaseGame
{
	public SpriteBatch batch;
	public void create()
	{
		super.create();
		this.batch = new SpriteBatch();
		setActiveScreen(new MenuScreen());
	}
}
