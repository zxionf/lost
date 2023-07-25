package com.zyx.kga.lost.component;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Widget;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.zyx.kga.lost.Info;

public class ArticlesColumn extends Widget{
    /*物品栏*/
    
    Image bg;
    
    public ArticlesColumn(){
        bg = new Image(RectangleBackGround.RectangularSegmentationFrame((int)(Info.ScreenWidth*0.8f*0.5f-4),(int)(Info.ScreenWidth*0.8f*0.5f)/9*1+4,9,0xffffff90));
        
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        bg.draw(batch,parentAlpha);
    }

    @Override
    public void setPosition(float x, float y, int alignment) {
        super.setPosition(x, y, alignment);
    }

    @Override
    public void setPosition(float x, float y) {
        super.setPosition(x, y);
        bg.setPosition(x+4,y+4);
    }
    
}
