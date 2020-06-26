package com.ktgames.comets;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class Rock extends BaseActor
{
    public Rock(float x, float y, Stage s)
    {
        super(x, y, s);

        this.loadTexture("/Users/katherineohalloran/Documents/GameDev/Comets/core/assets/Demo-Assets/rock.png");

        float random = MathUtils.random(30);

        // have the rock objects constantly rotate
        this.addAction(Actions.forever(Actions.rotateBy(30 + random, 1)));

        // Rocks move by at least 50 fps, plus a random # between 1 and 30
        this.setSpeed(50 + random);

        this.setMaxSpeed(50 + random);

        // rocks just float through space, don't decelerate
        this.setDeceleration(0);

        this.setMotionAngle(MathUtils.random(360));
    }

    public void act(float dt)
    {
        super.act(dt);

        this.applyPhysics(dt);

        // sets world bounds, addition to BaseActor base class for project
        this.wrapAroundWorld();
    }

}
