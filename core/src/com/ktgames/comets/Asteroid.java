package com.ktgames.comets;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class Asteroid extends BaseRock
{
    private String rockFilePath;
    private float scale;

    public Asteroid(float x, float y, Stage s)
    {
        super(x, y, s, 30);

        this.rockFilePath = "/Users/katherineohalloran/Documents/GameDev/Comets/core/assets/Game-Assets/Grey-Asteroid.png";
        this.scale = 2.5f;

        this.setScale(this.scale);
        this.loadTexture(this.rockFilePath);

    }
}
