package com.zyx.kga.lost.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.zyx.kga.lost.Info;
import com.zyx.kga.lost.component.Zbutton;

public class DeathView extends Stage implements View {

    @Override
    public void fadein() {
    }


    Zbutton.TextBtn resurrection;
    Zbutton.ShutButton shut;
    GameManager gm;
    public DeathView(GameManager g) {
        gm = g;
    }
    @Override
    public void create() {
        resurrection = new Zbutton.TextBtn("复活", new ClickListener(){
                public void clicked(InputEvent event, float x, float y) {
                    //l.setPosition(l.getX()+50,l.getY());
                    GameManager.viewState = GameManager.HIDEALL;
                    gm.getGame().player1.HP = 200;
                }
            });
        resurrection.setPosition(Info.ScreenWidth / 2, Info.ScreenHeight / 2);
        this.addActor(resurrection);

    }

    @Override
    public void render(float p) {
        Gdx.input.setInputProcessor(this);
        act();
        draw();
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
}
