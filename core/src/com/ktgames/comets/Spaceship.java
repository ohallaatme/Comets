package com.ktgames.comets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Spaceship extends BaseActor
{
    private Thrusters thrusters;
    private Shield shield;
    public int shieldPower;

    public Spaceship(float x, float y, Stage s)
    {
        super(x, y, s);

        //TODO - UPDATE with self created asset
        this.loadTexture("/Users/katherineohalloran/Documents/GameDev/Comets/core/assets/Demo-Assets/spaceship.png");
        this.setBoundaryPolygon(8);

        this.setAcceleration(200);
        this.setMaxSpeed(100);

        // very slow deceleration, user will have to offset with how they maneuver ship
        this.setDeceleration(10);

        this.thrusters = new Thrusters(0, 0, s);

        // Adding the thrusters to the Spaceship Base Actor Group
        // Base Actor now extension of group that allows effects to be placed on actors
        this.addActor(this.thrusters);

        // Adjust the thrusters position relative to the spaceship so that the thrusters appear in the correct location
        this.thrusters.setPosition(-this.thrusters.getWidth(),
                this.getHeight()/2 - this.thrusters.getHeight()/2);


        this.shield = new Shield(0, 0, s);

        // add shield to Spaceship base actor group so shield appears around spaceship
        this.addActor(shield);

        // center the shield around the spaceship object(this)
        this.shield.centerAtPosition(this.getWidth()/2, this.getHeight()/2);

        this.shieldPower = 100;

    }

    public void shoot()
    {
        if (this.getStage() == null)
        {
            return;
        }

        Laser laser = new Laser(0, 0, this.getStage());

        // center the laser at the Spaceship, this object, align rotation and motion angle
        laser.centerAtActor(this);
        laser.setRotation(this.getRotation());
        laser.setMotionAngle(this.getRotation());

    }

    public void warp()
    {
        // verify that the spaceship is still a part of the game, indicated by being
        // attached to the stage
        if (this.getStage() == null)
        {
            return;
        }

        // leave current position warp
        Warp warp1 = new Warp(0, 0, this.getStage());

        warp1.centerAtActor(this);

        // warp the spaceship to a random position on the screen after warp animation plays above
        this.setPosition(MathUtils.random(800), MathUtils.random(600));

        // enter new position warp
        Warp warp2 = new Warp(0, 0, this.getStage());
        warp2.centerAtActor(this);
    }

    public void act(float dt)
    {
        super.act(dt);

        // 120 degrees per second
        float degreesPerSecond = 120;

        // player controls
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
        {
            this.rotateBy(degreesPerSecond * dt);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
        {
            // - sign for opposite direction of rotation
            this.rotateBy(-degreesPerSecond * dt);
        }

        // thrusters (jets) visible if the player is accelerating forward, or else not visible
        if (Gdx.input.isKeyPressed(Input.Keys.UP))
        {
            this.accelerateAtAngle(this.getRotation());
            this.thrusters.setVisible(true);
        }

        else
        {
            this.thrusters.setVisible(false);
        }

        this.applyPhysics(dt);

        // world bounds wrap
        this.wrapAroundWorld();

        //shield appears weaker as health decreases
        this.shield.setOpacity(this.shieldPower/100f);

    }

}





















