package game.enemys;

import game.Game;
import game.GameObject;
import game.Player.Player;
import game.Renderer.Renderer;
import game.Settings;
import game.expolosion.Explosion;
import game.physics.BoxCollider;
import tklibs.Mathx;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Enemy extends GameObject {
    public Enemy(){
        GameObject.midlayers.add ( this );
        hitBox=new BoxCollider ( this,35,35 );
        position.set (Mathx.random ( 20,800 ),-50 );
        velocity.set (  Mathx.random ( -1,1 ),Mathx.random ( 2,4 ));
        velocity.setAngle (  Math.toRadians ( Mathx.random ( 25,50 ) ));

    }

    @Override
    public void run() {
        super.run ();
        this.DeactiveIfNeeded();
        this.move();

    }

    private void move() {
        if(this.onGoingRight()
                && this.outOfBoundRight()){
            this.reverseVelocityX();
        }
        if(this.onGoingLeft() && this.outOfBoundLeft()){
            this.reverseVelocityX ();
        }
    }

    private boolean outOfBoundLeft() {
        return position.x<25;
    }

    private boolean onGoingLeft() {
        return velocity.x<0;
    }


    private void reverseVelocityX() {
        velocity.x=-velocity.x;
    }

    private boolean outOfBoundRight() {
        return position.x>1280-25;
    }

    private boolean onGoingRight() {
        return velocity.x>0;
    }

    private void DeactiveIfNeeded() {
        if(this.position.y> 880 ){
            this.deactive ();
            Settings.mang--;

        }
    }
    @Override
    public void reset() {
        super.reset ();
        position.set ( Mathx.random ( 20,800 ),-50 );
        velocity.set (  Mathx.random ( -2,1 ),Mathx.random ( 2,4 ));
        velocity.setAngle (  Math.toRadians ( Mathx.random ( 25,50 ) ));


    }

    @Override
    public void deactive() {
        super.deactive ();
        Explosion explosion=GameObject.recycle ( Explosion.class );
        explosion.position.set ( this.position.x,this.position.y);
    }
}
