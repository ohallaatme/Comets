package com.ktgames.comets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Spaceship extends BaseActor
{
    private Thrusters thrusters;
    private Shield shield;
    private String spaceShipPath;
    public int shieldPower;

    public Spaceship(float x, float y, Stage s)
    {
        super(x, y, s);

        this.spaceShipPath = "/Users/katherineohalloran/Documents/GameDev/Comets/core/assets/Game-Assets/SpaceShip.png";
        this.loadTexture(this.spaceShipPath);
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
        this.thrusters.setPosition(this.getWidth()/2 - this.thrusters.getWidth()/2,
                this.getHeight() - this.thrusters.getHeight() - 8);


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
        // 6.27.2020 updated for vertical ship
        laser.centerAtActor(this);
        laser.setRotation(this.getRotation() + 90);
        laser.setMotionAngle(this.getRotation() + 90);

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

        // 6.27.2020 updated to accelerate at angle plus 90 to reflect vertical ship vs right facing with own graphics
        if (Gdx.input.isKeyPressed(Input.Keys.UP))
        {
            this.accelerateAtAngle(this.getRotation() + 90);
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
        if (this.shieldPower >= 75)
        {
            this.shield.setOpacity(0.75f);
        }
        else if (this.shieldPower >= 50)
        {
            this.shield.setOpacity(0.50f);
        } else if (this.shieldPower >= 25)
        {
            this.shield.setOpacity(0.25f);
        } else
        {
            // shield out of health
            this.shield.setOpacity(0.0f);
        }
    }
}





















