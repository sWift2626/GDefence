package com.darkhouse.gdefence.Model.Level;


import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.darkhouse.gdefence.Helpers.AssetLoader;
import com.darkhouse.gdefence.Screens.LevelMap;

public class EnegryBar extends ProgressBar{
    public EnegryBar(int width, int height, int x, int y) {
        super(0, LevelMap.getLevel().getStartEnergy(), 0.5f, true, AssetLoader.getEnergyBarSkin());


        int expBarSize[] = {width, height};
        setPosition(x, y);
        //setPosition(Gdx.graphics.getWidth() - expBarSize[0], userlevelButton.getY() - expBarSize[1] - 4);
        setSize(expBarSize[0], expBarSize[1]);
        // bar.setAnimateDuration(5);

        setValue(LevelMap.getLevel().getEnergyNumber());
        //System.out.println();

    }

    @Override
    public void act(float delta) {
        super.act(delta);
        setValue(LevelMap.getLevel().getEnergyNumber());
        //System.out.println(LevelMap.getLevel().getHealthNumber());
    }


}
