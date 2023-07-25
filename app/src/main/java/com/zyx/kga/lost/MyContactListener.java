package com.zyx.kga.lost;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import android.app.GameManager;

public class MyContactListener implements ContactListener {
    
    boolean a = true;

    @Override
    public void beginContact(Contact contact) {
        MyGdxGame.GM.getGame().player1.DeductHP();
        MyGdxGame.GM.getGame().ib.addInfo("[RED][碰撞检测器][]碰撞");
    }

    @Override
    public void endContact(Contact contact) {
    }

    @Override
    public void postSolve(Contact contact, ContactImpulse contactImpulse) {
    }

    @Override
    public void preSolve(Contact contact, Manifold manifold) {
    }

}
