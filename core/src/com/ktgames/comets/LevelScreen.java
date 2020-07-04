package com.ktgames.comets;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import static java.lang.Class.forName;

public class LevelScreen extends BaseScreen
{
    private String spacePath;
    private Spaceship spaceship;
    private boolean gameOver;

    // scoring
    private int score;
    private Label scoringLabel;



    @Override
    public void initialize()
    {
        // Actor for background
        BaseActor space = new BaseActor(0, 0, this.mainStage);

        // Background texture
        // TODO - need less stars
        this.spacePath = "/Users/katherineohalloran/Documents/GameDev/Comets/core/assets/Game-Assets/OuterSpace.png";
        space.loadTexture(this.spacePath);
        space.setSize(800, 600);

        //TODO confused why this is just BaseActor
        BaseActor.setWorldBounds(space);

        this.spaceship = new Spaceship(400, 300, this.mainStage);

        // --- CREATE ASTEROIDS ---
        for (int i=0; i<=20; i++)
        {
            int x = MathUtils.random(800);
            int y = MathUtils.random(600);

            new Asteroid(x, y, this.mainStage);
        }

        // -- CREATE COMETS ---
        for (int i=0; i<=10; i++)
        {
            int x = MathUtils.random(800);
            int y = MathUtils.random(600);

            new Comet(x, y, this.mainStage);

        }

        // initialize score
        this.score = 0;

        // initialize scoring label
        this.scoringLabel = new Label("Score: 0", BaseGame.labelStyle);
        this.scoringLabel.setColor(Color.WHITE);
        this.scoringLabel.setPosition(20, 40);
        this.uiStage.addActor(this.scoringLabel);

        this.gameOver = false;

    }


    @Override
    public void update(float dt)
    {
        for (BaseActor rockActor : BaseActor.getList(this.mainStage, "com.ktgames.comets.Asteroid", "com.ktgames.comets.Comet"))
        {
            if (rockActor.overlaps(this.spaceship))
            {
                if (this.spaceship.shieldPower <= 0)
                {
                    // game ending, explosion animation plays, spaceship is removed from screen
                    Explosion boom = new Explosion(0, 0, this.mainStage);
                    boom.centerAtActor(this.spaceship);
                    this.spaceship.remove();

                    //TODO - better understand the positioning of the ship after removal
                    this.spaceship.setPosition(-1000, -1000);

                    // Create a you lose message
                    //TODO - Eventually replace with score
                    BaseActor messageLose = new BaseActor(0, 0, this.uiStage);
                    messageLose.loadTexture("/Users/katherineohalloran/Documents/GameDev/Comets/core/assets/Demo-Assets/message-lose.png");
                    messageLose.centerAtPosition(400, 300);
                    messageLose.setOpacity(0);
                    messageLose.addAction(Actions.fadeIn(1));
                    this.gameOver = true;
                }
                else
                {
                    // decrease shieldPower property from spaceship due to collision with rock
                    this.spaceship.shieldPower -= 25;
                    Explosion boom = new Explosion(0, 0, this.mainStage);

                    // blow up the rock
                    boom.centerAtActor(rockActor);
                    rockActor.remove();
                }
            }

            for (BaseActor laserActor: BaseActor.getList(this.mainStage, "com.ktgames.comets.Laser"))
            {
                // if the laser hits a rock blow it up
                if (laserActor.overlaps(rockActor))
                {
                    Explosion boom = new Explosion(0, 0, this.mainStage);
                    boom.centerAtActor(rockActor);

                    // distinguish between comet and asteroid for scoring purposes
                    Class asteroidClass = null;
                    Class cometClass = null;

                    try
                    {
                        asteroidClass = forName("com.ktgames.comets.Asteroid");
                        cometClass = forName("com.ktgames.comets.Comet");
                    }
                    catch (Exception error)
                    {
                        error.printStackTrace();
                    }

                    if (asteroidClass.isInstance(rockActor))
                    {
                        this.score += 10;
                    }
                    if (cometClass.isInstance(rockActor))
                    {
                        this.score += 20;
                    }

                    this.scoringLabel.setText(String.format("Score: %s", this.score));
                    laserActor.remove();
                    rockActor.remove();
                }
            }
        }

        // If all of the rocks are gone and you did not die in the game, show you won message
        if (!this.gameOver && BaseActor.count(this.mainStage, "com.ktgames.comets.Asteroid", "com.ktgames.comets.Comet") == 0)
        {
            BaseActor messageWin = new BaseActor(0, 0, this.uiStage);
            messageWin.loadTexture("/Users/katherineohalloran/Documents/GameDev/Comets/core/assets/Demo-Assets/message-win.png");
            messageWin.centerAtPosition(400, 300);
            messageWin.setOpacity(0);
            messageWin.addAction(Actions.fadeIn(1));
            this.gameOver = true;
        }
    }

    // override default InputProcessor methods provided by BaseScreen class
    @Override
    public boolean keyDown(int keycode)
    {
        if (keycode == Input.Keys.SPACE)
        {
            this.spaceship.shoot();
        }

        if (keycode == Input.Keys.X)
        {
            this.spaceship.warp();
        }

        return false;
    }
}










