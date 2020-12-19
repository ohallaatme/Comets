package com.ktgames.comets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.compression.lzma.Base;

public class MenuScreen extends BaseScreen
{
    @Override
    public void initialize()
    {
        BaseActor space = new BaseActor(0, 0, this.mainStage);
        space.loadTexture("core/assets/Game-Assets/OuterSpace.png");
        space.setSize(800, 600);

        BaseActor title = new BaseActor(0, 0, this.mainStage);
        title.loadTexture("core/assets/Game-Assets/Title-Page.png");
        float scale = 8.0f;
        title.setScale(scale);

        title.centerAtPosition(400, 300);
        title.moveBy(0, 100);

        Label startLabel = new Label("Hit 'S' on your keyboard to start!", BaseGame.labelStyle);
        startLabel.setColor(Color.WHITE);
        startLabel.setPosition(300, 300);
        startLabel.moveBy(0, -100);
        this.uiStage.addActor(startLabel);

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
