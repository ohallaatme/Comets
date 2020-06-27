package com.ktgames.comets;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class Comet extends BaseRock
{
    private String rockFilePath;
    private float scale;

    public Comet(float x, float y, Stage s)
    {
        super(x, y, s, 60);

        this.rockFilePath = "/Users/katherineohalloran/Documents/GameDev/Comets/core/assets/Game-Assets/Comet.png";
        this.scale = 1.5f;

        this.setScale(this.scale);
        this.loadTexture(this.rockFilePath);

    }
}
