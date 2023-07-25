package com.zyx.kga.lost.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.zyx.kga.lost.Info;
import com.zyx.kga.lost.component.RectangleBackGround;
import com.zyx.kga.lost.component.Zbutton;

public class MapView extends Stage implements View {

    GameManager gm;
    OrthographicCamera cam;
    TiledMap map;
    OrthogonalTiledMapRenderer ren;
    Zbutton.ShutButton shut;
    Image bg;
    Texture me,camframe;
    SpriteBatch batch = new SpriteBatch();


    public MapView(GameManager t) {
        gm = t;
        map = gm.getGame().map;
    }

    @Override
    public void create() {
        cam = new OrthographicCamera(Info.ScreenWidth, Info.ScreenHeight);
        ren = new OrthogonalTiledMapRenderer(map);
        shut = new Zbutton.ShutButton();
        bg = new Image(RectangleBackGround.RGBArectangle(Info.ScreenWidth, Info.ScreenHeight, 0x00000066));
        bg.setPosition(0, 0);
        this.addActor(bg);
        shut.setPosition(Info.ScreenWidth - 50 - 40, Info.ScreenHeight - 50);
        this.addActor(shut);
        me = RectangleBackGround.RGBArectangle(12, 24, 0x00ff00ff);
        camframe = RectangleBackGround.RectangularFrame(Info.ScreenWidth, Info.ScreenHeight, 0xff0000ff, 16);
    }

    @Override
    public void render(float p) {
        Gdx.input.setInputProcessor(this);
        act();
        draw();
        ren.setView(cam);
        cam.zoom = 1.5f;
        ren.render();
        cam.position.set(50 * 16, 25 * 16, 0);
        batch.setProjectionMatrix(cam.combined);
        batch.begin();
        batch.draw(me, gm.getGame().player1.getPosition().x * Info.PPM - 6, gm.getGame().player1.getPosition().y * Info.PPM - 12);
        batch.draw(camframe, gm.getGame().b2dcam.position.x * Info.PPM - Info.ScreenWidth * 0.22f * Info.cameraheightscale / 2, gm.getGame().b2dcam.position.y * Info.PPM - Info.ScreenHeight * 0.22f * Info.cameraheightscale / 2, Info.ScreenWidth * Info.cameraheightscale * 0.22f, Info.ScreenHeight * Info.cameraheightscale * 0.22f);
        batch.end();
        cam.update();
    }

    @Override
    public void pause() {
    }

    @Override
    public void resize(int p, int p1) {
    }

    @Override
    public void resume() {
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    public void fadein() {
        //bg.addAction(Actions.fadeIn(2f));

    }


}
