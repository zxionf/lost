package com.zyx.kga.lost;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class Asst {
    
    public static class NormalButton{
        public static TextureRegionDrawable up,down;
    }
    
    public static class NormalTable{
        public static TextureRegionDrawable tablebg,tablebg2;
    }
    
    public static void load(){
        NormalButton.up = new TextureRegionDrawable(new TextureRegion(new Texture("UI/down_60.png")));
        NormalButton.up.setMinSize(Info.normalbutton_width, Info.noramlbutton_height);
        NormalButton.down = new TextureRegionDrawable(new TextureRegion(new Texture("UI/up_20.png")));
        NormalButton.down.setMinSize(Info.normalbutton_width, Info.noramlbutton_height);
        
        NormalTable.tablebg = new TextureRegionDrawable(new TextureRegion(new Texture("UI/down_60.png")));
        NormalTable.tablebg.setMinSize(Info.ScreenWidth-100-Info.normalbutton_width, 60);

        NormalTable.tablebg2 = new TextureRegionDrawable(new TextureRegion(new Texture("UI/down_60.png")));
        NormalTable.tablebg2.setMinSize(Info.ScreenWidth-100-Info.normalbutton_width*2, 60);
    }
}
