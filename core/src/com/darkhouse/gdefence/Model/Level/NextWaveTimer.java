package com.darkhouse.gdefence.Model.Level;


import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.darkhouse.gdefence.Helpers.AssetLoader;
import com.darkhouse.gdefence.Screens.LevelMap;

import java.math.BigDecimal;

public class NextWaveTimer extends Label{
    private float time;

    public float getTime() {
        return time;
    }

    public NextWaveTimer() {
        super("", AssetLoader.getTimerSkin());
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        time = LevelMap.getLevel().getTimerTime();
        time = new BigDecimal(time).setScale(2, BigDecimal.ROUND_UP).floatValue();


        setText("" + time);
    }

//    @Override
//    public void draw(Batch batch, float parentAlpha) {
//        if(time > 0) {
//            super.draw(batch, parentAlpha);
//        }
//    }
}
