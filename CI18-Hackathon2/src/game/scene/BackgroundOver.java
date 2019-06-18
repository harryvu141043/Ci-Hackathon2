package game.scene;

import game.GameObject;
import game.KeyEventPress;
import game.Renderer.Renderer;

import game.Settings;
import tklibs.AudioUtils;

import javax.sound.sampled.Clip;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class BackgroundOver extends GameObject {
    Clip sound;
    public BackgroundOver(){
        GameObject.toplayers.add ( this );
        sound=LoadObjects.gameover;
        renderer=new Renderer ( LoadObjects.gameoverimage);
        position.set ( 1920/2,853/2 );
        AudioUtils.replay ( sound );
    }
    int count=0;

    @Override
    public void run()  {

        count++;
        if(KeyEventPress.isAnyKeyPress && count>80){
            SceneManager.signNewScene ( new SceneStage1 () );
        }
    }
}
