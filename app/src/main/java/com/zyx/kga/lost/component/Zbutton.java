package com.zyx.kga.lost.component;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.zyx.kga.lost.game.GameManager;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;

public class Zbutton{
    
    public static class ShutButton extends Button{
        public ShutButton(ClickListener c){
            super(ButtonStyles.getShutButtonStyle());
            this.addListener(c);
        }
        public ShutButton(/*GMAE MANANGER*/){
            super(ButtonStyles.getShutButtonStyle());
            this.addListener(new ClickListener(){
                    public void clicked(InputEvent event, float x, float y) {
                        //l.setPosition(l.getX()+50,l.getY());
                        GameManager.viewState = GameManager.HIDEALL;
                    }
                });
        }
    }
    public static class TextBtn extends TextButton{
        public TextBtn(String s,ClickListener c){
            super(s,ButtonStyles.getNormal());
            this.addListener(c);
        }
    }
    public static class ImageBtn extends ImageButton{
        public ImageBtn(TextureRegionDrawable t,ClickListener c){
            super(t);
            this.addListener(c);
        }
    }
}
