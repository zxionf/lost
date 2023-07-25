package com.zyx.kga.lost.screen;

import com.zyx.kga.lost.MyGdxGame;
import com.zyx.kga.lost.game.MyGame;
import com.zyx.kga.lost.game.GameManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.zyx.kga.lost.game.MPB;

public class GameScreen extends AbstractScreen {
    
    public GameManager gm;
    
    public GameScreen(MyGdxGame game,GameManager gm) {
        super(game);
        this.gm = gm;
        gm.setGame(new MPB());
        gm.getGame().create();
        gm.init();
    }

    

    @Override
    public void render(float p) {
        Gdx.gl.glClearColor(1,1,0,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gm.update();
        gm.render(p);
    }
    
    

    @Override
    public void resize(int p, int p1) {
    }
    @Override
    public void show() {
    }
    @Override
    public void hide() {
    }
    
}
