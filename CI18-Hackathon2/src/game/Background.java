package game;

import game.Renderer.Renderer;
import game.enemys.Enemy;
import game.scene.LoadObjects;
import tklibs.AudioUtils;

import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Background extends GameObject {


    public Background(){
        GameObject.botlayers.add ( this );
        renderer=new Renderer (LoadObjects.backgroundimage );
//        renderer=LoadObjects.backgroundimage;
//        position=new Vector2D ( 1280/2,853/2 );
        anchor.set ( 0,0 );
        position.set ( 0,0 );


    }







    }

