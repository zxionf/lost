package com.zyx.kga.lost.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.zyx.kga.lost.Info;
import com.zyx.kga.lost.MyGdxGame;
import com.zyx.kga.lost.component.RectangleBackGround;
import com.zyx.kga.lost.component.Zbutton;

public class InformationView extends Stage implements View {

    @Override
    public void fadein() {
        this.addAction(Actions.fadeIn(0.5f));
    }


    ScrollPane scrollpane;
    Table table;
    Zbutton.ShutButton shut;
    Label.LabelStyle labelstyle;
    Label label;
    @Override
    public void create() {
        labelstyle = new Label.LabelStyle();
        labelstyle.font = MyGdxGame.ass.get("font/fontc_16.fnt", BitmapFont.class);
        labelstyle.font.getData().setScale(2);
        labelstyle.fontColor = Color.WHITE;

        label = new Label(Info.EventRecorder, labelstyle);
        table = new Table();
        table.align(Align.bottomLeft);
        table.add(label);
        ScrollPane.ScrollPaneStyle scrollpanestyle = new ScrollPane.ScrollPaneStyle();
        scrollpanestyle.background = new TextureRegionDrawable(RectangleBackGround.RGBArectangle(Info.ScreenWidth / 2, Info.ScreenHeight, RectangleBackGround.BLACK60));
        scrollpanestyle.vScroll = new TextureRegionDrawable(RectangleBackGround.RGBArectangle(20, Info.ScreenHeight, RectangleBackGround.BLACK60));
        scrollpanestyle.vScrollKnob = new TextureRegionDrawable(RectangleBackGround.RGBArectangle(20, 50, RectangleBackGround.WHITE60));

        scrollpane = new ScrollPane(table, scrollpanestyle);
        scrollpane.setSize(Info.ScreenWidth / 4 * 3, Info.ScreenHeight);
        shut = new Zbutton.ShutButton(new ClickListener(){
                public void clicked(InputEvent event, float x, float y) {
                    GameManager.viewState = GameManager.HIDEALL;
                }
            });
        scrollpane.setPosition(Info.ScreenWidth / 8, 0);
        shut.setPosition(Info.ScreenWidth - shut.getWidth() - 50, Info.ScreenHeight - shut.getHeight());
        this.addActor(scrollpane);
        this.addActor(shut);
    }

    @Override
    public void render(float p) {
        Gdx.input.setInputProcessor(this);
        label.setText(Info.EventRecorder);
        act();
        draw();
    }

    @Override
    public void pause() {
    }

    @Override
    public void dispose() {
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
