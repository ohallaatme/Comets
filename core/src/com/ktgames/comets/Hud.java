package com.ktgames.comets;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

// table from Scene2d to keep time and score
public class Hud
{
    public Stage stage;
    private Integer timer;
    private float timeCount;
    private Integer score;

    // create widgets which Scene2d calls a Label
    Label countDownLabel;
    Label scoreLabel;
    Label timeLabel;
    Label levelLabel;
    Label worldLabel;
    Label cometsLabel;

    public Hud(SpriteBatch sb)
    {
        this.timer = 300;
        this.timeCount = 0;
        this.score = 0;

        // create table to organize label
        Table table = new Table();

        // table aligns in center by default, this changes it to the top
        table.top();

        // table is now the size of our stage
        table.setFillParent(true);

        // initialize labels
        // "%03d" is format of three digits showing
        this.countDownLabel = new Label(String.format("%03d", this.timer),
                new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        // Score label is 6 digits long
        this.scoreLabel = new Label(String.format("%06d", this.score),
                new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        // this is just the text 'time'
        this.timeLabel = new Label("TIME", new Label.LabelStyle(new BitmapFont(),
                Color.WHITE));

        // just the first level -- UPDATE LATER
        this.levelLabel = new Label("1-1", new Label.LabelStyle(new BitmapFont(),
                Color.WHITE));

        // just the words WORLD
        this.worldLabel = new Label("WORLD", new Label.LabelStyle(new BitmapFont(),
                Color.WHITE));

        // Game Title Label
        this.cometsLabel = new Label("COMETS", new Label.LabelStyle(new BitmapFont(),
                Color.WHITE));

        // add Labels to table, expandX() method means that all Labels added to the
        // top row will equally expand over it
        table.add(this.cometsLabel).expandX().padTop(10);
        table.add(this.worldLabel).expandX().padTop(10);
        table.add(this.timeLabel).expandX().padTop(10);

        // create new row in table
        table.row();
        table.add(this.scoreLabel).expandX();
        table.add(this.levelLabel).expandX();
        table.add(this.countDownLabel).expandX();

        this.stage.addActor(table);
    }
}
