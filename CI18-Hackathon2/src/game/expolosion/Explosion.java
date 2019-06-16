package game.expolosion;

import game.GameObject;
import game.Renderer.Renderer;
import game.Settings;
import game.scene.LoadObjects;

public class Explosion extends GameObject {
    public Explosion(){
        GameObject.midlayers.add ( this );
        renderer=new Renderer ( LoadObjects.explosionimages,true,2 );
    }

}
