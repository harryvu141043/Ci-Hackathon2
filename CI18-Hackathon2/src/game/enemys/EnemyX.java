package game.enemys;

import game.GameObject;
import game.Renderer.Renderer;
import game.scene.LoadObjects;
import tklibs.Mathx;

public class EnemyX extends Enemy{
    public EnemyX(){
        GameObject.midlayers.add ( this );
        renderer=new Renderer ( LoadObjects.enemyimageX );



    }


}
