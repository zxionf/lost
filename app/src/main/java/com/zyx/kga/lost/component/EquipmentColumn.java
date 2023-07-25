package com.zyx.kga.lost.component;

import com.badlogic.gdx.scenes.scene2d.ui.Widget;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Batch;

public class EquipmentColumn extends Widget {
    
    Image head,body,leg,foot;
    
    public EquipmentColumn(){
        head = new Image(new TextureRegion(RectangleBackGround.RectangleTexture(80,80,0xffffff90)));
        body = new Image(new TextureRegion(RectangleBackGround.RectangleTexture(80,80,0xffffff90)));
        leg = new Image(new TextureRegion(RectangleBackGround.RectangleTexture(80,80,0xffffff90)));
        foot = new Image(new TextureRegion(RectangleBackGround.RectangleTexture(80,80,0xffffff90)));
        head.setPosition(200,500);
        body.setPosition(200,400);
        leg.setPosition(200,300);
        foot.setPosition(200,200);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        head.draw(batch, parentAlpha);
        body.draw(batch, parentAlpha);
        leg.draw(batch, parentAlpha);
        foot.draw(batch, parentAlpha);
    }
    
}
