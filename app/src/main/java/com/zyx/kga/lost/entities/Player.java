package com.zyx.kga.lost.entities;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.zyx.kga.lost.Info;
import com.zyx.kga.lost.MyGdxGame;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.zyx.kga.lost.component.RectangleBackGround;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.zyx.kga.lost.game.GameManager;
import com.zyx.kga.lost.component.InformationBar;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class Player extends Entity {

    Label.LabelStyle ls,ils;
    public Label label;
    ProgressBar HPBar;
    TextureRegionDrawable lsbg;
    //GlyphLayout layout = new GlyphLayout();
    InformationBar ib;
    
    @Override
    public void create() {
        ProgressBar.ProgressBarStyle pbs = new ProgressBar.ProgressBarStyle();
        TextureRegionDrawable bg =new TextureRegionDrawable(new TextureRegion(new Texture("UI/down_60.png")));
        bg.setMinSize(1/Info.PPM,12/Info.PPM);
        pbs.knobAfter =bg;
        TextureRegionDrawable knobbefore =new TextureRegionDrawable(new TextureRegion(RectangleBackGround.RGBArectangle(50,50,0xff0000aa)));
        knobbefore.setMinSize(1/Info.PPM,12/Info.PPM);
        pbs.knobBefore = knobbefore;

        HPBar = new ProgressBar(0,200,1,false,pbs);
        HPBar.setPosition(10,5);
        HPBar.setSize(24,2);
        stage.addActor(HPBar);
        
        ils = new Label.LabelStyle();
        ils.font = MyGdxGame.ass.get("font/fontc_16.fnt",BitmapFont.class);
        ils.font.getData().setScale(0.25f);
        ils.font.getData().markupEnabled = true;

        ls = new Label.LabelStyle();
        ls.font = MyGdxGame.ass.get("font/fontc_16.fnt",BitmapFont.class);
        ls.font.getData().setScale(0.25f);
        ls.font.getData().markupEnabled = true;
        lsbg = new TextureRegionDrawable(RectangleBackGround.RGBArectangle(10, 8,0x00000040 ));
        ls.background =lsbg;
        label = new Label("[RED]Z[BLACK]X[GREEN]I[GRAY]O[BLUE]N[GOLD]F[]",ls);
        //label.getStyle().background = new TextureRegionDrawable(RectangleBackGround.RGBArectangle((int)(8),(int)(8), RectangleBackGround.BLACK60));
        label.setPosition(body.getPosition().x*Info.PPM,body.getPosition().y*Info.PPM);
        stage.addActor(label);
        
    }

    
    

    public Player(World world , Stage stage ,SpriteBatch batch,InformationBar ib) {
        this.init();
        this.world = world;
        this.stage = stage;
        this.batch = batch;
        this.ib = ib;
        textureregion = new TextureRegion(new Texture("player/hp.png"));
        
        maxspeed = 4;
        height = 12;
        width = 6;
        DamageValue = 4;
        HP = 200;
        
        bdef.type = BodyDef.BodyType.DynamicBody;
        bdef.position.set(30 /Info. PPM, 30 /Info. PPM);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width /Info. PPM, height /Info. PPM);
        fdef.shape = shape;
        fdef.density = 0;
        fdef.filter.groupIndex = Info.value_player;
        
        this.body = world.createBody(bdef);
        this.body.createFixture(fdef);
        //this.body.setGravityScale(2);
        create();
    }
    
    public void update(){
        left = Info.controlstage_isLeft;
        right= Info.controlstage_isRight;
        jump = Info.controlstage_isUp;
        stop = Info.controlstage_isStop;
        
        HPBar.setValue(HP);
        HPBar.setPosition((float)getPosition().x * Info.PPM - 12, getPosition().y * Info.PPM + 15);
        //label
        label.setFontScale(0.25f);
        label.setText(Info.playerName);
        //layout.setText(ls.font,Info.playerName);
        //label.setWidth(layout.width/8);
        label.setWidth(label.getPrefWidth());
        label.setHeight(label.getPrefHeight());
        label.setPosition((getPosition().x-label.getWidth()/2/Info.PPM)* Info.PPM, (getPosition().y+1.4f)* Info.PPM);
        
        //监听玩家状态
        if(HP <= 0){
            
            GameManager.viewState = GameManager.DEAD_VIEW;
            HP = 200;
            ib.addInfo("[YELLOW]"+Info.playerName+"[WHITE]死亡");
        }
        
        batch.begin();
        batch.draw(textureregion, getPosition().x * Info.PPM - width, getPosition().y * Info.PPM - height, 2*width, 2*height);
        batch.end();
        
    }

    public void move() {
        if (!stop) {
            if((body.getLinearVelocity().y < 0.01f && body.getLinearVelocity().y > -0.01f)){
                if (right&body.getLinearVelocity().x<maxspeed*8) {
                    //body.applyLinearImpulse(new Vector2(maxspeed*4,0), new Vector2(-40,0), true);
                    //body.applyForceToCenter(new Vector2(maxspeed,0),true);
                    body.setTransform(body.getPosition().x += 0.002f,body.getPosition().y,0);
                    body.setLinearVelocity(maxspeed*2,body.getLinearVelocity().y);
                    //body.setTransform(body.getPosition().x +=maxspeed/4,body.getPosition().y,0);
                }
                if (left&body.getLinearVelocity().x<maxspeed*8) {
                    //body.applyLinearImpulse(new Vector2(maxspeed*4,0), new Vector2(-40,0), true);
                    //body.applyForceToCenter(new Vector2(maxspeed,0),true);
                    body.setTransform(body.getPosition().x -= 0.002f,body.getPosition().y,0);
                    body.setLinearVelocity(-maxspeed*2,body.getLinearVelocity().y);
                    //body.setTransform(body.getPosition().x +=maxspeed/4,body.getPosition().y,0);
                }
            }else{
                if (right) {
                    //body.applyLinearImpulse(new Vector2(maxspeed*4,0), new Vector2(-40,0), true);
                    //body.applyForceToCenter(new Vector2(maxspeed,0),true);
                    body.setLinearVelocity(maxspeed,body.getLinearVelocity().y);
                    //body.setTransform(body.getPosition().x +=maxspeed/4,body.getPosition().y,0);
                }
                else if (left) {
                    //body.applyLinearImpulse(new Vector2(maxspeed*4,0), new Vector2(-40,0), true);
                    //body.applyForceToCenter(new Vector2(maxspeed,0),true);
                    body.setLinearVelocity(-maxspeed,body.getLinearVelocity().y);
                    //body.setTransform(body.getPosition().x +=maxspeed/4,body.getPosition().y,0);
                }
            }
            
        } else {
            //mybody.setLinearVelocity(0,mybody.getLinearVelocity().y);
            //mybody.setLinearDamping(7);
        }
        if (jump) {
            if (body.getLinearVelocity().y < 0.01f && body.getLinearVelocity().y > -0.01f)
            {
                //body.applyForceToCenter(new Vector2(0, 400f), true);
                body.applyLinearImpulse(new Vector2(0,16), new Vector2(0,16), true);
            }
        }
    }
    
    public Image getTexture(){
        return new Image(textureregion);
    }
    public void DeductHP(){
        HP -= DamageValue;
        Label damagelabel = new Label("[RED]-"+DamageValue,ils);
        damagelabel.setFontScale(0.25f);
        damagelabel.setPosition(getPosition().x*Info.PPM,getPosition().y*Info.PPM);
        damagelabel.addAction(Actions.moveTo(getPosition().x*Info.PPM,getPosition().y*Info.PPM+6,0.5f));
        damagelabel.addAction(Actions.delay(0.5f,Actions.removeActor(damagelabel)));
        stage.addActor(damagelabel);
        
    }
    
}
