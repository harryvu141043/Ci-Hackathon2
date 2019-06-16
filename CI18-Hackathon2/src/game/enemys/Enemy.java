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
        hitBox=new BoxCollider ( this,50,50 );
        position.set(100,100);
        velocity.set ( 0,1 );



    }

    @Override
    public void run() {
        super.run ();
        this.DeactiveIfNeeded();

    }

    private void DeactiveIfNeeded() {
        if(this.position.y> 856 || this.position.y<-10 || this.position.x<-10 || this.position.x>1290){
            this.deactive ();
            System.out.println ("kkkkk");
            Settings.mang--;

        }
    }
    @Override
    public void reset() {
        super.reset ();
        position.set(100,100);
        velocity.set ( 0,1);


    }

    @Override
    public void deactive() {
        super.deactive ();
        Explosion explosion=GameObject.recycle ( Explosion.class );
        explosion.position.set ( this.position.x,this.position.y);
    }
}
