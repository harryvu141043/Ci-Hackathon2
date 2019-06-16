package game.Player;

import game.GameObject;
import game.Renderer.Renderer;
import game.Settings;
import game.enemys.Enemy;
import game.expolosion.Explosion;
import game.physics.BoxCollider;
import game.scene.LoadObjects;
import tklibs.AudioUtils;

import javax.sound.sampled.Clip;
import java.awt.image.BufferedImage;

public class PlayerBullet extends GameObject {
        Clip sound;

        public PlayerBullet(){

            GameObject.midlayers.add ( this );
            sound= LoadObjects.playerbulletsound;
            AudioUtils.replay ( sound );
            renderer=new Renderer (LoadObjects.playerbulletimages,true,0);
            hitBox=new BoxCollider ( this,10, 10 );
        }

    @Override
    public void run() {
        this.checkenemy();

    }
    private void checkenemy() {
        Enemy enemy=GameObject.findIntersects ( Enemy.class,hitBox );
        if(enemy!=null){
            enemy.deactive ();
            Settings.score++;


        }
    }
    @Override
    public void reset() {
        super.reset ();
        AudioUtils.replay ( sound );
    }
}
