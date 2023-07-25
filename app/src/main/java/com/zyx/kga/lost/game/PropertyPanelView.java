package com.zyx.kga.lost.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.zyx.kga.lost.Info;
import com.zyx.kga.lost.MyGdxGame;
import com.zyx.kga.lost.component.ArticlesColumn;
import com.zyx.kga.lost.component.ButtonStyles;
import com.zyx.kga.lost.component.EquipmentColumn;
import com.zyx.kga.lost.component.RectangleBackGround;
import com.zyx.kga.lost.entities.Player;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.zyx.kga.lost.entities.Bag;

public class PropertyPanelView extends Stage implements View {

    @Override
    public void fadein() {
    }


    GameManager gm;

    Player player;
    Image playerimage;

    Texture texture;
    Image bg;
    Label label1,label2;
    Label.LabelStyle labelstyle = new Label.LabelStyle();

    ArticlesColumn articlescolumn;
    EquipmentColumn equipmentcolumn;
    ScrollPane.ScrollPaneStyle scrollpanestyle = new ScrollPane.ScrollPaneStyle();
    ScrollPane bagscroll;
    
    Table bagtable = new Table();

    BitmapFont font;

    Button shut;


    public PropertyPanelView() {}
    public PropertyPanelView(GameManager gm) {
        this.gm = gm;
    }

    @Override
    public void create() {

        player = gm.getGame().player1;

        font = MyGdxGame.ass.get("font/fontc_16.fnt", BitmapFont.class);

        labelstyle.font = font;
        labelstyle.font.getData().markupEnabled = true;


        bg = new Image(RectangleBackGround.createRBG((int)(Gdx.graphics.getWidth() * 0.8f), (int)(Gdx.graphics.getHeight() * 0.8f), 0.5f));
        bg.setSize(Gdx.graphics.getWidth() * 0.8f, Gdx.graphics.getHeight() * 0.8f);
        bg.setPosition(Gdx.graphics.getWidth() * 0.1f, Gdx.graphics.getHeight() * 0.1f);

        shut = new Button(ButtonStyles.getShutButtonStyle());
        shut.setPosition(Gdx.graphics.getWidth() * 0.9f - 50 - 4, Gdx.graphics.getHeight() * 0.9f - 50 - 4);
        shut.addListener(new ClickListener(){

                public void clicked(InputEvent event, float x, float y) {
                    GameManager.viewState = GameManager.HIDEALL;
                }
            });


        this.addActor(bg);
        this.addActor(shut);

        label1 = new Label("大", labelstyle);
        label1.setPosition(Gdx.graphics.getWidth() * 0.25f, Gdx.graphics.getHeight() * 0.7f);

        label2 = new Label("宽度修正" + "(" + "0" + ")", labelstyle);
        label2.setPosition(Gdx.graphics.getWidth() * 0.25f, Gdx.graphics.getHeight() * 0.7f - label1.getHeight() - 30);
        this.addActor(label1);
		this.addActor(label2);

        playerimage = player.getTexture();
        playerimage.setScale(3);
        this.addActor(playerimage);
        playerimage.setPosition(Info.ScreenWidth * 0.2f, Info.ScreenHeight * 0.3f);

        articlescolumn = new ArticlesColumn();
        addActor(articlescolumn);
        articlescolumn.setPosition(Info.ScreenWidth * 0.1f, Info.ScreenHeight * 0.1f);

        equipmentcolumn = new EquipmentColumn();
        addActor(equipmentcolumn);
        
        scrollpanestyle.vScroll = new TextureRegionDrawable(RectangleBackGround.RGBArectangle(20, Info.ScreenHeight, RectangleBackGround.BLACK60));
        scrollpanestyle.vScrollKnob = new TextureRegionDrawable(RectangleBackGround.RGBArectangle(20, 50, RectangleBackGround.WHITE60));
        
        Bag bag= new Bag();
        bagscroll = new ScrollPane(bag,scrollpanestyle);
        bagscroll.setSize(Info.ScreenWidth*0.4f-50,Info.ScreenHeight*0.8f);
        bagscroll.setPosition(Info.ScreenWidth*0.5f,Info.ScreenHeight*0.1f);
        this.addActor(bagscroll);
    }

    @Override
    public void render(float p) {
        Gdx.input.setInputProcessor(this);
        label1.setText("[YELLOW]HP[WHITE]:[GREEN]" + player.HP + "[WHITE]/[YELLOW]200");
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

    public void setPlayer(Player player) {
        this.player = player;
    }


}
