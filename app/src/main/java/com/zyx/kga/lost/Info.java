package com.zyx.kga.lost;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;

public class Info {
    
    //public static Player player1,player2;
    //16px = 1m
    public static final float PPM = 16f;
    
    public static String playerName = "zxionf";
    
    public static final int ScreenWidth = Gdx.graphics.getWidth();
    public static final int ScreenHeight = Gdx.graphics.getHeight();
    
    public static int normalbutton_width = 150;
    public static int noramlbutton_height = 50;
    
    public static boolean controlstage_isLeft = false;
    public static boolean controlstage_isRight = false;
    public static boolean controlstage_isUp = false;
    public static boolean controlstage_isDown = false;
    public static boolean controlstage_isStop = false;
    
    public static String player1IP =null;
    public static String player2IP =null;
    
    
    public static float cameraheightscale = 1f;
    
    public static String versionName = "";
    public static int versionCode = 0;
    public static String deviceinfo = "";
    
    public static float bulletposition[] = {0,0};
    public static float bulleta[] = {0,0};
    
    public static final short value_block = 1;
    public static final short value_player = -1;
    
    public static String EventRecorder = "";
}
