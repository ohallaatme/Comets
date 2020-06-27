package com.ktgames.comets;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

//TODO 6.26 - Game works, but pickup at reviewing laser code/collisions, assets need updated, consider game logic updates, especially with movement
public class Laser extends BaseActor
{
    private String laserPath;
    public Laser(float x, float y, Stage s)
    {
        super(x, y, s);

        this.laserPath = "/Users/katherineohalloran/Documents/GameDev/Comets/core/assets/Game-Assets/Laser.png";
        this.loadTexture(this.laserPath);

        this.addAction(Actions.delay(1));
        this.addAction(Actions.after(Actions.fadeOut(0.5f)));
        this.addAction(Actions.after(Actions.removeActor()));

        this.setSpeed(400);
        this.setMaxSpeed(400);
        this.setDeceleration(0);

    }

    public void act(float dt)
    {
        super.act(dt);

        this.applyPhysics(dt);
        this.wrapAroundWorld();
    }
}
