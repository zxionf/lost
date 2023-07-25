package com.zyx.kga.lost.game;
import com.badlogic.gdx.utils.Array;

public class GameManager {

    MyGame game;

    public static int viewState = -1;
    public static final int HIDEALL = -1;
    public static final int SETTING_VIEW = 0;
    public static final int PPW_VIEW = 1;
    public static final int INFO_VIEW= 2;
    public static final int DEAD_VIEW= 3;
    public static final int MAP_VIEW=4;

    Array<View> views = new Array<View>();;

    public GameManager() {
    }

    public GameManager(MyGame game) {
        this.game = game;
    }

    public void init() {
        SettingView sv = new SettingView(this);
        sv.create();
        views.add(sv);
        PropertyPanelView ppw = new PropertyPanelView(this);
        ppw.create();
        views.add(ppw);
        InformationView iv = new InformationView();
        iv.create();
        views.add(iv);
        DeathView dv = new DeathView(this);
        dv.create();
        views.add(dv);
        MapView mv = new MapView(this);
        mv.create();
        views.add(mv);
    }
    public void update() {}
    public void render(float p) {
        game.render(p);
        if (viewState == -1) {} else {
            views.get(viewState).render(p);
            views.get(viewState).fadein();
        }
    }
    public void setGame(MyGame game) {
        this.game = game;
    }
    public MyGame getGame() {
        return game;
    }
}
