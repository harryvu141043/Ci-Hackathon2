package game.enemys;

import game.GameObject;
import game.Renderer.Renderer;
import game.scene.LoadObjects;
import tklibs.Mathx;

public class EnemyV extends Enemy {
    public EnemyV(){
        GameObject.midlayers.add ( this );
        renderer=new Renderer ( LoadObjects.enemyimageV );
//        renderer=LoadObjects.enemyimageV;

    }

}
