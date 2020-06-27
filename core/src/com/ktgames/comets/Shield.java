package com.ktgames.comets;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class Shield extends BaseActor
{
    private String shieldPath;
    public Shield(float x, float y, Stage s) {
        super(x, y, s);
        this.shieldPath = "/Users/katherineohalloran/Documents/GameDev/Comets/core/assets/Game-Assets/Shield.png";
        this.loadTexture(this.shieldPath);

        Action pulse = Actions.sequence(
                Actions.scaleTo(1.75f, 1.75f, 1), Actions.scaleTo(1.5f, 1.5f, 1));

                this.addAction(Actions.forever(pulse));
    }
}
