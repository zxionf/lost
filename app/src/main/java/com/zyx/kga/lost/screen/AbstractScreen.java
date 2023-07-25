package com.zyx.kga.lost.screen;

import com.badlogic.gdx.Screen;

import com.zyx.kga.lost.MyGdxGame;

public abstract class AbstractScreen implements Screen {

    protected MyGdxGame game;

    public AbstractScreen(MyGdxGame game) {
        this.game = game;
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }
}
