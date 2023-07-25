package com.zyx.kga.lost.entities;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Entity implements Action{
    
    public static final String TAG = "Entity";
    
    int id;
    String name;
    int width;
    int height;
    int minheight;
    int minwidth;
    int maxheight;
    int maxwidth;
    Texture texture;
    TextureRegion textureregion;
    
    public int HP;
    int DamageValue;
    
    int AttackDistance;
    
    int speed = 1;
    int maxspeed = 1;
    
    Vector2 position;
    
    Skill skill0,skill1,skill2;
    
    Bag bag;
    
    
    
    World world;
    Stage stage;
    SpriteBatch batch;
    BodyDef bdef;
    public Body body;
    FixtureDef fdef;
    Fixture fixture;
    //sensor
    //float x,y;
    boolean right,stop = true,left,jump;
    
    public abstract void move();
    
    public abstract void update();
    
    public void init(){
        bdef = new BodyDef();
        fdef = new FixtureDef();
    }
    
    public abstract void create();
    
    public void attack(){}
    
    public Vector2 getPosition(){
        return position = body.getPosition();
    }
    private void setPosition(float x,float y){
        body.getPosition().x = x;
        body.getPosition().y = y;
    }
    public void setTransform(float x ,float y,float angle){
        body.setTransform(x,y,angle);
    }
    public void setTransform(float x ,float y){
        body.setTransform(x,y,body.getAngle());
    }
    
}
