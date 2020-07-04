package com.ktgames.comets;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public abstract class BaseGame extends Game
{
    /**
     * Stores reference to game; used when calling <code>setActiveScreen</code> method.
     */

    private static BaseGame game;

    /**
     * Store label style to ensure text style is consistent throughout game
     */

    public static Label.LabelStyle labelStyle;

    /**
     * Called when game is initialized; stores global reference to game object
     */

    public BaseGame()
    {
        game = this;
    }

    /**
     * Used to switch screens while game is running.
     * Method is static to simplify usage.
     */


    /**
     * Called automatically by libGDX when game is initialized,
     * after <code>Gdx.input</code> and other objects have been initialized
     */
    public void create()
    {
        // prepare for multiple classes/stages.actors to receive discrete (vs continuous) input
        InputMultiplexer im = new InputMultiplexer();
        Gdx.input.setInputProcessor(im);

        // initialize text style for the game
        labelStyle = new Label.LabelStyle(new BitmapFont(), Color.WHITE);
    }

    public static void setActiveScreen(BaseScreen s)
    {
        game.setScreen(s);
    }


}
