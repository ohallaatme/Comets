package com.ktgames.comets;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public abstract class BaseRock extends BaseActor
{
    private int speed;

    public BaseRock(float x, float y, Stage s, int speed)
        {
            super(x, y, s);

            // no file path/texture load, abstract class
            this.speed = speed;
            // motion of rock rotation will be the same for child classes, but speed differs
            float random = MathUtils.random(30);

            // have the rock objects constantly rotate
            this.addAction(Actions.forever(Actions.rotateBy(30 + random, 1)));

            // Rocks move by at least 50 fps, plus a random # between 1 and 30
            this.setSpeed(this.speed + random);

            this.setMaxSpeed(this.speed + random);

            // rocks just float through space, don't decelerate
            this.setDeceleration(0);

            this.setMotionAngle(MathUtils.random(360));

        }

        public void act(float dt)
        {
            super.act(dt);
            this.applyPhysics(dt);

            // all rock objects will wrap around the screen, whether comet, asteroid, etc.
            this.wrapAroundWorld();
        }
}
