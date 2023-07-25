package com.zyx.kga.lost;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Game;
import android.app.GameManager;

public class State {
    
    public static class screenstate{
        public static int screenflag = 1;
        public static final int home = 1;
        public static final int multipplayerbattle = 2;
        public static final int setting = 3;
        public static void update(Game game){
            switch(screenflag){
                case home:
                    //Gdx.input.setInputProcessor(MyGdxGame.multipplayerbattle.controlStage);
                    break;
                case multipplayerbattle:
                    //Gdx.input.setInputProcessor(MyGdxGame.multipplayerbattle.ppw);
                    //MyGdxGame.multipplayerbattle.ppw.act();
                    //MyGdxGame.multipplayerbattle.ppw.draw();
                    break;
                case setting:
                    //game.setScreen(MyGdxGame.settingscreen);
                    
                    break;
            }
        }
    }
    
    public static class stage{
        public static int stageflag = 1;
        public static final int controlstage = 1;
        public static final int PropertyPanelWindow = 2;
        public static void update(){
            switch(stageflag){
                case controlstage:
                    Gdx.input.setInputProcessor(MyGdxGame.GM.getGame().controlStage);
                    break;
                case PropertyPanelWindow:
                    //Gdx.input.setInputProcessor(MyGdxGame.multipplayerbattle.ppw);
                    //MyGdxGame.multipplayerbattle.ppw.act();
                    //MyGdxGame.multipplayerbattle.ppw.draw();
                    break;
            }
        }
    }
    
    public static class input{
        public static int stageflag = 0;
        public static final int left = 1;
        public static final int right = 2;
        public static final int up = 3;
        public static final int down = 4;
        public static void update(){
            /*switch(stageflag){
                case controlstage:
                    Gdx.input.setInputProcessor(MyGdxGame.multipplayerbattle.controlStage);
                    break;
                case PropertyPanelWindow:
                    Gdx.input.setInputProcessor(MyGdxGame.multipplayerbattle.ppw);
                    MyGdxGame.multipplayerbattle.ppw.act();
                    MyGdxGame.multipplayerbattle.ppw.draw();
                    break;
            }*/
        }
    }
}
