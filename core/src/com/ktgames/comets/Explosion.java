package com.ktgames.comets;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class Explosion extends BaseActor
{
    public Explosion(float x, float y, Stage s)
    {
        super(x, y, s);

        // Explosion animation from SpriteSheet, run one time at a rate of 0.03fps
        this.loadAnimationFromSheet("/Users/katherineohalloran/Documents/GameDev/Comets/core/assets/Demo-Assets/explosion.png",
                6, 6, 0.03f, false);

    }

    public void act(float dt)
    {
        super.act(dt);

        // Once the explosion animation finishes, get rid of it
        if (this.isAnimationFinished())
        {
            this.remove();
        }
    }
}
