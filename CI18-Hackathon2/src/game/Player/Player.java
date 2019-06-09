package game.Player;

import game.GameObject;
import game.KeyEventPress;
import game.Renderer.Renderer;
import game.physics.BoxCollider;
import tklibs.Mathx;

public class Player extends GameObject {
    public Player(){
        renderer=new Renderer ( "images/Sprite-0001.png" );
        position.set ( 100,100 );
        anchor.set ( 0.5,0.5 );
        hitBox=new BoxCollider ( this,30,30 );
    }

    @Override
    public void run() {
        super.run ();
        this.move();
    }

    private void move() {

            if(KeyEventPress.isUpPress){
                position.y-=5;
            }
            if(KeyEventPress.isLeftPress){
                position.x-=5;
            }
            if(KeyEventPress.isDownPress){
                position.y+=5;
            }
            if(KeyEventPress.isRightPress){
                position.x+=5;
            }
//            this.position.x= Mathx.clamp ( this.position.x,0,384-100 );
//            this.position.y=Mathx.clamp ( this.position.y,500,800 );
        }

}
