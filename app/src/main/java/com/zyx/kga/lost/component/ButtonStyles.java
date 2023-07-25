package com.zyx.kga.lost.component;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.zyx.kga.lost.MyGdxGame;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class ButtonStyles extends Button {

    public static ButtonStyle getShutButtonStyle() {
        TextureRegionDrawable up = new TextureRegionDrawable(new TextureRegion(new Texture("UI/shut_up60.png")));
        TextureRegionDrawable down = new TextureRegionDrawable(new TextureRegion(new Texture("UI/shut_down20.png")));

        up.setMinSize(50, 50);
        down.setMinSize(50, 50);

        ButtonStyle styley = new ButtonStyle();
        styley.up = up;
        styley.down = down;
        return styley;
    }
    public static TextButton.TextButtonStyle getNormal() {
        TextureRegionDrawable up = new TextureRegionDrawable(RectangleBackGround.RGBArectangle(150, 50, RectangleBackGround.BLACK60));
        TextureRegionDrawable down =new TextureRegionDrawable(RectangleBackGround.RGBArectangle(150, 50, RectangleBackGround.WHITE60));
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.up = up;
        style.down = down;
        style.font = MyGdxGame.ass.get("font/fontc_16.fnt", BitmapFont.class);
        style.fontColor = Color.YELLOW;
        return style;
    }
}
