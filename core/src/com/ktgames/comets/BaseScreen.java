package com.ktgames.comets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

// must adhere to both Screen and InputProcessor interface from libGDX
public abstract class BaseScreen implements Screen, InputProcessor
{
    protected Stage mainStage;
    protected Stage uiStage;




    public BaseScreen()
    {
        this.mainStage = new Stage();
        this.uiStage = new Stage();

        initialize();
    }

    public abstract void initialize();

    public abstract void update(float dt);

    /*
    Game Loop:
        1) Process input (discretely handled by listener; continuous in update)
        2) Update game logic
        3) Render the graphics
     */

    public void render(float dt)
    {

        // act methods
        this.uiStage.act(dt);
        this.mainStage.act(dt);

        // defined by user
        this.update(dt);

        // clear the screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // draw the graphics
        this.mainStage.draw();
        this.uiStage.draw();
        // TODO - UPDATE SCORING POST CH 5


    }

    // methods required by Screen interface
    public void resize(int width, int height){}

    public void pause(){}

    public void resume(){}

    public void dispose(){}

    /**
     * Called when this becomes the active screen in a Game.
     * Set up InputMultiplexer here, in case screen is reactivated at a later time.
     */
    public void show()
    {
        InputMultiplexer im = (InputMultiplexer)Gdx.input.getInputProcessor();
        im.addProcessor(this);
        im.addProcessor(this.uiStage);
        im.addProcessor(this.mainStage);
    }

    /**
     * Called when this is no longer the active screen in a Game.
     * Screen class and Stages no longer process input.
     * Other InputProcessors must be removed manually.
     */
    public void hide()
    {
        InputMultiplexer im = (InputMultiplexer)Gdx.input.getInputProcessor();
        im.removeProcessor(this);
        im.removeProcessor(this.uiStage);
        im.removeProcessor(this.mainStage);
    }

    // method required by InputProcessor interface
    // checks if true - then no longer need to pass key activity info to other InputProcessors
    // if false (default),  gives each InputProcessor the opportunity to process the data.
    public boolean keyDown(int keycode)
    {
        return false;
    }

    public boolean keyUp(int keycode)
    {
        return false;
    }

    public boolean keyTyped(char c)
    {
        return false;
    }

    public boolean mouseMoved(int screenX, int screenY)
    {
        return false;
    }

    public boolean scrolled(int amount)
    {
        return false;
    }

    public boolean touchDown(int screenX, int screenY, int pointer, int button)
    {
        return false;
    }

    public boolean touchDragged(int screenX, int screenY, int pointer)
    {
        return false;
    }

    public boolean touchUp(int screenX, int screenY, int pointer, int button)
    {
        return false;
    }














}


















