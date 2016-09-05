package com.darkhouse.gdefence.Screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.darkhouse.gdefence.Helpers.AssetLoader;
import com.darkhouse.gdefence.Level.Level;
import com.darkhouse.gdefence.Model.Level.HealthBar;
import com.darkhouse.gdefence.Model.Level.Map;
import com.darkhouse.gdefence.Model.Level.NextWaveInfoPanel;

import java.math.BigDecimal;

public class LevelMap implements Screen {
    private SpriteBatch batch;
    private Stage stage;
    private ShapeRenderer shape;
    //private Map map;

    private static Level level;

    public static Level getLevel() {
        return level;
    }


    public LevelMap(int number) {
        batch = new SpriteBatch();
        stage = new Stage();
        level = new Level(number);
        initHpMpBar();

        level.start();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        batch.begin();
        batch.draw(AssetLoader.levelMapBg, 0, 0);
        level.render(delta, batch);
        drawNextWavePanel(delta, batch);
        //drawHpMpBar();
        batch.end();
        stage.act(delta);
        stage.draw();

    }
    private void initHpMpBar(){
        stage.addActor(new HealthBar(Gdx.graphics.getWidth(), 110, 0, Gdx.graphics.getHeight() - 85));
        //stage.addActor();
    }

    private void updateHpMpBar(){
        //stage.getActors().get(stage.getActors().indexOf(HealthBar.class, false));

    }

    private void drawNextWavePanel(float delta, SpriteBatch batch){
        drawTimer(delta, batch);
        //NextWaveInfoPanel npanel = new NextWaveInfoPanel();
        //npanel.draw(batch, 1);
    }



    private void drawTimer(float delta, SpriteBatch batch){
        if(!level.isInWave()) {
            float time = level.timeBetweenWaves[level.currentWave];
            time = new BigDecimal(time).setScale(2, BigDecimal.ROUND_UP).floatValue();

            //NextWaveInfoPanel npanel = new NextWaveInfoPanel();
            //npanel.draw(batch, 1);

            Label l = new Label("" + time, AssetLoader.getTimerSkin());
            l.setPosition(Gdx.graphics.getWidth() - 240, 30);
            l.draw(batch, 1);
        }

    }



    @Override
    public void dispose() {

    }
}
