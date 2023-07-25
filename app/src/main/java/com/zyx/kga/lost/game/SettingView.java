package com.zyx.kga.lost.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.zyx.kga.lost.Asst;
import com.zyx.kga.lost.Info;
import com.zyx.kga.lost.MainActivity;
import com.zyx.kga.lost.MyGdxGame;
import com.zyx.kga.lost.State;
import com.zyx.kga.lost.component.RectangleBackGround;

public class SettingView implements View {

    @Override
    public void fadein() {
        stage.addAction(Actions.fadeIn(0.5f));
    }


    SpriteBatch batch;
    //CheckBox checkBox;
    ScrollPane scrollPane;
    BitmapFont font;
    List<Object> list1,list2;
    Table table1,table2;
    Table table[] = new Table[6];
    Label.LabelStyle labelstyle;
    Slider.SliderStyle sliderstyle;

    ScrollPane scrollpane[] = new ScrollPane[6];
    TextButton btn1,btn2,btn3,btn4,shut;
    OrthographicCamera cam;
    Image bg;
    Stage stage;
    int number1,number2;

    Label label0_2_1;
    Label label0_2_0;
    Table table0_2;
    Cell cell0_2;

    GameManager gm;

    public SettingView(GameManager g) {
        gm = g;
    }

    @Override
    public void create() {
        batch = new SpriteBatch();
        bg = new Image(new TextureRegionDrawable(new TextureRegion(new Texture("UI/down_60.png"))));
        font = MyGdxGame.ass.get("font/fontc_16.fnt", BitmapFont.class);
        table1 = new Table();
        table2 = new Table();

        Viewport viewport = new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        cam = new OrthographicCamera();
        viewport.setCamera(cam);
        stage = new Stage(viewport);
        //this.setViewport(viewport);

        for (int i=0 ;i < 6;i++) {
            table[i] = new Table();
        }
        sliderstyle = new Slider.SliderStyle();
        sliderstyle.background = new TextureRegionDrawable(new TextureRegion(new Texture("stone.png")));
        sliderstyle.knob = new TextureRegionDrawable(new TextureRegion(RectangleBackGround.RectangleTexture(18, 36, RectangleBackGround.WHITE60)));

        Gdx.input.setInputProcessor(stage);

        labelstyle = new Label.LabelStyle();
        labelstyle.font = font;
        labelstyle.fontColor = Color.WHITE;
        //labelstyle.

        /*MainActivity.use.showQucikDialog("", "", new Runnable()
         {
         @Override
         public void run()
         {                 
         }
         });
         */

        TextButton.TextButtonStyle textbuttonstyle = new TextButton.TextButtonStyle();
        TextButton.TextButtonStyle textbuttonstyle2 = new TextButton.TextButtonStyle();

        textbuttonstyle.up = textbuttonstyle2.up = Asst.NormalButton.up;
        textbuttonstyle.down = textbuttonstyle2.down = Asst.NormalButton.down;
        textbuttonstyle.font = textbuttonstyle2.font = font;
        textbuttonstyle.font.getData().setScale(2);
        textbuttonstyle2.font.getData().setScale(2);
        textbuttonstyle.fontColor = Color.YELLOW;
        textbuttonstyle2.fontColor = Color.RED;

        //第一侧边条
        shut = new TextButton("关闭", textbuttonstyle2);
        shut.addListener(new ClickListener(){

                public void clicked(InputEvent event, float x, float y) {
                    State.screenstate.screenflag = State.screenstate.multipplayerbattle;
                    //game.setScreen(MyGdxGame.multipplayerbattle);
                    GameManager.viewState = GameManager.HIDEALL;
                }
            });
        table1.add(shut);

        List.ListStyle liststyle = new List.ListStyle();
        liststyle.font = font;
        liststyle.font.getData().setScale(2);
        liststyle.fontColorUnselected = Color.YELLOW;
        liststyle.background = Asst.NormalButton.up;
        liststyle.fontColorSelected = Color.WHITE;
        liststyle.selection = Asst.NormalButton.down;

        final List<String> list1 = new List<String>(liststyle);
        String[] items = {"基础", "音画", "高级"};
        list1.setItems(items);
        list1.setSize(Info.normalbutton_width, Info.ScreenHeight);
        //list1.pack();
        list1.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    //Log.e("ard", "选中项索引：" + list.getSelectedIndex()); // 始于0
                    //Log.e("ard", "选中项内容：" + list.getSelected());
                    number1 = list1.getSelectedIndex();
                }

            });


        //table1.top();

        table1.row().expand(0, 5);
        table1.add(list1);
        table1.row();
        table1.setSize(Info.normalbutton_width, Info.ScreenHeight);
        table1.setPosition(Info.ScreenWidth - shut.getWidth(), Info.ScreenHeight - table1.getHeight());

        //第二侧边条
        final List<String> list2 = new List<String>(liststyle);
        String[] items2 = {"game","debug","state"};
        list2.setItems(items2);
        list2.setSize(Info.normalbutton_width, Info.ScreenHeight);
        //list1.pack();
        list2.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    //Log.e("ard", "选中项索引：" + list.getSelectedIndex()); // 始于0
                    //Log.e("ard", "选中项内容：" + list.getSelected());
                    number2 = list2.getSelectedIndex();
                }

            });


        //table1.top();

        //table2.row().expand(0, 5);
        table2.add(list2);
        //table2.row();
        table2.setSize(Info.normalbutton_width, Info.ScreenHeight);
        table2.setPosition(Info.ScreenWidth * 3 - shut.getWidth() * 2, Info.ScreenHeight - table1.getHeight());

        //添加各种框体
        addKuangTi();


        ScrollPane.ScrollPaneStyle scrollpanestyle = new ScrollPane.ScrollPaneStyle();
        for (int i = 0;i < 6;i++) {
            scrollpane[i] = new ScrollPane(table[i], scrollpanestyle);
            //scrollpane[i].setScrollingDisabled(true,false);
            scrollpane[i].setHeight(Info.ScreenHeight);
            if (i < 2) {
                scrollpane[i].setWidth(Info.ScreenWidth - table1.getWidth());
            } else {
                scrollpane[i].setWidth(Info.ScreenWidth - table1.getWidth() - table2.getWidth());
            }
            scrollpane[i].setPosition(Info.ScreenWidth * i, 0);

        }


        stage.addActor(table1);
        bg.setSize(Info.ScreenWidth - table1.getWidth(), Info.ScreenHeight);
        bg.setPosition(0, 0);
        stage.addActor(bg);
        stage.addActor(table2);
        for (int i = 0;i < 6;i++) {
            stage.addActor(scrollpane[i]);
        }
    }
    private void addKuangTi() {
        //第零框体
        table[0].align(Align.topLeft);
        table[0].padLeft(50);
        table[0].padTop(30).padBottom(30);
        Table table0_0 = new Table();
        table0_0.background(Asst.NormalTable.tablebg);
        table0_0.setLayoutEnabled(true);
        table0_0.align(Align.left).padLeft(20);
        //table1_0.debug();
        Label label0_0 = new Label("自定义操作面板(开发中)", labelstyle);
        table0_0.add(label0_0);
        //table0_0.add().width(Info.ScreenWidth-100-Info.normalbutton_width-400-label0_0.getWidth()-20*2);

        Table table0_1 = new Table();
        table0_1.background(Asst.NormalTable.tablebg);
        table0_1.setLayoutEnabled(true);
        table0_1.align(Align.left).padLeft(20);
        //table1_1.debug();
        Label label0_1 = new Label("进攻策略(开发中)", labelstyle);
        table0_1.add(label0_1);

        table0_2 = new Table();
        table0_2.background(Asst.NormalTable.tablebg);
        table0_2.setLayoutEnabled(true);
        table0_2.align(Align.left).padLeft(20);
        table0_2.debug();
        label0_2_0 = new Label("昵称(点击文字可修改)", labelstyle);

        label0_2_1 = new Label(Info.playerName, labelstyle);
        label0_2_1.setAlignment(Align.right);
        table0_2.addListener(new ClickListener(){
                public void clicked(InputEvent event, float x, float y) {
                    MainActivity.use.EditDialog();
                    //gm.getGame().player1.label.getStyle().background = new TextureRegionDrawable(RectangleBackGround.RGBArectangle((int)(gm.getGame().player1.label.getWidth()*Info.PPM),(int)(gm.getGame().player1.label.getHeight()*Info.PPM), RectangleBackGround.BLACK60));
                }
            });
        table0_2.add(label0_2_0);
        cell0_2 = table0_2.add().fillY().width(Info.ScreenWidth - 100 - Info.normalbutton_width - label0_2_0.getWidth() - label0_2_1.getWidth() - 20 * 2);
        table0_2.add(label0_2_1);

        table[0].add(table0_0).padBottom(40).row();
        table[0].add(table0_1).padBottom(40).row();
        table[0].add(table0_2).row();


        //第一框体
        table[1].align(Align.topLeft);
        table[1].padLeft(50);
        table[1].padTop(30).padBottom(30);
        //table[1].add(new Label("摄像机视野调整",labelstyle));
        final Slider slider1_0 = new Slider(0.1f, 5f, 0.1f, false, sliderstyle);
        slider1_0.setSize(100, 32);
        slider1_0.addListener(new ChangeListener() {

                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    //Gdx.app.log("TAG", "slider changed to: " + slider.getValue());
                    //GameState.UIScale = 1.0f*slider1.getValue();
                    Info.cameraheightscale = slider1_0.getValue();
                }
            });

        TextureRegionDrawable tablebg = new TextureRegionDrawable(new TextureRegion(new Texture("UI/down_60.png")));
        tablebg.setMinSize(Info.ScreenWidth - 100 - Info.normalbutton_width, 60);
        Table table1_0 = new Table();
        table1_0.background(tablebg);
        table1_0.setLayoutEnabled(true);
        table1_0.align(Align.left).padLeft(20);
        //table1_0.debug();
        Label label1_0 = new Label("摄像机高度调整", labelstyle);
        table1_0.add(label1_0);
        table1_0.add().width(Info.ScreenWidth - 100 - Info.normalbutton_width - 400 - label1_0.getWidth() - 20 * 2);
        table1_0.add(slider1_0).right().width(400);

        //table[1].add(slider1_1);
        table[1].add(table1_0);

        //第二框体
        table[2].align(Align.topLeft);
        table[2].padLeft(50);
        table[2].padTop(30).padBottom(30);
        Table table2_0 = new Table();
        table2_0.background(Asst.NormalTable.tablebg2);
        table2_0.setLayoutEnabled(true);
        table2_0.align(Align.left).padLeft(20);
        //table1_0.debug();
        Label label2_0 = new Label("事件记录器(开发中)", labelstyle);
        table2_0.add(label2_0);
        //table0_0.add().width(Info.ScreenWidth-100-Info.normalbutton_width-400-label0_0.getWidth()-20*2);

        Table table2_1 = new Table();
        table2_1.background(Asst.NormalTable.tablebg2);
        table2_1.setLayoutEnabled(true);
        table2_1.align(Align.left).padLeft(20);
        //table1_1.debug();
        Label label2_1 = new Label("碰撞箱显示(开发中)", labelstyle);
        table2_1.add(label2_1);

        table[2].add(table2_0).padBottom(40).row();
        table[2].add(table2_1).row();

        //第4框体
        table[4].align(Align.topLeft);
        table[4].padLeft(50);
        table[4].padTop(30).padBottom(30);
        Table table4_0 = new Table();
        table4_0.background(Asst.NormalTable.tablebg2);
        table4_0.setLayoutEnabled(true);
        table4_0.align(Align.left).padLeft(20);
        //table1_0.debug();
        Label label4_0_0 = new Label("版本名:", labelstyle);
        Label label4_0_1 = new Label(Info.versionName, labelstyle);
        table4_0.add(label4_0_0);
        table4_0.add().width(Info.ScreenWidth - 100 - Info.normalbutton_width * 2 - label4_0_0.getWidth() - label4_0_1.getWidth() - 20 * 2);
        table4_0.add(label4_0_1).padRight(20);

        Table table4_1 = new Table();
        table4_1.background(Asst.NormalTable.tablebg2);
        table4_1.setLayoutEnabled(true);
        table4_1.align(Align.left).padLeft(20);
        //table1_1.debug();
        Label label4_1_0 = new Label("版本号:", labelstyle);
        Label label4_1_1 = new Label(Info.versionCode + "", labelstyle);
        table4_1.add(label4_1_0);
        table4_1.add().width(Info.ScreenWidth - 100 - Info.normalbutton_width * 2 - label4_1_0.getWidth() - label4_1_1.getWidth() - 20 * 2);
        table4_1.add(label4_1_1).padRight(20);

        Table table4_2 = new Table();
        table4_2.background(Asst.NormalTable.tablebg2);
        table4_2.setLayoutEnabled(true);
        table4_2.align(Align.left).padLeft(20);
        //table1_1.debug();
        Label label4_2_0 = new Label("设备:", labelstyle);
        Label label4_2_1 = new Label(Info.deviceinfo + "", labelstyle);
        table4_2.add(label4_2_0);
        table4_2.add().width(Info.ScreenWidth - 100 - Info.normalbutton_width * 2 - label4_2_0.getWidth() - label4_2_1.getWidth() - 20 * 2);
        table4_2.add(label4_2_1).padRight(20);

        table[4].add(table4_0).padBottom(20).row();
        table[4].add(table4_1).padBottom(20).row();
        table[4].add(table4_2).row();
    }
    @Override
    public void dispose() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void render(float p) {
        //Gdx.gl.glClearColor(1, 1, 1, 1);
        //Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        Gdx.input.setInputProcessor(stage);

        if (number1 != 2) {
            table1.setPosition(Info.ScreenWidth * number1 + Info.ScreenWidth - shut.getWidth(), Info.ScreenHeight - table1.getHeight());
            cam.position.set(number1 * Info.ScreenWidth + Info.ScreenWidth / 2, Info.ScreenHeight / 2, 0);

            bg.setSize(Info.ScreenWidth - table1.getWidth(), Info.ScreenHeight);
            bg.setPosition(Info.ScreenWidth * number1, 0);
        } else if (number1 == 2) {
            table1.setPosition(Info.ScreenWidth * (number1 + number2) + Info.ScreenWidth - shut.getWidth(), Info.ScreenHeight - table1.getHeight());
            table2.setPosition(Info.ScreenWidth * (number1 + number2) + Info.ScreenWidth - table1.getWidth() - table2.getWidth(), Info.ScreenHeight - table1.getHeight());
            cam.position.set((number1 + number2) * Info.ScreenWidth + Info.ScreenWidth / 2, Info.ScreenHeight / 2, 0);

            bg.setSize(Info.ScreenWidth - table1.getWidth() - table2.getWidth(), Info.ScreenHeight);
            bg.setPosition(Info.ScreenWidth * (number1 + number2), 0);
        }

        //table0_2.row();
        cell0_2.width(Info.ScreenWidth - 100 - Info.normalbutton_width - label0_2_0.getWidth() - label0_2_1.getWidth() - 20 * 2);
        label0_2_1.setText(Info.playerName);

        stage.act();
        stage.draw();

        batch.begin();
        font.draw(batch, "" + scrollpane[number1].getVisualScrollY() + "\n" + number1 + ";" + number2, 0, 300);
        batch.end();
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

}
