package game.scene;

import game.GameObject;
import game.Renderer.Renderer;
import tklibs.AudioUtils;
import tklibs.SpriteUtils;

import javax.sound.sampled.Clip;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class LoadObjects extends GameObject {
    public static BufferedImage backgroundimage,playerimage,playerbulletimage,enemyimageD,enemyimageX,enemyimageV,explosionimage,menu,gameoverimage;
    public static Clip playerbulletsound,gamesound,explosionsoundm,playeremptybullet,gameover;
    public static ArrayList<BufferedImage> playerbulletimages=new ArrayList<> (  ),explosionimages=new ArrayList<> (  );
    public LoadObjects(){
        GameObject.toplayers.add ( this );
        renderer=new Renderer ( "images/load.jpg" );
        position.set ( 1920/2,853/2 );

    }
    int count=0;

    @Override
    public void run() {
        count++;
        if(count>30){
            SceneManager.signNewScene ( new SceneStage1 () );
            count=0;
        }
        this.loadBackground();
        this.loadEnemy();
        this.loadPlayerEmptyBullet();
        this.loadPlayerbullet();
        this.loadExplosion();
        this.loadGameOver();
        this.loadPlayer();
        this.loadmenu();
    }

    private void loadGameOver() {
        gameoverimage=SpriteUtils.loadImage ( "images/gameover.jpg" );
        gameover=AudioUtils.loadSound ( "musics/game over.wav" );
    }

    private void loadmenu() {
        menu=SpriteUtils.loadImage ( "images/fmimg7944327154351991776.png" );
    }

    private void loadPlayerEmptyBullet() {
        playeremptybullet=AudioUtils.loadSound ( "musics/hết đạn.wav" );
    }

    private void loadExplosion() {
//        explosionimage=new Renderer ( "assets/images/enemies/explosion-big",true,2 );
        explosionimages= SpriteUtils.loadImages ( "assets/images/enemies/explosion-big" );


    }

    private void loadEnemy() {
//        enemyimageD=new Renderer ( "images/Enemys/red.png" );
//        enemyimageX=new Renderer ( "images/Enemys/blue.png" );
//        enemyimageV=new Renderer ( "images/Enemys/yellow.png" );
        enemyimageD=SpriteUtils.loadImage (  "images/Enemys/red.png");
        enemyimageX=SpriteUtils.loadImage (  "images/Enemys/blue.png");
        enemyimageV=SpriteUtils.loadImage (  "images/Enemys/yellow.png");
    }

    private void loadPlayerbullet() {
        playerbulletsound= AudioUtils.loadSound ( "musics/am_thanh_tieng_sung_1831391 fixed.wav" );
//        playerbulletimage=new Renderer ( "assets/images/enemies/explosion",true );
        playerbulletimages=SpriteUtils.loadImages ( "assets/images/enemies/explosion" );



    }

    private  void loadPlayer() {
//        playerimage=new Renderer ( "images/Sprite-0001.png" );
        playerimage=SpriteUtils.loadImage ( "images/Sprite-0001.png" );
        gamesound=AudioUtils.loadSound ( "musics/fixe1.wav" );
    }


    private void loadBackground(){
//        backgroundimage=new Renderer ( "images/Backgrounds/background-doc-dao-va-dep_110341729.png" );
        backgroundimage=SpriteUtils.loadImage ( "images/Backgrounds/background-doc-dao-va-dep_110341729.png" );
    }




}
