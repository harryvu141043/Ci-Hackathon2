package game.enemys;

import game.Game;
import game.GameObject;
import game.Renderer.Renderer;
import game.physics.BoxCollider;

public class Enemy extends GameObject {
    public Enemy(){
        anchor.set ( 0,0 );
        hitBox=new BoxCollider ( this,50,50 );
        position.set ( 0,-50 );
    }

    @Override
    public void run() {
        super.run ();
        this.DeactiveIfNeeded();
    }

    private void DeactiveIfNeeded() {
        if(this.position.y> 900){
            this.deactive ();
        }
    }

}
