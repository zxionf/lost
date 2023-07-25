package com.zyx.kga.lost;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.zyx.kga.lost.game.GameManager;


public class ControlStage extends Stage {

    public int CtlbtnSize = 150;

    public Touchpad touchPad;
    Touchpad.TouchpadStyle touchpadstyle;

    //InformationBar ib = new InformationBar();

    public void init_stage() {
        Image image_left= new Image(new TextureRegion(new Texture("UI/left.png")));
        Image image_right = new Image(new TextureRegion(new Texture("UI/right.png")));
        Image image_up = new Image(new TextureRegion(new Texture("UI/up.png")));
        Image image_down = new Image(new TextureRegion(new Texture("UI/down.png")));

        Image image_bag = new Image(new TextureRegion(new Texture("UI/bag.png")));

        Image image_setting = new Image(new TextureRegion(new Texture("UI/bag.png")));

        Image image_attrack_near = new Image(new TextureRegion(new Texture("UI/attack_near.png")));

        image_left.setSize(CtlbtnSize, CtlbtnSize);
        image_right.setSize(CtlbtnSize, CtlbtnSize);
        image_up.setSize(CtlbtnSize, CtlbtnSize);
        image_down.setSize(CtlbtnSize, CtlbtnSize);
        image_bag.setSize(CtlbtnSize, CtlbtnSize);

        image_setting.setSize(150, 150);
        image_setting.setPosition(0, Info.ScreenHeight - 150);

        image_attrack_near.setSize(150, 150);
        image_attrack_near.setPosition(Info.ScreenWidth - 300, Info.ScreenHeight / 2);

        image_left.setPosition(40, 0);
        image_down.setPosition(Gdx.graphics.getWidth() - image_left.getWidth(), Gdx.graphics.getHeight() / 2 - CtlbtnSize);
        image_right.setPosition(40 + image_left.getWidth() * 2, 0);
        image_up.setPosition(Gdx.graphics.getWidth() - image_left.getWidth(), Gdx.graphics.getHeight() / 2);
        image_bag.setPosition(Gdx.graphics.getWidth() - CtlbtnSize, 0);

        image_left.addListener(new InputListener(){

                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    Info.controlstage_isLeft = true;
                    Info.controlstage_isStop = false;
                    return true;
                    //return super.touchDown(event, x, y, pointer, button);
                }

                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    Info.controlstage_isStop = true;
                    Info.controlstage_isLeft  = false;
                    // super.touchUp(event, x, y, pointer, button);
                }

            });

        image_right.addListener(new InputListener(){

                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    Info.controlstage_isRight  = true;
                    Info.controlstage_isStop = false;
                    return true;
                    //return super.touchDown(event, x, y, pointer, button);
                }

                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    Info.controlstage_isStop = true;
                    Info.controlstage_isRight  = false;
                    //super.touchUp(event, x, y, pointer, button);
                }

            });
        image_up.addListener(new InputListener(){

                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    Info.controlstage_isUp = true;
                    return true;
                    //return super.touchDown(event, x, y, pointer, button);
                }

                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    Info.controlstage_isUp = false;
                    //super.touchUp(event, x, y, pointer, button);
                }

            });
        image_down.addListener(new InputListener(){

                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    Info.controlstage_isDown = true;
                    return true;
                    //return super.touchDown(event, x, y, pointer, button);
                }

                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    Info.controlstage_isDown = false;
                    //super.touchUp(event, x, y, pointer, button);
                }

            });
        image_bag.addListener(new InputListener(){

                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    return true;
                    //return super.touchDown(event, x, y, pointer, button);
                }

                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    GameManager.viewState = GameManager.PPW_VIEW;
                }

            });
        image_setting.addListener(new InputListener(){

                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    return true;
                    //return super.touchDown(event, x, y, pointer, button);
                }

                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    //State.screenstate.screenflag = State.screenstate.setting;
                    GameManager.viewState = GameManager.SETTING_VIEW;

                }

            });


        image_attrack_near.addListener(new InputListener(){

                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    return true;
                    //return super.touchDown(event, x, y, pointer, button);
                }

                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    //State.screenstate.screenflag = State.screenstate.setting;
                    //GameManager.viewState = GameManager.SETTING_VIEW;
                    MyGdxGame.GM.getGame().player2.DeductHP();
                }

            });

        touchpadstyle = new Touchpad.TouchpadStyle();
        touchpadstyle.background = new TextureRegionDrawable(new TextureRegion(R(300, 300)));
        touchpadstyle.knob = new TextureRegionDrawable(new TextureRegion(R2(100, 100)));
        touchPad = new Touchpad(0, touchpadstyle);
        touchPad.setPosition(900, 50);
        touchPad.addListener(new InputListener(){

                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                    //return super.touchDown(event, x, y, pointer, button);

                    return true;
                }

                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    //State.screenstate.screenflag = State.screenstate.setting;
                    //Info.bulletposition[0] = Info.player1.position.x;
                    //Info.bulletposition[1] = Info.player1.position.y;
                    //Info.bulleta[0] = touchPad.getKnobPercentX()*2;
                    //Info.bulleta[1] = touchPad.getKnobPercentY()*2;
                    Info.bulleta[0] = touchPad.getKnobPercentX() * 1000; //x-touchPad.getX();
                    //MultipPlayerBattle.time = 0;
                }

            });
        addActor(touchPad);

        addActor(image_left);
        addActor(image_right);
        addActor(image_up);
        addActor(image_down);
        addActor(image_bag);
        addActor(image_setting);
        addActor(image_attrack_near);
//        ScrollPane.ScrollPaneStyle scrollpanestyle = new ScrollPane.ScrollPaneStyle();
//        Table table = new Table();
//        scrollpanestyle.background = new TextureRegionDrawable(RectangleBackGround.RGBArectangle(300, 50, RectangleBackGround.BLACK60));
//        final ScrollPane scrollpane = new ScrollPane(table, scrollpanestyle);
//        scrollpane.setHeight(50);
//        scrollpane.setWidth(300);
//        scrollpane.setPosition(200,300);
//        scrollpane.addListener(new ClickListener(){
//                public void clicked(InputEvent event, float x, float y) {
//                    scrollpane.setPosition(scrollpane.getX()+50,scrollpane.getY());
//                }
//            });
//        addActor(scrollpane);

        Image image_chat = new Image(new TextureRegion(new Texture("UI/bag.png")));
        image_chat.setSize(50, 50);
        image_chat.setPosition((Info.ScreenWidth - 100) / 2, Info.ScreenHeight - 50);
        image_chat.addListener(new ClickListener(){
                public void clicked(InputEvent event, float x, float y) {
                    //l.setPosition(l.getX()+50,l.getY());
                    GameManager.viewState = GameManager.INFO_VIEW;
                }
            });
        this.addActor(image_chat);

        Image image_map = new Image(new TextureRegion(new Texture("UI/bag.png")));
        image_map.setSize(50, 50);
        image_map.setPosition((Info.ScreenWidth) / 2, Info.ScreenHeight - 50);
        image_map.addListener(new ClickListener(){
                public void clicked(InputEvent event, float x, float y) {
                    //l.setPosition(l.getX()+50,l.getY());
                    GameManager.viewState = GameManager.MAP_VIEW;
                }
            });
        this.addActor(image_map);
    }


    private Texture R(int weight, int height) {
        Pixmap pixmap = new Pixmap(weight, height, Pixmap.Format.RGBA8888);
//        pixmap.setColor(0x000000cc);
//        pixmap.fillRectangle(0,0,pixmap.getWidth(),pixmap.getHeight());
//        pixmap.setColor(0xffffffaa);
//        pixmap.fillRectangle(4,4,pixmap.getWidth()-8,pixmap.getHeight()-8);
        pixmap.setColor(0x000000cc);
        pixmap.fillCircle(pixmap.getWidth() / 2, pixmap.getHeight() / 2, pixmap.getHeight() / 2);
        //pixmap.fillRectangle(0,0,4,pixmap.getHeight());
        //pixmap.fillRectangle(0,0,pixmap.getWidth(),4);
        //pixmap.fillRectangle(pixmap.getWidth()-4,0,4,pixmap.getHeight());
        //pixmap.fillRectangle(0,pixmap.getHeight()-4,pixmap.getWidth(),4);
        //pixmap.setColor(0xff00ffcc);
        //pixmap.fillRectangle(4,4,pixmap.getWidth()-8,pixmap.getHeight()-8);
        Texture texture = new Texture(pixmap);
        pixmap.dispose();
        return texture;
    }

    private Texture R2(int weight, int height) {
        Pixmap pixmap = new Pixmap(weight, height, Pixmap.Format.RGBA8888);
//        pixmap.setColor(0x000000cc);
//        pixmap.fillRectangle(0,0,pixmap.getWidth(),pixmap.getHeight());
//        pixmap.setColor(0xffffffaa);
//        pixmap.fillRectangle(4,4,pixmap.getWidth()-8,pixmap.getHeight()-8);
        pixmap.setColor(0xff00ffcc);
        pixmap.fillCircle(pixmap.getWidth() / 2, pixmap.getHeight() / 2, pixmap.getHeight() / 2);
        //pixmap.fillRectangle(0,0,4,pixmap.getHeight());
        //pixmap.fillRectangle(0,0,pixmap.getWidth(),4);
        //pixmap.fillRectangle(pixmap.getWidth()-4,0,4,pixmap.getHeight());
        //pixmap.fillRectangle(0,pixmap.getHeight()-4,pixmap.getWidth(),4);
        //pixmap.setColor(0xff00ffcc);
        //pixmap.fillRectangle(4,4,pixmap.getWidth()-8,pixmap.getHeight()-8);
        Texture texture = new Texture(pixmap);
        pixmap.dispose();
        return texture;
    }
}
