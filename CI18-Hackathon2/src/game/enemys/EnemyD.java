package game.enemys;

import game.Renderer.Renderer;
import tklibs.Mathx;

public class EnemyD extends Enemy {
    public EnemyD(){
        renderer=new Renderer ( "images/Enemys/red.png" );
        velocity.set ( 0, Mathx.random ( 2,5 ) );
    }

    @Override
    public void reset() {
        super.reset ();
        velocity.set ( 0, Mathx.random ( 2,5 ) );
    }
}
