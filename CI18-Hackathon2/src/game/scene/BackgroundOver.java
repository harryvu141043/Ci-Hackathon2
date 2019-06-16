package game.scene;

import game.GameObject;
import game.KeyEventPress;
import game.Renderer.Renderer;

import game.Settings;

import javax.sound.sampled.Clip;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class BackgroundOver extends GameObject {

    public BackgroundOver(){
        GameObject.toplayers.add ( this );
        renderer=new Renderer ( "images/gameover.jpg" );
        position.set ( 1920/2,853/2 );
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
