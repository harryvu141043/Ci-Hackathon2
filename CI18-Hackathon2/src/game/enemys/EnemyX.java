package game.enemys;

import game.Renderer.Renderer;
import tklibs.Mathx;

public class EnemyX extends Enemy{
    public EnemyX(){
        renderer=new Renderer ( "images/Enemys/blue.png" );

        velocity.set ( 0, Mathx.random ( 2,5 ) );
//        velocity.setAngle ( 25 );
    }

    @Override
    public void reset() {
        super.reset ();
        velocity.set ( 0, Mathx.random ( 2,5 ) );
//        velocity.setAngle ( 25 );
    }
}
