package game.enemys;

import game.GameObject;
import game.Renderer.Renderer;
import game.scene.LoadObjects;
import tklibs.Mathx;

public class EnemyD extends Enemy {
    public EnemyD(){
        GameObject.midlayers.add ( this );
        renderer=new Renderer ( LoadObjects.enemyimageD );
//        renderer=LoadObjects.enemyimageD;

    }


}
