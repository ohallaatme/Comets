package com.ktgames.comets;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class Thrusters extends BaseActor
{
    private String filePath;
    public Thrusters(float x, float y, Stage s)
    {
        super(x, y, s);
        this.filePath = "/Users/katherineohalloran/Documents/GameDev/Comets/core/assets/Game-Assets/Fire.png";
        loadTexture(this.filePath);
    }
}
