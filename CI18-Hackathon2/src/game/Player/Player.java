package game.Player;

import game.*;
import game.Renderer.Renderer;
import game.enemys.Enemy;
import game.physics.BoxCollider;
import game.scene.LoadObjects;
import game.scene.Scene;
import game.scene.SceneManager;
import game.scene.SceneOver;
import tklibs.AudioUtils;
import tklibs.Mathx;

import javax.sound.sampled.Clip;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Player extends GameObject{
    Enemy enemy=new Enemy ();
    Clip sound;
    public Player() {

        GameObject.toplayers.add ( this );
        renderer=new Renderer (LoadObjects.playerimage );

        position.set ( 800, 800 );
        anchor.set ( 0.5, 0.5 );
        hitBox = new BoxCollider ( this, Settings.PLAYER_WIDTH, Settings.PLAYER_HEIGHT );
        speed = 10;
        sound=LoadObjects.gamesound;
        AudioUtils.replay ( sound );
        AudioUtils.loopForever ( sound );

    }
    public int count = 0, count1 = 0;
    public int speed;

    @Override
    public void run() {
        super.run ();
        this.move ();
        this.fire ();
        this.resetbullet();
        this.DeactiveIfneeded();



    }

    public void DeactiveIfneeded() {
        if(Settings.mang<=0){
            this.deactive ();
            SceneManager.signNewScene ( new SceneOver () );
            AudioUtils.pause ( sound );
        }
    }

    private void resetbullet() {
        if(Settings.numbershoot<=0){
            count++;
            if(count>1.2*80) {
                Settings.numbershoot = 3;
                count=0;
            }
        }
    }

    private void fire() {
        count1++;
        if (KeyEventPress.isFire && count1 > 40 && Settings.numbershoot>=1) {
            Settings.numbershoot--;
            PlayerBullet playerBullet = GameObject.recycle ( PlayerBullet.class );
            playerBullet.position.set ( this.position );
            count1 = 0;
        }
        if(KeyEventPress.isFire && count1>40 && Settings.numbershoot<=0){
            PlayerEmptyBullet playerEmptyBullet=GameObject.recycle ( PlayerEmptyBullet.class );
            count1=0;
        }
    }




    private void move() {

        if (KeyEventPress.isUpPress) {

            position.y -= speed;
        }
        if (KeyEventPress.isLeftPress) {
            position.x -= speed;
        }
        if (KeyEventPress.isDownPress) {
            position.y += speed;
        }
        if (KeyEventPress.isRightPress) {
            position.x += speed;
        }
        this.position.x = Mathx.clamp ( this.position.x, 20, 1280 - 20 );
        this.position.y = Mathx.clamp ( this.position.y, 20, 853 - 20 );
    }

    @Override
    public void reset() {
        super.reset ();
        position.set ( 100, 100 );
        AudioUtils.replay ( sound );
        AudioUtils.loopForever ( sound );

    }




}
