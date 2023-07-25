package com.zyx.kga.lost;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.zyx.kga.lost.game.GameManager;
import com.zyx.kga.lost.screen.GameScreen;
import com.zyx.kga.lost.screen.LoadingScreen;
import com.zyx.kga.lost.screen.OnlineBattlePrepareScreen;
import com.zyx.kga.lost.screen.SettingScreen;
import com.zyx.kga.lost.component.ButtonStyles;
import com.zyx.kga.lost.game.MPB;

public class MyGdxGame extends Game {

    Stage topstage;
    Image image;
    
    public static GameManager GM;
    public static AssetManager ass;
    private SpriteBatch batch;
    private BitmapFont font;
    
    public static MPB multipplayerbattle;
    public static SettingScreen settingscreen;
    public static GameScreen gamescreen;
    
    public static ControlStage controlstage;
    
    //场景
    //HomeScreen h;
    LoadingScreen loadingscreen;

    //加载完了
    public void load_finish() {
        //setScreen(new SettingScreen(this));
        MainActivity.use.getversion();
        Info.deviceinfo = MainActivity.use.getDeviceinfo();
        //multipplayerbattle = new MultipPlayerBattle(this);
        controlstage = new ControlStage();
        controlstage.init_stage();
        settingscreen = new SettingScreen(this);
        GM = new GameManager();
        gamescreen = new GameScreen(this,GM);
        //多人对战准备
        //setScreen(new OnlineBattlePrepareScreen(this));
        setScreen(gamescreen);
    }
    
    @Override
    public void create() {
        
        
        
        batch = new SpriteBatch();

        ass = new AssetManager();
        loadingscreen = new LoadingScreen(this);
        //进入加载场景
        super.setScreen(loadingscreen);
        //加载各种奇奇怪怪的东西
        ass.load("font/fontc_16.fnt", BitmapFont.class);
        
        Asst.load();
        
        //初始化过渡黑场
        topstage = new Stage();
        image = new Image(new Texture("UI/tran.jpg"));
        image.setSize(topstage.getWidth(), topstage.getHeight()); 
        image.setOrigin(topstage.getWidth() / 2, topstage.getHeight() / 2); 
        image.setColor(Color.CLEAR); 
        topstage.addActor(image); 

        font = new BitmapFont(Gdx.files.internal("font/font.fnt"),Gdx.files.internal("font/font.png"),false);
        font.getData().setScale(1.5f);
    }


    @Override
    public void render() {
        // Draws a red background
        Gdx.gl.glClearColor(1f, 1f, 1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //渲染游戏
        super.render();
        //渲染帧率、内存占用还有过渡黑场

        topstage.act();
        topstage.draw();

        batch.begin();
        //开发者信息
        font.setColor(Color.BLACK);
        font.draw(batch,"fps:" + Gdx.graphics.getFramesPerSecond()+"\n"+((Gdx.app.getJavaHeap() / 1048576) + (Gdx.app.getNativeHeap() / 1048576)) + "MB",2,126);
        font.setColor(Color.GREEN);
        font.draw(batch,"fps:" + Gdx.graphics.getFramesPerSecond()+"\n"+((Gdx.app.getJavaHeap() / 1048576) + (Gdx.app.getNativeHeap() / 1048576)) + "MB",0,128);
        batch.end();
        
        //State.screenstate.update(this);
        

        if (loadingscreen.isOk) {
            load_finish();
            loadingscreen.isOk = false;
            loadingscreen.dispose();
        }
    }
    //游戏过渡动作
    public void transition(Color c, float t) {
        image.setColor(c);
        image.addAction(Actions.color(Color.CLEAR, t));
    }

    public void transition() {
        image.setColor(Color.BLACK);
        image.addAction(Actions.color(Color.CLEAR, 0.5f));
    }
    
    //当手机分辨率变化时
    @Override
    public void resize(int width, int height)
    {
        super.resize(width, height);
    }
    //当游戏进入后台
    @Override
    public void pause()
    {
        //MainActivity.use.showQuickTip("暂停");
        super.pause();
    }
    //当游戏进程回复时
    @Override
    public void resume()
    {
        //MainActivity.use.showQuickTip("返回");
        super.resume();
	}

    @Override
    public void setScreen(Screen screen) {
        transition();
        super.setScreen(screen);
    }
}

