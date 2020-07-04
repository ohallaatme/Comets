package com.ktgames.comets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.compression.lzma.Base;

public class MenuScreen extends BaseScreen
{
    @Override
    public void initialize()
    {
        BaseActor space = new BaseActor(0, 0, this.mainStage);
        space.loadTexture("core/assets/Game-Assets/OuterSpace.png");
        space.setSize(800, 600);

        // TODO - Create Title and Instructions

    }

    @Override
    public void update(float dt)
    {
        // hit S to start the game
        if (Gdx.input.isKeyPressed(Input.Keys.S))
        {
            CometsGame.setActiveScreen(new LevelScreen());
        }
    }
}
