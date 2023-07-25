package com.zyx.kga.lost.game;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.zyx.kga.lost.ControlStage;
import com.zyx.kga.lost.component.InformationBar;
import com.zyx.kga.lost.entities.Player;

public abstract class MyGame implements ApplicationListener {
    
    World world;
    Stage stage;
    public ControlStage controlStage;
    public InformationBar ib;
    TiledMap map;
    OrthogonalTiledMapRenderer ren;
    OrthographicCamera cam,b2dcam;
    SpriteBatch batch;
    Batch fontbatch;
    BitmapFont font;
    
    public Player player1,player2;
    
    View v;
    
    @Override
    public abstract void create()

    @Override
    public void dispose() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void render() {
        
    }
    
    public void render(float p) {
        render();
    }
    @Override
    public void resize(int p, int p1) {
    }

    @Override
    public void resume() {
    }
    
    public void setView(){
        
    }
    
}
